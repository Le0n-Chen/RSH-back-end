package com.leoncf.video.repository;

import com.leoncf.video.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PictureRepo extends JpaRepository<Picture, Long> {

    Picture findById(long id);

    void deleteById(Long id);

    @Query(value = "SELECT time,picture FROM CAMERA_PIC WHERE date = :date ORDER BY time ASC ", nativeQuery = true)
    List<Object> findByDateASC(@Param("date") String date);

}
