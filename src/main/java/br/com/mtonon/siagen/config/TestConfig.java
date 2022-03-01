package br.com.mtonon.siagen.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.mtonon.siagen.services.DBService;

@Configuration
@Profile("development")
public class TestConfig {
	
	@Autowired
	private DBService dBService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		dBService.instantiateTestDatabase();
		
		return true;
	}

}
