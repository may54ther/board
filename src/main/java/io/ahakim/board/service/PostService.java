package io.ahakim.board.service;

import io.ahakim.board.domain.Post;
import io.ahakim.board.dto.PostResponse;
import io.ahakim.board.exception.PostNotFoundException;
import io.ahakim.board.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;

    public PostResponse findById(Long id) {
        Post post = postMapper
                .selectById(id)
                .orElseThrow(PostNotFoundException::new);
        return post.toResponseDTO();
    }
}