package com.cts.usecaseproject.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.usecaseproject.Model.Author;
import com.cts.usecaseproject.Repository.AuthorRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	
	@Autowired
	private AuthorRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Author author = repo.findByUsername(username);
		System.out.println(author.getUsername());
		if (author.getUsername().equals(username)) {
			Set<SimpleGrantedAuthority> authorities = new HashSet<>();
			authorities.add(new SimpleGrantedAuthority("ROLE_" + "AUTHOR"));
//			authorities.add(new SimpleGrantedAuthority("ROLE_" + "MANAGER"));
//			authorities.add(new SimpleGrantedAuthority("ROLE_" + "OWNER"));
			return new User(author.getUsername(),"{noop}"+ author.getPassword(), authorities);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}
