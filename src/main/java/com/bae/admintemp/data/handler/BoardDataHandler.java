package com.bae.admintemp.data.handler;


import com.bae.admintemp.data.entity.Board;
import com.bae.admintemp.data.entity.Category;
import com.bae.admintemp.data.entity.Member;

import java.util.Date;

public interface BoardDataHandler {

    Board saveBoardEntity(int id, String title, String contents, String imgUrl, String imgName, int viewCnt, String secure, int likeCnt, Date createAt, Date updateAt, Member member, Category category);

    Board getBoardEntity(int id);

}