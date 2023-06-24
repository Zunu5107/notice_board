package com.example.notice_board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PostDto {
    private String title;
    private String username;
    private String contents;


    public PostDto(String title, String username, String contents) {
        this.title = title;
        this.username = username;
        this.contents = contents;
    }
}
