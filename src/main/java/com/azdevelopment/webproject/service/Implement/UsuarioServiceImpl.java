package com.azdevelopment.webproject.service.Implement;

import com.azdevelopment.webproject.dto.UsuarioDTO;
import com.azdevelopment.webproject.exception.WebProjectError;
import com.azdevelopment.webproject.exception.WebProjectException;
import com.azdevelopment.webproject.mapper.UsuarioMapper;
import com.azdevelopment.webproject.model.Usuario;
import com.azdevelopment.webproject.repository.UsuarioRepository;
import com.azdevelopment.webproject.service.UsuarioService;
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
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private UsuarioMapper usuarioMapper;

    @Override
    public List<UsuarioDTO> obterUsuario() {
        List<Usuario> usuarios = this.usuarioRepository.findAll();
        return usuarioMapper.from(usuarios);
    }

    @Override
    public UsuarioDTO obterID(String id) {
        Usuario usuarios = this.usuarioRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario não existe."));
        return usuarioMapper.from(usuarios);
    }

    @Override
    public UsuarioDTO criar(UsuarioDTO usuario) {
        Usuario usuarioEntity = usuarioMapper.to(usuario);
        Usuario save = this.usuarioRepository.save(usuarioEntity);
        return usuarioMapper.from(save);
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

    @Override
    @SneakyThrows
    @Transactional
    public UsuarioDTO atualizarUsuario(UsuarioDTO usuario) {
        Usuario user = usuarioRepository.findById(usuario.getId())
                .orElseThrow(() -> new WebProjectException(WebProjectError.USER_NOT_FOUND));
            Usuario obj = new Usuario();
            obj.setNome(user.getNome());
            obj.setNascimento(user.getNascimento());
            obj.setEmail(user.getEmail());
            obj.setSenha(user.getSenha());
            Usuario userSaved = usuarioRepository.save(obj);

        return usuarioMapper.from(userSaved);
    }
}
