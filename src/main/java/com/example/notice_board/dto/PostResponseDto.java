package com.example.notice_board.dto;

import com.example.notice_board.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto extends PostDto {

    private Long postnumber;
    private LocalDateTime createdAt;
    public PostResponseDto(Post post) {
        super(post.getTitle(),post.getUsername(),post.getContents());
        this.postnumber = post.getPostnumber();
        this.createdAt = post.getCreatedAt();
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %s, %s, %s", this.postnumber, super.getTitle(), super.getUsername(), super.getContents(), this.createdAt);
    }

}
