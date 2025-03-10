import java.util.*;

interface Product {
    double calculatePrice();
    String getDetails();
}

abstract class BaseProduct implements Product {
    String name;
    double price;
    int stock;

    public BaseProduct(String n, double p, int s) {
        try {
            if (p <= 0 || s <= 0) {
                throw new IllegalArgumentException("Price and stock must be positive.");
            }
            name = n;
            price = p;
            stock = s;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Product processing complete.");
        }
    }

    public String getDetails() {
        return "Name: " + name + " Price: " + price + " Stock: " + stock;
    }

    public boolean isAvailable() {
        return stock > 0;
    }
}

class Electronics extends BaseProduct {
    int warrantyPeriod;

    public Electronics(String n, double p, int s, int wp) {
        super(n, p, s);
        warrantyPeriod = wp;
    }

    public double calculatePrice() {
        return price > 1000 ? price * 0.9 : price;
    }

    public String getDetails() {
        return super.getDetails() + " Warranty Period: " + warrantyPeriod;
    }
}

class Clothing extends BaseProduct {
    String size;
    String material;

    public Clothing(String n, double p, int s, String sz, String m) {
        super(n, p, s);
        size = sz;
        material = m;
    }

    public double calculatePrice() {
        return stock < 5 ? price * 0.95 : price;
    }

    public String getDetails() {
        return super.getDetails() + " Size: " + size + " Material: " + material;
    }
}

class Groceries extends BaseProduct {
    Date expirationDate;

    public Groceries(String n, double p, int s, Date ed) {
        super(n, p, s);
        expirationDate = ed;
        if (expirationDate.before(new Date())) {
            throw new IllegalArgumentException("Cannot add expired products.");
        }
    }

    public double calculatePrice() {
        return stock > 5 ? price * 0.92 : price;
    }

    public String getDetails() {
        return super.getDetails() + " Expiration Date: " + expirationDate;
    }
}

class Books extends BaseProduct {
    String author;

    public Books(String n, double p, int s, String a) {
        super(n, p, s);
        author = a;
    }

    public double calculatePrice() {
        return price > 50 ? price * 0.93 : price;
    }

    public String getDetails() {
        return super.getDetails() + ", Author: " + author;
    }
}

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select Product Type: 1. Electronics 2. Clothing 3. Groceries 4. Books");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        Product product = null;

        try {
            if (choice == 1) {
                System.out.print("Enter Warranty Period: ");
                int warranty = scanner.nextInt();
                product = new Electronics(name, price, stock, warranty);

            } 
            else if (choice == 2) {
                System.out.print("Enter Size: ");
                String size = scanner.nextLine();
                System.out.print("Enter Material: ");
                String material = scanner.nextLine();
                product = new Clothing(name, price, stock, size, material);

            } 
            else if (choice == 3) {
                System.out.print("Enter Expiration Date (yyyy-mm-dd): ");
                String dateStr = scanner.nextLine();
                Date expirationDate = new GregorianCalendar(
                        Integer.parseInt(dateStr.substring(0, 4)),
                        Integer.parseInt(dateStr.substring(5, 7)) - 1,
                        Integer.parseInt(dateStr.substring(8, 10))
                ).getTime();
                product = new Groceries(name, price, stock, expirationDate);
            } 
            else if (choice == 4) {
                System.out.print("Enter Author Name: ");
                String author = scanner.nextLine();
                product = new Books(name, price, stock, author);
            } 

            else {
                System.out.println("Invalid choice.");
            }
        } 
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } 

        finally {
            System.out.println("Product processing complete.");
        }
        
        if (product != null && ((BaseProduct) product).isAvailable()) {
            System.out.println("\nProduct Details:");
            System.out.println(product.getDetails());
            System.out.println("Final Price: " + product.calculatePrice());
        } else {
            System.out.println("Product is out of stock or invalid.");
        }
        
        scanner.close();
    }
}
