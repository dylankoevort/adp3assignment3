package za.ac.cput.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(encoder().encode("pass"))
                .roles("ADMIN")
                .and()
                .withUser("lecturer")
                .password(encoder().encode("123"))
                .roles("LECTURER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "**/student/create").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "**/student/read").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "**/student/read").hasRole("LECTURER")
                .antMatchers(HttpMethod.POST, "**/student/update").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "**/student/delete").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "**/student/getall").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "**/student/getall").hasRole("LECTURER")
                .antMatchers(HttpMethod.POST, "**/examination/create").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "**/examination/create").hasRole("LECTURER")
                .antMatchers(HttpMethod.GET, "**/examination/read").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "**/examination/read").hasRole("LECTURER")
                .antMatchers(HttpMethod.POST, "**/examination/update").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "**/examination/update").hasRole("LECTURER")
                .antMatchers(HttpMethod.POST, "**/examination/delete").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "**/examination/delete").hasRole("LECTURER")
                .antMatchers(HttpMethod.GET, "**/examination/getall").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "**/examination/getall").hasRole("LECTURER")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
