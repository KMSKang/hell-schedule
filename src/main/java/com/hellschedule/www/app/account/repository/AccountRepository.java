package com.hellschedule.www.app.account.repository;

import com.hellschedule.www.app.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findBySignname(String username);
}
