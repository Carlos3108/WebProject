package com.azdevelopment.webproject.mapper;

import com.azdevelopment.webproject.dto.ProdutoDTO;
import com.azdevelopment.webproject.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {
    public ProdutoDTO from(Produto produto) {
        return ProdutoDTO.builder()
                .id(produto.getId())
                .produto(produto.getNomeProduto())
                .validade(produto.getValidade())
                .quantidade(produto.getQuantidade())
                .valor(produto.getValor())
                .build();
    }

    public Produto to(ProdutoDTO produto) {
        return Produto.builder()
                .id(produto.getId())
                .nomeProduto(produto.getProduto())
                .validade(produto.getValidade())
                .quantidade(produto.getQuantidade())
                .valor(produto.getValor())
                .build();
    }
}
