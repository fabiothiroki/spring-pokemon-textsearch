package com.example.demo.pokemon;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepositoryCustom {
    List<Pokemon> search(String description);
}
