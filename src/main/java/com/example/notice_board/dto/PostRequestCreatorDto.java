package com.example.notice_board.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostRequestCreatorDto{
    private String username;
    //modifity nullable = false;
    private String password;
    private String title;
    private String contents;

    public PostRequestCreatorDto(String username, String password, String title, String contents) {
        this.username = username;
        this.password = password;
        this.title = title;
        this.contents = contents;
    }
}
