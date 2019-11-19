package restaurant;

import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();
        boolean exit = false;
        do {
            int selection;
            if (menu.getLastUpdated() != null) { System.out.println("\nMenu last updated " + menu.getLastUpdated()); }
            System.out.println("\n0 - Add a menu item");
            System.out.println("1 = Remove menu item");
            System.out.println("2 - List menu items by category");
            System.out.println("3 - List new items");
            System.out.println("4 - View entire menu");
            System.out.println("5 - Exit");
            try {
                selection = input.nextInt();
            } catch (Exception ignored) {
                selection = -1;
            }
            input.nextLine();
            if (selection == 0) {
                menu.addMenuItem(menu.inputItem());
                menu.setLastUpdated(new Date());
            } else if (selection == 1) {
                System.out.print("Enter name of item to remove: ");
                String itemToRemove = input.nextLine();
                menu.removeItem(itemToRemove);
            } else if (selection == 2) {
                System.out.print("Enter category: ");
                String category = input.nextLine();
                menu.listByCategory(category);
            } else if (selection == 3) {
                menu.listNewItems();
            } else if (selection == 4) {
                menu.printMenu();
            } else  if (selection == 5) {
                exit = true;
            } else {
                System.out.println("INVALID ENTRY");
            }
        } while (!exit);
    }
}
