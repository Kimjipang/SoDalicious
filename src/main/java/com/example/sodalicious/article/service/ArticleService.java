package com.example.sodalicious.article.service;

import com.example.sodalicious.article.domain.cms__article;
import com.example.sodalicious.article.domain.ArticleRequest;
import com.example.sodalicious.article.repository.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    
    @Autowired
    private final ArticleMapper articleMapper;
    
    ArticleService(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }
    // 게시물 생성
    public void postArticle(ArticleRequest request) {
        articleMapper.postArticle(request);
    }
    // 게시물 상세 조회
    public cms__article getArticle(Long article_id) {
        articleMapper.viewCount(article_id);
        return articleMapper.findById(article_id);
    }
    // 게시물 목록 조회
    public List<cms__article> getAllArticles() {
        return articleMapper.findAll();
    }
    // 게시물 삭제
    public void deleteArticle(Long article_id) {
        articleMapper.deleteById(article_id);
    }
}
