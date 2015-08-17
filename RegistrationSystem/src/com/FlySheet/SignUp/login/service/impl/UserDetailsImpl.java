package com.FlySheet.SignUp.login.service.impl;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserDetailsImpl extends User {

	private static final long serialVersionUID = -3231277470761178946L;

	public UserDetailsImpl(String username, String password,
			Collection<? extends GrantedAuthority> authorities)
			throws IllegalArgumentException {
		super(username, password, true, true, true, true, authorities);
	}
}
