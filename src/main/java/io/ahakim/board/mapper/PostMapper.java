package io.ahakim.board.mapper;

import io.ahakim.board.domain.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface PostMapper {

    Optional<Post> selectById(Long id);
}