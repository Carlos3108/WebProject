package com.azdevelopment.webproject.service.Implement;

import com.azdevelopment.webproject.model.Usuario;
import com.azdevelopment.webproject.repository.UsuarioRepository;
import com.azdevelopment.webproject.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> obterUsuario() {
        return this.usuarioRepository.findAll();
    }

    @Override
    public Usuario obterID(String id) {
        return this.usuarioRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario não existe."));
    }

    @Override
    public Usuario criar(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }
}
