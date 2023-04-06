package com.project.api.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.project.api.user.dto.AuthenticationRequest;
import com.project.api.user.dto.AuthenticationResponse;
import com.project.api.user.dto.RegisterRequest;
import com.project.database.Entities.user.User;
import com.project.services.user.UserService;

import jakarta.annotation.security.RolesAllowed;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

  private final UserService service;
  private final UserService userService;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody RegisterRequest request) {
    return ResponseEntity.ok(service.register(request));
  }

  //  @RolesAllowed("ROLE_ADMIN")
  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse> authenticate(
    @RequestBody AuthenticationRequest request) {
    return ResponseEntity.ok(service.authenticate(request));
  }
  @RolesAllowed("ROLE_ADMIN")
  @GetMapping("/users")
  public List<User> getAllUsers() {
    return userService.getAll();
  }
  @PostMapping("/users")
  public User addProduct(@RequestBody User user) {
    return userService.addUser(user);
  }

  @GetMapping("/users/{id}")
  public User getById(@PathVariable Integer id) {
    return userService.getById(id);
  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable int id) {
    userService.deleteUser(id);
  }

}
