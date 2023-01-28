package io.ahakim.board.dto;


import io.ahakim.board.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostResponse {

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

    @Builder
    public PostResponse(Long id, String writer, String title, String content, Integer views, Long refId, Long parentId, Integer step, Integer level, String createdAt) {
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
    }

    public Post toEntity() {
        return Post.builder()
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
}