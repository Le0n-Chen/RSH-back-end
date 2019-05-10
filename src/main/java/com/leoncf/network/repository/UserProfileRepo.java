package com.leoncf.network.repository;

import com.leoncf.network.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserProfileRepo extends JpaRepository<UserProfile, Long> {
    UserProfile findByMacAddress(String macAddress);

    void deleteByMacAddress(String macAddress);

    @Query(value = "SELECT * FROM NETWORK_USER_PROFILE WHERE is_allow = 1 AND mac_address IN (SELECT DISTINCT mac_address FROM NETWORK_SCAN_TERM WHERE date = :date);", nativeQuery = true)
    List<UserProfile> findAllowedUser(@Param("date") String date);

    @Query(value = "SELECT * FROM NETWORK_USER_PROFILE WHERE is_allow = 0 AND mac_address IN (SELECT DISTINCT mac_address FROM NETWORK_SCAN_TERM WHERE date = :date);", nativeQuery = true)
    List<UserProfile> findNotAllowedUser(@Param("date") String date);

    @Query(value = "SELECT DISTINCT mac_address FROM NETWORK_SCAN_TERM WHERE date = :date AND mac_address NOT IN ( SELECT mac_address FROM NETWORK_USER_PROFILE );", nativeQuery = true)
    List<String> findNotKnownUser(@Param("date") String date);
}
