package com.azdevelopment.webproject.controller;

import com.azdevelopment.webproject.dto.ProdutoDTO;
import com.azdevelopment.webproject.service.ProdutoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @PostMapping
    public ProdutoDTO criar(@RequestBody ProdutoDTO produto) throws Exception{
        if (!Objects.isNull(produto.getId())){
            throw new Exception("Ao adicionar um produto o ID deve ser Null");
        }
        return this.produtoService.criar(produto);
    }

}
