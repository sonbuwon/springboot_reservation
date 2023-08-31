package com.packt.cardatabase.service;

import com.packt.cardatabase.domain.Board;
import com.packt.cardatabase.domain.dto.BoardDTO;
import com.packt.cardatabase.domain.dto.PageRequestDTO;
import com.packt.cardatabase.domain.dto.PageResponseDTO;
import com.packt.cardatabase.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService{

    private final ModelMapper modelMapper;
    private final BoardRepository boardRepository;

    @Override
    public Long register(BoardDTO boardDTO) {

        Board board = this.modelMapper.map(boardDTO, Board.class);
        Long bno = this.boardRepository.save(board).getBno();

        return bno;
    }

    @Override
    public BoardDTO readOne(Long bno) {
        Optional<Board> optionalBoard = this.boardRepository.findById(bno);
        Board board = optionalBoard.orElseThrow();
        BoardDTO boardDTO = this.modelMapper.map(board, BoardDTO.class);
        return boardDTO;
    }

    @Override
    public void modify(BoardDTO boardDTO) {
        Optional<Board> optionalBoard = this.boardRepository.findById(boardDTO.getBno());
        Board board = optionalBoard.orElseThrow();
        board.change(boardDTO.getTitle(), boardDTO.getContent());
        this.boardRepository.save(board);
    }

    @Override
    public void remove(Long bno) {
        this.boardRepository.deleteById(bno);
    }

    @Override
    public PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO) {

        String[] types = pageRequestDTO.getTypes();
        String keyword = pageRequestDTO.getKeyword();
        Pageable pageable = pageRequestDTO.getPageable("bno");

        Page<Board> result = this.boardRepository.searchAll(types, keyword, pageable);

        List<BoardDTO> dtoList = result.stream().map(board -> modelMapper.map(board, BoardDTO.class)).collect(Collectors.toList());

        return PageResponseDTO.<BoardDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int)result.getTotalElements())
                .build();
    }
}
