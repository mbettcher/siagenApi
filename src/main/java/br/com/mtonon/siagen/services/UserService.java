package br.com.mtonon.siagen.services;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.mtonon.siagen.security.UserSS;

public class UserService {
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}catch(Exception e) {
			return null;
		}
	}

}
