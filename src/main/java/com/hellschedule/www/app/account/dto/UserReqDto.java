package com.hellschedule.www.app.account.dto;

import com.hellschedule.www.app.account.domain.Account;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserReqDto {

    @Setter
    @Getter
    public static class LoginReqDto {
        private String username;
        private String password;
    }

    @Setter
    @Getter
    public static class JoinReqDto {
        @NotEmpty
        @Pattern(regexp = "^[a-zA-Z0-9]{2,10}@[a-zA-Z0-9]{2,6}\\.[a-zA-Z]{2,3}$", message = "이메일 형식으로 작성해주세요")
        private String username;

        @NotEmpty
        @Size(min = 4, max = 20)
        private String password;

        public Account toEntity(BCryptPasswordEncoder passwordEncoder) {
            return Account.builder()
                          .role(Account.Role.USER)
                          .username(username)
                          .password(passwordEncoder.encode(password))
                          .build();
        }
    }
}
