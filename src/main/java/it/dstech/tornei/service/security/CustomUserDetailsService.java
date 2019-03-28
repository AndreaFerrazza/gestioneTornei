package it.dstech.tornei.service.security;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.dstech.tornei.model.Account;
import it.dstech.tornei.model.Role;
import it.dstech.tornei.service.AccountService;
import it.dstech.tornei.service.security.AuthenticationUtil;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	AccountService accountService;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException, DataAccessException {
		Optional<Account> optionalAccount= accountService.findFirstByUsername(userName);
		if (!optionalAccount.isPresent()) {
			throw new UsernameNotFoundException("Utente non trovato: " + userName);
		}
		Account user = optionalAccount.get();

		boolean accountNonExpired = true;
		boolean userEnabled = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		Set<Role> ruoli = new HashSet<Role>();
		ruoli.add(user.getRoles());
		
		return new User(user.getUsername(), user.getPassword(), userEnabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, AuthenticationUtil.getAuthorities(ruoli));
	}
}
