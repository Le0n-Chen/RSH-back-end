package com.leoncf.web;

import com.leoncf.model.WifiUser;
import com.leoncf.service.WifiUserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class WifiUserController {

    @Resource
    WifiUserService wifiUserService;

    @RequestMapping(value = "/wifiuser",method = RequestMethod.GET)

    public List<WifiUser> showAll() {
        List<WifiUser> wifiUser = this.wifiUserService.getScanLogList();
        System.out.println(11);
        return wifiUser;
    }

    @RequestMapping(value = "/wifiuser/{day}",method = RequestMethod.GET)

    public List<WifiUser> showNumByDay(@PathVariable("day") String day) {
        List<WifiUser> wifiUser = this.wifiUserService.findUserNumByDay(day);
        System.out.println(day);
        return wifiUser;
    }
}
