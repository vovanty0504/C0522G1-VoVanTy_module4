package com.example.config;


import com.example.service.security.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailService myUserDetailService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/").permitAll()
                .and()
                .authorizeRequests().
                antMatchers("/").permitAll()
//                .antMatchers("**/list", "**/list", "**/list", "**/list")
//                .hasAnyRole("USER")
//                .antMatchers("/customer/**", "/employee/**", "/facility/**","contract/**")
//                .hasAnyRole("ADMIN")
                .anyRequest().authenticated();
//        http.csrf().disable()
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/").permitAll()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/home").permitAll()
//                .antMatchers("employee/list", "facility/list", "customer/list", "contract/list").hasAnyRole("USER")
//                .antMatchers("/customer/**", "/employee/**", "/facility/**","contract/**").hasAnyRole("ADMIN")
//                .anyRequest().authenticated();
    }
}
