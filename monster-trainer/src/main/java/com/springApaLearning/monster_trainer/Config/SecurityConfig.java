package com.springApaLearning.monster_trainer.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration //Store method level beans
@EnableWebSecurity //enable different security properties
public class SecurityConfig {


    //after making the jwtAuthetication class
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private JwtAuthenticationFilter authenticationFilter;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(c->c.disable())
//                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(c-> c
                        .requestMatchers(HttpMethod.GET,"/api/v1/monster/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/v1/auth/*").permitAll()
                        .requestMatchers(HttpMethod.PUT,"/api/v1/monster/update").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/api/v1/monster/delete/*").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
//                after jwtAuthenticationFilter class
                .sessionManagement(ses -> ses.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
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
