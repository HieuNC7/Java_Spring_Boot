package com.springboot.demo.week45.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

    http.authorizeHttpRequests(
        authz ->
            authz
                .requestMatchers(HttpMethod.GET, "/api/**")
                .authenticated()
                .requestMatchers("/api/**")
                .authenticated()
                .anyRequest()
                .permitAll());
    http.oauth2Login(Customizer.withDefaults());
    http.oauth2ResourceServer(Customizer.withDefaults());
    http.oauth2ResourceServer(
        oauth2ResourceServerCustomizer ->
            oauth2ResourceServerCustomizer.jwt(
                jwtCustomizer ->
                    jwtCustomizer.jwtAuthenticationConverter(new JwtAuthenticationConverter())));
    return http.build();
  }
}
