package com.bae.admintemp.service.impl;

import com.bae.admintemp.data.dto.BoardDto;
import com.bae.admintemp.data.handler.BoardDataHandler;
import com.bae.admintemp.data.handler.MemberDataHandler;
import com.bae.admintemp.data.repository.MemberRepository;
import com.bae.admintemp.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final Logger LOGGER = LoggerFactory.getLogger(MemberServiceImpl.class);

    BoardDataHandler boardDataHandler;

    @Autowired
    public BoardServiceImpl(BoardDataHandler boardDataHandler) {
        this.boardDataHandler = boardDataHandler;
    }
    @Override
    public BoardDto saveBoard(BoardDto boardDto) {
        return null;
    }

    @Override
    public BoardDto getBoard(int id) {
        return null;
    }

    @Override
    public List<BoardDto> getList() {
        return null;
    }

    @Override
    public BoardDto write(BoardDto boardDto) {
        return null;
    }

    @Override
    public BoardDto view(int id) {
        return null;
    }

    @Override
    public BoardDto read(int id) {
        return null;
    }

    @Override
    public BoardDto modify(BoardDto boardDto) {
        return null;
    }

    @Override
    public BoardDto remove(int id) {
        return null;
    }
}
