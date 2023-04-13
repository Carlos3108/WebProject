package com.azdevelopment.webproject.controller;

import com.azdevelopment.webproject.dto.UserDTO;
import com.azdevelopment.webproject.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getUser() {
        return this.userService.getUser();
    }

    @GetMapping("/{id}")
    public UserDTO getID(@PathVariable String id) {
        return this.userService.getID(id);
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO user){
        return userService.create(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id)  {
        userService.delete(id);
    }

    @PutMapping
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO user){
        return ResponseEntity.ok(this.userService.update(user));
    }
}
