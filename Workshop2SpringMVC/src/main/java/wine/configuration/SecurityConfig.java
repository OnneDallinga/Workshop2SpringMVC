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

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	DataSource dataSource;
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
	    throws Exception {

	  auth
	  .userDetailsService(userDetailsService)
	  .passwordEncoder(encoder());
	  
	  auth
	    .jdbcAuthentication()
	      .dataSource(dataSource)
	      .usersByUsernameQuery(
	          "select username, encryptedpassword, enabled from account " +
	          "where username=?")
	      .authoritiesByUsernameQuery(
	          "select username, authority from authorities " +
	          "where username=?")
	      .passwordEncoder(new BCryptPasswordEncoder()); // the encryption

	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http
	    .authorizeRequests()
	      .antMatchers("/mainmenu") // choose 1 or more pages
	        .access("hasRole('ROLE_USER')") // choose the access level for those pages
	      .antMatchers("/**").access("permitAll") // choose the access level for all other pages
	      
	      .and()
	      .formLogin()
	        .loginPage("/login") // defines login page
	        .defaultSuccessUrl("/mainmenu", true) // defines where user is forced to go after logging in (true)
	      .and()
	        .logout()
	          .logoutSuccessUrl("/") // logout page
	        
	        ;
	}
}