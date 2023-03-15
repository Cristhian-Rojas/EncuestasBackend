package com.example.prueba.repository;

import com.example.prueba.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    @Query(value = "select u.email from testfit.users u where u.id_user=:id  group by u.email;",nativeQuery = true)
    String findEmail(int id);
}
