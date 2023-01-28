package io.ahakim.board.exception;

public class PostNotFoundException extends CustomException {

    public PostNotFoundException() {
        super("게시글이 존재하지 않습니다.");
    }

    public PostNotFoundException(String message) {
        super(message);
    }
}
