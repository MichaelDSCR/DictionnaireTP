package com.formation.poe.java.dictionnaire;

import com.formation.poe.java.dictionnaire.exceptions.DictionnaireException;

import java.util.Scanner;

public class Menu {

    private Dictionnaire dictionnaire;
    private Scanner scanner;

    public Menu(Dictionnaire dictionnaire) {
        this.dictionnaire = dictionnaire;
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

            try {
                switch (option) {
                    case "1" -> dictionnaire.displayDictionary();
                    case "2" -> dictionnaire.saveCSV();
                    case "3" -> dictionnaire.searchDefinition();
                    case "4" -> System.out.println("Programme terminé.");
                    default -> System.out.println("Option invalide. Veuillez réessayer.");
                }
            } catch (DictionnaireException e) {
                System.err.println(e.getMessage());
            }
        } while (!option.equals("4"));

        // Fermer le scanner pour libérer les ressources
        scanner.close();
    }
}
