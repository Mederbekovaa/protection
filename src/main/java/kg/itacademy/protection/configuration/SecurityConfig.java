package kg.itacademy.protection.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import javax.sql.DataSource;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT t.login, t.password FROM users t WHERE t.login = ?")
                .authoritiesByUsernameQuery(
                        "SELECT  r.name_role " +
                                "FROM users_roles ur " +
                                "INNER JOIN users u " +
                                "   on ur.user_id = u.id " +
                                "INNER JOIN roles r " +
                                "   on ur.role_id = r.id " +
                                "WHERE u.login = ? "
                );

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors().disable()
                .csrf().disable()
                .authorizeRequests()

                .antMatchers(HttpMethod.GET, "/api/contact/getAll").permitAll()
                .antMatchers(HttpMethod.POST, "/api/contact/create").hasRole("CHILD")
                .antMatchers(HttpMethod.PUT, "/api/contact/update").hasRole("CHILD")
                .antMatchers(HttpMethod.DELETE, "/api/contact/delete").hasRole("CHILD")

                .antMatchers(HttpMethod.GET,"/api/child/get/*").hasRole("PARENT")

                .antMatchers("/api/user/sign-in").permitAll()
                .antMatchers("/api/user/sign-up").permitAll()

                .antMatchers("/api/role/create").permitAll()

                .antMatchers("/swagger-ui.html/*").permitAll()

                .and()
                .httpBasic();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
