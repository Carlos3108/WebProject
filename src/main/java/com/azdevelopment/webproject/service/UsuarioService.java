package com.azdevelopment.webproject.service;

import com.azdevelopment.webproject.model.Usuario;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface UsuarioService {
    List<Usuario> obterUsuario();
    Usuario obterID(String id);
    Usuario criar(Usuario usuario);
    ResponseEntity<String> excluir(String id);
}
