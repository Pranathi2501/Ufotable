package com.movieflix.services;

import java.util.List;

import com.movieflix.entities.Movie;

public interface MovieService {

	public String addMovie(Movie mov);
	
	public List<Movie> viewMovie();

	public Movie updateMovie(Movie mov);

	public String deleteUser(int id);



}
