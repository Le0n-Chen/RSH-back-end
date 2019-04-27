package com.leoncf.network.service.impl;

import com.leoncf.network.model.UserLog;
import com.leoncf.network.repository.UserLogRepo;
import com.leoncf.network.service.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserLogLogServiceImpl implements UserLogService {

    @Autowired
    private UserLogRepo userLogRepo;

    @Override
    public List<UserLog> getScanLogList() {
        return userLogRepo.findAll();
    }

    @Override
    public UserLog findScanLogById(long id) { return userLogRepo.findById(id); }

    @Override
    public Map<Object, Integer> findUserNumByDay(String date) {
        List<String> list = userLogRepo.findByDateASC(date);
        String pattern = "HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        Map<Object, Integer> result= new LinkedHashMap<>();
        for( int j = 0 ; j < list.size() ; j++) { // time convert to string
            list.set(j, df.format(list.get(j)));
        }

        for( int i = 1 ; i < list.size() ; i++) {
            if(list.get(i) .equals(list.get(i - 1))){
                result.replace(list.get(i), result.get(list.get(i - 1)) + 1);
            }else{
               result.put(list.get(i), 1);
            }
        }

        return result;
    }

    @Override
    public void save(UserLog userLog) {
        this.userLogRepo.save(userLog);
    }

    @Override
    public void edit(UserLog userLog) {
        this.userLogRepo.save(userLog);
    }

    @Override
    public void delete(long id) {
        userLogRepo.deleteById(id);
    }
}
