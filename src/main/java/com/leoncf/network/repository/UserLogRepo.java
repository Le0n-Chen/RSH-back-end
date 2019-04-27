package com.leoncf.network.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.leoncf.network.model.UserLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserLogRepo extends JpaRepository<UserLog, Long> {

    UserLog findById(long id);

    List<UserLog> findByDate(String date);

    void deleteById(Long id);

    @Query(value = "select time from NETWORK_SCAN_TERM where date = :date order by time ASC ", nativeQuery = true)
    List<String> findByDateASC(@Param("date") String date);



}
