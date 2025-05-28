package com.ayesa.project1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.java.Log;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(
	 	prePostEnabled = true, 
	 	securedEnabled = true, 
	 	jsr250Enabled = true)
@Log
public class WebSecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		// Content to the basic autoconfiguration of Spring Security.
		// Spring takes access control with html pages by default for login and logout
		// but it can be changed for our own forms.
        httpSecurity
                .headers(headers -> headers.frameOptions(Customizer.withDefaults()).disable()) //Necesario para que salgan todos los marcos de /h2
                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2/**")) // Para permitir acceso a /h2/** sin CSRF
                .authorizeHttpRequests((authorize) -> authorize
			        	//.requestMatchers("/", "/index", "/login*", "/h2/**").permitAll()
			        	.requestMatchers("/h2/**").permitAll()
			        	.requestMatchers("/img/**").permitAll()
			        	.requestMatchers("/loginPost").authenticated()
                        .anyRequest().authenticated())
//                .formLogin(Customizer.withDefaults());	
        
                .formLogin(formLogin -> {
                    formLogin
                      //.loginPage("/loginGet") // Login page will be accessed through this endpoint. We will create a controller method for this.
                      //.loginProcessingUrl("/login-processing") // This endpoint will be mapped internally. This URL will be our Login form post action.
                      //.usernameParameter("username")
                      //.passwordParameter("password")
                      .permitAll() // We re permitting all for login page
                      .defaultSuccessUrl("/master") // If the login is successful, user will be redirected to this URL.
                      .failureUrl("/login?badCredentials"); // If the user fails to login, application will redirect the user to this endpoint
                   	})
                .logout(formLogout -> {
                    formLogout
                    .logoutUrl("/logoutGet")
                    .permitAll() // We re permitting all for logout page
                    .logoutSuccessUrl("/loginGet?logoutOk"); // If the logout is successful, user will be redirected to this URL.
                	})
                	
                ;
        
        //log.info("*********** httpSecurity.getSharedObjects()= " + httpSecurity.getSharedObjects());

		return httpSecurity.build();
	}

	
}
