package com.hellschedule.www.app.account.service;

import com.hellschedule.www.app.account.dto.AccountDto;
import com.hellschedule.www.app.account.dto.AccountReqDto;
import com.hellschedule.www.app.account.dto.AccountResDto;

public interface AccountService {
    AccountResDto.Duplicate duplicate(AccountReqDto.Duplicate dto);
    AccountResDto.Create createUser(AccountReqDto.CreateUser dto);
    AccountResDto.Create createCeo(AccountReqDto.CreateCeo dto);
}
