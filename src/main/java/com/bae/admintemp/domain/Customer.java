package com.bae.admintemp.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Customer {
    @Id
    @Column(unique = true)
    private String C_userid;
    private String C_userpw;
    private String C_username;
    private String C_provider;
    private String C_grade;
    private String C_zip;
    private String C_addr;
    private String C_addr2;
    private String C_sms_yn;
    private String C_email_yn;
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

    public String getC_userid() {
        return C_userid;
    }

    public void setC_userid(String c_userid) {
        C_userid = c_userid;
    }

    public String getC_userpw() {
        return C_userpw;
    }

    public void setC_userpw(String c_userpw) {
        C_userpw = c_userpw;
    }

    public String getC_username() {
        return C_username;
    }

    public void setC_username(String c_username) {
        C_username = c_username;
    }

    public String getC_provider() {
        return C_provider;
    }

    public void setC_provider(String c_provider) {
        C_provider = c_provider;
    }

    public String getC_grade() {
        return C_grade;
    }

    public void setC_grade(String c_grade) {
        C_grade = c_grade;
    }

    public String getC_zip() {
        return C_zip;
    }

    public void setC_zip(String c_zip) {
        C_zip = c_zip;
    }

    public String getC_addr() {
        return C_addr;
    }

    public void setC_addr(String c_addr) {
        C_addr = c_addr;
    }

    public String getC_addr2() {
        return C_addr2;
    }

    public void setC_addr2(String c_addr2) {
        C_addr2 = c_addr2;
    }

    public String getC_sms_yn() {
        return C_sms_yn;
    }

    public void setC_sms_yn(String c_sms_yn) {
        C_sms_yn = c_sms_yn;
    }

    public String getC_email_yn() {
        return C_email_yn;
    }

    public void setC_email_yn(String c_email_yn) {
        C_email_yn = c_email_yn;
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

}