package com.example.Exercicio5.services;

import java.util.List;

import com.example.Exercicio5.Repositories.CategoriaRepository;
import com.example.Exercicio5.models.CategoriaModel;
import org.springframework.stereotype.Service;


@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaModel criarCategoria(CategoriaModel categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<CategoriaModel> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public CategoriaModel buscarPorId(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public void deletarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}