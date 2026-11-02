
import java.util.Scanner;

public class Main {

    static int size = 5;
    static String queue[] = new String[size];
    static int front = -1;
    static int rear = -1;

    // Insert print request
    static void enqueue(String job) {

        if ((rear + 1) % size == front) {
            System.out.println("Printer Queue is Full!");
            return;
        }

        if (front == -1) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % size;
        }

        queue[rear] = job;
        System.out.println("Print Request Added: " + job);
    }

    // Remove print request
    static void dequeue() {

        if (front == -1) {
            System.out.println("Printer Queue is Empty!");
            return;
        }

        System.out.println("Processing Print Request: " + queue[front]);

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
    }

    // Display queue elements
    static void display() {

        if (front == -1) {
            System.out.println("Printer Queue is Empty!");
            return;
        }

        System.out.println("Pending Print Requests:");

        int i = front;

        while (true) {
            System.out.println(queue[i]);

            if (i == rear)
                break;

            i = (i + 1) % size;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;
        String job;

        do {
            System.out.println("\n--- Printer Circular Queue ---");
            System.out.println("1. Add Print Request");
            System.out.println("2. Process Print Request");
            System.out.println("3. Display Print Requests");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Print Request: ");
                    job = sc.nextLine();
                    enqueue(job);
                    break;

                case 2:
                    dequeue();
                    break;

                case 3:
                    display();
                    break;

                case 4:
                    System.out.println("Exiting Printer Queue...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
