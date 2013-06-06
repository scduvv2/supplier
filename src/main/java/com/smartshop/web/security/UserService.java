package com.smartshop.web.security;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smartshop.web.account.Account;
import com.smartshop.web.account.Role;
import com.smartshop.web.account.repository.AccountRepository;

public class UserService implements UserDetailsService{
	
	@Autowired
	AccountRepository accountRepository;



	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Account account = accountRepository.findByEmail(username);
		if(account == null) {
			throw new UsernameNotFoundException("user not found");
		}
		return createUser(account);
	}

	private UserDetails createUser(Account account) {
		return new User(account.getEmail(), account.getPassword(), createAuthority(account.getRoles()));

	}
	
	public void signin(Account account) {
		SecurityContextHolder.getContext().setAuthentication(authenticate(account));
	}

	private Authentication authenticate(Account account) {
		return new UsernamePasswordAuthenticationToken(createUser(account), null, createAuthority(account.getRoles()));		
	}
			

	private List<EnumGrantedAuthority> createAuthority(List<Role> roles) {

		List<EnumGrantedAuthority> enumGrantedAuthorities = new ArrayList<EnumGrantedAuthority>();
		for(Role role:roles){
			EnumGrantedAuthority authority = new EnumGrantedAuthority(role);
			enumGrantedAuthorities.add(authority);
			
		}
		return enumGrantedAuthorities;

	}

}
