package com.azdevelopment.webproject.mapper;

import com.azdevelopment.webproject.dto.UsuarioDTO;
import com.azdevelopment.webproject.exception.WebProjectError;
import com.azdevelopment.webproject.exception.WebProjectException;
import com.azdevelopment.webproject.model.User;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UsuarioMapper {

    public List<UsuarioDTO> from(List<User> users) {
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();
        users.forEach(user -> {
            usuariosDTO.add(UsuarioDTO.builder()
                    .id(user.getId())
                    .nome(user.getNome())
                    .email(user.getEmail())
                    .nascimento(user.getNascimento())
                    .build());
        });
        return usuariosDTO;
    }

    public UsuarioDTO from(User user) {
        return UsuarioDTO.builder()
                .id(user.getId())
                .nome(user.getNome())
                .email(user.getEmail())
                .nascimento(user.getNascimento())
                .build();
    }

    public UsuarioDTO fromUpdate(UsuarioDTO usuarioDTO, User user) {

        return UsuarioDTO.builder()
                .id(user.getId())
                .nome(isDiferent(usuarioDTO.getNome(), user.getNome()))
                .email(isDiferent(usuarioDTO.getEmail(), user.getEmail()))
                .nascimento(new Date(isDiferent(usuarioDTO.getNascimento().toString(),
                        user.getNascimento().toString())))
                .senha(isDiferent(usuarioDTO.getSenha(), user.getSenha()))
                .build();
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

    public User to(UsuarioDTO usuario) {
        User userEntity = new User();
        userEntity.setNome(usuario.getNome());
        userEntity.setEmail(usuario.getEmail());
        userEntity.setNascimento(usuario.getNascimento());
        userEntity.setSenha(usuario.getSenha());
        return userEntity;
    }
}
