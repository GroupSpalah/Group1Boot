package com.config;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Import({EncoderConfig.class})
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SecurityAdConfig {

   /* private final PasswordEncoder passwordEncoder;

    public SecurityAdConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)  throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("John")
                .password("$2a$10$WCeOTXEQhLxu7uu1x4PKyOUz5wfyndNShTQhr8CVv8Q3SqnHP0zI6")
                .roles("USER")//123
                .and()
                .withUser("Jack")
                .password("$2a$10$gomReallY2OM6I5KxeXT6.NMMulX3OrV7Z4IiLJNXppzGXgZuunBm")
                .roles("ADMIN");//123456
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                        .authorizeHttpRequests(req ->
                        req.requestMatchers("/secure/user").hasRole("USER")
                                .requestMatchers("/secure/admin").hasRole("ADMIN")
                                .requestMatchers("/login").permitAll()
                                .anyRequest()
                                .authenticated())
                .formLogin();
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager
            (AuthenticationConfiguration authenticationConfiguration) throws Exception {
        AuthenticationManager authenticationManager = authenticationConfiguration.getAuthenticationManager();
        return
                authenticationManager;
    }

}
