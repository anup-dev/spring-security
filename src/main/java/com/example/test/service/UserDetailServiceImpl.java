package com.example.test.service;

import com.example.test.entity.User;
import com.example.test.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by Anup on 9/9/15.
 */
public class UserDetailServiceImpl implements UserDetailsService {

    @Inject
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        if (user == null) {
            throw new UsernameNotFoundException("email donot exist");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                AuthorityUtils.createAuthorityList("ROLE_USER"));
    }

}
