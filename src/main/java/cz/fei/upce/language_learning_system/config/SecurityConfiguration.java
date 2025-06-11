package cz.fei.upce.language_learning_system.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    private static final String[]WHITE_LIST_URL =
            {
            "/api/admin/**",
            "/api/users/**",
            "/api/auth/**",
            "/api/cards/**"};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http

                .csrf()

                .disable()

                .authorizeRequests()


                .requestMatchers(WHITE_LIST_URL)

                .permitAll()

                .and()

                .sessionManagement()

                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()

                .authenticationProvider(authenticationProvider)

                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();

    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.securityMatcher("/**")
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/auth/**").permitAll()
//                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
//                        .requestMatchers("/api/users/**").hasAnyRole("ADMIN", "USER")
//                        .requestMatchers("/api/cards/**").hasRole("ADMIN")
//                        .anyRequest().authenticated()
//                )
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }

    //    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//
//        configuration.setAllowedOrigins(List.of("http://localhost:8005"));
//        configuration.setAllowedMethods(List.of("GET", "POST"));
//        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type"));
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//
//        source.registerCorsConfiguration("/**", configuration);
//
//        return source;
//    }
    @Bean

    public CorsConfigurationSource corsConfigurationSource() {

        final CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOriginPatterns(List.of("*"));

        configuration.setAllowedMethods(List.of("HEAD",

                "GET", "POST", "PUT", "DELETE", "PATCH"));

        // setAllowCredentials(true) is important, otherwise:

        // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.

        configuration.setAllowCredentials(true);

        configuration.setExposedHeaders(List.of("Authorization"));

        // setAllowedHeaders is important! Without it, OPTIONS preflight request

        // will fail with 403 Invalid CORS request

        configuration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", configuration);

        return source;

    }

}
