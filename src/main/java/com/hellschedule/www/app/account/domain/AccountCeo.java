package com.hellschedule.www.app.account.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "account_ceo")
public class AccountCeo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 상호명

    // 주소

    // 개업 일자

    // 사업자번호

    // 락커 총 횟수

    // 회원복

    @NotNull(message = "등록자를 입력해 주세요")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;
}
