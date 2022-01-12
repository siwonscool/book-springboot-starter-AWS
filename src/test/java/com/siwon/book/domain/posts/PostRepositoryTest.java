package com.siwon.book.domain.posts;

import com.siwon.book.web.dto.PostsUpdateRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
// 별다른 설정 없이 @SpringBootTest 를 사용할 경우 H2 데이터베이스를 자동으로 실행
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    /*
    * JUnit 에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지정
    * 보통은 배포전 전체 테스트를 수행할 때 테스트간 데이터 침범을 막기위해 사용
    * */
    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        //테이블 posts 에 insert/update 쿼리를 실행, id가 없으면 insert 없으면 update
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("siwon@gmail.com")
                .build());

        //when
        //테이블 posts 에 있는 모든 데이터를 조회
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }


}
