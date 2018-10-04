package com.edu.Rest1;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.edu.Rest1.model.Car;

@Path("car")
public class CarResource {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Car> getCar() {
		System.out.println("Get Car method called.");
		Car c1 = new Car("Hyundai", "Accent", 2009);
		Car c2 = new Car("Maruti", "Ciaz", 2018);
		List<Car> list = Arrays.asList(c1, c2);
		return list;
	}
	
//	@GET
//	@Produces(MediaType.APPLICATION_XML)
//	public Car getCar() {
//		System.out.println("Get Car method called.");
//		Car c1 = new Car("Hyundai", "Accent", 2009);
//		return c1;
//	}
	
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getCar() {
//		System.out.println("Get Car method called.");
//		Car c1 = new Car("Hyundai", "Verna", 2015);
//		return c1.toString();
//	}
	
}