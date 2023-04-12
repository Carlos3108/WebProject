package com.azdevelopment.webproject.service;

import com.azdevelopment.webproject.dto.UserDTO;
import com.azdevelopment.webproject.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> getUser();

    UserDTO getID(String id);

    UserDTO create(UserDTO user);

    void delete(String id);

    UserDTO update(UserDTO user);
}
