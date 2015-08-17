package com.FlySheet.SignUp.login.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.FlySheet.SignUp.dao.UsersDAO;

import data.Users;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsersDAO usersDAO;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		Users user = null;

		if (!username.equals("roleAnonymous")) {
			try {
				user = usersDAO.findByUsername(username);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (user != null) {
			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			return new UserDetailsImpl(user.getUsername(), user.getPassword(), grantedAuthorities);
		}

		throw new UsernameNotFoundException("Invalid username: " + username);
	}

}
