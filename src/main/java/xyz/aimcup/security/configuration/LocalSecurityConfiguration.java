package xyz.aimcup.security.configuration;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import xyz.aimcup.security.filter.LocalTokenAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableFeignClients(basePackages = "xyz.aimcup.security.feign")
@RequiredArgsConstructor
@ComponentScan(basePackages = "xyz.aimcup.security")
@EnableMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true
)
@Slf4j
public class LocalSecurityConfiguration {
    private final LocalTokenAuthenticationFilter tokenAuthenticationFilter;

    @Bean(name = "globalSecurityFilterChain")
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .build();
    }

    @PostConstruct
    public void postConstruct() {
        log.info("SecurityConfiguration loaded. Securing with DEVELOPMENT settings.");
    }
}
