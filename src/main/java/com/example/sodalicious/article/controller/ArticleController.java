package com.example.sodalicious.article.controller;


import com.example.sodalicious.article.domain.cms__article;
import com.example.sodalicious.article.domain.ArticleRequest;
import com.example.sodalicious.article.service.ArticleService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }
    // 게시물 생성
    @PostMapping("/article")
    public ResponseEntity<String> postArticle(@RequestBody ArticleRequest request) {
        articleService.postArticle(request);
        return ResponseEntity.ok().body("SUCCESS POST ARTICLE!");
    }
    // 게시물 상세 조회
    @GetMapping("/article/{article_id}")
    public ResponseEntity<cms__article> getArticle(@PathVariable Long article_id) {
        cms__article cmsarticle = articleService.getArticle(article_id);
        return ResponseEntity.ok().body(cmsarticle);
    }
    // 게시물 목록 조회
    @GetMapping("/article")
    public ResponseEntity<List<cms__article>> getAllArticles() {
        List<cms__article> cmsarticleList = articleService.getAllArticles();
        return ResponseEntity.ok().body(cmsarticleList);
    }
    // 게시물 삭제
    @DeleteMapping("/article/{article_id}")
    public ResponseEntity<String> deleteArticle(@PathVariable Long article_id) {
        articleService.deleteArticle(article_id);
        return ResponseEntity.ok().body("SUCCESS DELETE ARTICLE!");
    }
    // 게시물 검색 (단어)
    @GetMapping("/search/word")
    public ResponseEntity<List<cms__article>> searchAllArticlesByTitle(@RequestParam String title) {
        List<cms__article> searchResult = articleService.searchAllByTitle(title);
        return ResponseEntity.ok().body(searchResult);
    }
    // 게시물 검색 (특정 기간)
    @GetMapping("/search/date")
    public ResponseEntity<List<cms__article>> searchAllArticlesByDate(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime start,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime end
    ) {
        Timestamp timestamp1 = Timestamp.valueOf(start.toLocalDate().atStartOfDay());
        Timestamp timestamp2 = Timestamp.valueOf(end.toLocalDate().atStartOfDay());
        System.out.println(timestamp1);
        System.out.println(timestamp2);
        List<cms__article> searchResult = articleService.searchAllByDate(timestamp1, timestamp2);
        return ResponseEntity.ok().body(searchResult);
    }
}
