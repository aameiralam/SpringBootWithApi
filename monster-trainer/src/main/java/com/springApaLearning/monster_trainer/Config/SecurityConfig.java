package com.springApaLearning.monster_trainer.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //Store method level beans
@EnableWebSecurity //enable different security properties
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(c->c.disable())
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(c-> c
                        .requestMatchers(HttpMethod.GET,"/api/v1/monster/**").permitAll()
                        .requestMatchers(HttpMethod.PUT,"/api/v1/monster/update").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/api/v1/monster/delete/*").hasRole("ADMIN")
                        .anyRequest().authenticated());
        return http.build();
    }

//    @Bean
//    this method is used for http security basic
//    public UserDetailsService userDetailsService(){
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder().encode("adminPass"))
//                .roles("ADMIN")
//                .build();
//        UserDetails user = User.builder()
//                .username("user")
//                .password(passwordEncoder().encode("userPass"))
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin,user);
//    }

//    @Bean // it will cause circular dependency. Application config needs the encoder
//    public PasswordEncoder passwordEncoder (){
//        return new BCryptPasswordEncoder();
//    }


}
