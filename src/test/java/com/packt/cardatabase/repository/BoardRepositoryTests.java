package com.packt.cardatabase.repository;

import com.packt.cardatabase.domain.Board;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
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

    @Test
    public void testPaging() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());
        Page<Board> result = this.boardRepository.findAll(pageable);

        result.forEach(e -> {
            log.info(e);
        });
    }

    @Test
    public void testJPQL() {
        Pageable pageable = PageRequest.of(0, 30, Sort.by("bno").descending());
        Page<Board> result = this.boardRepository.findKeyword("9", pageable);

        log.info(result.getNumber());

        result.forEach(e -> {
            log.info(e);
        });
    }

    @Test
    public void testSearch1() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());
        this.boardRepository.search1(pageable);
    }

    @Test
    public void testSearchAll() {
        String[] type = {"t", "c", "w"};
        String keyword = null;
        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());

        Page<Board> result = this.boardRepository.searchAll(type, keyword, pageable);

        log.info("Total Pages: " + result.getTotalPages());
        log.info("Total Elements: " + result.getTotalElements());
    }
}
