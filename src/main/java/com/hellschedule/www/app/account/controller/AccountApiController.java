package com.hellschedule.www.app.account.controller;

import com.hellschedule.www.app.account.dto.AccountReqDto;
import com.hellschedule.www.app.account.service.AccountService;
import com.hellschedule.www.common.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/accounts")
public class AccountApiController {
    private final AccountService service;

    // 회원가입 (중복 확인)
    @PostMapping("/duplicate")
    public ResponseEntity<?> duplicate(@RequestBody @Valid AccountReqDto.Duplicate dto, BindingResult bindingResult) {
        return ResponseEntity.ok(new ResponseDto<>(service.duplicate(dto)));
    }

    // 회원가입 (회원, 강사)
    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody @Valid AccountReqDto.CreateUser dto, BindingResult bindingResult) {
        return ResponseEntity.ok(new ResponseDto<>(service.createUser(dto)));
    }

    // 회원가입 (대표자)
    @PostMapping("/ceo")
    public ResponseEntity<?> createCeo(@RequestBody @Valid AccountReqDto.CreateCeo dto, BindingResult bindingResult) {
        return ResponseEntity.ok(new ResponseDto<>(service.createCeo(dto)));
    }
}
