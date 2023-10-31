package com.bae.admintemp.repository;

import com.bae.admintemp.domain.Board;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    int countAllByWriter(String writer);

    Board findByBno(Long bno);

    void deleteByBno(Long bno);

    List<Board> findByWriter(String writer);

    List<Board> findByTitleAndWriter(String title, String writer);

    @Transactional
    int deleteByWriter(String writer);
}