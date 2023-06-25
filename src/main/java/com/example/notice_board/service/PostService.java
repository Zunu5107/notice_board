package com.example.notice_board.service;

import com.example.notice_board.dto.*;
import com.example.notice_board.entity.Post;
import com.example.notice_board.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PostService {

    PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostResponseDto> getPostAll() {
        return postRepository.findAllByOrderByCreatedAtDesc().stream().map(PostResponseDto::new).toList();
    }

    public PostResponseDto getSelectPost(long id) {
        return new PostResponseDto(findPost(id));
    }

    public PostResponseDto createPost(PostRequestCreatorDto requestDto) {
        Post post = new Post(requestDto);

        Post resultPost = this.postRepository.save(post);

        return new PostResponseDto(resultPost);
    }


    // 게시글의 id // 게시글 수정할 데이터 + 패스워드 동일화 체크
    @Transactional
    public PostResponseDto modifiedSelectPost(long id, PostRequestModifyDto requestDto) {
        Post changepost = findPost(id);

        if(CheckPassword(changepost, requestDto.getPassword())){
            if(requestDto.getTitle() != null)
                changepost.updateTitle(requestDto.getTitle());
            if(requestDto.getUsername() != null)
                changepost.updateUsername(requestDto.getUsername());
            if(requestDto.getContents() != null)
                changepost.updateContents(requestDto.getContents());
        }

        return new PostResponseDto(changepost);
    }

    // 게시글의 id + 패스워드 동일화 체크
    public ResultResponseTextDto DeleteSelectPost(long id, PostRequestDeleteDto requestDto) {
        String password = requestDto.getPassword();
        if (password == null)
            return new ResultResponseTextDto("RequestBody Error");
        Post changepost = findPost(id);
        if(CheckPassword(changepost, password)){
            this.postRepository.delete(changepost);

            return new ResultResponseTextDto("Success");
        }
        return new ResultResponseTextDto("Fail");
    }

    private Post findPost(long id) {
        return this.postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("선택한 게시글은 존재하지 않습니다."));
    }

    private boolean CheckPassword(Post post, String password) {
        if(post.getPassword().equals(password)){
            return true;
        }
        else{
            throw new IllegalArgumentException("패스워드 일치하지 않음.");
        }
    }

}
