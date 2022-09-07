package com.example.sodalicious.board.repository;

import com.example.sodalicious.board.domain.BoardRequest;
import com.example.sodalicious.board.domain.cms__board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 게시판 (board) 생성
    void postBoard(BoardRequest request);
    // 게시판 목록 조회
    List<cms__board> findAll();
    // 게시판 상세 조회
    cms__board findById(Long board_id);
    // 게시판 삭제
    void deleteById(Long board_id);
}
