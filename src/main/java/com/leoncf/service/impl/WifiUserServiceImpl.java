package com.leoncf.service.impl;

import com.leoncf.model.WifiUser;
import com.leoncf.repository.WifiUserRepo;
import com.leoncf.service.WifiUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WifiUserServiceImpl implements WifiUserService {

    @Autowired
    private WifiUserRepo wifiUserRepo;

    @Override
    public List<WifiUser> getScanLogList() {
        return wifiUserRepo.findAll();
    }

    @Override
    public WifiUser findScanLogById(long id) {
        return wifiUserRepo.findById(id);
    }

    @Override
    public List<WifiUser> findUserNumByDay(String date) {
        return wifiUserRepo.findByDate(date);
    }

    @Override
    public void save(com.leoncf.model.WifiUser wifiUser) {
        this.wifiUserRepo.save(wifiUser);
    }

    @Override
    public void edit(com.leoncf.model.WifiUser wifiUser) {
        this.wifiUserRepo.save(wifiUser);
    }

    @Override
    public void delete(long id) {
        wifiUserRepo.deleteById(id);
    }
}
