package com.grh.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grh.dao.services.UserServiceInterface;
import com.grh.model.entities.Profile;
import com.grh.model.entities.User;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	private final UserServiceInterface userService;
@GetMapping
public ResponseEntity<List<User>> getUsers()
{
	return ResponseEntity.ok(userService.getUsers());
	
}
@PostMapping
public ResponseEntity<User> addOne(@Valid @RequestBody User user)
{
return ResponseEntity.ok(userService.creaOneUser(user));	

}
@PutMapping("/{userId}")
public ResponseEntity<Profile> updateProfile(@Valid @RequestBody Profile profile, @PathVariable long userId )
{
return ResponseEntity.ok(userService.updateProfile(profile, userId));	
}
@PatchMapping("/{userId}")
public ResponseEntity<User> assignProfile(@Valid @RequestBody Profile profile, @PathVariable long userId )
{
return ResponseEntity.ok(userService.AssignProfileToUser(userId, profile));	
}
@DeleteMapping("/{id}")
public void deleteOneUser(@PathVariable long id)
{
	userService.deleteOneUser(id);
}


}
