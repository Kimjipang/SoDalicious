package com.example.sodalicious.article.repository;


import com.example.sodalicious.article.domain.cms__article;
import com.example.sodalicious.article.domain.ArticleRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    // 게시물 생성
    void postArticle(ArticleRequest request);
    // 게시물 상세 조회 view 카운트 증가
    void viewCount(Long article_id);
    // 게시물 상세 조회
    cms__article findById(Long article_id);
    // 게시물 목록 조회
    List<cms__article> findAll();
    // 게시물 삭제
    void deleteById(Long article_id);
    // 게시물 검색
    List<cms__article> searchArticleList(String title);
}
