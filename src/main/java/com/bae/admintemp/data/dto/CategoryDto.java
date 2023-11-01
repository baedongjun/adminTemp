package com.bae.admintemp.data.dto;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@RedisHash(value = "category", timeToLive = 60)
public class CategoryDto {
    private int cateId;
    private int parentCateId;
    private String cateName;
}
