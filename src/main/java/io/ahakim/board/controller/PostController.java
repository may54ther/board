package io.ahakim.board.controller;

import io.ahakim.board.dto.PostRequest;
import io.ahakim.board.dto.PostResponse;
import io.ahakim.board.dto.pagination.Page;
import io.ahakim.board.dto.pagination.Pageable;
import io.ahakim.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public String posts(@ModelAttribute Pageable pageable, Model model) {
        int count = postService.count();
        List<PostResponse> list = postService.findAll(pageable);
        Page<PostResponse> response = new Page<>(list, pageable, count);
        model.addAttribute("posts", response);
        return "views/post/list";
    }

    @GetMapping("/{id}")
    public String post(@PathVariable Long id, Model model) {
        PostResponse post = postService.findById(id);
        postService.updateViews(id);
        model.addAttribute("post", post);
        return "views/post/detail";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("post", new PostRequest());
        return "views/post/add";
    }

    @PostMapping("/add")
    public String addPost(@Valid @ModelAttribute("post") PostRequest postRequest,
                          BindingResult bindingResult,
                          RedirectAttributes redirect) throws BindException {
        if (bindingResult.hasFieldErrors()) {
            throw new BindException(bindingResult);
        }
        Long savedId = postService.save(postRequest);
        redirect.addAttribute("id", savedId);
        return "redirect:{id}";
    }

    @GetMapping("/{parentId}/reply")
    public String replyForm(@PathVariable Long parentId, Model model) {
        model.addAttribute("post", new PostRequest());
        return "views/post/add";
    }

    @PostMapping("/{parentId}/reply")
    public String addReply(@PathVariable Long parentId,
                           @ModelAttribute("post") PostRequest postRequest,
                           RedirectAttributes redirect) {
        Long savedId = postService.reply(parentId, postRequest);
        System.out.println("savedId = " + savedId);
        redirect.addAttribute("id", savedId);
        return "redirect:/posts/{id}";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.findById(id));
        return "views/post/edit";
    }

    @PostMapping("/{id}/edit")
    public String editPost(@PathVariable Long id,
                           @ModelAttribute("post") PostRequest postRequest,
                           RedirectAttributes redirect) {
        postService.update(id, postRequest);
        redirect.addAttribute("id", id);
        return "redirect:/posts/{id}";
    }

    @GetMapping("/{id}/remove")
    public String removePost(@PathVariable long id) {
        postService.remove(id);
        return "redirect:/";
    }
}

