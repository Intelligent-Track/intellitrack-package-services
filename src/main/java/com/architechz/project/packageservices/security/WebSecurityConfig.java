package com.architechz.project.packageservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
  
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.cors().and().csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .authorizeRequests().antMatchers("/api/pack/**").permitAll()
        .antMatchers("/api/ware/**").permitAll()
        .antMatchers("/api/del/**").permitAll()
        .antMatchers("/api/vehi/**").permitAll()
        .antMatchers("/api/prod/**").permitAll()
        .antMatchers("/api/qte/**").permitAll()
        .anyRequest().authenticated();
    
    return http.build();
  }
}
