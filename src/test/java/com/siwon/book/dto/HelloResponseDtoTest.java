package com.siwon.book.dto;

import com.siwon.book.web.dto.HelloResponseDto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        /*
        * assertThat 은 테스트 검증 라이브러리의 검증 메소드로 메소드 체이닝 디원으로 isEqualTo 와 같이 메소드를 이어서 사용가능
        * */
        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
