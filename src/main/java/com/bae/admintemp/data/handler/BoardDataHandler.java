package com.bae.admintemp.data.handler;


import com.bae.admintemp.data.entity.Board;
import com.bae.admintemp.data.entity.Category;
import com.bae.admintemp.data.entity.Member;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BoardDataHandler {

    Board saveBoardEntity(int id, String title, String contents, String imgUrl, String imgName, int viewCnt, String secure,
                          int likeCnt, Member member, Category category);

    Board getBoardEntity(int id);

    List<Board> findAll();

}