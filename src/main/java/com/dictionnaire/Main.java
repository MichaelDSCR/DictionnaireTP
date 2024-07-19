package com.dictionnaire;

public class Main {

    public static void main(String[] args) {
        // Créer une instance de CSVReaderWriter
        CSVReaderWriter csvReaderWriter = new CSVReaderWriter();

        // Lire le fichier CSV d'entrée
        csvReaderWriter.readCSV("./entree.csv");

        // Créer une instance de Menu avec CSVReaderWriter
        Menu menu = new Menu(csvReaderWriter);

        // Afficher le menu et gérer les choix utilisateur
        menu.displayMenu();
    }
}
