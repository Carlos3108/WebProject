package com.azdevelopment.webproject.controller;

import com.azdevelopment.webproject.dto.UserDTO;
import com.azdevelopment.webproject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
    public UserDTO create(@RequestBody UserDTO user) throws Exception {
        if (!Objects.isNull(user.getId())) {
            throw new Exception("Ao criar o usuario o ID deve ser Null");
        }
        return this.userService.create(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id)  {
        userService.delete(id);
    }

    @PutMapping
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO user) throws Exception {
        if (!Objects.nonNull(user.getId())) {
            throw new Exception("When updating the user, the ID must be filled in.");
        }
        return ResponseEntity.ok(this.userService.update(user));
    }
}
