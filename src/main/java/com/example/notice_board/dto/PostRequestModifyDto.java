package com.example.notice_board.dto;

import lombok.Getter;

@Getter
public class PostRequestModifyDto extends PostDto{
    //modifity nullable = false;
    private String password;

    public PostRequestModifyDto(String title, String username, String password, String contents) {
        super(title,username,contents);
        this.password = password;
    }

    @Override
    public String toString() {
        return "PostRequestModifyDto{" +
                "title='" + super.getTitle() + '\'' +
                "username='" + super.getUsername() + '\'' +
                "password='" + this.password + '\'' +
                "contents='" + super.getContents() + '\'' +
                '}';
    }

}
