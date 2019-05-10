package com.leoncf.network.service.impl;

import com.leoncf.network.model.UserProfile;
import com.leoncf.network.repository.UserProfileRepo;
import com.leoncf.network.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService{
    @Autowired
    UserProfileRepo userProfileRepo;

    @Override
    public List<UserProfile>  getUserProfileList() { return userProfileRepo.findAll(); }

    @Override
    public UserProfile findUserProfileByMacAddress(String macAddress) { return userProfileRepo.findByMacAddress(macAddress); }

    @Override
    public List<UserProfile> findAllowedUserByDate(String date) {
        return userProfileRepo.findAllowedUser(date);
    }
    @Override
    public List<UserProfile> findNotAllowedUserByDate(String date) {
        return userProfileRepo.findNotAllowedUser(date);
    }

    @Override
    public List<String> findNotKnownUserByDate(String date) {
        return userProfileRepo.findNotKnownUser(date);
    }

    @Override
    public void save(UserProfile userProfile) { userProfileRepo.save(userProfile); }

    @Override
    public void edit(UserProfile userProfile) { userProfileRepo.save(userProfile); }

    @Override
    public void deleteByMacAddress(String macAddress) { userProfileRepo.deleteByMacAddress(macAddress); }
}
