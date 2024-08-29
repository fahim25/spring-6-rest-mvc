package com.springframework.spring6restmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

@Configuration
public class SpringSecConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
//                .authorizeHttpRequests(requests -> requests
//                        .anyRequest().authenticated())
                .csrf((csrf)->csrf.ignoringRequestMatchers("/api/**"));
        return httpSecurity.build();
    }

}
