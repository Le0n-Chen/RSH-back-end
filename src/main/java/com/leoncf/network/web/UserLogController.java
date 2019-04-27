package com.leoncf.network.web;

import com.leoncf.network.model.UserLog;
import com.leoncf.network.service.UserLogService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/network")
public class UserLogController {

    @Resource
    UserLogService userLogService;

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public List<UserLog> showAll() {
        List<UserLog> userLog = this.userLogService.getScanLogList();
        return userLog;
    }

    @RequestMapping(value = "/user/num/{day}",method = RequestMethod.GET)
    public Map<Object, Integer> showUserLogByDay(@PathVariable("day") String day) {
        return this.userLogService.findUserNumByDay(day);
    }

}
