package com.movieflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieflix.entities.Movie;
import com.movieflix.repositories.MovieRepository;

@Service
public class MovieServiceImplementation implements MovieService
{
	@Autowired 
	MovieRepository	movrepo;
	
	
	@Override
	public String addMovie(Movie mov) {
		System.out.println("movie added");
		movrepo.save(mov);
		System.out.println("movie is added");
		return "movie is added";
	}


	@Override
	public List<Movie> viewMovie() {
		List<Movie> movieList = movrepo.findAll();
		return movieList;
	}


	@Override
	public Movie updateMovie(Movie mov) {
		return movrepo.save(mov);
	}


	@Override
	public String deleteUser(int id) {
		movrepo.deleteById(id);
		return "user Deleted";
	}



}
