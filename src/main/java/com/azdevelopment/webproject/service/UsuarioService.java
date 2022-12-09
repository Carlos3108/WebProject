package com.azdevelopment.webproject.service;

import com.azdevelopment.webproject.dto.UsuarioDTO;
import com.azdevelopment.webproject.model.Usuario;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface UsuarioService {
    List<UsuarioDTO> obterUsuario();
    UsuarioDTO obterID(String id);
    UsuarioDTO criar(UsuarioDTO usuario);
    ResponseEntity<String> excluir(String id);
    ResponseEntity<String> atualizarUsuario(UsuarioDTO usuario);
}
