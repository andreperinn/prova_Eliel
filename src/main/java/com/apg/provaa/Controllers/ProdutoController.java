package com.apg.provaa.Controllers;

import com.apg.provaa.Models.ProdutoModel;
import com.apg.provaa.Repositories.ProdutoRepository;
import com.apg.provaa.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping (path = "/api/produtos")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;


    @PostMapping
    public ResponseEntity <ProdutoModel> criarProd(@RequestBody ProdutoModel produtoModel) {
        ProdutoModel request = produtoService.criarProd(produtoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity <List<ProdutoModel>> listarProd() {
       List <ProdutoModel> request = produtoService.listarProd();
       return ResponseEntity.ok().body(request);
    }

    @GetMapping (path = "/{id}")
    public ResponseEntity <ProdutoModel> buscarId(@PathVariable Long id) {
        ProdutoModel request = produtoService.buscarId(id);
        return ResponseEntity.ok().body(request);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity <ProdutoModel> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoModel produtoModel) {
        ProdutoModel request = produtoService.atualizarProd(produtoModel, id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoService.excluirProd(id);
        return ResponseEntity.noContent().build();
    }




}
