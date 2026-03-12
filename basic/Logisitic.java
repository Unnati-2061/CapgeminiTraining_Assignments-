package foundation;

import java.util.Scanner;

public class Logistic {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int inventory = 50;
        String orderStatus = "Not Placed";
        System.out.print("Enter order quantity: ");
        int orderQty = sc.nextInt();

        if (orderQty <= inventory) {

            orderStatus = "Order Placed";
            System.out.println("\nStatus: " + orderStatus);

            // Processing
            orderStatus = "Processing";
            System.out.println("Status: " + orderStatus);

            inventory = inventory - orderQty;

            // Out for delivery
            orderStatus = "Out for Delivery";
            System.out.println("Status: " + orderStatus);

            // Delivered
            orderStatus = "Delivered";
            System.out.println("Status: " + orderStatus);

            System.out.println("\nOrder delivered successfully!");
            System.out.println("Remaining inventory: " + inventory);

        } else {
            orderStatus = "Order Cancelled";
            System.out.println("\nStatus: " + orderStatus);
            System.out.println("Reason: Insufficient inventory");
        }

        sc.close();
    }

}
