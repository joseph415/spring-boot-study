package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class PostsRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Builder
    public PostsRequestDto(String title, String content, String author) {
        this(title, content);
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
            .title(this.title)
            .content(this.content)
            .author(this.author)
            .build();
    }
}

