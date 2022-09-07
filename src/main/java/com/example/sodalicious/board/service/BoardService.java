package com.example.sodalicious.board.service;


import com.example.sodalicious.board.domain.BoardRequest;
import com.example.sodalicious.board.domain.cms__board;
import com.example.sodalicious.board.repository.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardMapper boardMapper;

    BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }
    // 게시판 (board) 생성
    public void postBoard(BoardRequest request) {
        boardMapper.postBoard(request);
    }

    // 게시판 목록 조회
    public List<cms__board> getBoardList() {
        return boardMapper.findAll();
    }
    // 게시판 상세 조회
    public cms__board getBoard(Long board_id) {
        return boardMapper.findById(board_id);
    }
    // 게시판 삭제
    public void deleteBoard(Long board_id) {
        boardMapper.deleteById(board_id);
    }
}
