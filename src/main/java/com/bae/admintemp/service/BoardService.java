package com.bae.admintemp.service;

import com.bae.admintemp.domain.Board;
import com.bae.admintemp.domain.Member;
import com.bae.admintemp.repository.BoardRepository;
import com.bae.admintemp.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    // 전체 게시물을 가져오는 메서드
    public List<Board> getList(){
        return (List<Board>) boardRepository.findAll();
    }

    //게시물을 작성하는 메서드
    public Board write(Board board){
        return boardRepository.save(board);
    }

    //게시물을 읽어오는 메서드
    public Board read(Long bno){
        Board board = boardRepository.findByBno(bno);
        if(board == null) return null;
        board.setView_cnt(board.getView_cnt() + 1);
        boardRepository.save(board);
        return board;
    }

    //게시물을 수정하는 메서드
    public Board modify(Board newBoard){
        Board board = boardRepository.findByBno(newBoard.getBno());
        if(board == null) return null;
        board.setTitle(newBoard.getTitle());
        board.setContent(newBoard.getContent());
        return boardRepository.save(board);
    }

    //게시물을 삭제하는 메서드
    @Transactional
    public void remove(Long bno){
        Board board = boardRepository.findByBno(bno);
        if(board != null) boardRepository.deleteByBno(bno);

    }
}