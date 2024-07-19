package com.dictionnaire;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class CSVReaderWriter {

    private Map<String, String> dictionary = new TreeMap<>();

    // Méthode pour lire un fichier CSV
    public void readCSV(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine.length >= 2) {
                    dictionary.put(nextLine[0], nextLine[1]);
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier CSV : " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erreur inattendue : " + e.getMessage());
        }
    }

    // Méthode pour sauvegarder le dictionnaire dans un fichier CSV
    public void saveCSV(String filePath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                writer.writeNext(new String[]{entry.getKey(), entry.getValue()});
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde du fichier CSV : " + e.getMessage());
        }
    }

    // Méthode pour afficher la liste des mots
    public void displayDictionary() {
        System.out.println("Liste des mots :");
        for (String word : dictionary.keySet()) {
            System.out.println(word);
        }
    }

    // Méthode pour chercher la définition d'un mot
    public void searchDefinition(String word) {
        String definition = dictionary.get(word);
        if (definition != null) {
            System.out.println(word + ": " + definition);
        } else {
            System.out.println("Le mot \"" + word + "\" n'a pas été trouvé.");
        }
    }

    // Méthode pour obtenir le dictionnaire
    public Map<String, String> getDictionary() {
        return dictionary;
    }
}