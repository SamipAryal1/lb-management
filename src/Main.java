import Models.Book;
import Models.Genre;
import Models.Order;
import Models.Customer;
import Models.BookOrder;
import Models.BookQuantity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Book> bookList = new ArrayList<>();
        List<BookOrder> bookOrders = new ArrayList<>();


        System.out.print("Enter the number of books: ");
        int numBooks = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numBooks; i++) {
            System.out.println("Enter details for book " + (i + 1) + ":");

            System.out.print("Book Name: ");
            String bookName = scanner.nextLine();

            System.out.print("Author: ");
            String author = scanner.nextLine();

            System.out.print("Description: ");
            String description = scanner.nextLine();

            System.out.print("Genre Name: ");
            String genreName = scanner.nextLine();

            System.out.print("Genre Description: ");
            String genreDescription = scanner.nextLine();

            Genre genre = new Genre(genreName, genreDescription);
            Book book = new Book(bookName, author, description, genre);
            bookList.add(book);
        }

        System.out.print("Enter the number of book orders: ");
        int numOrders = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numOrders; i++) {
            System.out.println("Enter details for order " + (i + 1) + ":");

            System.out.print("Price per book: ");
            double bookPrice = scanner.nextDouble();
            scanner.nextLine();

            List<BookQuantity> bookQuantities = new ArrayList<>();
            for (Book book : bookList) {
                System.out.print("Enter quantity for book '" + book.getBook_name() + "': ");
                int quantity = scanner.nextInt();
                scanner.nextLine();
                if (quantity > 0) {
                    bookQuantities.add(new BookQuantity(book.getBook_name(), quantity));
                }
            }

            BookOrder bookOrder = new BookOrder(bookQuantities, bookPrice);
            bookOrders.add(bookOrder);
        }

        System.out.print("Customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("Customer Email: ");
        String customerEmail = scanner.nextLine();

        System.out.print("Customer Phone: ");
        String customerPhone = scanner.nextLine();

        Customer customer = new Customer(new ArrayList<>(), customerName, customerEmail, customerPhone);

        System.out.print("Enter VAT rate (in %): ");
        double vatRate = scanner.nextDouble();

        System.out.print("Enter Discount rate (in %): ");
        double discountRate = scanner.nextDouble();

        Order order = new Order(bookOrders, vatRate, discountRate, customer);

        System.out.println("\nOrder Details:");
        for (BookOrder bookOrder : bookOrders) {
            System.out.println("Books in Order:");
            for (BookQuantity bq : bookOrder.getBookQuantities()) {
                String bookName = bq.getBookName();
                int quantity = bq.getQuantity();
                double price = bookOrder.getBookPrice();
                double totalBookPrice = quantity * price;
                System.out.println("Book Name: " + bookName + " | Quantity: " + quantity + " | Price per Book: " + price + " | Total Price: " + totalBookPrice);
            }
        }

        double vat = order.calculateVat();
        double discount = order.calculateDiscount();
        double finalPrice = order.calculateFinalPrice();

        System.out.println("\nBilling Summary:");
        System.out.println("Books Ordered:");
        for (BookOrder bookOrder : bookOrders) {
            for (BookQuantity bq : bookOrder.getBookQuantities()) {
                String bookName = bq.getBookName();
                int quantity = bq.getQuantity();
                double price = bookOrder.getBookPrice();
                System.out.println("Book Name: " + bookName + " | Quantity: " + quantity + " | Price per Book: " + price);
            }
        }

        System.out.println("Total Price: " + order.getTotalPrice());
        System.out.println("VAT (" + vatRate + "%): " + vat);
        System.out.println("Discount (" + discountRate + "%): " + discount);
        System.out.println("Final Price: " + finalPrice);

        scanner.close();
    }
}
