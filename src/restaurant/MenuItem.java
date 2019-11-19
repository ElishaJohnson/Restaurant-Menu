package restaurant;

import java.util.HashMap;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "name=" + name + ",category=" + category + ",price=" + price + ",description=" + description + ",isNew=" + isNew;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return Objects.equals(getName().toLowerCase(), menuItem.getName().toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getCategory(), getPrice(), isNew());
    }
}
