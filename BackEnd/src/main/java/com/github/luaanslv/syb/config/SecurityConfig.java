package com.github.luaanslv.syb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  static{  System.out.println("estou lendo securyti");}

    // 1. Configuração do codificador de senhas (BCrypt)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 2. Configuração do Filtro de Segurança (Onde liberamos as rotas)
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desabilita CSRF para permitir POST de outras origens
                .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Usa o Bean de CORS abaixo
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/usuario/login", "/usuario/cadastrar").permitAll() // Portas abertas
                        .anyRequest().authenticated() // Tudo o que não for login/cadastro exige login
                );

        return http.build();
    }

    // 3. Configuração explícita do CORS (Resolve o erro da IDE e do Navegador)
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();

        // Origens permitidas (Seu Live Server)
        config.setAllowedOrigins(List.of("http://127.0.0.1:5500", "http://localhost:5500"));

        // Métodos permitidos
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Cabeçalhos permitidos
        config.setAllowedHeaders(List.of("*"));

        // Permite envio de cookies/auth headers se necessário
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // Aplica para todos os endpoints
        return source;
    }
}