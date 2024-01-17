package com.semanadois.semanadois.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public Produto cadastrar(Produto produto) {
        return this.produtoRepository.save(produto);
    }

    public Produto pegarPorId(Integer id) {
        return this.produtoRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarProduto(Integer id) {
        this.produtoRepository.deleteById(id);
    }


    @Transactional(readOnly = true)
    public List<Produto> findByNome(String nome) {
        return this.produtoRepository.findAllByNome("%" + nome + "%");
    }
}
