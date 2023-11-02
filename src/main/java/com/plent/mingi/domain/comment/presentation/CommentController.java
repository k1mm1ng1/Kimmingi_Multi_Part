package com.plent.mingi.domain.comment.presentation;

import com.plent.mingi.domain.comment.presentation.dto.CreateCommentRequest;
import com.plent.mingi.domain.comment.presentation.dto.response.CommentListResponse;
import com.plent.mingi.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{post-id}")
    public Long createComment(
            @PathVariable("post-id") Long postId,
            @RequestBody CreateCommentRequest request
    ) {
        return commentService.createComment(postId, request);
    }

    @GetMapping("/{post-id}")
    public CommentListResponse getAllComment(
            @PathVariable("post-id") Long postId,
            Pageable pageable
    ) {
        return commentService.getAllComment(pageable, postId);
    }

}
