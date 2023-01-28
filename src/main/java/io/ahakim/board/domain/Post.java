package io.ahakim.board.domain;

import io.ahakim.board.dto.PostRequest;
import io.ahakim.board.dto.PostResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Post {

    private Long id;

    private String writer;

    private String title;

    private String content;

    private Integer views;

    private Long refId;

    private Long parentId;

    private Integer step;

    private Integer level;

    private String createdAt;

    private String status;

    public Integer nextLevel() {
        return this.level + 1;
    }

    public PostRequest toRequestDTO() {
        return PostRequest.builder()
                          .writer(writer)
                          .title(title)
                          .content(content)
                          .parentId(parentId)
                          .build();
    }

    public PostResponse toResponseDTO() {
        return PostResponse.builder()
                           .id(id)
                           .writer(writer)
                           .title(title)
                           .content(content)
                           .views(views)
                           .refId(refId)
                           .parentId(parentId)
                           .step(step)
                           .level(level)
                           .createdAt(createdAt)
                           .build();
    }

    @Builder
    public Post(Long id, String writer, String title, String content, Integer views, Long refId, Long parentId, Integer step, Integer level, String createdAt, String status) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.views = views;
        this.refId = refId;
        this.parentId = parentId;
        this.step = step;
        this.level = level;
        this.createdAt = createdAt;
        this.status = status;
    }
}


