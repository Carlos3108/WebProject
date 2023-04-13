package com.azdevelopment.webproject.mapper;

import com.azdevelopment.webproject.dto.UserDTO;
import com.azdevelopment.webproject.exception.WebProjectError;
import com.azdevelopment.webproject.exception.WebProjectException;
import com.azdevelopment.webproject.model.User;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserMapper {

    public List<UserDTO> from(List<User> users) {
        List<UserDTO> userDTO = new ArrayList<>();
        users.forEach(user -> {
            userDTO.add(UserDTO.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .email(user.getEmail())
                    .birth(user.getBirth())
                    .build());
        });
        return userDTO;
    }

    public UserDTO from(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .birth(user.getBirth())
                .build();
    }

    public User fromUpdate(UserDTO userDTO ,User user) {
        return User.builder()
                .id(user.getId())
                .name(isDiferent(userDTO.getName(), user.getName()))
                .email(isDiferent(userDTO.getEmail(), user.getEmail()))
                .birth(isDiferentDate(userDTO.getBirth(), user.getBirth()))
                .password(isDiferent(userDTO.getPassword(), user.getPassword()))
                .build();
    }

    private Date isDiferentDate(Date newBirth, Date oldBirth) {
        if (newBirth != null && !newBirth.equals(oldBirth))
            return newBirth;
        else
            return oldBirth;
    }

    private static String isDiferent(String newValue, String oldValue) {
        if (newValue != null && !newValue.equals(oldValue))
            return isValid(newValue);
        else
            return isValid(oldValue);
    }

    @SneakyThrows
    private static String isValid(String value) {
        if (value.trim().isEmpty())
            throw new WebProjectException(WebProjectError.VALUE_IS_INVALID);
        return value;
    }

    public User to(UserDTO userDTO) {
        return User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .birth(userDTO.getBirth())
                .password(userDTO.getPassword())
                .build();
    }
}
