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
    private String inflow;
    private String grade;
    private String zip;
    private String addr;
    private String addr2;
    private String sms_yn;
    private String email_yn;
    @Temporal(value = TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date create_date;
    @Temporal(value = TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date update_date;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date expiration_date;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date secession_date;
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

    public String getInflow() {
        return inflow;
    }

    public void setInflow(String inflow) {
        this.inflow = inflow;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getSms_yn() {
        return sms_yn;
    }

    public void setSms_yn(String sms_yn) {
        this.sms_yn = sms_yn;
    }

    public String getEmail_yn() {
        return email_yn;
    }

    public void setEmail_yn(String email_yn) {
        this.email_yn = email_yn;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public Date getSecession_date() {
        return secession_date;
    }

    public void setSecession_date(Date secession_date) {
        this.secession_date = secession_date;
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