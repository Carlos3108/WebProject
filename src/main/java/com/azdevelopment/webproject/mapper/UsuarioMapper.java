package com.azdevelopment.webproject.mapper;

import com.azdevelopment.webproject.dto.UsuarioDTO;
import com.azdevelopment.webproject.model.Usuario;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
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

    public UsuarioDTO from(Usuario usuario){
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .nascimento(usuario.getNascimento())
                .build();
    }
}
