package com.bae.admintemp.data.repository;

import com.bae.admintemp.data.entity.Board;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    Board findById(int id);

    List<Board> findByTitleOrContents(String title, String contents);

    @Transactional
    void deleteById(int id);
}