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
public class Hotel {
	
	private Integer id;
	private String name;
	private Integer cityCode;
	private String cityName;
	private List<Room> rooms;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCityCode() {
		return cityCode;
	}
	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	

}
