package com.ibm.login;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.login.dto.UserDataDTO;
import com.ibm.login.service.UserService;

@SpringBootApplication
//Enables Spring Boot’s auto-configuration mechanism, package scan, and registering extra beans in the
//context or import additional configuration classes
@EnableOAuth2Sso //Enables OAuth2 Single Sign On, will automatically use application.yml properties for security
public class LoginMs1Application extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(LoginMs1Application.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		//Configuring Spring security access. For /login, /user, and /userinfo, we need authentication.
		//Logout is enabled.
		//Adding csrf token support to this configurer.
		http.authorizeRequests()
		.antMatchers("/login**", "/user","/userInfo").authenticated()
		.and().logout().logoutSuccessUrl("/").permitAll()
		.and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		super.configure(http);

	}


	@Override public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**"); 
		super.configure(web); 
	}





}
