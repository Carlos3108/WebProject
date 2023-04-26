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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    @SneakyThrows
    public UserDTO getID(String id) {
        User user = this.userRepository
                .findById(id)
                .orElseThrow(() -> new WebProjectException(WebProjectError.USER_NOT_FOUND));
        return userMapper.from(user);
    }

    @Override
    @SneakyThrows
    public ResponseEntity<UserDTO> create(UserDTO user) {
        if (!Objects.isNull(user.getId())) {
            throw new WebProjectException(WebProjectError.ERROR_CREATING);
        }
        User userEntity = userMapper.to(user);
        User save = this.userRepository.save(userEntity);
        return ResponseEntity.ok(userMapper.from(save));
    }

    @Transactional
    @SneakyThrows
    public void delete(String id) {
        userRepository.findById(id)
                .orElseThrow(() -> new WebProjectException(WebProjectError.USER_NOT_FOUND));
        userRepository.deleteById(id);
    }

    @Override
    @SneakyThrows
    @Transactional
    public UserDTO update(UserDTO userDTO) {
        User oldUser = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new WebProjectException(WebProjectError.USER_NOT_FOUND));
        User user = userMapper.fromUpdate(userDTO,oldUser);
        User userSaved = Optional.of(userRepository.save(user))
                .orElseThrow(() -> new WebProjectException(WebProjectError.ERROR_UPDATE));
        return userMapper.from(userSaved);
    }
}
