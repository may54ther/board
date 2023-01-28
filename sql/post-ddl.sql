CREATE TABLE posts (
    id         INT AUTO_INCREMENT COMMENT 'PK, 고유번호' PRIMARY KEY,
    writer     VARCHAR(100)                            NOT NULL COMMENT '작성자명',
    title      VARCHAR(100)                            NOT NULL COMMENT '제목',
    content    BLOB                                    NOT NULL COMMENT '내용',
    views      INT         DEFAULT 0                   NOT NULL COMMENT '조회수',
    ref_id     INT                                     NOT NULL COMMENT '참조 게시글 ID(기본값은 현재 게시글 ID)',
    parent_id  INT         DEFAULT 0                   NULL COMMENT '부모 게시글 ID',
    step       INT         DEFAULT 0                   NOT NULL COMMENT '게시글 순서',
    level      INT         DEFAULT 0                   NULL COMMENT '게시글 깊이',
    created_at DATETIME    DEFAULT CURRENT_TIMESTAMP() NOT NULL COMMENT '등록일',
    status     VARCHAR(10) DEFAULT 'DEFAULT'           NOT NULL COMMENT '사용 여부',
    CONSTRAINT status CHECK (`status` IN ('DEFAULT', 'DELETED'))
);

CREATE INDEX post_id_idx ON posts (id);

