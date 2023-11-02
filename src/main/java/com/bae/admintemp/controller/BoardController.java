package com.bae.admintemp.controller;

import com.bae.admintemp.data.dto.BoardDto;
import com.bae.admintemp.service.BoardService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public String getList(Model model) {
        List<BoardDto> list = boardService.getList();
        model.addAttribute("list", list);
        return "board/list";
    }

    @GetMapping("/write")
    public String writeGet(Model model) {
        BoardDto board = new BoardDto();
        model.addAttribute("board", board);
        return "board/write";
    }

    @PostMapping("/write")
    public String writePost(@Valid @RequestBody BoardDto boardDto) {
        boardService.write(boardDto);
        return "redirect:/board/list";
    }

    @GetMapping("/view")
    public String read(int id, Model model) {
        BoardDto board = boardService.view(id);
        if (board != null) {
            model.addAttribute("board", board);
        }
        return "board/view";
    }

    @GetMapping("/modify")
    public String modifyGet(int id, Model model) {
        BoardDto board = boardService.read(id);
        model.addAttribute("board", board);
        return "board/write";
    }

    @PostMapping("/remove")
    public String remove(Integer id) {
        boardService.remove(id);
        return "redirect:/board/list";
    }


}
