package com.movieflix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.movieflix.entities.Movie;
import com.movieflix.services.MovieService;

//@RestController
//@RequestMapping("Movie")

@Controller
public class MovieController {
	
	@Autowired
	MovieService movserv;
	
	
	@GetMapping("map-addmovie")
	public String mapAddMovie()
	{
		return "addmovie";
		
	}
	
	@PostMapping("addmovie")
	public String addMovie(@ModelAttribute Movie mov) {
		movserv.addMovie(mov);
		return "addmoviesuccess";
	}
	
	
	@GetMapping("viewmovie")
	public String viewMovie(Model model) {
		List<Movie> movieList = movserv.viewMovie();
		model.addAttribute("movie", movieList);
		return "viewmovie";
	}
	
//	@PostMapping("deletemovie")
//	public String deleteMovie(@PathVariable int id) {
//		movserv.deleteMovie(id);
//		return "moviedeleted";
//	}
//	
	@GetMapping("exploremovies")
	public String movies() {
		return "payment";
	}
	
		@PostMapping("update")
		public Movie updateMovie(@RequestBody Movie mov) {
		return movserv.updateMovie(mov);
//		userv.updateProfile(user);
//		return "userUpdated";
	}
//	
	@DeleteMapping("delete{id}")
	public String deleteUser(@PathVariable int id){
		 return movserv.deleteUser(id);
//		return "userdeleted";
	}
	
	
}
