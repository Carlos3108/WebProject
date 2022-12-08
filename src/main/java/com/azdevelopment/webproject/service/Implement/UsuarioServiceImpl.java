package com.azdevelopment.webproject.service.Implement;

import com.azdevelopment.webproject.dto.UsuarioDTO;
import com.azdevelopment.webproject.mapper.UsuarioMapper;
import com.azdevelopment.webproject.model.Usuario;
import com.azdevelopment.webproject.repository.UsuarioRepository;
import com.azdevelopment.webproject.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

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

    @Override
    public ResponseEntity<String> atualizarUsuario(Usuario usuario, String id){
        Optional<Usuario> user = usuarioRepository.findById(id);
        if (user.isPresent()){
            Usuario obj = user.get();
            if (usuario.getNome() != null){
                obj.setNome(usuario.getNome());
            }
            if (usuario.getNascimento() != null){
                obj.setNascimento(usuario.getNascimento());
            }
            if (usuario.getEmail() != null){
                obj.setEmail(usuario.getEmail());
            }
            if (usuario.getSenha() != null){
                obj.setSenha(usuario.getSenha());
            }
            usuarioRepository.save(obj);
        } else {
            return status(HttpStatus.BAD_REQUEST).body("Usuario não encontrado.");
        }
        return status(HttpStatus.OK).body("Usuario atualizado com sucesso.");
    }
}
