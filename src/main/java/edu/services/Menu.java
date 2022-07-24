package edu.services;

import java.util.Scanner;

public class Menu {
    // Creating of market
    public void runMarket() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello my friend. Please enter name of your marketplace: ");
        String nameOfMarket = sc.nextLine();
        Market newMarket = new Market(nameOfMarket);
        System.out.println("Congrats. You created marketplace with name: " + nameOfMarket);

        while (true) {
            showMenu();
            int menuSelection = sc.nextInt();
            switch (menuSelection) {
                case 1 -> createUserMenu(newMarket);
                case 2 -> createProductMenu(newMarket);
                case 3 -> removeUserMenu(newMarket);
                case 4 -> removeProductMenu(newMarket);
                case 5 -> newMarket.showAllUsers();
                case 6 -> newMarket.showAllProducts();
                case 7 -> buyProduct(newMarket);
                case 8 -> {
                    System.out.println("Goodbye see you soon!");
                    sc.close();
                    System.exit(0);
                }
                default -> System.out.println("You choose incorrect value, please choose correct value from 1-8");
            }
        }
    }

    private static void showMenu() {
        System.out.println("-----------------------------------------------------------------------------------------" +
                "\n" +
                "-----------------------------------------------------------------------------------------");
        System.out.println("Admin menu");
        System.out.println("1. Create an user");
        System.out.println("2. Create a product");
        System.out.println("3. Delete an user");
        System.out.println("4. Delete a product");
        System.out.println("5. Show all users");
        System.out.println("6. Show all products");
        System.out.println("7. Buy a product for user");
        System.out.println("8. Exit from market");
    }

    private void buyProduct(Market market) throws ArithmeticException {
        try {
            System.out.println("Choose user by id");
            market.showAllUsers();
            Scanner scanner = new Scanner(System.in);
            int selectedUserId = scanner.nextInt();

            System.out.println("Choose product by id");
            market.showAllProducts();
            int selectedUserID = scanner.nextInt();

            User selectedUser = market.getUsers().stream().filter(user -> user.getUniqueId().equals(selectedUserId))
                    .findFirst().get();

            Product selectedProduct = market.getProducts().stream().filter(product -> product.getUniqueId().equals(selectedUserID))
                    .findFirst().get();

            double diff = selectedUser.getAmountOfMoney() - selectedProduct.getPrice();
            if (diff < 0) {
                throw new ArithmeticException("Not enough money in the account");
            } else {
                selectedUser.setAmountOfMoney(diff);
                selectedUser.getUserProducts().add(selectedProduct);
                market.getProducts().remove(selectedProduct);
                System.out.println("Product successfully purchased");
            }
        } catch (ArithmeticException ex) {
            System.out.println("ArithmeticException => " + ex.getMessage());
        }

    }

    private void createProductMenu(Market market) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name of product");
        String product = sc.nextLine();
        System.out.println("Please enter price for the product");
        double price = sc.nextDouble();
        System.out.printf(market.addProduct(new Product(product, price)));
        market.showAllProducts();
    }

    private void createUserMenu(Market market) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name");
        String name = sc.nextLine();
        System.out.println("Please enter the surname");
        String surname = sc.nextLine();
        System.out.println("Please enter amount of money for user");
        double money = sc.nextDouble();
        System.out.printf(market.addUser(new User(name, surname, money)));
        market.showAllUsers();
    }

    private void removeUserMenu(Market market) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the unique id for user");
        int id = sc.nextInt();
        System.out.println(market.removeUserById(id));
        market.showAllUsers();
    }

    private void removeProductMenu(Market market) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the unique id for product");
        int id = sc.nextInt();
        System.out.println(market.removeProductById(id));
        market.showAllProducts();
    }
}
