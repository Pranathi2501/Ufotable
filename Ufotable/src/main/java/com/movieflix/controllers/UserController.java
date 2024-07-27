package com.movieflix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.movieflix.entities.Movie;
import com.movieflix.entities.User;
import com.movieflix.services.MovieService;
import com.movieflix.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
//@RestController
//@RequestMapping("User")


public class UserController {
	@Autowired
	UserService userv;
	
	@Autowired
	MovieService movserv;
	
	
	@GetMapping("viewuser")
	public String viewUser(Model model){
		List<User> userList = userv.viewUser();
		model.addAttribute("user",userList);
		return "viewuser";
		
	}

	@GetMapping("exploremovie")
	public String exploreMovie(Model model, HttpSession session) {
		
		String email = (String)session.getAttribute("email");

		User usr=userv.getUser(email);
		boolean status = usr.isPremium();
		
		if(status == true)
		{
			List<Movie> movieList = movserv.viewMovie();
			model.addAttribute("movie", movieList);
			return "viewmovieuser";
		}
		else
		{
			return "payment";
		}
	}
	
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
//	@PostMapping("update")
//	public User updateProfile(@RequestBody User user) {
//		return userv.updateProfile(user);
////		userv.updateProfile(user);
////		return "userUpdated";
//	}
//	
//	@DeleteMapping("delete{id}")
//	public String deleteUser(@PathVariable int id){
//		 return userv.deleteUser(id);
////		return "userdeleted";
//	}
}		
	
	
	
	
	

//	<form th:action ="update" th:object ="${user}" method=post>
//	</form>
//	<form th:action ="@{/user/{id} (id=${student.id})}" th:object ="${user}" method=post>


