package com.packt.cardatabase.controller;

import com.packt.cardatabase.domain.dto.BoardDTO;
import com.packt.cardatabase.domain.dto.PageRequestDTO;
import com.packt.cardatabase.domain.dto.PageResponseDTO;
import com.packt.cardatabase.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        PageResponseDTO<BoardDTO> responseDTO = this.boardService.list(pageRequestDTO);
        log.info("Response: " + responseDTO);
        model.addAttribute("responseDTO", responseDTO);
    }
}
