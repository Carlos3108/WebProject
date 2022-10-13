package com.azdevelopment.webproject.repository;

import com.azdevelopment.webproject.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface UsuarioRepository extends MongoRepository <Usuario, String>{
    @Query
    public List<Usuario> obterUsuarioPorNascimento(Date de, Date ate);
}
