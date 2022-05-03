package com.cagriyilmaz.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder
//                .inMemoryAuthentication()
//                .withUser("hamirmizrak")
//                .password("{noop}root") //  {noop} yazınca şifre maskesiz görünür.
//                .roles("USER");
//    }

//    @Autowired
//    public void configureEncryped(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        authenticationManagerBuilder
//                .inMemoryAuthentication()
//                .withUser("hamirmizrak")
//                .password(passwordEncoder.encode("root")) //maskelenmişl olarak şifre gönderilir
//                .roles("USER");
//    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//    }


//}
public class WebSecurityConfig {
}
