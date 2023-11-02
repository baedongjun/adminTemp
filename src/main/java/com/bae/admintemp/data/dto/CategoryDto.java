package com.bae.admintemp.data.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@RedisHash(value = "category", timeToLive = 60)
public class CategoryDto {
    @NotNull
    @Id
    private int cateId;
    private int parentCateId;
    private String cateName;
}
