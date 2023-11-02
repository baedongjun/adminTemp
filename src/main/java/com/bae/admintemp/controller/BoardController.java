package com.bae.admintemp.controller;

import com.bae.admintemp.data.dto.BoardDto;
import com.bae.admintemp.data.entity.Category;
import com.bae.admintemp.data.entity.Member;
import com.bae.admintemp.service.BoardService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final Logger LOGGER = LoggerFactory.getLogger(BoardController.class);
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public List<BoardDto> getBoardList() {
        List<BoardDto> list = boardService.getList();
        return list;
    }

    @GetMapping("/board/{id}")
    public BoardDto getBoard(@PathVariable int id) {
        long startTime = System.currentTimeMillis();
        LOGGER.info("[getBoard] perform {} of Around Hub API.", "getBoard");

        BoardDto boardDto = boardService.getBoard(id);

        LOGGER.info(
                "[getBoard] Response :: id = {}, title = {}, contents = {}, imgUrl = {}, imgName = {}, viewCnt = {}" +
                        ", secure = {}, likeCnt; = {}, member = {}, category = {}, Response Time = {}ms",
                boardDto.getId(), boardDto.getTitle(), boardDto.getContents(), boardDto.getImgUrl(), boardDto.getImgName(),
                boardDto.getViewCnt(), boardDto.getSecure(), boardDto.getLikeCnt(), boardDto.getMember(), boardDto.getCategory(),
                (System.currentTimeMillis() - startTime));
        return boardDto;
    }

    @PostMapping("/board")
    public ResponseEntity<BoardDto> createBoard(@Valid @RequestBody BoardDto boardDto) {
        LOGGER.info("[createBoard] perform {} of Around Hub API.", "createBoard");

        BoardDto response = boardService.saveBoard(boardDto.getId(), boardDto.getTitle(), boardDto.getContents(), boardDto.getImgUrl(),
                boardDto.getImgName(), boardDto.getViewCnt(), boardDto.getSecure(), boardDto.getLikeCnt(), boardDto.getMember(),
                boardDto.getCategory());

        LOGGER.info(
                "[createBoard] Response >> id : {}, title : {}, contents : {}, imgUrl : {}, imgName : {}, viewCnt : {}" +
                        ", secure : {}, likeCnt : {}, member : {}, category : {}",
                response.getId(), response.getTitle(), response.getContents(), response.getImgUrl(), response.getImgName(),
                response.getViewCnt(), response.getSecure(), response.getLikeCnt(), response.getMember(), response.getCategory());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/board/{id}")
    public ResponseEntity<BoardDto> deleteBoard(@PathVariable int id) {
        return null;
    }
}
