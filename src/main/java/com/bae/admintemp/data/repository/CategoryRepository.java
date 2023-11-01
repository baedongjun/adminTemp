package com.bae.admintemp.data.repository;

import com.bae.admintemp.data.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByCateId(int cateId);
}