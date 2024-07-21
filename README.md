## Description
Ce projet est une application Java simple qui permet de lire, sauvegarder et rechercher des mots et leurs définitions dans un dictionnaire. L'application utilise des fichiers CSV pour stocker les données et inclut des fonctionnalités de journalisation et de test unitaire.

## Fonctionnalités
- Lire les mots et leurs définitions depuis un fichier CSV (`entree.csv`)
- Sauvegarder le dictionnaire dans un fichier CSV (`sortie.csv`)
- Afficher la liste des mots
- Rechercher la définition d'un mot
- Gestion des exceptions
- Journalisation des activités avec SLF4J et Logback
- Tests unitaires avec JUnit

## Prérequis
- Java 11 ou supérieur
- Maven 3.6 ou supérieur

## Installation
1. Clonez le dépôt :
   git clone https://github.com/MichaelDSCR/dictionnaireTP.git
2. Accédez au répertoire du projet :
   cd votre-projet
4. Executez l'application :
   mvn exec:java -Dexec.mainClass="com.formation.poe.java.dictionnaire.Main"
5. Suivez les instructions dans le menu pour utiliser les différentes fonctionnalités.

## Journalisation
Les logs sont configurés avec Logback et SLF4J. 
La configuration de base affiche les logs dans la console.
Vous pouvez modifier logback.xml pour changer la configuration des logs.

## Tests
Pour exécuter les tests unitaires, utilisez la commande suivante :
mvn test

## Contribuer
Les contributions sont les bienvenues ! Veuillez suivre les étapes suivantes :
1. Fork le dépôt
2. Créez une branche pour votre fonctionnalité (git checkout -b fonctionnalite/ma-nouvelle-fonctionnalite)
3. Commitez vos modifications (git commit -m 'Ajout de ma nouvelle fonctionnalité')
4. Poussez vers la branche (git push origin fonctionnalite/ma-nouvelle-fonctionnalite)
5. Ouvrez une Pull Request

## Auteur
Descorcier Michaël

## Remerciements

Merci à tous ceux qui s'intéressent à mon code et à ce projet. 
Vos retours, suggestions et contributions sont précieux et fortement appréciés. 
Si vous avez des questions ou souhaitez échanger sur ce projet, n'hésitez pas à me contacter. 
Ensemble, nous pouvons rendre ce projet encore meilleur !
