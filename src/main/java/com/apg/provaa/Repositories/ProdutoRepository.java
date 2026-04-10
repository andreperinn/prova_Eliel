package com.apg.provaa.Repositories;

import com.apg.provaa.Models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository <ProdutoModel, Long> {
}
