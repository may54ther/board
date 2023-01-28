package io.ahakim.board.mapper;

import io.ahakim.board.domain.Post;
import io.ahakim.board.dto.pagination.Pageable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {

    int count();

    Boolean existsById(Long id);

    List<Post> selectAll(Pageable pageable);

    Optional<Post> selectById(Long id);

    int selectNextStepByParentId(Long parentId);

    void insert(Post post);

    void insertReply(Post post);

    void update(Post post);

    void updateViews(Long id);

    void updateSiblingSteps(Long refId, Integer step);

    void delete(Long id);
}