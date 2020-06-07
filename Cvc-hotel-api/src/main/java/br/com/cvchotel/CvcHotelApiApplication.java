package br.com.cvchotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class CvcHotelApiApplication {
	
	//Criando builder do webcliente, alternatica mais performática ao RestTemplate 
	@Bean
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(CvcHotelApiApplication.class, args);
		
	}

}
