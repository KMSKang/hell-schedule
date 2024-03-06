package com.hellschedule.www.common.security.auth;

import com.hellschedule.www.app.account.domain.Account;
import com.hellschedule.www.app.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService implements UserDetailsService {
    private final AccountRepository repository;

    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    public UserDetails loadUserByUsername(String signname) throws UsernameNotFoundException {
        Account account = repository.findBySignname(signname);
        if (account == null) {
            new InternalAuthenticationServiceException("아이디를 찾을 수 없습니다");
        }
        return new LoginUser(account);
    }

}
