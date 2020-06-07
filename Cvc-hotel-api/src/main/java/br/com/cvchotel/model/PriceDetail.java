package br.com.cvchotel.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
*@author Jonatas Almeida	
*@date 06/06/2020
*/

//Parametro para evitar que seja transmitido varaveis nulas, melhorando a performance
@JsonInclude(Include.NON_NULL)
public class PriceDetail {
	private double pricePerDayAdult;
	private double pricePerDayChild;
	
	public double getPricePerDayAdult() {
		return pricePerDayAdult;
	}
	public void setPricePerDayAdult(double pricePerDayAdult) {
		this.pricePerDayAdult = pricePerDayAdult;
	}
	public double getPricePerDayChild() {
		return pricePerDayChild;
	}
	public void setPricePerDayChild(double pricePerDayChild) {
		this.pricePerDayChild = pricePerDayChild;
	}
	
	
}
