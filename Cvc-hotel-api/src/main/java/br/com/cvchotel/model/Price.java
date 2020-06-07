package br.com.cvchotel.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
*@author Jonatas Almeida	
*@date 06/06/2020
*/

//Parametro para evitar que seja transmitido varaveis nulas, melhorando a performance
@JsonInclude(Include.NON_NULL)
public class Price {
	
	private double adult;
	private double child;
	
	public double getAdult() {
		return adult;
	}
	public void setAdult(double adult) {
		this.adult = adult;
	}
	public double getChild() {
		return child;
	}
	public void setChild(double child) {
		this.child = child;
	}
	
	
}
