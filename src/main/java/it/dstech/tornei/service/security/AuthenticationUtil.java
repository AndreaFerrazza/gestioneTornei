package it.dstech.tornei.service.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import it.dstech.tornei.model.Role;

public class AuthenticationUtil {

	public static boolean hasRole(String role) {
		Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication()
				.getAuthorities();
		boolean hasRole = false;
		for (GrantedAuthority authority : authorities) {
			hasRole = authority.getAuthority().equals(role);
			if (hasRole)
				return hasRole;
		}
		return hasRole;
	}

	/**
	 * @return username dell'utente loggato
	 */
	public static String getUsername() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	/**
	 * @return restituisce una lista di authorities partendo dai ruoli
	 */
	public static List<GrantedAuthority> getAuthorities(Set<Role> ruoli) {
		GrantedAuthority authority;
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role role : ruoli) {
			authority = new SimpleGrantedAuthority(role.getNome());
			authorities.add(authority);
		}
		return authorities;
	}
}
