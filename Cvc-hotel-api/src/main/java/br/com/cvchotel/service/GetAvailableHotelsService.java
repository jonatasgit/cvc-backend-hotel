package br.com.cvchotel.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.decimal4j.util.DoubleRounder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.cvchotel.model.Hotel;
import br.com.cvchotel.model.PriceDetail;
import br.com.cvchotel.model.Room;
import br.com.cvchotel.model.RoomResponse;
import br.com.cvchotel.model.TripResponse;
import reactor.core.publisher.Flux;

/**
*@author Jonatas Almeida	
*@date 06/06/2020
*/

@Service
public class GetAvailableHotelsService {
	
	@Autowired
	private WebClient.Builder webClienteBuilder;
	
	private static final String HOTELSBYCITYURI = "https://cvcbackendhotel.herokuapp.com/hotels/avail/";
	private static final String HOTELSBYHOTELURI = "https://cvcbackendhotel.herokuapp.com/hotels/";
	private static final double COMMISSION = 0.7;
	
	
	//Metodo Responsável por realizar as regras de negócios e devolver para o controller
	public List<TripResponse> getHotelPricesByTrip(Integer cityCode, LocalDate checkIn, LocalDate checkOut, Integer adultNumber, Integer childNumber) {
		
		//Chamando api de forma assíncrona
		Flux<Hotel> hotelFlux = this.getHotelsByCityId(cityCode);
		
		List<TripResponse> response = new ArrayList<TripResponse>();
		List<Hotel> hotelList = new ArrayList<Hotel>();
		
		//Calculando dias da estadia solicitada
		long stay = ChronoUnit.DAYS.between(checkIn, checkOut); 
		
		//Iniciando leitura da api
		hotelFlux.subscribe(resp -> hotelList.add(resp));
		
		//Aguandando primeiro objeto da api ser retornado para iniciar a lógica
		hotelFlux.blockFirst();
		
		//Laço para percorrer cada Hotel e Quartos disponíveis, realizando os calculos necessários
		//e transpondo para o objeto de resposta final
		for(Hotel item : hotelList) {
			TripResponse trip = new TripResponse();
			trip.setId(item.getId());
			trip.setCityName(item.getCityName());
			
			List<RoomResponse> rooms = new ArrayList<RoomResponse>();
			for(Room itemRoom : item.getRooms()) {
				RoomResponse room = new RoomResponse();
				room.setRoomID(itemRoom.getRoomID());
				room.setCategoryName(itemRoom.getCategoryName());
				
				//Calculando valor por adultos e crianças já com a comissão				
				double adultPrice = itemRoom.getPrice().getAdult() / COMMISSION;
				double childPrice = itemRoom.getPrice().getChild() / COMMISSION;
				
				//Arredondando valores após calculo da comissão
				adultPrice = DoubleRounder.round(adultPrice, 2);
				childPrice = DoubleRounder.round(childPrice, 2);
				
				//Definindo bloco PriceDetail
				PriceDetail priceDetail = new PriceDetail();
				priceDetail.setPricePerDayAdult(adultPrice);
				priceDetail.setPricePerDayChild(childPrice);
				room.setPriceDetail(priceDetail);
				
				//Calculando valor total da estadia
				double totalPrice = (adultPrice * adultNumber * stay) + (childPrice * childNumber * stay);
				totalPrice = DoubleRounder.round(totalPrice, 2);
				room.setTotalPrice(totalPrice);
				rooms.add(room);
			}
			trip.setRooms(rooms);
			response.add(trip);
			
		}
		
		
	
		return response;
	}
	
	//Metodo Responsável por realizar as regras de negócios e devolver para o controller
	public List<TripResponse> getHotelPriceByTrip(Integer hotelId, LocalDate checkIn, LocalDate checkOut, Integer adultNumber, Integer childNumber) {
		
		//Chamando api de forma assíncrona
		Flux<Hotel> hotelFlux = this.getHotelsByHotelId(hotelId);
		
		List<TripResponse> response = new ArrayList<TripResponse>();
		List<Hotel> hotelList = new ArrayList<Hotel>();
		
		//Calculando dias da estadia solicitada
		long stay = ChronoUnit.DAYS.between(checkIn, checkOut); 
		
		//Iniciando leitura da api
		hotelFlux.subscribe(resp -> hotelList.add(resp));
		
		//Aguandando primeiro objeto da api ser retornado para iniciar a lógica
		hotelFlux.blockFirst();
		
		//Laço para percorrer cada Hotel e Quartos disponíveis, realizando os calculos necessários
		//e transpondo para o objeto de resposta final
		for(Hotel item : hotelList) {
			TripResponse trip = new TripResponse();
			trip.setId(item.getId());
			trip.setCityName(item.getCityName());
			
			List<RoomResponse> rooms = new ArrayList<RoomResponse>();
			for(Room itemRoom : item.getRooms()) {
				RoomResponse room = new RoomResponse();
				room.setRoomID(itemRoom.getRoomID());
				room.setCategoryName(itemRoom.getCategoryName());
				
				//Calculando valor por adultos e crianças já com a comissão				
				double adultPrice = itemRoom.getPrice().getAdult() / COMMISSION;
				double childPrice = itemRoom.getPrice().getChild() / COMMISSION;
				
				//Arredondando valores após calculo da comissão
				adultPrice = DoubleRounder.round(adultPrice, 2);
				childPrice = DoubleRounder.round(childPrice, 2);
				
				//Definindo bloco PriceDetail
				PriceDetail priceDetail = new PriceDetail();
				priceDetail.setPricePerDayAdult(adultPrice);
				priceDetail.setPricePerDayChild(childPrice);
				room.setPriceDetail(priceDetail);
				
				//Calculando valor total da estadia
				double totalPrice = (adultPrice * adultNumber * stay) + (childPrice * childNumber * stay);
				totalPrice = DoubleRounder.round(totalPrice, 2);
				room.setTotalPrice(totalPrice);
				rooms.add(room);
			}
			trip.setRooms(rooms);
			response.add(trip);
			
		}
		
		
	
		return response;
	}
	
	
	//Método responsável por consumir a api que retornas os hotéis por cidade
	private Flux<Hotel> getHotelsByCityId(Integer cityCode) {
		
		Flux<Hotel> hotelFlux = webClienteBuilder.build()
				.get()
				.uri(HOTELSBYCITYURI+cityCode)
				.retrieve()
				.bodyToFlux(Hotel.class);

		return hotelFlux;
	}
	
	//Método responsável por consumir a api que retornas o detalhe do hotel
	private Flux<Hotel> getHotelsByHotelId(Integer hotelId) {
		
		Flux<Hotel> hotelFlux =  webClienteBuilder.build()
				.get()
				.uri(HOTELSBYHOTELURI+hotelId)
				.retrieve()
				.bodyToFlux(Hotel.class);
				
			
		 return hotelFlux;
	}
	
	
}
