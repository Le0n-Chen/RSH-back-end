package com.leoncf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.leoncf.model.WifiUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WifiUserRepo extends JpaRepository<com.leoncf.model.WifiUser, Long> {

    WifiUser findById(long id);

    List<WifiUser> findByDate(String date);

    void deleteById(Long id);



}
