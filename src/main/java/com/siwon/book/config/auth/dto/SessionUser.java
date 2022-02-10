package com.siwon.book.config.auth.dto;

import com.siwon.book.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

// User 객체를 Session 에 담기 위해서 직렬화한 클래스를 생성한다.
// User 객체에 직렬화 코드를 넣게되면 다른 엔티티와 관계를 가질경우 유지보수성이 떨어지므로 클래스를 만들어 사용한다.
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
