package com.formation.poe.java.dictionnaire;

import com.formation.poe.java.dictionnaire.exceptions.DictionnaireException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Lancement de l'application.");

        // Créer une instance de la classe Dictionnaire
        Dictionnaire dictionnaire = new Dictionnaire();

        try {
            // Utiliser la méthode de lecture sur le fichier CSV
            dictionnaire.readCSV();
        } catch (DictionnaireException e) {
            logger.error("Erreur lors de la lecture du fichier CSV", e);
            return;
        }

        // Passer l'instance de Dictionnaire au menu
        Menu menu = new Menu(dictionnaire);

        // Afficher le menu
        menu.displayMenu();

        logger.info("Arrêt de l'application.");
    }
}
