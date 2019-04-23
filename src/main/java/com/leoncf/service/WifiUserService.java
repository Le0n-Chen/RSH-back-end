package com.leoncf.service;

import com.leoncf.model.WifiUser;

import java.util.List;

public interface WifiUserService {

    public List<WifiUser> getScanLogList();

    public com.leoncf.model.WifiUser findScanLogById(long id);

    public List<WifiUser> findUserNumByDay(String date);

    public void save(com.leoncf.model.WifiUser wifiUser);

    public void edit(com.leoncf.model.WifiUser wifiUser);

    public void delete(long id);

}
