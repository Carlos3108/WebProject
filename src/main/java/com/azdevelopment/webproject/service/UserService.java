package com.azdevelopment.webproject.service;

import com.azdevelopment.webproject.dto.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<UserDTO> getUser();

    UserDTO getID(String id);

    ResponseEntity<UserDTO> create(UserDTO user);

    void delete(String id);

    UserDTO update(UserDTO user);
}
