package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FavortiesController {

	@RequestMapping(value = "/favorites", method = { RequestMethod.GET, RequestMethod.POST })
	public String favoritesForm() {
		System.out.println("FavortiesController.favoritesForm()");

		return "favorites/favorites";
	}

}
