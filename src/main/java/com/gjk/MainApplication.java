package com.gjk;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.util.WebUtils;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
    	SpringApplication.run(MainApplication.class, args);
    }

    @Configuration
    protected static class WebMvcConfiguration extends WebMvcConfigurerAdapter {

		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/login").setViewName("login");
		}
	
		@Bean
		public ViewResolver viewResolver() {
			InternalResourceViewResolver bean = new InternalResourceViewResolver();
			bean.setSuffix(".html");
			return bean;
		}
    }

    @Configuration
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    protected static class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    	
    	@Autowired
		private DataSource dataSource;
    	
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
			.authorizeRequests()
			.antMatchers("/h2-console/**").hasRole("ADMIN")// not working // role should not start with 'ROLE_' since it is automatically inserted
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
			.and()
			.logout().logoutSuccessUrl("/login?logout").permitAll()
			.and()
			.httpBasic()
			.and()
			.csrf().csrfTokenRepository(csrfTokenRepository())
			.and()
			.addFilterAfter(csrfHeaderFilter(), CsrfFilter.class);
		}
	
		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.jdbcAuthentication().dataSource(this.dataSource);
			
//		    auth.inMemoryAuthentication()
//		    .withUser("admin").password("admin").roles("ADMIN", "USER")
//		    .and()
//		    .withUser("gjk").password("gjk").roles("USER");
		}
	
		// setting csrf token into cookie for html page
		private Filter csrfHeaderFilter() {
			return new OncePerRequestFilter() {
				@Override
				protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
					CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
					if (csrf != null) {
						Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
						String token = csrf.getToken();
						if (cookie == null || token != null && !token.equals(cookie.getValue())) {
							cookie = new Cookie("XSRF-TOKEN", token);
							cookie.setPath("/");
							response.addCookie(cookie);
						}
					}
					filterChain.doFilter(request, response);
				}
			};
		}
	
		// customizing the CSRF filter for Angular
		// when getting csrf token, use name "X-XRSF-TOKEN" instead of the default "X-CSRF-TOKEN".
		private CsrfTokenRepository csrfTokenRepository() {
			HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
			repository.setHeaderName("X-XSRF-TOKEN");
			return repository;
		}

    }

}
