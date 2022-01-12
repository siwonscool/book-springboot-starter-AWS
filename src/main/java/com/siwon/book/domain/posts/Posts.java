package com.siwon.book.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
// 테이블과 링크될 클래스를 나타내는 @Entity
@Entity
public class Posts {

    // 해당 테이블의 PK 필드를 나타내는 @Id
    @Id
    // PK의 생성규칙을 지정할 수 있으며 GenerationType.IDENTITY 로 지정시 Auto increment가 됨
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 테이블의 칼럼을 나타내며 선언하지 않더라도 해당클래스의 필드는 칼럼이 됨
    // 기본값을 변경하고 싶을 경우 ( ex. 길이, 타입 ) 사용
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
