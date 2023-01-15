package com.example.clientscrud;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.example.clientscrud.model.Client;
import com.example.clientscrud.model.ClientGroup;

@SpringBootApplication
public class ClientscrudApplication implements RepositoryRestConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ClientscrudApplication.class, args);
	}
	
	@Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(ClientGroup.class);
        config.exposeIdsFor(Client.class);
    }

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();

		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList(
		"http://localhost:4200",
		"https://mighty-chamber-60817.herokuapp.com/"
		));
		
		corsConfiguration.setAllowedHeaders(Arrays.asList(
			"Origin", 
			"Access-Control-Allow-Origin", 
			"Content-Type",
			"Accept", 
			"Authorization", 
			"Origin, Accept", 
			"X-Requested-With",
			"Access-Control-Request-Method", 
			"Access-Control-Request-Headers"
		));

		corsConfiguration.setExposedHeaders(Arrays.asList(
			"Origin", 
			"Content-Type", 
			"Accept", 
			"Authorization",
			"Access-Control-Allow-Origin", 
			"Access-Control-Allow-Origin", 
			"Access-Control-Allow-Credentials"
		));

		corsConfiguration.setAllowedMethods(Arrays.asList(
			"GET", 
			"POST", 
			"PUT", 
			"DELETE", 
			"OPTIONS"
		));

		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}
