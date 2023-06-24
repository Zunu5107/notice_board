package com.example.notice_board.dto;

import lombok.Getter;

@Getter
public class PostRequestCreatorDto extends PostDto{

    //modifity nullable = false;
    private String password;

    public PostRequestCreatorDto(String title, String username, String password, String contents) {
        super(title,username,contents);
        this.password = password;
    }
}
