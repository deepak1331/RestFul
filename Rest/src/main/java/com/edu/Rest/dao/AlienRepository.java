package com.edu.Rest.dao;

import java.util.Arrays;
import java.util.List;

import com.edu.Rest.model.Alien;

public class AlienRepository {

	List<Alien> list = null;

	public AlienRepository() {
		Alien a1 = new Alien(101,"Deepak", "Java", "Softcrylic", 29);
		Alien a2 = new Alien(102,"Shashi", "PeopleSoft", "Hexaware", 27);
		list = Arrays.asList(a1, a2);
	}

	public List<Alien> getList() {
		return list;
	}

	public Alien getAlienById(int id) {
		return list.stream().filter(a -> id == a.getUserId()).findAny().orElse(null);
	}

}
