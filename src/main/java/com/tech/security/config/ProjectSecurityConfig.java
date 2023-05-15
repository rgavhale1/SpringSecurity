package com.tech.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests()
        .requestMatchers("/hello/test")
        .permitAll()
        .requestMatchers("/hello/save")
        .authenticated();
    http.formLogin();
    http.httpBasic();
    return http.build();
  }

  /* @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
      http.authorizeHttpRequests().anyRequest().denyAll();
      http.formLogin();
      http.httpBasic();
      return http.build();
    }
  */
  /* @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests().anyRequest().permitAll();
    http.formLogin();
    http.httpBasic();
    return http.build();
  }*/
  /*@Bean
  InMemoryUserDetailsManager userDetails() {
    UserDetails user1 =
        User.withDefaultPasswordEncoder()
            .username("anurag")
            .password("test1234")
            .authorities("admin")
            .build();
    UserDetails user2 =
        User.withDefaultPasswordEncoder()
            .username("raje")
            .password("test12345")
            .authorities("developer")
            .build();
    return new InMemoryUserDetailsManager(user1, user2);
  }*/
  @Bean
  public InMemoryUserDetailsManager userDetails() {

    InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
    UserDetails userDetails1 =
        User.withUsername("raju").password("testing").authorities("admin").build();
    UserDetails userDetails2 =
        User.withUsername("kaju").password("testing1").authorities("testing").build();

    inMemoryUserDetailsManager.createUser(userDetails1);
    inMemoryUserDetailsManager.createUser(userDetails2);
    return inMemoryUserDetailsManager;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {

    return NoOpPasswordEncoder.getInstance();
  }
}
