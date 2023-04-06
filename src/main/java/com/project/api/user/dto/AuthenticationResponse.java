package com.project.api.user.dto;

import com.project.database.Entities.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

  private boolean success;
  private String token;
 
  private String message;
User user;
}
