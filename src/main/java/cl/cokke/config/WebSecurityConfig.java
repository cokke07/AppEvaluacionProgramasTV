package cl.cokke.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity(debug = false)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
 		.authorizeRequests()
 		.antMatchers("/admin/**, /static/**", "/css/**", "/js/**", "/registration", "/shows/**").hasRole("ADMIN")
 		.antMatchers("/user/** , /static/**", "/css/**", "/js/**", "/registration", "/shows/**").hasRole("USER")
 		.antMatchers("/login", "/registration", "/shows/**", "/home", "redirect:/shows")
 		.permitAll() //se configuran las rutas permitidas
 		.anyRequest()
 		.authenticated() //se configuran las demas rutas para estar aseguradas
 		.and()
 		.formLogin()
 		.loginPage("/login")
 		.failureUrl("/login?error=true") //pagina de login por defecto y pagina de error
 		.usernameParameter("username")
 		.passwordParameter("password")
 		.defaultSuccessUrl("/home",true) //sitio de exito post inicio de sesion
 		.and()
 		.exceptionHandling()
 		.accessDeniedPage("/recurso-prohibido");

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
 		.withUser("admin@gmail.com")
 		.password(bCryptPasswordEncoder().encode("admin")).roles("ADMIN")
 		.and()
 		.withUser("user@gmail.com")
 		.password(bCryptPasswordEncoder()
 		.encode("user"))
 		.roles("USER");
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
}
