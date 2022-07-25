package com.project.Tema7_springWeb.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
            .authorizeHttpRequests()
            .mvcMatchers("/users/").permitAll()
            .mvcMatchers("/users/create/").hasRole("Admin")
            .mvcMatchers("/insurances/car").hasAuthority("write")
            .mvcMatchers("/insurances/house").hasAuthority("write")
            .mvcMatchers("/insurances/car/price/*").hasAuthority("write")
            .mvcMatchers("/insurances/house/price/*").hasAuthority("write")
                .anyRequest().authenticated().and().httpBasic();

        return http.build();
    }

    @Bean
    UserDetailsService userDetailsService(){
        var userDetailsManager = new InMemoryUserDetailsManager();

        UserDetails user1 = User.withUsername("admin1")
                        .password(new BCryptPasswordEncoder().encode("111"))
                        .roles("Admin")
                        .authorities("read", "write")
                        .build();

        UserDetails user2 = User.withUsername("user1")
                .password(new BCryptPasswordEncoder().encode("111"))
                .roles("User")
                .authorities("read")
                .build();

        userDetailsManager.createUser(user1);
        userDetailsManager.createUser(user2);

        return userDetailsManager;
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
