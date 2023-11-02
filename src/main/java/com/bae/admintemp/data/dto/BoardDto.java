package com.bae.admintemp.data.dto;

import com.bae.admintemp.data.entity.Board;
import com.bae.admintemp.data.entity.Category;
import com.bae.admintemp.data.entity.Member;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@RedisHash(value = "board", timeToLive = 60)
public class BoardDto {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String contents;
    private String imgUrl;
    private String imgName;
    private int viewCnt;
    private String secure;
    private int likeCnt;

    private Member member;

    private Category category;

    public BoardDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.contents = board.getContents();
        this.imgUrl = board.getImgUrl();
        this.imgName = board.getImgName();
        this.viewCnt = board.getViewCnt();
        this.secure = board.getSecure();
        this.likeCnt = board.getLikeCnt();
        this.member = board.getMember();
        this.category = board.getCategory();
    }

    public Board toEntity(){
        return Board.builder()
                .id(id)
                .title(title)
                .contents(contents)
                .imgUrl(imgUrl)
                .imgName(imgName)
                .viewCnt(viewCnt)
                .secure(secure)
                .likeCnt(likeCnt)
                .member(member)
                .category(category)
                .build();
    }
}
