package com.hellschedule.www.app.account.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AccountReqDto {
    @Getter
    @Setter
    public static class Duplicate {
        @NotBlank(message = "아이디를 입력해 주세요")
        @Pattern(regexp = "^[a-zA-Z0-9]{2,10}@[a-zA-Z0-9]{2,6}\\.[a-zA-Z]{2,3}$", message = "이메일 형식으로 입력해 주세요")
        private String signname;
    }

    @Getter
    @Setter
    public static class CreateUser extends AccountDto {
        //
    }

    @Getter
    public static class CreateCeo extends AccountDto {
        @NotBlank(message = "대표자명을 입력해 주세요")
        @Size(max = 10, message = "대표자명을 10자 이내로 입력해 주세요")
        private String ceoname;
    }
}
