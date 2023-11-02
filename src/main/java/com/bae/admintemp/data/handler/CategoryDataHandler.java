package com.bae.admintemp.data.handler;


import com.bae.admintemp.data.entity.Board;
import com.bae.admintemp.data.entity.Category;

import java.util.List;

public interface CategoryDataHandler {

    Category saveCategoryEntity(int cateId, int parentCateId, String cateName, List<Board> list);

    Category getCategoryEntity(int cateId);

}