package com.example.library.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        //auth.inMemoryAuthentication().withUser("tom").password("{noop}abc123").roles("USER")
        //       .and().withUser("admin").password("{noop}abc123").roles("ADMIN");
    }

    @Bean
    public UserDetailsService userDetailsService() {

        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("tom").password("abc123").roles("USER").build());
        manager.createUser(users.username("admin").password("abc123").roles("ADMIN").build());
        return manager;

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http.authorizeRequests().anyRequest().permitAll();
        http.csrf().disable();*/

        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }


}
