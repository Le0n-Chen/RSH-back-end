package com.leoncf.network.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class ValidLog {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private String time;
    @Column(nullable = false)
    private String mac_address;
    @Column(nullable = false)
    private String ip_address;
    @Column(nullable = false)
    private String request_source;
}
