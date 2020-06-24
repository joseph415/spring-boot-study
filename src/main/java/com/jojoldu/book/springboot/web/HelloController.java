package com.jojoldu.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public HelloResponseDto hello(@RequestParam("name") String name, @RequestParam("amount") int amount) {

        return new HelloResponseDto(name, amount);
    }
}
