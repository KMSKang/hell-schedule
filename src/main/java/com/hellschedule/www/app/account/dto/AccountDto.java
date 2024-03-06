package com.hellschedule.www.app.account.dto;

import com.hellschedule.www.app.account.domain.Account;
import com.hellschedule.www.common.security.util.BaseDto;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AccountDto extends BaseDto {
    @NotNull(message = "권한 형식으로 입력해 주세요")
    private Account.Role role;

    @NotBlank(message = "아이디를 입력해 주세요")
    @Pattern(regexp = "^[a-zA-Z0-9]{1,10}+$"
           , message = "10자 이내 영문, 숫자를 사용하여 입력해 주세요")
    private String signname;

    @NotBlank(message = "비밀번호를 입력해 주세요")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%^&*?,./\\\\<>|_-[+]=\\`~\\(\\)\\[\\]\\{\\}])[A-Za-z[0-9]!@#$%^&*?,./\\\\<>|_-[+]=\\`~\\(\\)\\[\\]\\{\\}]{8,20}$"
           , message = "8~20자 이내 영문, 숫자, 특수문자를 사용하여 입력해 주세요")
    private String password;

    @NotBlank(message = "이름을 입력해 주세요")
    @Pattern(regexp = "^[가-힣]{1,10}+$"
           , message = "10자 이내 한글을 사용하여 입력해 주세요")
    private String username;

    @NotNull(message = "이메일을 입력해 주세요")
    @Pattern(regexp = "^[a-zA-Z0-9]{2,10}@[a-zA-Z0-9]{2,6}\\.[a-zA-Z]{2,3}$"
           , message = "이메일 형식으로 입력해 주세요")
    private String email;

    @NotNull(message = "휴대폰 번호를 입력해 주세요")
    @Pattern(regexp = "^[0-9]{11}", message = "휴대폰 번호 형식으로 입력해 주세요")
    private String phone;

    public Account toEntity() {
        return Account.builder()
                      .role(role)
                      .signname(signname)
                      .password(password)
                      .username(username)
                      .email(email)
                      .phone(phone)
                      .build();
    }
}
