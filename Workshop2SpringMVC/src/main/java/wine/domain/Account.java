package wine.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
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
    @Size(min = 5, message = "Your username must be at least 5 characters long")
    @Pattern(regexp = "[A-Za-z0-9_]+", message = "Your username must be at least 5 characters long and"
            + "consist only of letters or numbers")
    private String username;

    @NotNull
    @Size(min = 8, message = "Your password must be at least 8 characters long.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}$", message = "Your password must contain at least one uppercase letter, one lowercase letter,"
            + " one number and one special character.")

    @SuppressWarnings("unused")
	private String encryptedPassword;
    
    @SuppressWarnings("unused")
	private boolean enabled;

    public Account(String username, String password) {
		this.username = username;
		this.encryptedPassword = password;
		this.createdOn = new Date();
		this.lastModifiedOn = new Date();
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
		return null;
	}

}
