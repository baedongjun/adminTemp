package com.bae.admintemp.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Member {
    @Id
    @Column(unique = true)
    private String mUserid;
    private String mUserpw;
    private String mUsername;
    @Temporal(value = TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createAt;
    @Temporal(value = TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updateAt;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date expirationAt;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date secessionAt;
    private String secessionReason;
    private String roles;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    List<Board> list = new ArrayList<>();

    public String getmUserid() {
        return mUserid;
    }

    public void setmUserid(String mUserid) {
        this.mUserid = mUserid;
    }

    public String getmUserpw() {
        return mUserpw;
    }

    public void setmUserpw(String mUserpw) {
        this.mUserpw = mUserpw;
    }

    public String getmUsername() {
        return mUsername;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Date getExpirationAt() {
        return expirationAt;
    }

    public void setExpirationAt(Date expirationAt) {
        this.expirationAt = expirationAt;
    }

    public Date getSecessionAt() {
        return secessionAt;
    }

    public void setSecessionAt(Date secessionAt) {
        this.secessionAt = secessionAt;
    }

    public String getSecessionReason() {
        return secessionReason;
    }

    public void setSecessionReason(String secessionReason) {
        this.secessionReason = secessionReason;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public List<Board> getList() {
        return list;
    }

    public void setList(List<Board> list) {
        this.list = list;
    }
}