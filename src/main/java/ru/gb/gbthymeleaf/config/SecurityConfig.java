package ru.gb.gbthymeleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.AuthorizedUrl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(
                (requests) -> requests
                        .antMatchers("/").permitAll()
                        .antMatchers("/product/all").permitAll()
                        .antMatchers(HttpMethod.POST, "/product").hasAuthority("ADMIN")
                        .antMatchers(HttpMethod.GET, "/auth").anonymous()
                        .mvcMatchers(HttpMethod.GET, "/product/{productId}").permitAll()
        );

        http.authorizeRequests((requests) -> ((AuthorizedUrl) requests.anyRequest()).authenticated());
        http.formLogin();
        http.httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
