package com.leoncf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.leoncf.model.ScanLog;

public interface ScanLogRepository extends JpaRepository<ScanLog, Long> {

    ScanLog findById(long id);

    void deleteById(Long id);

}
