package com.azdevelopment.webproject.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document()
public class Produto {
    @Id
    private String id;
    private String nomeProduto;
    private Date validade;
    private int quantidade;
    private float valor;
}
