package com.azdevelopment.webproject.controller;

import com.azdevelopment.webproject.model.Usuario;
import com.azdevelopment.webproject.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
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

}
