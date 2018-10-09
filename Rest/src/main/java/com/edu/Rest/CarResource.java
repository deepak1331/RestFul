package com.edu.Rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.edu.Rest.model.Car;

@Path("cars")
public class CarResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Car> getCar() {
		System.out.println("Get Car method called.");
		Car c1 = new Car("Hyundai", "Accent", 2009);
		Car c2 = new Car("Maruti", "Ciaz", 2018);
//		return Arrays.asList(c1, c2);
		List<Car> carList = new ArrayList<Car> ();
		carList.add(c1);
		carList.add(c2);
		return carList;
	}

}
