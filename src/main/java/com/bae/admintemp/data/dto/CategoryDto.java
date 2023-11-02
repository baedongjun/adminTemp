package com.bae.admintemp.data.dto;

import com.bae.admintemp.data.entity.Board;
import com.bae.admintemp.data.entity.Category;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@RedisHash(value = "category", timeToLive = 60)
public class CategoryDto {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cateId;
    private int parentCateId;
    private String cateName;

    List<Board> list = new ArrayList<>();

    public Category toEntity(){
        return Category.builder()
                .cateId(cateId)
                .parentCateId(parentCateId)
                .cateName(cateName)
                .build();
    }
}
