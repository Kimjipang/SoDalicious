package com.example.sodalicious.article.controller;


import com.example.sodalicious.article.domain.cms__article;
import com.example.sodalicious.article.domain.ArticleRequest;
import com.example.sodalicious.article.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/search")
    public ResponseEntity<List<cms__article>> searchAllArticles(@RequestParam String title) {
        System.out.println(title);
        List<cms__article> searchResult = articleService.searchAllArticles(title);
        return ResponseEntity.ok().body(searchResult);
    }
    // 특정기간 게시물 조회
}
