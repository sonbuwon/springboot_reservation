package com.packt.cardatabase.repository;

import com.packt.cardatabase.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
