package com.apg.provaa.Services;


import com.apg.provaa.Models.ProdutoModel;
import com.apg.provaa.Repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;


    public ProdutoModel criarProd(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

    public List <ProdutoModel> listarProd() {
        return produtoRepository.findAll();
    }

    public ProdutoModel buscarId(Long id) {
        return produtoRepository.findById(id).get();
    }

    public ProdutoModel atualizarProd(ProdutoModel produtoexistente, Long id) {
        produtoexistente = produtoRepository.findById(id).get();

        produtoexistente.setNome(produtoexistente.getNome());
        produtoexistente.setPreco(produtoexistente.getPreco());
        produtoexistente.setDescricao(produtoexistente.getDescricao());
        produtoexistente.setId(produtoexistente.getId());
        produtoexistente.setStatus(produtoexistente.getStatus());

        return produtoRepository.save(produtoexistente);

    }

    public void excluirProd(Long id) {
        produtoRepository.deleteById(id);
    }

}
