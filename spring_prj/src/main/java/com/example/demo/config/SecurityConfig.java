package com.example.demo.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityfilterChain(HttpSecurity http) throws Exception {
      http.formLogin(login -> login
        .loginProcessingUrl("/login")
        .loginPage("/login")
        .defaultSuccessUrl("/mylist")
        .failureUrl("/login?error")
        .permitAll()
      ).logout(logout -> logout
        .logoutSuccessUrl("/mylist")
      ).authorizeHttpRequests(authz -> authz
        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
        .requestMatchers("/").permitAll()
        .requestMatchers("/image/**").permitAll()
        .requestMatchers("/login").permitAll()
        .requestMatchers("/register").permitAll()
        .anyRequest().authenticated()
      );
      return http.build();
  }
  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }

}