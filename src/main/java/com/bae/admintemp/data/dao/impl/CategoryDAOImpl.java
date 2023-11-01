package com.bae.admintemp.data.dao.impl;

import com.bae.admintemp.data.dao.CategoryDAO;
import com.bae.admintemp.data.entity.Category;
import com.bae.admintemp.data.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryDAOImpl implements CategoryDAO {

    private final Logger LOGGER = LoggerFactory.getLogger(CategoryDAOImpl.class);

    CategoryRepository categoryRepository;

    @Autowired
    public CategoryDAOImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category saveCategory(Category category) {
        LOGGER.info("[saveCategory] category 정보 저장. categoryId : {}", category.getCateId());
        Category category1 = categoryRepository.save(category);
        LOGGER.info("[saveCategory] category 정보 저장완료. categoryId : {}", category1.getCateId());
        return category1;
    }

    @Override
    public Category getCategory(Integer cateId) {
        LOGGER.info("[getCategory] category 정보 요청. categoryId : {}", cateId);
        Category category = categoryRepository.getById(cateId);
        LOGGER.info("[getCategory] category 정보 요청 완료. categoryId : {}", category.getCateId());
        return category;
    }

    /**
     * Repository에서 기본적으로 제공하는 대표적인 메소드
     */
    private void testRepositoryMethod() {
/*    categoryRepository.save();
    categoryRepository.getById();
    categoryRepository.delete();
    categoryRepository.deleteAll();
    categoryRepository.findAll();
    categoryRepository.saveAll();*/
    }
}