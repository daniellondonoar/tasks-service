package com.tasks.routes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasks.models.Users;
import com.tasks.controller.UsersController;

@CrossOrigin
@RequestMapping("users")
@RestController
public class UsersRoute {
	
	@Autowired
	private UsersController UsersController;
	
	@PostMapping("/signin")
	public Optional<Users> signin(@RequestBody Users users) {
		return UsersController.findByUsernameAndPassword(users.getUsername().toString(), users.getPassword().toString());
	}
	
	@GetMapping("/getOne/{id}")
	public Optional<Users> getOne(@PathVariable Integer id) {
		return UsersController.findById(id);
	}
}
