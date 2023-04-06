package com.azdevelopment.webproject.service.Implement;

import com.azdevelopment.webproject.dto.UserDTO;
import com.azdevelopment.webproject.exception.WebProjectError;
import com.azdevelopment.webproject.exception.WebProjectException;
import com.azdevelopment.webproject.mapper.UserMapper;
import com.azdevelopment.webproject.model.User;
import com.azdevelopment.webproject.repository.UserRepository;
import com.azdevelopment.webproject.service.UserService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private UserMapper userMapper;

    @Override
    public List<UserDTO> getUser() {
        List<User> users = this.userRepository.findAll();
        return userMapper.from(users);
    }

    @Override
    public UserDTO getID(String id) {
        User user = this.userRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User does not exist."));
        return userMapper.from(user);
    }

    @Override
    public UserDTO create(UserDTO user) {
        User userEntity = userMapper.to(user);
        User save = this.userRepository.save(userEntity);
        return userMapper.from(save);
    }

    @Transactional
    public ResponseEntity<String> delete(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            return status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        return status(HttpStatus.OK).body("User deleted successfully.");
    }

    @Override
    @SneakyThrows
    @Transactional
    public UserDTO update(UserDTO userDTO) {
        User user = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new WebProjectException(WebProjectError.USER_NOT_FOUND));
            User userSaved = userRepository.save(user);
        return userMapper.fromUpdate(userDTO, userSaved);
    }
}
