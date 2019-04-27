package com.leoncf.network.service;

import com.leoncf.network.model.UserLog;

import java.util.List;
import java.util.Map;

public interface UserLogService {

    public List<UserLog> getScanLogList();

    public UserLog findScanLogById(long id);

    public Map<Object, Integer> findUserNumByDay(String date);

    public void save(UserLog userLog);

    public void edit(UserLog userLog);

    public void delete(long id);

}
