package com.bae.admintemp.service;

import com.bae.admintemp.data.dto.BoardDto;
import com.bae.admintemp.data.dto.ProductDto;
import com.bae.admintemp.data.entity.Board;
import com.bae.admintemp.data.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BoardService {
    BoardDto saveBoard(BoardDto boardDto);

    BoardDto getBoard(int id);
    List<BoardDto> getList();

    BoardDto write(BoardDto boardDto);

    BoardDto view(int id);

    BoardDto read(int id);

    BoardDto modify(BoardDto boardDto);

    BoardDto remove(int id);

    // 전체 게시물을 가져오는 메서드
//    public List<Board> getList() {
//        return (List<Board>) boardRepository.findAll();
//    }

    //게시물을 작성하는 메서드
//    public Board write(Board board) {
//        return boardRepository.save(board);
//    }

//    public Board view(int id) {
//        Board board = boardRepository.findById(id);
//        if (board == null) return null;
//        board.setViewCnt(board.getViewCnt() + 1);
//        boardRepository.save(board);
//        return board;
//    }

    //게시물을 읽어오는 메서드
//    public Board read(int id) {
//        Board board = boardRepository.findById(id);
//        if (board == null) return null;
//        return board;
//    }

    //게시물을 수정하는 메서드
//    public Board modify(Board newBoard) {
//        Board board = boardRepository.findById(newBoard.getId());
//        if (board == null) return null;
//        board.setTitle(newBoard.getTitle());
//        board.setContents(newBoard.getContents());
//        return boardRepository.save(board);
//    }
//
//    //게시물을 삭제하는 메서드
//    @Transactional
//    public void remove(int id) {
//        Board board = boardRepository.findById(id);
//        if (board != null) boardRepository.deleteById(id);
//
//    }
}