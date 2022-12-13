package com.azdevelopment.webproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {
    private String id;
    private String produto;
    private Date validade;
    private int quantidade;
    private float valor;
}
