package br.com.cvchotel.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.cvchotel.model.Hotel;
import reactor.core.publisher.Flux;

/**
*@author Jonatas Almeida	
*@date 06/06/2020
*/

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GetAvailableHotelsServiceTest {
	
	@Autowired
	private WebClient.Builder clienteTest;
	
	//Methodo com teste unitário para integração com serviço
	@Test
	public void returnHotelIntegrationTest() throws Exception {
		//arrange
		
		//act
		Flux<Hotel> hotelFlux = clienteTest.build()
			.get()
			.uri("https://cvcbackendhotel.herokuapp.com/hotels/1")
			.retrieve()
			.bodyToFlux(Hotel.class);
		
		hotelFlux.blockFirst();
		
		//assert
		Assertions.assertThat(hotelFlux.subscribe(resp -> resp.getId())).isNotNull();
		Assertions.assertThat(hotelFlux.subscribe(resp -> resp.getRooms())).isNotNull();
	}
	
	
	//Methodo com teste unitário para integração com serviço
	@Test
	public void returnHotelsIntegrationTest() throws Exception {
		//arrange
		
		//act
		Flux<Hotel> hotelFlux = clienteTest.build()
			.get()
			.uri("https://cvcbackendhotel.herokuapp.com/hotels/avail/1032")
			.retrieve()
			.bodyToFlux(Hotel.class);
		
		hotelFlux.blockFirst();
		
		//assert
		Assertions.assertThat(hotelFlux.subscribe(resp -> resp.getId())).isNotNull();
		Assertions.assertThat(hotelFlux.subscribe(resp -> resp.getRooms())).isNotNull();
	}
}
