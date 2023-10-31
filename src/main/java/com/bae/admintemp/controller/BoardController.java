package com.bae.admintemp.controller;

import com.bae.admintemp.domain.Board;
import com.bae.admintemp.domain.Member;
import com.bae.admintemp.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
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

    @GetMapping("/list")
    public String getList(Model model){
        List<Board> list = boardService.getList();
        model.addAttribute("list", list);
        return "board/list";
    }

    @GetMapping("/write")
    public String writeGet(@AuthenticationPrincipal User user, Model model){
        Board board = new Board();
        Member member = new Member();
        member.setUserid(user.getUsername());
        board.setMember(member);

        model.addAttribute("board", board);
        return "board/write";
    }

    @PostMapping("/write")
    public String writePost(Board board, @AuthenticationPrincipal User user, Model model){
        Member member = new Member();
        member.setUserid(user.getUsername());
        board.setMember(member);
        boardService.write(board);

        return "redirect:/board/list";
    }

    @GetMapping("/read")
    public String read(Long bno, Model model){
        Board board = boardService.read(bno);
        if(board != null){
            model.addAttribute("board", board);
        }
        return "board/read";
    }

    @GetMapping("/modify")
    public String modifyGet(Long bno, Model model){
        Board board = boardService.read(bno);
        model.addAttribute("board", board);
        return "board/write";
    }
    @PostMapping("/modify")
    public String modifyPost(Board board, Model model){
        boardService.modify(board);
        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String remove(Long bno, Model model){
        boardService.remove(bno);
        return "redirect:/board/list";
    }


}
