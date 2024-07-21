package com.formation.poe.java.dictionnaire;

import com.formation.poe.java.dictionnaire.exceptions.DictionnaireException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DictionnaireTest {

    private static final Logger logger = LoggerFactory.getLogger(DictionnaireTest.class);

    private Dictionnaire dictionnaire;

    @BeforeEach
    void setUp() {
        dictionnaire = new Dictionnaire();
    }

    @Test
    void testReadCSV() {
        logger.info("Test de lecture du CSV.");
        assertDoesNotThrow(() -> dictionnaire.readCSV());
        Map<String, String> dictionary = dictionnaire.getDictionary();
        assertFalse(dictionary.isEmpty(), "Le dictionnaire ne doit pas être vide après la lecture du fichier CSV.");
    }

    @Test
    void testSaveCSV() {
        logger.info("Test de sauvegarde du CSV.");
        assertDoesNotThrow(() -> {
            dictionnaire.readCSV();
            dictionnaire.saveCSV();
        });
    }

    @Test
    void testSearchDefinition() {
        logger.info("Test de recherche de définition.");
        assertDoesNotThrow(() -> dictionnaire.readCSV());
        dictionnaire.getDictionary().put("test", "definition");
        String definition = dictionnaire.getDictionary().get("test");
        assertEquals("definition", definition, "La définition du mot 'test' doit être 'definition'.");
    }
}

