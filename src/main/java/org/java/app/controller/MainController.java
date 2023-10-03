package org.java.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.app.pojo.Movie;
import org.java.app.pojo.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {

	@GetMapping("/")
	public String home(Model model, HttpServletRequest request) {
		String name = "Lorenzo";
		String currentUrl = request.getRequestURI();
		model.addAttribute("currentUrl", currentUrl);
		model.addAttribute("name", name);

		return "home";
	}

	@GetMapping("/movies")
	public String getMovies(Model model, HttpServletRequest request) {
		List<Movie> movies = getBestMovies();
		String currentUrl = request.getRequestURI();
		model.addAttribute("currentUrl", currentUrl);
		model.addAttribute("movies", movies);

		return "movies";
	}

	@GetMapping("/songs")
	public String getSongs(Model model, HttpServletRequest request) {
		List<Song> songs = getBestSongs();
		String currentUrl = request.getRequestURI();
		model.addAttribute("currentUrl", currentUrl);
		model.addAttribute("songs", songs);

		return "songs";
	}

	@GetMapping("/movies/{id}")
	public String getMovie(@PathVariable int id, Model model, HttpServletRequest request) {
		Movie movie = getBestMovies().stream().filter(singleMovie -> singleMovie.getId() == id).toList().get(0);
		String currentUrl = request.getRequestURI();
		model.addAttribute("currentUrl", currentUrl);
		model.addAttribute("movie", movie);

		return "movie";
	}

	@GetMapping("/songs/{id}")
	public String getSong(@PathVariable int id, Model model, HttpServletRequest request) {
		Song song = getBestSongs().stream().filter(singleSong -> singleSong.getId() == id).toList().get(0);
		String currentUrl = request.getRequestURI();
		model.addAttribute("song", song);

		return "song";
	}

	private List<Movie> getBestMovies() {
		List<Movie> movies = new ArrayList<>();

		for (int i = 1; i <= 5; i++) {
			movies.add(new Movie(i, "Movie " + i));
		}

		return movies;
	}

	private List<Song> getBestSongs() {
		List<Song> songs = new ArrayList<>();

		for (int i = 1; i <= 5; i++) {
			songs.add(new Song(i, "Song " + i));
		}

		return songs;
	}
}
