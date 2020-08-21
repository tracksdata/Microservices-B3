package com.cts.brownfield.pss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableAdminServer
@Configuration
@SpringBootApplication
public class SpringbootAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAdminApplication.class, args);
	}
	@Configuration
	public static class SecurityConfig extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
            .formLogin()
            .loginPage("/login")
            .permitAll();
        http
            .logout().logoutUrl("/logout").permitAll();
        http.csrf()
            .ignoringAntMatchers("/actuator/**", "/instances/**", "/logout");
        http
            .authorizeRequests()
            .antMatchers("/**/*.css", "/assets/**", "/third-party/**", "/logout", "/login")
            .permitAll();
        http
            .authorizeRequests()
            .anyRequest()
            .authenticated();
        http.httpBasic(); // Activate Http basic Auth for the server
    }
		
	}

}
