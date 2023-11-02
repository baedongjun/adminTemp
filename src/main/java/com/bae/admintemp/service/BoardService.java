package com.bae.admintemp.service;

import com.bae.admintemp.data.dto.BoardDto;
import com.bae.admintemp.data.dto.ProductDto;
import com.bae.admintemp.data.entity.Board;
import com.bae.admintemp.data.entity.Category;
import com.bae.admintemp.data.entity.Member;
import com.bae.admintemp.data.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BoardService {
    BoardDto saveBoard(int id, String title, String contents, String imgUrl, String imgName, int viewCnt, String secure,
                       int likeCnt, Member member, Category category);

    BoardDto getBoard(int id);
    List<BoardDto> getList();
}