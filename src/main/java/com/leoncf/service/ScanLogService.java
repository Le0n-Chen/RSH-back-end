package com.leoncf.service;

import com.leoncf.model.ScanLog;

import java.util.List;

public interface ScanLogService {

    public List<ScanLog> getScanLogList();

    public ScanLog findScanLogById(long id);

    public void save(ScanLog scanLog);

    public void edit(ScanLog scanLog);

    public void delete(long id);

}
