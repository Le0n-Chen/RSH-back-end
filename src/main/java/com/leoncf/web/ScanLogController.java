package com.leoncf.web;

import com.leoncf.model.ScanLog;
import com.leoncf.service.ScanLogService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ScanLogController {

    @Resource
    ScanLogService scanLogService;

    @RequestMapping("/scanLog")
    public List<ScanLog> list() {
        List<ScanLog> scanLog = scanLogService.getScanLogList();
        System.out.println(scanLog);
        return scanLog;
    }
}
