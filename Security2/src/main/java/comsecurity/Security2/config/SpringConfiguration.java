package comsecurity.Security2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userDetails = User
                .withUsername("user")
                .password(passwordEncoder().encode("abc"))
                .roles("user")
                .build();

        UserDetails adminDetails = User
                .withUsername("admin")
                .password(passwordEncoder().encode("abc"))
                .roles("admin")
                .build();
        return new InMemoryUserDetailsManager(userDetails, adminDetails);

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers ("/api/user")
                                .hasRole("user")
                                .requestMatchers ("/api/admin")
                                .hasRole("admin")
                                .requestMatchers ("/api/public").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(withDefaults());
        return httpSecurity.build();
    }

//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/api/public")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin();
//        return httpSecurity.build();
//    }


}
