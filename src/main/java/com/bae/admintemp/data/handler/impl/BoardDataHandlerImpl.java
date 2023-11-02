package com.bae.admintemp.data.handler.impl;


import com.bae.admintemp.data.dao.BoardDAO;
import com.bae.admintemp.data.entity.Board;
import com.bae.admintemp.data.entity.Category;
import com.bae.admintemp.data.entity.Member;
import com.bae.admintemp.data.handler.BoardDataHandler;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Transactional
public class BoardDataHandlerImpl implements BoardDataHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(BoardDataHandlerImpl.class);

    BoardDAO boardDAO;

    @Autowired
    public BoardDataHandlerImpl(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    @Override
    public Board saveBoardEntity(int id, String title, String contents, String imgUrl, String imgName, int viewCnt,
                                 String secure, int likeCnt, Date createAt, Date updateAt, Member member, Category category) {

        LOGGER.debug("[saveBoardEntity] 매개변수를 통해 Entity 객체 생성");
        Board board = new Board(id, title, contents, imgUrl, imgName, viewCnt, secure, likeCnt, createAt, updateAt, member,
                category);

        LOGGER.info("[saveBoardEntity] boardDAO로 Board 정보 저장 요청. id : {}", id);
        return boardDAO.saveBoard(board);
    }

    @Override
    public Board getBoardEntity(int id) {
        LOGGER.info("[saveBoardEntity] boardDAO로 Board 정보 요청. id : {}", id);
        return boardDAO.getBoard(id);
    }
}