package com.leoncf.network.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="NETWORK_USER_PROFILE")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="mac_address")
    private String macAddress;
    @Column(name="note_name")
    private String noteName;
    @Column(name="is_allow")
    private int isAllow;
}
