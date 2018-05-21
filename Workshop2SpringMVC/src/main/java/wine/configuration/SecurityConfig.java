package wine.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import wine.repositories.AccountRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AccountRepository accountRepo;

	@Autowired
	DataSource dataSource;
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(8); // set to strength:8 for 8 encryption rounds
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
	    throws Exception {
  
	  auth
	    .jdbcAuthentication()
	      .dataSource(dataSource)
	      .usersByUsernameQuery(
	          "select username, encrypted_password, enabled from account " +
	          "where username=?")
		  .authoritiesByUsernameQuery(
		      "select username, authority from authorities " +
		      "where username=?")
	      .passwordEncoder(encoder());; // the encryption
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http
	    .authorizeRequests()
	    	.antMatchers("/register").permitAll()
	    	.anyRequest().authenticated()
	    	.and()
	    .formLogin()
	        .loginPage("/login") // defines login page
	        .defaultSuccessUrl("/home", true) // defines where user is forced to go after logging in (true)
	        .permitAll()
	        .and()
	        .logout()
	        	.logoutUrl("/logout")
	        	.logoutSuccessUrl("/login") // logout page                             
				.invalidateHttpSession(true)
	        ;
	}
}