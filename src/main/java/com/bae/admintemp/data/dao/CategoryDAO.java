package com.bae.admintemp.data.dao;


import com.bae.admintemp.data.entity.Category;

public interface CategoryDAO {

    Category saveCategory(Category category);

    Category getCategory(Integer cateId);

}