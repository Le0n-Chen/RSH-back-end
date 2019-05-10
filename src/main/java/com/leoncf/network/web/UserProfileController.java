package com.leoncf.network.web;

import com.leoncf.network.model.UserProfile;
import com.leoncf.network.service.UserLogService;
import com.leoncf.network.service.UserProfileService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/network")
public class UserProfileController {
    @Resource
    UserProfileService userProfileService;

    @RequestMapping(value = "/user/profile",method = RequestMethod.GET)
    public List<UserProfile> showAll() {
        List<UserProfile> result = this.userProfileService.getUserProfileList();
        return result;
    }

    @RequestMapping(value = "/user/allowed/{day}",method = RequestMethod.GET)
    public List<UserProfile> showAllowedUser(@PathVariable("day") String day) {
        List<UserProfile> result = this.userProfileService.findAllowedUserByDate(day);
        return result;
    }

    @RequestMapping(value = "/user/unallowed/{day}",method = RequestMethod.GET)
    public List<UserProfile> showUnallowedUser(@PathVariable("day") String day) {
        List<UserProfile> result = this.userProfileService.findNotAllowedUserByDate(day);
        return result;
    }

    @RequestMapping(value = "/user/invalid/{day}",method = RequestMethod.GET) // invalid = unallowed + undefined
    public List<UserProfile> showInvalidedUser(@PathVariable("day") String day) {
        List<UserProfile> unallowedUser = this.userProfileService.findNotAllowedUserByDate(day);
        List<String> unknownUser = this.userProfileService.findNotKnownUserByDate(day);
        for(String macAddress : unknownUser) {
            UserProfile userProfile = new UserProfile();
            userProfile.setNoteName("");
            userProfile.setMacAddress(macAddress);
            userProfile.setIsAllow(0); // default: not allowed
            unallowedUser.add(userProfile);
        }
        return unallowedUser;
    }
}
