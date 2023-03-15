package com.example.prueba.controller;

import com.example.prueba.model.Poll;
import com.example.prueba.service.PollService;
import com.example.prueba.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/polls")
@RequiredArgsConstructor
public class PollController {

    private final PollService pollService;
    private final UserService userService;

    @GetMapping
    ResponseEntity<List<Poll>> findAll() {
        return ResponseEntity.ok(pollService.findAll());
    }

    @PostMapping
    ResponseEntity<Poll> save(@RequestBody Poll poll) {

        String email = userService.findEmail(poll.getUser().getId());
        poll.setEmailpoll(email);

        Poll result = pollService.save(poll);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable int id) {
        Poll result = pollService.findById(id);

        try {
            pollService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


    }

}
