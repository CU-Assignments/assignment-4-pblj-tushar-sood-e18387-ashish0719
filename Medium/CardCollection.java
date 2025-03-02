import java.util.*;

class Card {
    String symbol;
    String value;

    Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String toString() {
        return symbol + " " + value;
    }
}

public class CardCollection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Collection<Card> cards = new ArrayList<>();
        while (true) {
            System.out.println("1. Add  2. Find  3. Show  4. Exit");
            int ch = sc.nextInt();
            if (ch == 1) {
                System.out.println("Enter Symbol and Value:");
                String symbol = sc.next();
                String value = sc.next();
                cards.add(new Card(symbol, value));
            } else if (ch == 2) {
                System.out.println("Enter Symbol to Find:");
                String symbol = sc.next();
                for (Card c : cards) {
                    if (c.symbol.equals(symbol)) {
                        System.out.println(c);
                    }
                }
            } else if (ch == 3) {
                for (Card c : cards) {
                    System.out.println(c);
                }
            } else if (ch == 4) {
                break;
            }
        }
        sc.close();
    }
}
