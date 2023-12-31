package forgalomiranyitas.foprogram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,proxyTargetClass = true)
public class WebSecurityConfig {
    //@Autowired
    private final UserDetailsService customUserDetailService;

    public WebSecurityConfig(final UserDetailsService customUserDetailService) {
        this.customUserDetailService = customUserDetailService;
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.requestMatchers(
                    "/resources/**","/","/images/**","/regisztral","/regisztral_feldolgoz",
                    "/jelszoteszt", "/korlatozasok", "/uzenetkuldes", "/uzenet-bekuldve",
                    "/api/**"
                ).permitAll()
                .requestMatchers("/admin/**").hasAuthority("ROLE_Admin")
                .anyRequest().authenticated())
                .formLogin(formLogin ->formLogin.defaultSuccessUrl("/home").permitAll())
                .logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/").permitAll())
                .exceptionHandling(Customizer.withDefaults());
        http.csrf().disable();
        return http.build();
    }
}
