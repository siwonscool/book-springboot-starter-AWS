package com.siwon.book.config.auth;

import com.siwon.book.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@RequiredArgsConstructor
//Spring Security 설정 활성화
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    // URL 별 권한 관리를 설정하는 옵션으로 이게 선언되어야 antMatchers 옵션 사용가능
                    .authorizeRequests()
                    // 권한관리 대상을 지정하는 옵션으로 URL, HTTP 별로 관리가능
                    // "/" 등 지정된 URL 들은 permitAll() 옵션을 통해 전체 열람 권한을 주었음
                    // "/api/v1/**" 주소를 가진 API 는 USER 권한을 가진 사람만 가능하도록 함
                    .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    // 설정된값 이외에 나머지 URL 을 anyRequest 로 가져와 authenticated 를 추가하여 나머지 URL 들은 모두 인증된 사용자들에게만 허용
                    .anyRequest().authenticated()
                .and()
                    .logout()
                        //로그인 성공시 URL
                        .logoutSuccessUrl("/")
                .and()
                    // OAuth 2 로그인 기능에 대한 여러 설정의 진입점
                    .oauth2Login()
                        // OAuth 2 로그인 성공 이후 사용자 정보를 가져올 때 설정을 담당
                        .userInfoEndpoint()
                            // 소셜로그인 성공시 후속 조치를 진행하는 UserService 인터페이스의 구현체를 등록
                            .userService(customOAuth2UserService);
    }
}
