package com.hellschedule.www.app.account.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Boolean.FALSE;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "권한을 입력해 주세요")
    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column
    private Role role = Role.USER;

    @NotBlank(message = "아이디를 입력해 주세요")
    @Pattern(regexp = "^[a-zA-Z0-9]{1,10}+$"
           , message = "10자 이내 영문, 숫자를 사용하여 입력해 주세요")
    @Column(unique = true)
    private String signname;

    @NotBlank(message = "비밀번호를 입력해 주세요")
    @Size(max = 100, message = "비밀번호를 100자 이내로 입력해 주세요")
    @Column
    private String password;

    @NotBlank(message = "이름을 입력해 주세요")
    @Pattern(regexp = "^[가-힣]{1,10}+$"
            , message = "10자 이내 한글을 사용하여 입력해 주세요")
    @Column
    private String username;

    @NotNull(message = "이메일을 입력해 주세요")
    @Pattern(regexp = "^[a-zA-Z0-9]{2,10}@[a-zA-Z0-9]{2,6}\\.[a-zA-Z]{2,3}$"
           , message = "이메일 형식으로 입력해 주세요")
    @Column
    private String email;

    @NotNull(message = "휴대폰 번호를 입력해 주세요")
    @Pattern(regexp = "^[0-9]{11}", message = "휴대폰 번호 형식으로 입력해 주세요")
    @Column
    private String phone;

    @NotNull(message = "등록일을 입력해 주세요")
    @Builder.Default
    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @NotNull(message = "수정일을 입력해 주세요")
    @Builder.Default
    @Column
    private LocalDateTime updatedAt = LocalDateTime.now();

    @NotNull(message = "삭제 여부를 입력해 주세요")
    @Builder.Default
    @Column
    private Boolean isDeleted = FALSE;

    @Builder.Default
    @OneToMany(mappedBy = "account")
    private List<AccountCeo> accountCeos = new ArrayList<>();

    @Getter
    @RequiredArgsConstructor
    public enum Role {
        USER("회원"),
        PARTNER("강사"),
        CEO("대표자"),
        ADMIN("관리자");

        final private String name;

        @JsonCreator
        public static Role parsing(String inputValue) {
            return Stream.of(Role.values())
                         .filter(category -> category.toString().equals(inputValue.toUpperCase()))
                         .findFirst()
                         .orElse(null);
        }
    }
}
