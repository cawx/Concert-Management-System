package com.example.xo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.xo.Service.AccountDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AccountDetailService accountDetailService;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(registry->{
                registry.requestMatchers("/", "/register").permitAll();
                registry.requestMatchers("/admin/**").hasRole("ADMIN");
                registry.requestMatchers("/user/**").hasAnyRole("USER", "ADMIN");
                registry.anyRequest().authenticated();
            })
            .formLogin(formLogin -> formLogin.permitAll())
            .build();
    }
/* 
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails normalUser = User.builder()
            .username("gc")
            .password("$2a$12$lJK5.E4OrdmbaCmb9.pTr.ZaNsd5WiEHtB9KDXCHe7AsVXRsLDbnW")
            .roles("USER")
            .build();
        UserDetails adminUser = User.builder()
            .username("admin")
            .password("$2a$12$5fTNjx3IiOepVhqCXY1Oi.qZrrSFcgZMHvufUpZd1JWnq3Nkspfqa")
            .roles("ADMIN", "USER")
            .build();
        return new InMemoryUserDetailsManager(normalUser, adminUser);
    }
*/
    @Bean
    public UserDetailsService userDetailsService() {
        return accountDetailService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(accountDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
