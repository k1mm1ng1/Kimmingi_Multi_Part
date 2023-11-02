package com.plent.mingi.domain.auth.entity;

import com.plent.mingi.domain.comment.entity.Comment;
import com.plent.mingi.domain.post.entity.Post;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String password;

    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> postList;
    public void addPost(Post post) {
        getPostList().add(post);
    }

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> commentList;
    public void addComment(Comment comment) {
        getCommentList().add(comment);
    }

    @Builder
    public User(String userId, String password, String name) {
        this.userId = userId;
        this.password = password;
        this.name = name;
    }

    public void updateUser(String userId, String password, String name) {
        this.userId = userId;
        this.password = password;
        this.name = name;
    }
}
