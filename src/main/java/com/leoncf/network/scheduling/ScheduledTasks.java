package com.leoncf.network.scheduling;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


import com.leoncf.network.model.UserLog;
import com.leoncf.network.scan.PingTester;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import  org.springframework.scheduling.annotation.Scheduled;
import  org.springframework.stereotype.Component;


@Component
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private  static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    private  static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Scheduled(fixedRate = 60000)
    public void reportCurrent(){
        PingTester tester = new PingTester();
        List<Map<String, String>> scanResult = tester.startPing();
        Date nowData = new Date();
        String date = dateFormat.format(nowData);
        String time = timeFormat.format(nowData);
        for(Map<String, String> scanItem : scanResult){
            scanItem.put("date", date);
            scanItem.put("time", time);
        }
        System.out.println(scanResult);
        logger.info("现在时间：{}",timeFormat.format(new Date()));
    }

}