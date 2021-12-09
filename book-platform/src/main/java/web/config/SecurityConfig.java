package web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import web.domain.Permission;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(UserDetailsService service) {
        this.userDetailsService = service;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
        authManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                csrf().disable().
                authorizeRequests().
                antMatchers("/").permitAll().
                antMatchers(HttpMethod.GET, "/**").hasAuthority(Permission.RECORD_READ.getPermission()).
                antMatchers(HttpMethod.POST, "/**").hasAuthority(Permission.RECORD_WRITE.getPermission()).
                antMatchers(HttpMethod.DELETE, "/**").hasAuthority(Permission.RECORD_WRITE.getPermission()).
                //antMatchers("/**").denyAll().
                        anyRequest().authenticated().and().httpBasic();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(
                "/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/swagger-ui/",
                "/webjars/**",
                "/resources/**",
                "/static/**");
    }
}
