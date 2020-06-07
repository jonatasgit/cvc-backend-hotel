package br.com.cvchotel.controller;

/**
*@author Jonatas Almeida	
*@date 06/06/2020
*/

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cvchotel.model.TripResponse;
import br.com.cvchotel.service.GetAvailableHotelsService;

@RestController
public class GetRoomPricesController {
	
	@Autowired
	GetAvailableHotelsService availableHotelsService;

	@ResponseBody
	@RequestMapping(value="/hotels-available", method = RequestMethod.GET)
	public ResponseEntity<List<TripResponse>> getHotelPricesByTrip(@RequestParam("cityCode") Integer cityCode,
															 @RequestParam("checkIn")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn,
															 @RequestParam("checkOut") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut,
															 @RequestParam("adultNumber") Integer adultNumber,
															 @RequestParam("childNumber") Integer childNumber) {
		
		return new ResponseEntity<>(availableHotelsService.getHotelPricesByTrip(cityCode, checkIn, checkOut, adultNumber, childNumber), HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/hotel-available", method = RequestMethod.GET)
	public ResponseEntity<List<TripResponse>> getHotelPriceByTrip(@RequestParam("hotelID") Integer hotelId,
															 @RequestParam("checkIn")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn,
															 @RequestParam("checkOut") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut,
															 @RequestParam("adultNumber") Integer adultNumber,
															 @RequestParam("childNumber") Integer childNumber) {
		
		return new ResponseEntity<>(availableHotelsService.getHotelPriceByTrip(hotelId, checkIn, checkOut, adultNumber, childNumber), HttpStatus.OK);
	}
	
}
