package com.example.demo.pokemon;


import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;

import java.io.InputStream;
import java.util.List;

public class PokemonReader {

    public static List<Pokemon> readFile(InputStream inputStream) throws Exception {
        MappingIterator<Pokemon> pokemonIter = new CsvMapper()
                .readerWithTypedSchemaFor(Pokemon.class)
                .readValues(inputStream);

        return pokemonIter.readAll();
    }
}
