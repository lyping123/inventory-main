package demo2.demo2.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import demo2.demo2.servise.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class SecurityConfig{
    @Bean
    public UserDetailsService UserDetailsService(){
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder PasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean 
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth=new DaoAuthenticationProvider();
        auth.setUserDetailsService(UserDetailsService());
        auth.setPasswordEncoder(PasswordEncoder());
        return auth;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(requests -> requests
                        .antMatchers(HttpMethod.GET, "/").permitAll()
                        .antMatchers("/images/**").permitAll()
                        .antMatchers(HttpMethod.GET, "/register").permitAll()
                        .antMatchers(HttpMethod.POST, "/register").permitAll()
                        .antMatchers(HttpMethod.GET, "/login").permitAll()
                        .antMatchers(HttpMethod.POST, "/login").permitAll()
                        .antMatchers(HttpMethod.GET, "/users").hasAnyAuthority("admin")
                        .antMatchers(HttpMethod.GET, "/deleteaccount").hasAnyAuthority("admin")
                        .antMatchers(HttpMethod.POST, "/products").hasAnyAuthority("admin","user")
                        .antMatchers(HttpMethod.GET, "/product").hasAnyAuthority("admin","user")
                        .antMatchers(HttpMethod.GET,"/editproduct").hasAnyAuthority("admin","user")
                        .antMatchers(HttpMethod.GET,"/deleteproduct").hasAnyAuthority("admin","user")
                        .anyRequest().authenticated())
                .formLogin(login -> login
                        .loginPage("/login")
                        .usernameParameter("email")
                        .defaultSuccessUrl("/products")
                        .failureUrl("/login?error=true")
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .invalidateHttpSession(true)
                        .logoutSuccessUrl("/login?logout=true")
                        .permitAll())
                .csrf(csrf -> csrf.disable());
        return http.build();
    }

    // @Bean
    // public SecurityFilterChain configuration(HttpSecurity http) throws Exception {
    //     http
    //             .csrf(csrf -> csrf.disable());
	// 	return http.build();
	// }
    

}
