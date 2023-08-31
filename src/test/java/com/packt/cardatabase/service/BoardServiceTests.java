package com.packt.cardatabase.service;

import com.packt.cardatabase.domain.dto.BoardDTO;
import com.packt.cardatabase.domain.dto.PageRequestDTO;
import com.packt.cardatabase.domain.dto.PageResponseDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister() {
        BoardDTO boardDTO = BoardDTO.builder()
                .title("Sample Title")
                .content("Sample Content")
                .writer("Sampler")
                .build();

        boardService.register(boardDTO);
    }

    @Test
    public void testSave() {
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(101L)
                .title("Upgraded Title")
                .content("Upgraded Content").build();

        this.boardService.modify(boardDTO);
    }

    @Test
    public void testList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .type("tcw")
                .keyword("1")
                .page(1)
                .size(10)
                .build();

        PageResponseDTO<BoardDTO> responseDTO = this.boardService.list(pageRequestDTO);
        log.info(responseDTO);
    }
}
