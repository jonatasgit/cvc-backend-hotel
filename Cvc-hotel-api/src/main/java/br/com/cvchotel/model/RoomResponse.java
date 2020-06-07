package br.com.cvchotel.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
*@author Jonatas Almeida	
*@date 06/06/2020
*/

//Parametro para evitar que seja transmitido varaveis nulas, melhorando a performance
@JsonInclude(Include.NON_NULL)
public class RoomResponse {
	private Integer roomID;
	private String categoryName;
	private double totalPrice;
	private PriceDetail priceDetail;
	
	public Integer getRoomID() {
		return roomID;
	}
	public void setRoomID(Integer roomID) {
		this.roomID = roomID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public PriceDetail getPriceDetail() {
		return priceDetail;
	}
	public void setPriceDetail(PriceDetail priceDetail) {
		this.priceDetail = priceDetail;
	}
	
	
}
