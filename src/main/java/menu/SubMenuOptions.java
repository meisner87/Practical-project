package menu;

import java.util.Scanner;

public class SubMenuOptions {
    boolean exit = false;
    private MenuEmployee menuEmployee;
    private AnimalMenu animalMenu;

    public SubMenuOptions() {
        this.menuEmployee = new MenuEmployee();
        this.animalMenu = new AnimalMenu();
    }

    private int menuOptions(Scanner input) {
        System.out.println("\n-------------------------------------------------------");
        System.out.println("Main menu ");
        System.out.println("-------------------------------------------------------");
        System.out.println();
        System.out.println("1: Sub Menu - Employee");
        System.out.println("2: Sub Menu - Animal");
        System.out.println("100 - Quit");
        System.out.println("***************************************************");

        System.out.println("Type the sub menu option: ");
        return input.nextInt();
    }

    public void animalMenu(Scanner input) {
        while(!exit) {
            int userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:
                    this.menuEmployee.menuChoice(input);
                    break;
                case 2:
                    this.animalMenu.menuChoice(input);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:

                    break;
                case 100:
                    exit = true;
                    System.out.println("System closed");
                    break;
//                default:
//                    System.out.println("\nSorry, please enter valid Option");
//                    menuChoice(input);
            }
        }
    }
}
