package com.leoncf.service.impl;

import com.leoncf.model.ScanLog;
import com.leoncf.repository.ScanLogRepository;
import com.leoncf.service.ScanLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScanLogServiceImpl implements ScanLogService {

    @Autowired
    private ScanLogRepository scanLogRepository;

    @Override
    public List<ScanLog> getScanLogList() {
        return scanLogRepository.findAll();
    }

    @Override
    public ScanLog findScanLogById(long id) {
        return scanLogRepository.findById(id);
    }

    @Override
    public void save(ScanLog scanLog) {
        scanLogRepository.save(scanLog);
    }

    @Override
    public void edit(ScanLog scanLog) {
        scanLogRepository.save(scanLog);
    }

    @Override
    public void delete(long id) {
        scanLogRepository.deleteById(id);
    }
}
