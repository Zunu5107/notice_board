package com.example.notice_board.dto;

import com.example.notice_board.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    private Long postNumber;
    private String title;
    private String username;
    private String contents;
    private LocalDateTime createdAt;

    public PostResponseDto(Post post) {
        this.postNumber = post.getPostnumber();
        this.title = post.getTitle();
        this.username = post.getUsername();
        this.contents = post.getContents();
        this.createdAt = post.getCreatedAt();
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %s, %s, %s", this.postNumber, this.username, this.title, this.contents, this.createdAt);
    }

}
