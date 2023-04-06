package com.project.database.Repository.user;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.database.Entities.user.User;
@Repository
public interface UserRepositery  extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);

}
