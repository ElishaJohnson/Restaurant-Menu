package restaurant;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    private static DecimalFormat df2 = new DecimalFormat("0.00");
    private Date lastUpdated;
    private ArrayList<MenuItem> menuItems = new ArrayList<>();
    Date getLastUpdated() { return lastUpdated; }
    void setLastUpdated(Date lastUpdated) { this.lastUpdated = lastUpdated; }
    ArrayList<MenuItem> getMenuItems() { return menuItems; }
    void addMenuItem(MenuItem menuItem) {
        for (MenuItem item : menuItems) {
            if (item.equals(menuItem)) {
                System.out.println(menuItem.getName() + " is already on the menu.");
                return;
            }
        }
        this.menuItems.add(menuItem);
    }

    void listByCategory(String category) {
        System.out.println("\n" + category.toUpperCase() + "S");
        for (MenuItem item : this.menuItems) {
            if (item.getCategory().toLowerCase().equals(category.toLowerCase())) {
                System.out.println();
                if (item.isNew()) { System.out.print("*NEW* "); }
                System.out.println(item.getName());
                System.out.println(item.getDescription());
                System.out.println("$" + df2.format(item.getPrice()));
            }
        }
    }
    void printMenu() {
        System.out.println("-RESTAURANT MENU-");
        System.out.println("Last updated " + this.getLastUpdated());
        for(String category : this.categories()) {
            listByCategory(category);
        }
    }
    private ArrayList<String> categories() {
        ArrayList<String> categoryList = new ArrayList<>();
        for (MenuItem item: this.menuItems) {
            if (!categoryList.contains(item.getCategory())) { categoryList.add(item.getCategory()); }
        }
        return categoryList;
    }
    void listNewItems() {
        System.out.println("\nNEW ITEMS");
        for (MenuItem item : this.menuItems) {
            if (item.isNew()) {
                System.out.println("\n" + item.getName());
                System.out.println(item.getDescription());
                System.out.println("$" + df2.format(item.getPrice()));
            }
        }
    }
    void removeItem(String itemToRemove) {
        for (int i = 0; i < this.menuItems.size(); i++) {
            if (this.menuItems.get(i).getName().toLowerCase().equals(itemToRemove.toLowerCase())) {
                this.menuItems.remove(i);
                return;
            }
        }
    }
    static MenuItem inputItem() {
        Scanner input = new Scanner(System.in);
        MenuItem newItem = new MenuItem();
        System.out.print("Name: ");
        String name = input.nextLine();
        newItem.setName(name);
        System.out.print("Description: ");
        String description = input.nextLine();
        newItem.setDescription(description);
        System.out.print("Category: ");
        String category = input.nextLine();
        newItem.setCategory(category);
        System.out.print("Price: $");
        double price = input.nextDouble();
        newItem.setPrice(price);
        System.out.print("New item? true/false: ");
        boolean isNew = input.nextBoolean();
        newItem.setIsNew(isNew);
        return newItem;
    }
}
