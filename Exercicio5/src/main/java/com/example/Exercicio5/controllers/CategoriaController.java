package com.example.Exercicio5.controllers;

import java.util.List;

import com.example.Exercicio5.models.CategoriaModel;
import com.example.Exercicio5.services.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<CategoriaModel> criarCategoria(@RequestBody CategoriaModel categoria) {
        CategoriaModel novaCategoria = categoriaService.criarCategoria(categoria);
        return ResponseEntity.status(201).body(novaCategoria);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaModel>> listarCategorias() {
        return ResponseEntity.ok(categoriaService.listarCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaModel> buscarCategoria(@PathVariable Long id) {

        CategoriaModel categoria = categoriaService.buscarPorId(id);

        if (categoria == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {

        CategoriaModel categoria = categoriaService.buscarPorId(id);

        if (categoria == null) {
            return ResponseEntity.notFound().build();
        }

        categoriaService.deletarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}