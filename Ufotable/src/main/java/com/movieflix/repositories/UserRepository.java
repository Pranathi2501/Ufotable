package com.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieflix.entities.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	//Method to find user by using the email
	public User findByEmail(String email);

	public User deleteById(int id);

}






























