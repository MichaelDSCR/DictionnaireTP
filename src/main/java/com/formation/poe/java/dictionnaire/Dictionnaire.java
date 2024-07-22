package com.formation.poe.java.dictionnaire;

import com.formation.poe.java.dictionnaire.exceptions.DictionnaireException;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

public class Dictionnaire {

    private static final Logger logger = LoggerFactory.getLogger(Dictionnaire.class);

    private Map<String, String> dictionary = new TreeMap<>();
    private Scanner scanner = new Scanner(System.in);

    // Méthode pour lire un fichier CSV
    public void readCSV() throws DictionnaireException {
        logger.info("Début de la lecture du fichier CSV.");
        try (CSVReader reader = new CSVReader(new FileReader("./src/main/resources/data/entree.csv"))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine.length >= 2) {
                    dictionary.put(nextLine[0].trim().toLowerCase(),
                            nextLine[1].trim().toLowerCase());
                }
            }
            logger.info("Lecture du fichier CSV terminée avec succès.");
        } catch (IOException | CsvValidationException e) {
            logger.error("Erreur lors de la lecture du fichier CSV", e);
            throw new DictionnaireException("Erreur lors de la lecture du fichier CSV", e);
        }
    }

    // Méthode pour sauvegarder le dictionnaire dans un fichier CSV
    public void saveCSV() throws DictionnaireException {
        logger.info("Début de la sauvegarde du fichier CSV.");
        try (CSVWriter writer = new CSVWriter(new FileWriter("./src/main/resources/data/sortie.csv"))) {
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                writer.writeNext(new String[]{entry.getKey(), entry.getValue()});
            }
            logger.info("Sauvegarde du fichier CSV terminée avec succès.");
        } catch (IOException e) {
            logger.error("Erreur lors de la sauvegarde du fichier CSV", e);
            throw new DictionnaireException("Erreur lors de la sauvegarde du fichier CSV", e);
        }
    }

    // Méthode pour afficher la liste des mots
    public void displayDictionary() {
        logger.info("Affichage de la liste des mots.");
        System.out.println("Liste des mots :");
        for (String word : dictionary.keySet()) {
            System.out.println(word);
        }
    }

    // Méthode pour chercher la définition d'un mot
    public void searchDefinition() {
        logger.info("Recherche de la définition d'un mot.");
        displayDictionary();
        System.out.print("Entrez un mot pour afficher sa définition : ");
        String word = scanner.nextLine().trim().toLowerCase();
        String definition = dictionary.get(word);
        if (definition != null) {
            System.out.println(definition);
            logger.info("Définition trouvée pour le mot '{}': {}", word, definition);
        } else {
            System.out.println("Le mot \"" + word + "\" n'a pas été trouvé.");
            logger.warn("Le mot '{}' n'a pas été trouvé dans le dictionnaire.", word);
        }
    }

    // Méthode pour obtenir le dictionnaire
    public Map<String, String> getDictionary() {
        return dictionary;
    }
}
