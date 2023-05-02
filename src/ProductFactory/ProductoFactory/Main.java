package ProductFactory.ProductoFactory;

abstract class Product {
    protected String title;
    protected double price;

    static String BOOK = "book";
    static String CLOTHING = "clothing";
    static String ELECTRONIC = "electronic";

    public Product(String title, double price) {
        this.title = title;
        this.price = price;
    }

    static Product factory (String tipo, String s, double v, String s1){
        if (tipo.equals(BOOK)) {
            return new Book(s,v,s1);
        } else if (tipo.equals(CLOTHING)) {
            return new Clothing(s,v,s1);
        } else {
            return new Electronic(s,v,s1);
        }
    }

    public abstract void display();
}

class Book extends Product {
    protected String author;

    public Book(String title, double price, String author) {
        super(title, price);
        this.author = author;
    }

    @Override
    public void display() {
        System.out.println("Book - Title: " + title + ", Author: " + author + ", Price: " + price);
    }
}

class Electronic extends Product {
    protected String manufacturer;

    public Electronic(String title, double price, String manufacturer) {
        super(title, price);
        this.manufacturer = manufacturer;
    }

    @Override
    public void display() {
        System.out.println("Electronic - Title: " + title + ", Manufacturer: " + manufacturer + ", Price: " + price);
    }
}

class Clothing extends Product {
    protected String size;

    public Clothing(String title, double price, String size) {
        super(title, price);
        this.size = size;
    }

    @Override
    public void display() {
        System.out.println("Clothing - Title: " + title + ", Size: " + size + ", Price: " + price);
    }
}


public class Main {
    public static void main(String[] args) {

        Product llibre = Product.factory(Product.BOOK, "Harry Potter and the Philosopher's Stone", 9.99, "J.K. Rowling");

        Product electgro = Product.factory(Product.ELECTRONIC, "iPhone 12 Pro", 999.99, "Apple");

        Product clothing = Product.factory(Product.CLOTHING, "Maxi Dress", 38, "ASOS");

        llibre.display();

        electgro.display();

        clothing.display();
    }
}