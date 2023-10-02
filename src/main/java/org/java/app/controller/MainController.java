package org.java.app.controller;

import java.util.ArrayList;

import org.java.app.Movie;
import org.java.app.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	private Song getSingleSongs(int id) {
		Song[] listaSong = new Song[10];
		for (int i = 0; i < 10; i++) {
			listaSong[i] = new Song(i, "song" + i);

		}
		return listaSong[id];
	}

	private String getBestMovies() {
		String listaString = "";

		for (int i = 0; i < 10; i++) {
			listaString += new Movie(i, "movie" + i) + ",";

		}
		return listaString;
	}

	private Movie getSingleMovies(int id) {
		Movie[] listaMovie = new Movie[10];
		for (int i = 0; i < 10; i++) {
			listaMovie[i] = new Movie(i, "movie" + i);

		}
		return listaMovie[id];
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

//-----------------------------------------------
	@GetMapping("/songs/{id}")

	public String singleSong(@PathVariable int id, Model model) {
		Song singola = getSingleSongs(id);
		model.addAttribute("string", singola);

		return "singleSong";
	}

	@GetMapping("/movies/{id}")

	public String singleMovie(@PathVariable int id, Model model) {
		Movie singola = getSingleMovies(id);
		model.addAttribute("string", singola);

		return "SingleMovie";
	}


}