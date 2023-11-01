package com.bae.admintemp.data.dao.impl;

import com.bae.admintemp.data.dao.BoardDAO;
import com.bae.admintemp.data.entity.Board;
import com.bae.admintemp.data.repository.BoardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardDAOImpl implements BoardDAO {

    private final Logger LOGGER = LoggerFactory.getLogger(BoardDAOImpl.class);

    BoardRepository boardRepository;

    @Autowired
    public BoardDAOImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Board saveBoard(Board board) {
        LOGGER.info("[saveBoard] board 정보 저장. boardId : {}", board.getId());
        Board board1 = boardRepository.save(board);
        LOGGER.info("[saveBoard] board 정보 저장완료. boardId : {}", board1.getId());
        return board1;
    }

    @Override
    public Board getBoard(Integer id) {
        LOGGER.info("[getBoard] board 정보 요청. boardId : {}", id);
        Board board = boardRepository.getById(id);
        LOGGER.info("[getBoard] board 정보 요청 완료. boardId : {}", board.getId());
        return board;
    }

    /**
     * Repository에서 기본적으로 제공하는 대표적인 메소드
     */
    private void testRepositoryMethod() {
/*    boardRepository.save();
    boardRepository.getById();
    boardRepository.delete();
    boardRepository.deleteAll();
    boardRepository.findAll();
    boardRepository.saveAll();*/
    }
}