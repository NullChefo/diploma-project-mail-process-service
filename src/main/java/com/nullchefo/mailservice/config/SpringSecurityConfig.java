package com.nullchefo.mailservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http    // TODO fix this
				.csrf().disable()
				//	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				//	.and()
				.authorizeHttpRequests()
				.requestMatchers("/actuator/**",

								 "/mail-process/v1/api-docs/**",
								 "/mail-process/swagger-ui.html"
								).permitAll()
				.anyRequest().authenticated();
		http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
		return http.build();
	}
}
