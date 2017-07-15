package com.project.online.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "authorities")
public class Authorities implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "authorityId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "authority")
    private String authority;

    @JoinColumn(name = "userName")
    private String userName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}


