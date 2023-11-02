package com.bae.admintemp.service.impl;

import com.bae.admintemp.data.dto.BoardDto;
import com.bae.admintemp.data.dto.BoardDto;
import com.bae.admintemp.data.entity.Board;
import com.bae.admintemp.data.entity.Board;
import com.bae.admintemp.data.entity.Category;
import com.bae.admintemp.data.entity.Member;
import com.bae.admintemp.data.handler.BoardDataHandler;
import com.bae.admintemp.data.handler.BoardDataHandler;
import com.bae.admintemp.data.repository.BoardRepository;
import com.bae.admintemp.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService {

    private final Logger LOGGER = LoggerFactory.getLogger(BoardServiceImpl.class);

    BoardDataHandler boardDataHandler;

    @Autowired
    public BoardServiceImpl(BoardDataHandler boardDataHandler) {
        this.boardDataHandler = boardDataHandler;
    }
    @Override
    public BoardDto saveBoard(int id, String title, String contents, String imgUrl, String imgName, int viewCnt, String secure,
                              int likeCnt, Member member, Category category) {

        LOGGER.info("[saveBoard] boardDataHandler 로 상품 정보 저장 요청");
        Board board = boardDataHandler.saveBoardEntity(id, title, contents, imgUrl, imgName, viewCnt, secure, likeCnt, member, category);

        LOGGER.info("[saveBoard] Entity 객체를 DTO 객체로 변환 작업. userId : {}", board.getId());
        BoardDto boardDto = new BoardDto(board.getId(), board.getTitle(), board.getContents(),
                board.getImgUrl(), board.getImgName(), board.getViewCnt(), board.getSecure(),
                board.getLikeCnt(), board.getMember(), board.getCategory()
        );

        return boardDto;
    }

    @Override
    public BoardDto getBoard(int id) {

        LOGGER.info("[getBoard] boardDataHandler 로 상품 정보 조회 요청");
        Board board = boardDataHandler.getBoardEntity(id);

        LOGGER.info("[getBoard] Entity 객체를 DTO 객체로 변환 작업. userId : {}", board.getId());
        BoardDto boardDto = new BoardDto(board.getId(), board.getTitle(), board.getContents(),
                board.getImgUrl(), board.getImgName(), board.getViewCnt(), board.getSecure(),
                board.getLikeCnt(), board.getMember(), board.getCategory()
        );

        return boardDto;
    }

    @Override
    public List<BoardDto> getList() {
        List<Board> boardList = boardDataHandler.findAll();
        return boardList.stream().map(BoardDto::new).collect(Collectors.toCollection(LinkedList::new));
    }


}
