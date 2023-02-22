package com.azdevelopment.webproject.mapper;

import com.azdevelopment.webproject.dto.UsuarioDTO;
import com.azdevelopment.webproject.exception.WebProjectError;
import com.azdevelopment.webproject.exception.WebProjectException;
import com.azdevelopment.webproject.model.Usuario;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UsuarioMapper {

    public List<UsuarioDTO> from(List<Usuario> usuarios) {
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();
        usuarios.forEach(usuario -> {
            usuariosDTO.add(UsuarioDTO.builder()
                    .id(usuario.getId())
                    .nome(usuario.getNome())
                    .email(usuario.getEmail())
                    .nascimento(usuario.getNascimento())
                    .build());
        });
        return usuariosDTO;
    }

    public UsuarioDTO from(Usuario usuario) {
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .nascimento(usuario.getNascimento())
                .build();
    }

    public UsuarioDTO fromUpdate(UsuarioDTO usuarioDTO, Usuario usuario) {

        return UsuarioDTO.builder()
                .id(usuario.getId())
                .nome(isDiferent(usuarioDTO.getNome(), usuario.getNome()))
                .email(isDiferent(usuarioDTO.getEmail(), usuario.getEmail()))
                .nascimento(new Date(isDiferent(usuarioDTO.getNascimento().toString(),
                        usuario.getNascimento().toString())))
                .senha(isDiferent(usuarioDTO.getSenha(), usuario.getSenha()))
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

    public Usuario to(UsuarioDTO usuario) {
        Usuario usuarioEntity = new Usuario();
        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setEmail(usuario.getEmail());
        usuarioEntity.setNascimento(usuario.getNascimento());
        usuarioEntity.setSenha(usuario.getSenha());
        return usuarioEntity;
    }
}
