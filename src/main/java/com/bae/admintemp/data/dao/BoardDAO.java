package com.bae.admintemp.data.dao;


import com.bae.admintemp.data.entity.Board;

public interface BoardDAO {

    Board saveBoard(Board board);

    Board getBoard(Integer id);

}