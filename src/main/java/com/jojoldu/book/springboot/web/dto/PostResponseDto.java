package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PostResponseDto {
    private final Long id;
    private final String title;
    private final String content;
    private final String author;
}
