package com.example.Exercicio5.Repositories;

import com.example.Exercicio5.models.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {

}