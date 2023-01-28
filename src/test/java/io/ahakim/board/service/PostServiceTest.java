package io.ahakim.board.service;

import io.ahakim.board.dto.PostResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
class PostServiceTest {

    @Autowired
    PostService postService;

    @Test
    @DisplayName("게시글 조회 성공")
    void findById_Success() throws Exception {
        Long findId = 2L;
        PostResponse findPost = postService.findById(findId);

        assertThat(findPost.getId()).isEqualTo(findId);
    }

    @Test
    @DisplayName("게시글 조회 실패")
    void findById_Fail() throws Exception {
        Long findId = 0L;
        PostResponse findPost = postService.findById(findId);
        
        assertThat(findPost.getId()).isEqualTo(findId);
    }
}