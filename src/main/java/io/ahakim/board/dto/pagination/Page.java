package io.ahakim.board.dto.pagination;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ToString
public class Page<T> {

    private final List<T> list = new ArrayList<T>();
    private final Pageable pageable;
    private final int total;

    public Page(List<T> content) {
        this(content, null, null == content ? 0 : content.size());
    }

    public Page(List<T> list, Pageable pageable, int total) {
        if (null == list) {
            throw new IllegalArgumentException("List must not be null");
        }

        this.list.addAll(list);
        this.pageable = pageable;
        this.total = total;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public List<T> getList() {
        return Collections.unmodifiableList(list);
    }

    public boolean hasContent() {
        return !list.isEmpty();
    }

    public int getPageNum() {
        return pageable.getPage();
    }

    public int getPageSize() {
        return pageable.getSize();
    }

    public int getTotalElement() {
        return total;
    }

    public int getTotalPage() {
        return (int) Math.ceil((double) getTotalElement() / pageable.getSize());
    }

    public int getPageStart() {
        return Math.floorDiv((pageable.getPage() - 1), 5) * 5 + 1;
    }

    public int getPageEnd() {
        return Math.min((getPageStart() + (5 - 1)), getTotalPage());
    }

    public boolean isFirstPage() {
        return !hasPrevPage();
    }

    public boolean isLastPage() {
        return !hasNextPage();
    }

    public boolean hasPrevPage() {
        return getPageStart() > 1;
    }

    public boolean hasNextPage() {
        return getPageEnd() != getTotalPage();
    }
}
