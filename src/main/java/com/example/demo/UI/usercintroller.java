package com.example.demo.UI;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //BindRequests
@RequestMapping("users") //Handle requests
public class usercintroller {
	
	
	@GetMapping //bind the get request
	public String getuser()
	{
		return "get user called";
	}
	
	@PostMapping // Posy
	public String createUser() {
		return "Create User called";
	}
	
	@PutMapping
	public String updateUser() {
		return "Update User Called";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "Delete user called";
	}

}
