package com.bae.admintemp.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DialectOverride;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private int bId;
    private String bTitle;
    private String bContents;
    private String bImgUrl;
    private String bImgName;
    private int bView;
    private String bSecure;
    private int bLikeCnt;
    @Temporal(value = TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createAt;
    @Temporal(value = TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updateAt;

    @ManyToOne
    @JoinColumn(name = "mUserid", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "cateId", nullable = false)
    private Category category;

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public String getbTitle() {
        return bTitle;
    }

    public void setbTitle(String bTitle) {
        this.bTitle = bTitle;
    }

    public String getbContents() {
        return bContents;
    }

    public void setbContents(String bContents) {
        this.bContents = bContents;
    }

    public String getbImgUrl() {
        return bImgUrl;
    }

    public void setbImgUrl(String bImgUrl) {
        this.bImgUrl = bImgUrl;
    }

    public String getbImgName() {
        return bImgName;
    }

    public void setbImgName(String bImgName) {
        this.bImgName = bImgName;
    }

    public int getbView() {
        return bView;
    }

    public void setbView(int bView) {
        this.bView = bView;
    }

    public String getbSecure() {
        return bSecure;
    }

    public void setbSecure(String bSecure) {
        this.bSecure = bSecure;
    }

    public int getbLikeCnt() {
        return bLikeCnt;
    }

    public void setbLikeCnt(int bLikeCnt) {
        this.bLikeCnt = bLikeCnt;
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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}