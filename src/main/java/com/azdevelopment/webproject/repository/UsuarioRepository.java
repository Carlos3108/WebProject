package com.azdevelopment.webproject.repository;

import com.azdevelopment.webproject.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<User, String> {

}
