package com.example.sodalicious.board.domain;


import lombok.Data;
import lombok.Getter;


@Getter
@Data
public class BoardResponse {

    private Long board_id;
    private String name_ko;
}
