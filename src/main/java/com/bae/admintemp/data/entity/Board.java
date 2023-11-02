package com.bae.admintemp.data.entity;

import com.bae.admintemp.data.dto.BoardDto;
import com.bae.admintemp.data.dto.CategoryDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "board")
public class Board extends BaseEntity {
    @Id
    Integer id;
    String title;
    String contents;
    String imgUrl;
    String imgName;
    Integer viewCnt;
    String secure;
    Integer likeCnt;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    Member member;

    @ManyToOne
    @JoinColumn(name = "cateId", nullable = false)
    Category category;

    public BoardDto toDto(){
        return BoardDto.builder()
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