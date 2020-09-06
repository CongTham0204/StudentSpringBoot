package com.student.manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.student.manager.authentication.MyUserDetailsService;
import com.student.manager.controller.FacultyController;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@Autowired
	private MyBasicAuthenticationEntryPoint authenticationEntryPoint;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		// Các User trong bộ nhớ (MEMORY).

		auth.inMemoryAuthentication().withUser("user1").password("12345").roles("USER");
		auth.inMemoryAuthentication().withUser("admin1").password("12345").roles("ADMIN", "USER");

		// Các User trong Database
		auth.userDetailsService(myUserDetailsService);

	}
	
	

	@SuppressWarnings("deprecation")
	@Override
	protected UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(
                User.withDefaultPasswordEncoder() // Sử dụng mã hóa password đơn giản
                    .username("admin")
                    .password("12345")
                    .roles("ADMIN") // phân quyền là người dùng.
                    .build()
        );
        return manager;
    }
	



	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();

		// Các trang không yêu cầu login
		http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();

		// Trang /userInfo yêu cầu phải login với vai trò USER hoặc ADMIN.
		// Nếu chưa login, nó sẽ redirect tới trang /login.
		http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
		http.authorizeRequests().antMatchers("/students").access("hasAnyRole('ROLE_USER')");
		http.authorizeRequests().antMatchers("/facultys").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
		
		// Trang chỉ dành cho ADMIN
		http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");
		http.authorizeRequests().antMatchers("/buttons").access("hasRole('ROLE_ADMIN')");
		http.authorizeRequests().antMatchers("/buttonsSubject").access("hasRole('ROLE_ADMIN')");
		// Khi ngư�?i dùng đã login, với vai trò XX.
		// Nhưng truy cập vào trang yêu cầu vai trò YY,
		// Ngoại lệ AccessDeniedException sẽ ném ra.
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

		// Cấu hình cho Login Form.
		http.authorizeRequests().and().formLogin()// r

				// Submit URL của trang login
				.loginProcessingUrl("/j_spring_security_check") // Submit URL
				.loginPage("/login")
				.defaultSuccessUrl("/userInfo")//
				.failureUrl("/login?error=true")//
				.usernameParameter("username")//
				.passwordParameter("password")

				// Cấu hình cho Logout Page.
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/loginPage");

		http.authorizeRequests().antMatchers("/registerSubject/**","/createSubject/**","/search/**").authenticated().and().httpBasic()
				.authenticationEntryPoint(authenticationEntryPoint);

	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}