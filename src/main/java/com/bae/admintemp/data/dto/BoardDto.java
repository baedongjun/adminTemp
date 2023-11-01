package com.bae.admintemp.data.dto;

import com.bae.admintemp.data.entity.Category;
import com.bae.admintemp.data.entity.Member;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@RedisHash(value = "board", timeToLive = 60)
public class BoardDto {
    private int id;
    private String title;
    private String contents;
    private String imgUrl;
    private String imgName;
    private int viewCnt;
    private String secure;
    private int likeCnt;
    private Date createAt;
    private Date updateAt;

    private Member member;

    private Category category;
}
