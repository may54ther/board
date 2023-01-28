package io.ahakim.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    @GetMapping
    public String posts() {
        return "views/post/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        return "views/post/add";
    }

    @GetMapping("/{parentId}/reply")
    public String replyForm(@PathVariable Long parentId) {
        return "views/post/add";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id) {
        return "views/post/edit";
    }
}

