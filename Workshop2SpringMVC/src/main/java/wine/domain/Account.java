package wine.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.RequiredArgsConstructor;
import wine.utility.BaseEntity;

@Entity
@EqualsAndHashCode(callSuper = false, of = {"username"})
//@RequiredArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true) > volgens geeft dit een comp error omdat er een final field is (serialVersionUID)
public class Account extends BaseEntity<Long> implements UserDetails {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(unique=true)
    private String username;

    @NotNull
    @SuppressWarnings("unused")
	private String encryptedPassword;
    
    @SuppressWarnings("unused")
    @ColumnDefault("true")
	private boolean enabled;

    public Account(String username, String password) {
		this.username = username;
		this.encryptedPassword = password;
		this.createdOn = new Date();
		this.lastModifiedOn = new Date();
		this.enabled = true;
	}

	public Account() {
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEncryptedPassword() {
		return this.encryptedPassword;
	}
	
}
