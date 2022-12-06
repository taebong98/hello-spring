package com.coffee.app.spring.practice.coffee.dto;

import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;

@Getter
public class CoffeePostDto {
    @Pattern(regexp = "^([가-힣])(\\s?[가-힣])*$",
            message = "커피명(한글)은 한글이어야 합니다(단어 사이 공백 한 칸 포함). 예) 아이스 아메리카노")
    private String korName;

    @Pattern(regexp = "^([a-zA-z])(\\s?[a-zA-Z])*$",
            message = "커피명(영문)은 영문이어야 합니다(단어 사이 공백 한 칸 포함). 예) Cafe Latte")
    private String engName;

    @Range(min = 100, max = 50000)
    private int price;


    @Pattern(regexp = "^([a-zA-Z]){3}",
            message = "커피코드는 3자리 영문이어야 합니다.")
    private String coffeeCode;
}
