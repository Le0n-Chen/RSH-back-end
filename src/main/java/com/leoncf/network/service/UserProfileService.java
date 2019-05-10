package com.leoncf.network.service;

import com.leoncf.network.model.UserProfile;

import java.util.List;

public interface UserProfileService {
    public List<UserProfile> getUserProfileList();

    public UserProfile findUserProfileByMacAddress(String mac_address);

    public List<UserProfile> findAllowedUserByDate(String date);

    public List<UserProfile> findNotAllowedUserByDate(String date);

    public List<String> findNotKnownUserByDate(String date);

    public void save(UserProfile userProfile);

    public void edit(UserProfile userProfile);

    public void deleteByMacAddress(String mac_address);
}
