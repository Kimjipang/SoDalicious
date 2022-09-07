package com.example.sodalicious.board.controller;


import com.example.sodalicious.article.domain.ArticleRequest;
import com.example.sodalicious.board.domain.BoardRequest;
import com.example.sodalicious.board.domain.cms__board;
import com.example.sodalicious.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {

    private final BoardService boardService;

    BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 게시판 (board) 생성
    @PostMapping("/board")
    public ResponseEntity<String> postBoard(@RequestBody BoardRequest request) {
        boardService.postBoard(request);
        return ResponseEntity.ok().body("SUCCESS POST BOARD!");
    }
    // 게시판 목록 조회
    @GetMapping("/board")
    public ResponseEntity<List<cms__board>> getBoardList() {
        List<cms__board> getCmsBoardList = boardService.getBoardList();
        return ResponseEntity.ok().body(getCmsBoardList);
    }
    // 게시판 상세 조회
    @GetMapping("/board/{board_id}")
    public ResponseEntity<cms__board> getBoard(@PathVariable Long board_id) {
        cms__board getCmsBoard = boardService.getBoard(board_id);
        return ResponseEntity.ok().body(getCmsBoard);
    }
    // 게시판 삭제
    @DeleteMapping("/board/{board_id}")
    public ResponseEntity<String> deleteBoard(@PathVariable Long board_id) {
        boardService.deleteBoard(board_id);
        return ResponseEntity.ok().body("SUCCESS DELETE BOARD!");
    }
}