package com.hellschedule.www.app.account.dto;

import com.hellschedule.www.app.account.domain.Account;
import lombok.Getter;

public class AccountResDto {
    @Getter
    public static class Duplicate extends AccountDto {
        public Duplicate() {
            //
        }
    }

    @Getter
    public static class Create extends AccountDto {
        public Create(Account entity) {
            super.setId(entity.getId());
        }
    }
}
