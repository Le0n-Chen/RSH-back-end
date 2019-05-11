package com.leoncf.network.scan;

import org.springframework.beans.factory.annotation.Value;

import java.net.InetAddress;
import java.net.SocketException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class PingTester {
    private Queue<String> allIp;
    private int fetchedNum = 0; // 已经取得的任务数量，每次从队列中取一个ip就加1
    private List<Map<String, String>> result =  new ArrayList<>();


    public PingTester(String scanAddr) {
        // 首先创建一个队列用于存储所有ip地址
        allIp = new LinkedList<String>();
        for (int i = 0; i < 256; i++) {
            allIp.offer(scanAddr + i);
//            for (int j = 0; j < 256; j++) {
//                allIp.offer("192.168."+i+"."+j);
//            }
        }
    }

    public List<Map<String, String>> startPing() {
        // 创建一个线程池，多个线程同时跑
        int threadNum = 1000;
        ExecutorService executor = Executors.newFixedThreadPool(threadNum);
        for (int i = 0; i < threadNum; i++) {
            executor.execute(new PingRunner());
        }
        executor.shutdown();
        try {
            while (!executor.isTerminated()) {
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Fetched num is " + fetchedNum);
        return result;
    }


    private class PingRunner implements Runnable {
        private String taskIp = null;
        @Override
        public void run() {
            try {
                while ((taskIp = getIp()) != null) {
                    InetAddress addr = InetAddress.getByName(taskIp);
                    if (addr.isReachable(5000)) {
                        String mac_s = MacAddress.getMac(taskIp);
                        Map<String, String> reachedItem = new HashMap();
                        reachedItem.put("ip_address", taskIp);
                        reachedItem.put("mac_address", mac_s);
                        reachedItem.put("request_source", "auto_scan");
                        System.out.println("host ["+taskIp+"] is reachable");
                        System.out.println("mac  " + mac_s);
                        result.add(reachedItem);
                    } else {
                        System.out.println("host ["+taskIp+"] is not reachable");
                    }
                }
            } catch (SocketException e) {
                System.out.println("host ["+taskIp+"] permission denied");
            } catch (Exception e) {
                System.out.println("---------------------------------------------"+taskIp);
                e.printStackTrace();
            }
        }

        public String getIp() {
            String ip = null;
            synchronized (allIp) {
                ip = allIp.poll();
            }
            if (ip != null) {
                fetchedNum++;
            }
            return ip;
        }
    }
}
