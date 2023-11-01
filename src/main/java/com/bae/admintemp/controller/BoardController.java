package com.bae.admintemp.controller;

import com.bae.admintemp.data.entity.Board;
import com.bae.admintemp.service.BoardService;
import com.bae.admintemp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    public String getList(Model model) {
        List<Board> list = boardService.getList();
        model.addAttribute("list", list);
        return "board/list";
    }

    @GetMapping("/write")
    public String writeGet(Model model) {
        Board board = new Board();
        model.addAttribute("board", board);
        return "board/write";
    }

    @PostMapping("/write")
    public String writePost(Board board) {
        boardService.write(board);
        return "redirect:/board/list";
    }

    @GetMapping("/view")
    public String read(int id, Model model) {
        Board board = boardService.view(id);
        if (board != null) {
            model.addAttribute("board", board);
        }
        return "board/view";
    }

    @GetMapping("/modify")
    public String modifyGet(int id, Model model) {
        Board board = boardService.read(id);
        model.addAttribute("board", board);
        return "board/write";
    }

    @PostMapping("/remove")
    public String remove(Integer id) {
        boardService.remove(id);
        return "redirect:/board/list";
    }


}
