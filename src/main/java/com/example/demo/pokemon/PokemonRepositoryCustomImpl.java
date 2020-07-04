package com.example.demo.pokemon;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PokemonRepositoryCustomImpl implements PokemonRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Pokemon> search(String description) {
        List pokemons = entityManager.createQuery(
                "select p from Pokemon p where fts(" + description + ") = true")
                .getResultList();
        return pokemons;
    }
}
