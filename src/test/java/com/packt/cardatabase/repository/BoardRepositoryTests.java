package com.packt.cardatabase.repository;

import com.packt.cardatabase.domain.Board;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testInsert() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Board board = Board.builder()
                    .title("Title " + i)
                    .content("Content " + i)
                    .writer("user" + (i % 10))
                    .build();

            this.boardRepository.save(board);
        });
    }

    @Test
    public void testUpdate() {
        Optional<Board> optionalBoard = this.boardRepository.findById(100L);
        Board board = optionalBoard.orElseThrow();
        board.change("Updated Title", "Updated Content");
        this.boardRepository.save(board);
    }
}
