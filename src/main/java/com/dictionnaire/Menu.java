package com.dictionnaire;

import java.util.Map;
import java.util.Scanner;

public class Menu {

    private CSVReaderWriter csvReaderWriter;
    private Scanner scanner;

    public Menu(CSVReaderWriter csvReaderWriter) {
        this.csvReaderWriter = csvReaderWriter;
        this.scanner = new Scanner(System.in);
    }

    // Méthode pour afficher le menu et gérer les choix de l'utilisateur
    public void displayMenu() {
        String option;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Afficher la liste des mots");
            System.out.println("2. Sauvegarder la liste dans le fichier sortie");
            System.out.println("3. Afficher la définition d'un mot");
            System.out.println("4. Quitter");

            System.out.print("Choisissez une option : ");
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    csvReaderWriter.displayDictionary();
                    break;
                case "2":
                    csvReaderWriter.saveCSV("./sortie.csv");
                    System.out.println("Liste sauvegardée dans le fichier sortie.");
                    break;
                case "3":
                    csvReaderWriter.displayDictionary();
                    searchWord();
                    break;
                case "4":
                    System.out.println("Programme terminé.");
                    return;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }  while (!option.equals("4") && !option.equalsIgnoreCase("quitter"));
        // Fermer le scanner pour libérer les ressources
        scanner.close();
    }

    // Méthode pour chercher et afficher la définition d'un mot
    private void searchWord() {

        for (Map.Entry<String, String> entry : csvReaderWriter.getDictionary().entrySet()) {
            if (entry.getValue().isEmpty()) {
                System.out.println(entry.getKey());
            }
        }

        System.out.print("Entrez un mot pour afficher sa définition : ");
        String word = scanner.nextLine();
        csvReaderWriter.searchDefinition(word);
    }
}