package edu;

import edu.services.Market;
import edu.services.Product;
import edu.services.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creating of market
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello my friend. Please enter name of your marketplace : ");
        String nameOfMarket = sc.nextLine();
        Market market = new Market(nameOfMarket);
        System.out.println("Congrats. You created marketplace with name : " + nameOfMarket);

        while (true) {
            showMenu();
            int menuSelection = sc.nextInt();
            switch (menuSelection) {
                case 1:
                    createUserMenu(market);
                    break;
                case 2:
                    createProductMenu(market);
                    break;
                case 3:
                    removeUserMenu(market);
                    break;
                case 4:
                    removeProductMenu(market);
                    break;
                default:
                    System.out.println("You choose incorrect value, please chose correct value from 1-4");
            }
        }

    }

    private static void showMenu() {
        System.out.println("-----------------------------------------------------------------------------------------" +
                "\n" +
                "-----------------------------------------------------------------------------------------");
        System.out.println("Admin menu");
        System.out.println("1. Create user");
        System.out.println("2. Create product");
        System.out.println("3. Delete user");
        System.out.println("4. Delete product");
    }

    private static void createProductMenu(Market market) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name of product");
        String product = sc.nextLine();
        System.out.println("Please enter price for the product");
        Double price = sc.nextDouble();
        System.out.printf(market.addProduct(new Product(product, price)));
        market.showAllProducts();
    }

    private static void createUserMenu(Market market) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name");
        String name = sc.nextLine();
        System.out.println("Please enter the surname");
        String surname = sc.nextLine();
        System.out.println("Please enter amount of money for user");
        Double money = sc.nextDouble();
        System.out.printf(market.addUser(new User(name, surname, money)));
        market.showAllUsers();
    }

    private static void removeUserMenu(Market market) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the unique id for user");
        int id = sc.nextInt();
        System.out.println(market.removeUserById(id));
        market.showAllUsers();
    }

    private static void removeProductMenu(Market market) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the unique id for product");
        int id = sc.nextInt();
        System.out.println(market.removeProductById(id));
        market.showAllProducts();
    }
}