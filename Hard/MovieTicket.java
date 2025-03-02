import java.util.Scanner;

class TicketBooking extends Thread {
    static int seats = 10;
    int tickets;
    String user;

    TicketBooking(String user, int tickets) {
        this.user = user;
        this.tickets = tickets;
    }

    public void run() {
        bookSeats();
    }

    synchronized void bookSeats() {
        if (seats >= tickets) {
            System.out.println(user + " booked " + tickets + " seats.");
            seats -= tickets;
        } else {
            System.out.println(user + " failed to book. Only " + seats + " seats left.");
        }
    }
}

public class MovieTicket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of users: ");
        int n = sc.nextInt();
        sc.nextLine();

        TicketBooking[] users = new TicketBooking[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter tickets: ");
            int tickets = sc.nextInt();
            sc.nextLine();

            users[i] = new TicketBooking(name, tickets);
            if (i == 0) {
                users[i].setPriority(Thread.MAX_PRIORITY);
            }
        }

        for (TicketBooking user : users) {
            user.start();
            try {
                user.join();  
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        sc.close();
    }
}
