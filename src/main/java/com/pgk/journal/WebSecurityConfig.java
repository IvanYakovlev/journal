package com.pgk.journal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;


import java.util.Arrays;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${ad.domain}")
    private String AD_DOMAIN;

    @Value("${ad.url}")
    private String AD_URL;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/resources/**","/css/*").permitAll()
                .anyRequest().authenticated()
                .and()
                //.formLogin().permitAll()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().permitAll()
                .and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
        authManagerBuilder.authenticationProvider(activeDirectoryLdapAuthenticationProvider()).userDetailsService(userDetailsService());
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Arrays.asList(activeDirectoryLdapAuthenticationProvider()));
    }
    @Bean
    public AuthenticationProvider activeDirectoryLdapAuthenticationProvider() {
        ActiveDirectoryLdapAuthenticationProvider provider = new ActiveDirectoryLdapAuthenticationProvider(AD_DOMAIN, AD_URL);
        provider.setConvertSubErrorCodesToExceptions(true);
        provider.setUseAuthenticationRequestCredentials(true);

        return provider;
    }
}