package com.example.test.config;

import com.example.test.repository.UserRepository;
import com.example.test.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.inject.Inject;

/**
 * Created by Anup on 9/9/15.
 */
@Configuration
@EnableWebSecurity
@ComponentScan(value = "com.example.test")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Inject
    UserRepository userRepository;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailServiceImpl();
    }

    @Override
    protected void configure(HttpSecurity http) throws  Exception{
        http
                .authorizeRequests()
                    .antMatchers("/*.html","/resources/js/*","/resources/css/*","/resources/*/*").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/loginUser")
                    .usernameParameter("username").passwordParameter("password")
                    .failureUrl("/loginFailed")

                    .permitAll()
                    .and()
                .logout()
                    //.logoutUrl("/logout")
                    .logoutSuccessUrl("/logoutSuccess")
                    .invalidateHttpSession(true)
                    .permitAll();
    }

   /* @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }*/

}
