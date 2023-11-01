package com.bae.admintemp.data.handler;


import com.bae.admintemp.data.entity.Category;

public interface CategoryDataHandler {

    Category saveCategoryEntity(String categoryId, String categoryName, int categoryPrice, int categoryStock);

    Category getCategoryEntity(String categoryId);

}