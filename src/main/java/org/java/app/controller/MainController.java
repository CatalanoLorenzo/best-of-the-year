package org.java.app.controller;

import java.util.ArrayList;

import org.java.app.Movie;
import org.java.app.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	private String getBestSongs() {
		String listaString = "";
		for (int i = 0; i < 10; i++) {
			listaString += new Song(i, "song" + i) + ",";

		}
		return listaString;
	}

	private String getBestMovies() {
		String listaString = "";

		for (int i = 0; i < 10; i++) {
			listaString += new Movie(i, "song" + i) + ",";

		}
		return listaString;
	}

//-----------------------------------------------
	@GetMapping("/")
	@ResponseBody
	public String home(Model model) {
		final String name = "Lorenzo";
		model.addAttribute("name", name);
		return "Home";
	}

//-----------------------------------------------
	@GetMapping("/movies")

	public String movies(Model model) {
		String dati = getBestMovies();
		model.addAttribute("string", dati);

		return "Movies";
	}

	@GetMapping("/songs")
	public String songs(Model model) {
		String dati = getBestSongs();
		model.addAttribute("string", dati);

		return "Songs";
	}
}
