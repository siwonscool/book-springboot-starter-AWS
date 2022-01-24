package com.siwon.book.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//JpaRepository<Entity 클래스,PK 타입> 를 상속하면 기본적인 CRUD 메소드가 자동으로 생성
public interface PostsRepository extends JpaRepository<Posts,Long> {

    // Spring JPA 에서 제공하지 않는 메소드는 다음과 같이 쿼리를 만들어 사용한다.
    // 하지만 아래의 기능은 JPA 에서 제공하긴함
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC ")
    List<Posts> findAllDesc();

}
