package com.leoncf.video.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "CAMERA_PIC")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private String time;
    @Column(nullable = false, name="picture")
    private String pictureAddress;

    public Picture(String date, String time, String pictureAddress) {
        this.date = date;
        this.time = time;
        this.pictureAddress = pictureAddress;
    }

}
