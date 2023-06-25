package com.example.notice_board.controller;


import com.example.notice_board.dto.*;
import com.example.notice_board.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class NoticeController {

    private PostService postService;

    @Autowired
    public NoticeController(PostService postService) {
        this.postService = postService;
    }


    // GET
    // http://localhost:8080/api/posts
    @GetMapping("/posts")
    public List<PostResponseDto> getPosts() {
        return postService.getPostAll();
    }

    // POST
    // http://localhost:8080/api/posts
    @PostMapping("/posts")
    public PostResponseDto createPost(@RequestBody PostRequestCreatorDto requestDto) {
        return postService.createPost(requestDto);
    }

    // GET
    // http://localhost:8080/api/posts/{id}
    @GetMapping("/posts/{id}")
    public PostResponseDto getPostDetail(@PathVariable Long id) {
        return postService.getSelectPost(id);
    }

    // PUT
    // http://localhost:8080/api/posts/{id}
    @PutMapping("/posts/{id}")
    public PostResponseDto ModifiedPost(@PathVariable Long id, @RequestBody PostRequestModifyDto requestDto){
        System.out.println("requestDto.toString() = " + requestDto.toString());
        return postService.modifiedSelectPost(id,requestDto);
    }

    // DELETE
    // http://localhost:8080/api/posts/{id}
    @DeleteMapping ("/posts/{id}")
    public ResultResponseTextDto DeletePost(@PathVariable Long id, @RequestBody PostRequestDeleteDto requestDto){
        return postService.DeleteSelectPost(id, requestDto);
    }

    @GetMapping("/test")
    public ResultResponseTextDto Temp(){ return new ResultResponseTextDto("Success"); }
}
