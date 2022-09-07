package com.example.sodalicious.article.domain;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class cms__article {
    private Long article_id;
    private Long board_id;
    private LocalDateTime created_datetime;
    private Boolean is_pinned;
    private Long view_count;
    private String title;
    private String content_html;
    private String content_string;
}
