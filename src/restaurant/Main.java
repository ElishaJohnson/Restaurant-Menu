package restaurant;

import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();
        boolean exit = false;
        do {
            if (menu.getLastUpdated() != null) { System.out.println("\nMenu last updated " + menu.getLastUpdated()); }
            System.out.println("\n0 - Add a menu item");
            System.out.println("1 - List menu items by category");
            System.out.println("2 - List new items");
            System.out.println("3 - Exit");
            int selection = input.nextInt();
            input.nextLine();
            if (selection == 0) {
                menu.addMenuItem(menu.inputItem());
                menu.setLastUpdated(new Date());
            } else if (selection == 1) {
                System.out.print("Enter category: ");
                String category = input.nextLine();
                menu.listByCategory(category);
            } else if (selection == 2) {
                menu.listNewItems();
            } else {
                exit = true;
            }
        } while (!exit);
    }
}
