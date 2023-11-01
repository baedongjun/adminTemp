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
    private String userid;
    private String pw;
    private String username;
    @Temporal(value = TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date create_at;
    @Temporal(value = TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date update_at;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date expiration_at;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date secession_at;
    private String secession_reason;
    private String roles;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    List<Board> list = new ArrayList<>();

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    public Date getExpiration_at() {
        return expiration_at;
    }

    public void setExpiration_at(Date expiration_at) {
        this.expiration_at = expiration_at;
    }

    public Date getSecession_at() {
        return secession_at;
    }

    public void setSecession_at(Date secession_at) {
        this.secession_at = secession_at;
    }

    public String getSecession_reason() {
        return secession_reason;
    }

    public void setSecession_reason(String secession_reason) {
        this.secession_reason = secession_reason;
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