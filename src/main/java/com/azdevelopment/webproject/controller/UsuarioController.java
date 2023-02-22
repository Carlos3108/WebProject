package com.azdevelopment.webproject.controller;

import com.azdevelopment.webproject.dto.UsuarioDTO;
import com.azdevelopment.webproject.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuarioDTO> obterUsuarios() {
        return this.usuarioService.obterUsuario();
    }

    @GetMapping("/{id}")
    public UsuarioDTO obterID(@PathVariable String id) {
        return this.usuarioService.obterID(id);
    }

    @PostMapping
    public UsuarioDTO criar(@RequestBody UsuarioDTO usuario) throws Exception {
        if (!Objects.isNull(usuario.getId())) {
            throw new Exception("Ao criar o usuario o ID deve ser Null");
        }
        return this.usuarioService.criar(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable String id) {
        return this.usuarioService.excluir(id);
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@RequestBody UsuarioDTO usuario) throws Exception {
        if (!Objects.nonNull(usuario.getId())) {
            throw new Exception("Ao atualizar o usuario o ID deve ser preenchido");
        }
        return ResponseEntity.ok(this.usuarioService.atualizarUsuario(usuario));
    }
}
