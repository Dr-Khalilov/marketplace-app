package edu;

import edu.services.Market;
import edu.services.User;

public class Main {
    public static void main(String[] args) {
        Market market = new Market("Amazon");
        System.out.println(market.addUser(new User("Umar", "Khalilov", 500)));
        System.out.println(market.addUser(new User("Vitaly", "Bocharov", 500)));
        System.out.println(market);
        System.out.println(market.removeUserById("b0f2507f-21ce-49ae-bed7-c49f78094fbe"));
        System.out.println(market);
    }
}