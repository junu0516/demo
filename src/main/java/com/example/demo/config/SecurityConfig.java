package com.example.demo.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.demo.service.LoginService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	LoginService loginService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(loginService);		
	}

	/*사용자 인증 설정*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/","/main","/enrollForm").permitAll()
			.antMatchers(HttpMethod.POST, "/enroll").permitAll()
			.anyRequest().authenticated()
			.and()
				.formLogin()
				.loginPage("/loginForm")
				.usernameParameter("userId")
				.passwordParameter("userPwd")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/success",true)
				.successHandler(new AuthenticationSuccessHandler() {

					@Override
					public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
							Authentication authentication) throws IOException, ServletException {
						String inputPwd = request.getParameter("userPwd");
						System.out.println(inputPwd);
						
						response.sendRedirect("/success");
					}
				})
				.failureUrl("/failure")
				.failureHandler(new AuthenticationFailureHandler() {

					@Override
					public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
							AuthenticationException exception) throws IOException, ServletException {
						String inputPwd = request.getParameter("userPwd");
						System.out.println(inputPwd);
						
						
					}
					
				})
				.permitAll()
			.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
			.and()
				.csrf().disable();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return  new BCryptPasswordEncoder();
	}
}
