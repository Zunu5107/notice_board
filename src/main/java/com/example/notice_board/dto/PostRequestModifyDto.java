package com.example.notice_board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestModifyDto{
    private String username;
    //modifity nullable = false;
    private String password;
    private String title;
    private String contents;

    public PostRequestModifyDto(String username, String password, String title, String contents) {
        this.username = username;
        this.password = password;
        this.title = title;
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "PostRequestModifyDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
