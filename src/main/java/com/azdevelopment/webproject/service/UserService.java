package com.azdevelopment.webproject.service;

import com.azdevelopment.webproject.dto.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<UserDTO> getUser();

    UserDTO getID(String id);

    UserDTO create(UserDTO user);

    ResponseEntity<String> delete(String id);

    UserDTO update(UserDTO user);
}
