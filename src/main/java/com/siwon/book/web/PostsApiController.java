package com.siwon.book.web;

import com.siwon.book.domain.posts.Posts;
import com.siwon.book.service.posts.PostsService;
import com.siwon.book.web.dto.PostsResponseDto;
import com.siwon.book.web.dto.PostsSaveRequestDto;
import com.siwon.book.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    /*
    * @RequiredArgsConstructor 어노테이션으로 Bean 주입을 생성자로 받는다
    * 기존에 사용했던 @AutoWired 와 동일한 효과를 얻을 수 있다.
    * 장점 1. 순환 참조 방지가능.
    * 장점 2. 테스트 코드 작성이 편리하다.
    * 장점 3. 더좋은 품질의 코드 작성이 가능.
    * 장점 4. immutable 하여 실행중 객체가 변하는것을 막거나, 오류를 사전에 방지할 수 있다.
    * */
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id,requestDto);
    }

    @GetMapping("api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("api/v1/posts/{id}")
    public Long delete(@PathVariable long id){
        postsService.delete(id);
        return id;
    }

}
