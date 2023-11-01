package com.bae.admintemp.service;

import com.bae.admintemp.data.entity.Category;
import com.bae.admintemp.data.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getList() {
        return (List<Category>) categoryRepository.findAll();
    }

    public Optional<Category> findOne(int cateId) {
        return categoryRepository.findByCateId(cateId);
    }
}