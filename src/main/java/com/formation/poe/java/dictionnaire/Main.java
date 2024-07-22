package com.formation.poe.java.dictionnaire;

import com.formation.poe.java.dictionnaire.exceptions.DictionnaireException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void afficherArtAscii() {
        String artAscii =

                "██████╗ ██╗ ██████╗████████╗██╗ ██████╗ ███╗   ██╗███╗   ██╗ █████╗ ██╗██████╗ ███████╗\n" +
                "██╔══██╗██║██╔════╝╚══██╔══╝██║██╔═══██╗████╗  ██║████╗  ██║██╔══██╗██║██╔══██╗██╔════╝\n" +
                "██║  ██║██║██║        ██║   ██║██║   ██║██╔██╗ ██║██╔██╗ ██║███████║██║██████╔╝█████╗\n" +
                "██║  ██║██║██║        ██║   ██║██║   ██║██║╚██╗██║██║╚██╗██║██╔══██║██║██╔══██╗██╔══╝\n" +
                "██████╔╝██║╚██████╗   ██║   ██║╚██████╔╝██║ ╚████║██║ ╚████║██║  ██║██║██║  ██║███████╗\n" +
                "╚═════╝ ╚═╝ ╚═════╝   ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝╚═╝  ╚═══╝╚═╝  ╚═╝╚═╝╚═╝  ╚═╝╚══════╝";

        System.out.println(artAscii);
    }

    public static void main(String[] args) {
        LOGGER.info("Lancement de l'application.");

        // Afficher l'art ASCII
        afficherArtAscii();

        // Créer une instance de la classe Dictionnaire
        Dictionnaire dictionnaire = new Dictionnaire();

        try {
            // Utiliser la méthode de lecture sur le fichier CSV
            dictionnaire.readCSV();
        } catch (DictionnaireException e) {
            LOGGER.error("Erreur lors de la lecture du fichier CSV", e);
            return;
        }

        // Passer l'instance de Dictionnaire au menu
        Menu menu = new Menu(dictionnaire);

        // Afficher le menu
        menu.displayMenu();

        LOGGER.info("Arrêt de l'application.");
    }
}
