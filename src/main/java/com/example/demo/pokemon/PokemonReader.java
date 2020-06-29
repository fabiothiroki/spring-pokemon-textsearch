package com.example.demo.pokemon;


import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;

import java.io.File;
import java.util.List;

public class PokemonReader {

    public static List<Pokemon> readFile(File csvFile) throws Exception {
        MappingIterator<Pokemon> pokemonIter = new CsvMapper()
                .readerWithTypedSchemaFor(Pokemon.class)
                .readValues(csvFile);

        return pokemonIter.readAll();
    }
}
