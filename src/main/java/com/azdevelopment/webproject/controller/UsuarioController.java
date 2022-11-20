package com.azdevelopment.webproject.controller;

import com.azdevelopment.webproject.model.Usuario;
import com.azdevelopment.webproject.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> obterUsuarios(){
        return this.usuarioService.obterUsuario();
    }
    @GetMapping("/{id}")
    public Usuario obterID(@PathVariable String id){
        return this.usuarioService.obterID(id);
    }
    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario){
        return this.usuarioService.criar(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable String id){
        return this.usuarioService.excluir(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarUsuario(@RequestBody Usuario usuario,
                                            @PathVariable("id") String id){
        return usuarioService.atualizarUsuario(usuario, id);
    }
}
