package com.bae.admintemp.data.handler.impl;


import com.bae.admintemp.data.dao.CategoryDAO;
import com.bae.admintemp.data.entity.Category;
import com.bae.admintemp.data.handler.CategoryDataHandler;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoryDataHandlerImpl implements CategoryDataHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(CategoryDataHandlerImpl.class);

    CategoryDAO categoryDAO;

    @Autowired
    public CategoryDataHandlerImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public Category saveCategoryEntity(String categoryId, String categoryName, int categoryPrice,
                                     int categoryStock) {

        LOGGER.debug("[saveCategoryEntity] 매개변수를 통해 Entity 객체 생성");
        Category category = new Category(categoryId, categoryName, categoryPrice,
                categoryStock);

        LOGGER.info("[saveCategoryEntity] categoryDAO로 Category 정보 저장 요청. categoryId : {}", categoryId);
        return categoryDAO.saveCategory(category);
    }

    @Override
    public Category getCategoryEntity(String categoryId) {
        LOGGER.info("[saveCategoryEntity] categoryDAO로 Category 정보 요청. categoryId : {}", categoryId);
        return categoryDAO.getCategory(categoryId);
    }
}