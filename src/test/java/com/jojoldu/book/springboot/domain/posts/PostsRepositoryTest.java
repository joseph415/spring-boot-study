package com.jojoldu.book.springboot.domain.posts;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/truncate.sql")
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @Autowired
    MemberRepository memberRepository;

    // @After
    // public void cleanUp() {
    //     postsRepository.deleteAll();
    // }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("jeseok95@gmail.com")
                .build()
        );

        //when
        List<Posts> posts = postsRepository.findAll();

        //then
        Posts post = posts.get(0);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        memberRepository.save(new Member("gkd"));

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        List<Member> member = memberRepository.findAll();

        Member member1 = member.get(0);

        System.out.println(posts.getId());
        System.out.println(member1.getId());

        System.out.println(">>>>> createData = " + posts.getCreateData() + ", modifiedDate = "
                + posts.getModifiedData());
        System.out.println(">>>>>" + now);

        assertThat(posts.getCreateData()).isAfter(now);
        assertThat(posts.getModifiedData()).isAfter(now);
    }
}