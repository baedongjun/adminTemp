package com.bae.admintemp.service;

import com.bae.admintemp.data.dto.BoardDto;
import com.bae.admintemp.data.dto.CategoryDto;
import com.bae.admintemp.data.dto.MemberDto;
import com.bae.admintemp.data.entity.Board;
import com.bae.admintemp.data.entity.Category;
import com.bae.admintemp.data.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface CategoryService {
    CategoryDto saveCategory(int cateId, int parentCateId, String cateName, List<Board> list);

    CategoryDto getCategory(int cateId);

}