package com.bootcamp.springboot.Implementation;

import com.bootcamp.springboot.model.Users;
import com.bootcamp.springboot.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private UsersService usersService;

    @Autowired
    public UserDetailsServiceImpl(UsersService usersService) {
        this.usersService = usersService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersService.findByUsername(username);
        if (users == null) {
            throw new UsernameNotFoundException("Username " + username + " not found.");
        } else if (!users.isActive()) {
            throw new BadCredentialsException("User is not active");
        }
        return new org.springframework.security.core.userdetails.User(users.getUsername(), users.getPassword(), loadAuthorities(users));
    }

    private Collection<? extends GrantedAuthority> loadAuthorities(Users users) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        logger.info("{}", users.getRoles().toArray());
        users.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
        return authorities;
    }
}
