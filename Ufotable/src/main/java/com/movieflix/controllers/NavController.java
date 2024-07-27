package com.movieflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.movieflix.entities.User;
import com.movieflix.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class NavController {
//	@GetMapping("map-register")
//	public String mapRegister() 
//	{
//		return "register";
//	}
//	@GetMapping("map-login")
//	public String mapLogin() {
//		return "login";
//	}
//	@GetMapping("map-addmovie")
//	public String mapAddMovie()
//	{
//		return "addmovie";
//		
//	}
	
	
				@Autowired
				UserService userv;
				
				@GetMapping("/register")
				public String register() {
					return "register";
				}
			
				@GetMapping("/login")
				public String login() {
					return "login";
				}
				
				@PostMapping("/register")
				public String addUsers(@ModelAttribute User usr, Model model) {
					boolean status = userv.emailExits(usr.getEmail());
					if(status == true) {
						model.addAttribute("userExists", true);
						System.out.println(" User Already Exists");
						return "register";
						
					} else {
						model.addAttribute("userSuccess", true);
						System.out.println("User Registered Succesfully");
						userv.addUsers(usr);
						return "index";	
					}
				}
			
			
				@PostMapping("validateUser")
				public String validateUser(@RequestParam String email,
						@RequestParam String password,Model model, HttpSession session) {
					boolean loginStatus = userv.checkUser(email, password);
					if(loginStatus == true)  {
			
						session.setAttribute("email", email);
			
						if(email.equals("admin@gmail.com")) {
							return "adminhome";
						}
						else {
							return "userhome";
						}
					}
					else   {
						model.addAttribute("loginFailed", true); // Add loginFailed attribute to indicate failure
						return "index"; // Assuming your index.html template is named "index.html"
					}
				}
			
				
				@GetMapping("/services")
				public String service() {
					return "services";
				}
			
				@GetMapping("/contactus")
				public String contact() {
					return "contactus";
				}
				
				@GetMapping("/faq")
				public String faq() {
					return "faq";
				}
			
			
				@GetMapping("/aboutus")
				public String aboutus() {
					return "aboutus";
				}
			}
			
			
			
			
			
			
