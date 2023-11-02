package com.bae.admintemp.data.dao;


import com.bae.admintemp.data.entity.Board;
import com.bae.admintemp.data.entity.Member;

import java.util.List;
import java.util.Optional;

public interface BoardDAO {

    Board saveBoard(Board board);

    Board getBoard(Integer id);

    List<Board> findAll();

}