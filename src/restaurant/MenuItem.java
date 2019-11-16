package restaurant;

import java.util.HashMap;

public class MenuItem {
    private String name;
    private String description;
    private String category;
    private double price;
    private boolean isNew;
    void setName(String name) { this.name = name; }
    void setDescription(String description) { this.description = description; }
    void setCategory(String category) { this.category = category; }
    void setPrice(double price) { this.price = price; }
    void setIsNew(boolean isNew) { this.isNew = isNew; }
    String getName() { return name; }
    String getDescription() { return description; }
    String getCategory() { return category; }
    double getPrice() { return price; }
    boolean isNew() { return isNew; }
}
