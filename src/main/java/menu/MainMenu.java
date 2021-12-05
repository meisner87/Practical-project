package menu;

import java.util.Scanner;

public class MainMenu {
    private static SubMenuOptions subMenuOptions;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        subMenuOptions = new SubMenuOptions();
        subMenuOptions.animalMenu(scanner);
    }

    public static void getMainMenu() {
        subMenuOptions.animalMenu(scanner);
        
    }
}
