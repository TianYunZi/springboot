package com.boot.config;

import com.boot.service.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by XJX on 2017/6/14.
 * Spring Security配置
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    UserDetailsService customerUserService() {
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customerUserService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().authenticated().and()
//                .formLogin().loginPage("/login")
//                .defaultSuccessUrl("/home")
//                .failureUrl("/login?error")
//                .permitAll().and().rememberMe()
//                .tokenValiditySeconds(1209600)//指定cookies有效期为2星期
//                .key("myKey")
//                .and().logout().permitAll();
        http.authorizeRequests()
                .anyRequest().authenticated() //4
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .permitAll() //5
                .and()
                .logout().permitAll(); //6
    }
}
