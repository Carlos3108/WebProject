package com.azdevelopment.webproject.repository;

import com.azdevelopment.webproject.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UsuarioRepository extends MongoRepository<Usuario, String> {

}
