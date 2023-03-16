package com.example.prueba.controller;

import com.example.prueba.configuration.TokenManager;
import com.example.prueba.model.Person;
import com.example.prueba.model.User;
import com.example.prueba.service.PersonService;
import com.example.prueba.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PersonService personService;
    private final PasswordEncoder passwordEncoder;
    private final TokenManager tokenManager;

    @PostMapping("/login")
    public User login(@RequestBody  User user) {
       User email = userService.findByEmail(user.getEmail());
       if (email == null)
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);

       if(!passwordEncoder.matches(user.getPassword(), email.getPassword()))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);

       if(!email.isEnabled())
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);

       user.setPassword(null);
       String token = tokenManager.generateJwtToken(user.getEmail());

       user.setToken(token);

       return user;
    }

    @PostMapping("/register")
    public User save(@RequestBody  User user) {
        Person getId = personService.save(user.getPerson());

        user.setPerson(getId);
        String passEncode = passwordEncoder.encode(user.getPassword());
        user.setPassword(passEncode);
        userService.save(user);
        user.setPassword(null);
        return user;
    }

    @GetMapping
    public User findByEmail(String email) {
        return userService.findByEmail(email);
    }


}
