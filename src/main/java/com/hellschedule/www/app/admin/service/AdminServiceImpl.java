package com.hellschedule.www.app.admin.service;

import com.hellschedule.www.app.account.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {
    @Transactional
    public AccountDto index() {
        return null;
    }
}
