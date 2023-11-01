package com.bae.admintemp.data.handler;


import com.bae.admintemp.data.entity.Category;

public interface CategoryDataHandler {

    Category saveCategoryEntity(int cateId, int parentCateId, String cateName);

    Category getCategoryEntity(int cateId);

}