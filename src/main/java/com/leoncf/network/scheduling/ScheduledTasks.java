package com.leoncf.network.scheduling;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


import com.leoncf.network.model.UserLog;
import com.leoncf.network.scan.PingTester;
import com.leoncf.network.service.UserLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import  org.springframework.scheduling.annotation.Scheduled;
import  org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private  static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    private  static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Value("${network.scan.address}")
    private String scanAddr;
    @Resource
    UserLogService userLogService;

    @Scheduled(fixedRate = 1800000)
    public void reportCurrent(){
        PingTester tester = new PingTester(scanAddr);
        List<Map<String, String>> scanResult = tester.startPing();
        Date nowData = new Date();
        String date = dateFormat.format(nowData);
        String time = timeFormat.format(nowData);
        for(Map<String, String> scanItem : scanResult){
            scanItem.put("date", date);
            scanItem.put("time", time);
        }

        for(Map<String, String> scanItem : scanResult) {
            UserLog userLog = new UserLog();
            userLog.setDate(scanItem.get("date"));
            userLog.setTime(scanItem.get("time"));
            userLog.setIp_address(scanItem.get("ip_address"));
            userLog.setMac_address(scanItem.get("mac_address"));
            userLog.setRequest_source(scanItem.get("request_source"));
            userLogService.save(userLog);
        }
    }

}