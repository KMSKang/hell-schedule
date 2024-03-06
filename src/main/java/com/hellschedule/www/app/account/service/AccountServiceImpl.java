package com.hellschedule.www.app.account.service;

import com.hellschedule.www.app.account.domain.Account;
import com.hellschedule.www.app.account.dto.AccountDto;
import com.hellschedule.www.app.account.dto.AccountReqDto;
import com.hellschedule.www.app.account.dto.AccountResDto;
import com.hellschedule.www.app.account.repository.AccountRepository;
import com.hellschedule.www.common.exception.CustomApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final PasswordEncoder passwordEncoder;

    private final AccountRepository accountRepository;

    // 회원가입 (중복 확인)
    public AccountResDto.Duplicate duplicate(AccountReqDto.Duplicate dto) {
        String signname = dto.getSignname();

        // 중복 가입 체크
        Account account = accountRepository.findBySignname(signname);
        if (account != null) {
            throw new CustomApiException("이미 가입된 계정이 있습니다");
        }

        return new AccountResDto.Duplicate();
    }

    // 회원가입 (회원, 강사)
    @Transactional
    public AccountResDto.Create createUser(AccountReqDto.CreateUser dto) {
        // 중복 가입 체크
        Account account = accountRepository.findBySignname(dto.getSignname());
        if (account != null) {
            throw new CustomApiException("이미 가입된 계정이 있습니다");
        }

        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        Account entity = accountRepository.save(dto.toEntity());

        return new AccountResDto.Create(entity);
    }

    // 회원가입 (대표자)
    @Transactional
    public AccountResDto.Create createCeo(AccountReqDto.CreateCeo dto) {
        return null;
    }
}
