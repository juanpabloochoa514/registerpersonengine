package api_registerPerson.juanpabloochoa.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfiguration {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
