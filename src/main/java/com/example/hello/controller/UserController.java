package com.example.hello.controller;

import com.example.hello.model.User;
import com.example.hello.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Configuration
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "Greeting")
	@GetMapping("/")
	public String index() {
		return "Hello customer";
	}

	@ApiOperation(value = "View a list of all available users")
	@GetMapping("/users")
	public List<User> getCustomers() {
		return userService.getAllUsers();
	}

	@ApiOperation(value = "Get a user by Id")
	@GetMapping("/users/{id}")
	public Optional<User> getCustomerId(@PathVariable int id) {
		return userService.getUser(id);
	}

	@ApiOperation(value = "Add a user")
	@PostMapping ("/users/add")
	public void addUsers(@RequestBody User user) {
		userService.addUser(user);
	}

	@ApiOperation(value = "Update a user")
	@PutMapping ("/users/update")
	public void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}

	@ApiOperation(value = "Delete a user by id")
	@DeleteMapping ("/users/delete/id/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}


}