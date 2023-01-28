package io.ahakim.board.dto.pagination;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
public class Pageable {

    @Min(1)
    private int page;

    @Min(10)
    private int size;

    public Pageable() {
        this(1, 10);
    }

    public Pageable(int page, int size) {
        this.page = page > 0 ? page : 1;
        this.size = Math.max(size, 10);
    }

    @JsonIgnore
    public int getOffset() {
        return (this.page - 1) * this.size;
    }
}
