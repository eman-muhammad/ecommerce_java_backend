package com.project.Security.config;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.database.Entities.user.User;

@Configuration
@EnableMethodSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfiguration {

  private final JwtAuthFilter jwtAuthFilter;
  private final AuthenticationProvider authenticationProvider;

  private static final String[] WHITELIST = {
      "/products/**",
      "/images/**",
      "/orders/**",
      "/products/**",
      "/auth/**"

  };

  private static final String[] SECURED_URLs = { "/product/**" };

  // @Autowired
  // public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
  //   authenticationMgr.inMemoryAuthentication()
  //       .withUser("admin").password("admin").authorities("ROLE_USER", "ROLE_ADMIN");
  // }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    // .csrf().disable()
    // .authorizeHttpRequests()
    // .requestMatchers(UN_SECURED_URLs).permitAll().and()
    // .authorizeHttpRequests().requestMatchers(SECURED_URLs)
    // .hasAuthority("ADMIN").anyRequest().authenticated()
    // .and().sessionManagement()
    // .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    // .and()
    // .authenticationProvider(authenticationProvider)
    // .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
    // .build();

    return http
        .csrf()
        .disable()
        .headers().frameOptions().disable().and()
        .cors().and() // disable some kind of verification
        .authorizeHttpRequests()
        .shouldFilterAllDispatcherTypes(false)
        .requestMatchers(WHITELIST) // my white list any one can access
        .permitAll()
        .anyRequest() // any other requests must be auth
        .authenticated()
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        // let spring create new session for every request
        .and()
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class).build();
    // add jwt filter before username pass auth filter//
    // http.formLogin();
    // return http.build();
  }

}
