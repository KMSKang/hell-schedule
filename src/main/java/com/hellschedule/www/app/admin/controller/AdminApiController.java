package com.hellschedule.www.app.admin.controller;


import com.hellschedule.www.app.admin.service.AdminService;
import com.hellschedule.www.common.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminApiController {
    private final AdminService service;

    @GetMapping
    public ResponseEntity<?> index() {
        return ResponseEntity.ok(new ResponseDto<>(1, "회원정보 성공", null));
    }
}
