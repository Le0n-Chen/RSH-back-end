package com.leoncf.network.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="NETWORK_SCAN_TERM")
public class UserLog {
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
