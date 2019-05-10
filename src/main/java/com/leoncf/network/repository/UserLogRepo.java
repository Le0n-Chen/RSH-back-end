package com.leoncf.network.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.leoncf.network.model.UserLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserLogRepo extends JpaRepository<UserLog, Long> {

    UserLog findById(long id);

    void deleteById(Long id);

    @Query(value = "SELECT time FROM NETWORK_SCAN_TERM WHERE date = :date ORDER BY time ASC ", nativeQuery = true)
    List<String> findByDateASC(@Param("date") String date);



}
