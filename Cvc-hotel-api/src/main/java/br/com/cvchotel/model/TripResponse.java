package br.com.cvchotel.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
*@author Jonatas Almeida	
*@date 06/06/2020
*/

//Parametro para evitar que seja transmitido varaveis nulas, melhorando a performance
@JsonInclude(Include.NON_NULL)
public class TripResponse {
	
	private Integer Id;
	private String cityName;
	private List<RoomResponse> rooms;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public List<RoomResponse> getRooms() {
		return rooms;
	}
	public void setRooms(List<RoomResponse> rooms) {
		this.rooms = rooms;
	}
	
	
}
