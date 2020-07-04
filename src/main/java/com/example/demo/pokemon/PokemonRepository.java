package com.example.demo.pokemon;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Long> {

    @Query("SELECT p FROM Pokemon p WHERE fts(:description) = true")
    List<Pokemon> search(@Param("description") String description);

}
