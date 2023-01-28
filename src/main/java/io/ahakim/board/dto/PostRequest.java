package io.ahakim.board.dto;

import io.ahakim.board.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class PostRequest {

    @NotBlank
    @Size(max = 20)
    private String writer;

    @NotBlank
    @Size(max = 100)
    private String title;

    @NotBlank
    private String content;

    private Long parentId;

    @Builder
    public PostRequest(String writer, String title, String content, Long parentId) {
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.parentId = parentId;
    }

    public Post toEntity() {
        return Post.builder()
                   .writer(writer)
                   .title(title)
                   .content(content)
                   .parentId(parentId)
                   .build();
    }
}
