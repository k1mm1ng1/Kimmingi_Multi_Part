package com.plent.mingi.domain.comment.service;

import com.plent.mingi.domain.auth.entity.User;
import com.plent.mingi.domain.auth.facade.UserFacade;
import com.plent.mingi.domain.comment.entity.Comment;
import com.plent.mingi.domain.comment.presentation.dto.CreateCommentRequest;
import com.plent.mingi.domain.comment.presentation.dto.response.CommentListResponse;
import com.plent.mingi.domain.comment.presentation.dto.response.CommentResponse;
import com.plent.mingi.domain.comment.repository.CommentRepository;
import com.plent.mingi.domain.post.entity.Post;
import com.plent.mingi.domain.post.exception.PostNotFoundException;
import com.plent.mingi.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final UserFacade userFacade;

    @Transactional(rollbackFor = RuntimeException.class)
    public Long createComment(Long postId, CreateCommentRequest request) {
        User author = userFacade.queryUser(true);

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        Comment comment = Comment.builder()
                .comment(request.getComment())
                .build();
        comment.setAuthor(author);
        comment.setPost(post);
        post.addComment(comment);

        return comment.getCommentId();
    }

    @Transactional(readOnly = true)
    public CommentListResponse getAllComment(Pageable pageable, Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);
        Page<Comment> comments = commentRepository.findAllByPost(pageable, post);

        return CommentListResponse.builder()
                .list(comments.stream().map(it ->
                                CommentResponse.builder()
                                        .author(it.getAuthor().getName())
                                        .comment(it.getComment())
                                        .createdAt(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(it.getCreatedAt()))
                                        .build()
                        ).collect(Collectors.toList()))
                .build();
    }
}
