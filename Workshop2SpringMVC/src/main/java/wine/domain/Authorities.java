package wine.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name = "authorities")
public class Authorities {
	
	@Id
	private long id;
	
	@NotNull
	private String username;
	
	HashSet<GrantedAuthority> authorities;

	
	public Authorities (long id, String username) {
	authorities = new HashSet<>();
	authorities.add(new SimpleGrantedAuthority("USER"));
	this.id = id;
	this.username = username;
	}
	
	public Authorities () {
		
	}

}
