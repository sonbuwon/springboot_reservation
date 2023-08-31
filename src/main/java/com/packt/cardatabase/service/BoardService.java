package com.packt.cardatabase.service;

import com.packt.cardatabase.domain.dto.BoardDTO;
import com.packt.cardatabase.domain.dto.PageRequestDTO;
import com.packt.cardatabase.domain.dto.PageResponseDTO;

public interface BoardService {

    Long register(BoardDTO boardDTO);
    BoardDTO readOne(Long bno);
    void modify(BoardDTO boardDTO);
    void remove(Long bno);
    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);
}
