package com.example.sodalicious.article.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleRequest {

//    private Long article_id;
//    private Boolean is_pinned;
//    private Long view_count;
    private Long board_id;
    private String title;
    private String content;
}
