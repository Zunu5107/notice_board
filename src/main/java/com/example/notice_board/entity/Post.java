package com.example.notice_board.entity;

import com.example.notice_board.dto.PostRequestCreatorDto;
import com.example.notice_board.dto.PostRequestModifyDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "posts")
@NoArgsConstructor
public class Post extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postnumber;

    @Column(name = "title")
    private String title;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "contents", nullable = false)
    private String contents;

    public Post(String title, String name, String password, String contents) {

        this.title = title;
        this.username = name;
        this.password = password;
        this.contents = contents;
    }

    public Post(PostRequestCreatorDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.contents = requestDto.getContents();
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateUsername(String username) {
        this.username = username;
    }

    public void updateContents(String contents) {
        this.contents = contents;
    }
}
