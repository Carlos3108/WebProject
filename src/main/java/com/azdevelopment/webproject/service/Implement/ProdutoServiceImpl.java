package com.azdevelopment.webproject.service.Implement;

import com.azdevelopment.webproject.dto.ProdutoDTO;
import com.azdevelopment.webproject.mapper.ProdutoMapper;
import com.azdevelopment.webproject.model.Produto;
import com.azdevelopment.webproject.repository.ProdutoRepository;
import com.azdevelopment.webproject.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {
    private ProdutoRepository produtoRepository;
    private ProdutoMapper produtoMapper;

    @Override
    public ProdutoDTO criar(ProdutoDTO produto) {
        Produto produtoEntity = produtoMapper.to(produto);
        Produto save = this.produtoRepository.save(produtoEntity);
        return produtoMapper.from(save);
    }
}
