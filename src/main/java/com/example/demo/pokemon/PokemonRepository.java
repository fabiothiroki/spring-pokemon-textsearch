package com.example.demo.pokemon;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Long>, PokemonRepositoryCustom {

    List<Pokemon> search(String description);

}
