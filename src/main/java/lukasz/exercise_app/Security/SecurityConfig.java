package lukasz.exercise_app.Security;

import lukasz.exercise_app.Entities.Role;
import lukasz.exercise_app.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private User user = new User();
    private Role role = new Role();

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserDetailsServiceImpl userDetailsService;



    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .userDetailsService(userDetailsService);

        auth
                .inMemoryAuthentication()
                .withUser("sss").password(passwordEncoder().encode("skla")).roles("lukasz")
                .and()
                .withUser("bbb").password(passwordEncoder().encode("idfty")).roles("lukasz");
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {


        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/", "/login**", "/webjars/**", "/error**").hasRole("lukasz")
                .antMatchers(HttpMethod.GET,"/exercise").hasRole("lukasz")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home")
                .failureUrl("/login?error")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .deleteCookies("cookie_log")
                .permitAll()
                .and()
                .rememberMe()
                .rememberMeCookieName("Cookie_log")
                .tokenValiditySeconds(30*20)
                .and()
                .csrf().disable();
        http.headers().frameOptions().disable();
    }



}
