package com.azdevelopment.webproject.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document()
public class User {
    @Id
    private String id;
    private String name;
    private Date birth;
    private String email;
    private String password;
}

