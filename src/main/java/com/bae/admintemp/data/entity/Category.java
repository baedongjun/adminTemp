package com.bae.admintemp.data.entity;

import com.bae.admintemp.data.dto.CategoryDto;
import com.bae.admintemp.data.dto.CustomerDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "category")
public class Category extends BaseEntity {
    @Id
    private Integer cateId;
    private Integer parentCateId;
    private String cateName;
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    List<Board> list = new ArrayList<>();

    public CategoryDto toDto(){
        return CategoryDto.builder()
                .cateId(cateId)
                .parentCateId(parentCateId)
                .cateName(cateName)
                .build();
    }
}