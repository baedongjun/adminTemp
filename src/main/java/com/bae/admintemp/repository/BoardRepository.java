package com.bae.admintemp.repository;

import com.bae.admintemp.domain.Board;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    int countAllByMUserid(String mUserid);

    Board findByBId(int bId);

    void deleteByBId(int bId);

    List<Board> findByMUserid(String mUserid);

    List<Board> findByBTitleAndMUserid(String bTitle, String mUserid);

    @Transactional
    int deleteByMUserid(String mUserid);
}