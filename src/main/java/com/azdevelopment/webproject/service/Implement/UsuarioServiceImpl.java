package com.azdevelopment.webproject.service.Implement;

import com.azdevelopment.webproject.model.Usuario;
import com.azdevelopment.webproject.repository.UsuarioRepository;
import com.azdevelopment.webproject.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

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

    @Transactional
    public ResponseEntity<String> excluir(String id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            return status(HttpStatus.NOT_FOUND).body("Usuario não encontrado.");
        }
        return status(HttpStatus.OK).body("Usuario excluido com sucesso.");
    }
}
