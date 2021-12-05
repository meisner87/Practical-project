package menu;

import model.*;
import persistence.RepositoryAnimal;

import java.util.List;
import java.util.Scanner;

public class AnimalMenu {

    private RepositoryAnimal repositoryAnimal;

    public AnimalMenu() {
        repositoryAnimal = new RepositoryAnimal();
    }

    private int menuOptions(Scanner scanner) {
        System.out.println("\n-------------------------------------------------------");
        System.out.println("Main menu ");
        System.out.println("-------------------------------------------------------");
        System.out.println();
        System.out.println("1: Save a new animal");
        System.out.println("2: List all animals ");
        System.out.println("3: List all animals,by species,type,and zoo");
        System.out.println("100 - Quit");
        System.out.println("***************************************************");

        System.out.println("Type the sub menu option: ");
        return scanner.nextInt();
    }

    protected void menuChoice(Scanner scanner) {

        int userChoice;
        do {
            userChoice = menuOptions(scanner);
            switch (userChoice) {
                case 1:
                    saveNewAnimal(scanner);
                    break;
                case 2:
                    listAllAnimals(scanner);
                    break;
                case 3:
                    listAnimalsBySpecieTypeZoo(scanner);

                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 100:
                    MainMenu.getMainMenu();
                    break;
                default:
                    System.out.println("\nSorry, please enter valid Option");
                    menuOptions(scanner);
                    break;
            }// End of switch statement
        } while (userChoice != 100);
    }

    private void saveNewAnimal(Scanner scanner) {
        String animalName;
        do {
            System.out.println("Animal name has only letters from a-Z");
            System.out.println("Animal name : ");
            animalName = scanner.next();
        } while (!animalName.matches("[a-zA-Z]{3,30}+"));


        String animalDescription;
        do {
            System.out.println("Animal description has only letters from a-Z");
            System.out.println("Description : ");
            animalDescription = scanner.next();
        } while (!animalDescription.matches("[a-zA-Z]{3,30}+"));


        AnimalDescription animalDescrib = new AnimalDescription();

        animalDescrib.setName(animalName);

        System.out.println("Type the specie");
        Species esp = new Species();
        String specie  = scanner.next();
        esp.setDescription(specie);
        animalDescrib.setSpecies(esp);

        System.out.println("Enter the type");
        AnimalTypes animalT = new AnimalTypes();
        String animalTypes = scanner.next();
        animalT.setAnimalDescription(animalTypes);
        animalDescrib.setAnimalTypes(animalT);

        repositoryAnimal.saveAnAnimal(animalDescrib);

    }

        private void listAllAnimals(Scanner scanner) {
            List<AnimalDescription> listAllAnimals = repositoryAnimal.listAllAnimals();
            if (listAllAnimals.size() > 0) {
                System.out.println("\nList of animals:");
                for (AnimalDescription anm : listAllAnimals) {
                    System.out.println(anm.toString());
                }
            } else {
                System.out.println("\nNo animals registered\n");

            }

        }
    private void listAnimalsBySpecieTypeZoo(Scanner scanner) {
        List<AnimalDepartment> list = repositoryAnimal.listAnimalsBySpecieTypeAndZoo();
        if (list.size() > 0) {
            System.out.println("\nList of animals by specie,type and zoo:");
            for (AnimalDepartment anm : list) {
                System.out.println(anm.toString());
            }
        } else {
            System.out.println("\nNo animals registered\n");
    }
    }
}



