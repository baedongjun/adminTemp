package com.bae.admintemp.service.impl;

import com.bae.admintemp.data.dto.CategoryDto;
import com.bae.admintemp.data.entity.Board;
import com.bae.admintemp.data.entity.Category;
import com.bae.admintemp.data.handler.CategoryDataHandler;
import com.bae.admintemp.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

    CategoryDataHandler categoryDataHandler;

    @Autowired
    public CategoryServiceImpl(CategoryDataHandler categoryDataHandler) {
        this.categoryDataHandler = categoryDataHandler;
    }

    @Override
    public CategoryDto saveCategory(int cateId, int parentCateId, String cateName, List<Board> list) {

        LOGGER.info("[saveCategory] categoryDataHandler 로 상품 정보 저장 요청");
        Category category = categoryDataHandler.saveCategoryEntity(cateId, parentCateId, cateName, list);

        LOGGER.info("[saveCategory] Entity 객체를 DTO 객체로 변환 작업. cateId : {}", category.getCateId());
        CategoryDto categoryDto = new CategoryDto(category.getCateId(), category.getParentCateId(), category.getCateName(), category.getList());

        return categoryDto;
    }

    @Override
    public CategoryDto getCategory(int cateId) {

        LOGGER.info("[getCategory] categoryDataHandler 로 상품 정보 조회 요청");
        Category category = categoryDataHandler.getCategoryEntity(cateId);

        LOGGER.info("[getCategory] Entity 객체를 DTO 객체로 변환 작업. cateId : {}", category.getCateId());
        CategoryDto categoryDto = new CategoryDto(category.getCateId(), category.getParentCateId(), category.getCateName(), category.getList());

        return categoryDto;
    }
}