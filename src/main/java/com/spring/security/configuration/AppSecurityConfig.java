package com.spring.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@EnableWebSecurity
public class AppSecurityConfig extends org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
       /* User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        try {
            auth.inMemoryAuthentication()
                    .withUser(userBuilder.username("zaur").password("zaur").roles("EMPLOYEE"))
                    .withUser(userBuilder.username("elena").password("elena").roles("HR"))
                    .withUser(userBuilder.username("ivan").password("ivan").roles("MANAGER", "HR"));
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        try {
            auth.jdbcAuthentication().dataSource(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() // запросы авторизованы
                .antMatchers("/").hasAnyRole("EMPLOYEE", "HR", "MANAGER") // доступ к корню сайта имеют все роли
                .antMatchers("/hr_info").hasRole("HR") // доступ к /hr_info имеет только роль HR
                .antMatchers("/manager_info/**").hasRole("MANAGER") // доступ к /manager_info имеет только роль MANAGER
                .and().formLogin().permitAll(); // включаем форму логина
    }

}
