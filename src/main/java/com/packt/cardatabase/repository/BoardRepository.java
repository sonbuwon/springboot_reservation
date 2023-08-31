package com.packt.cardatabase.repository;

import com.packt.cardatabase.domain.Board;
import com.packt.cardatabase.repository.search.BoardSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {

    @Query("select b from Board b where b.title like concat('%',:keyword,'%')")
    Page<Board> findKeyword(@Param("keyword") String keyword, Pageable pageable);


}
