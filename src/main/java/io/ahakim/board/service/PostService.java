package io.ahakim.board.service;

import io.ahakim.board.domain.Post;
import io.ahakim.board.dto.PostRequest;
import io.ahakim.board.dto.PostResponse;
import io.ahakim.board.dto.pagination.Pageable;
import io.ahakim.board.exception.PostNotFoundException;
import io.ahakim.board.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;


    public int count() {
        return postMapper.count();
    }

    private void existsById(Long id) {
        if (!postMapper.existsById(id))
            throw new PostNotFoundException();
    }

    public List<PostResponse> findAll(Pageable pageable) {
        return postMapper.selectAll(pageable)
                         .stream().map(Post::toResponseDTO)
                         .collect(Collectors.toList());
    }

    public PostResponse findById(Long id) {
        Post post = postMapper
                .selectById(id)
                .orElseThrow(PostNotFoundException::new);
        return post.toResponseDTO();
    }

    private int getNextStepByParentId(Long parentId) {
        return postMapper.selectNextStepByParentId(parentId);
    }

    @Transactional
    public Long save(PostRequest requestDto) {
        Post savePost = requestDto.toEntity();
        postMapper.insert(savePost);
        return savePost.getId();
    }

    @Transactional
    public Long reply(Long parentId, PostRequest requestDto) {
        Post parentPost = postMapper
                .selectById(parentId)
                .orElseThrow(PostNotFoundException::new);
        int nextStep = getNextStepByParentId(parentId);

        Post reply = Post.builder()
                         .writer(requestDto.getWriter())
                         .title(requestDto.getTitle())
                         .content(requestDto.getContent())
                         .refId(parentPost.getRefId())
                         .parentId(parentId)
                         .step(nextStep)
                         .level(parentPost.nextLevel())
                         .build();

        updateSiblingSteps(reply.getRefId(), reply.getStep());
        postMapper.insertReply(reply);
        return reply.getId();
    }

    @Transactional
    public void update(Long id, PostRequest requestDTO) {
        Post updatePost = requestDTO.toEntity();
        updatePost.setId(id);
        postMapper.update(updatePost);
    }

    @Transactional
    public void updateViews(Long id) {
        existsById(id);
        postMapper.updateViews(id);
    }

    private void updateSiblingSteps(Long refId, Integer step) {
        postMapper.updateSiblingSteps(refId, step);
    }

    @Transactional
    public void remove(Long id) {
        existsById(id);
        postMapper.delete(id);
    }
}