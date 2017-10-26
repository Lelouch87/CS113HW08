import java.util.Scanner;

public class HeapDriver {
    public static void main(String[] args) {
        MinHeap<Integer> minHeap = new MinHeap<>();
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Scanner keyboard = new Scanner(System.in);
        int decision;
        int number;
        System.out.println("Welcome to Heap Demo with Integers");
        do {
            printMenu();
            decision = keyboard.nextInt();
            switch(decision) {
                case 1:
                    System.out.print("Enter a number to insert into the heap: ");
                    number = keyboard.nextInt();
                    maxHeap.insertItem(number);
                    break;
                case 2:
                    System.out.print("Enter a number to insert into the heap: ");
                    number = keyboard.nextInt();
                    minHeap.insertItem(number);
                    break;
                case 3:
                    System.out.println("Removing from max heap");
                    maxHeap.removeItem();
                    break;
                case 4:
                    System.out.println("Removing from min heap");
                    minHeap.removeItem();
                    break;
                case 5:
                    System.out.println("Printing max heap...");
                    System.out.println(maxHeap);
                    break;
                case 6:
                    System.out.println("Printing min heap...");
                    System.out.println(minHeap);
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
            }
        } while (decision > 0 && decision < 7);
    }

    public static void printMenu() {
        System.out.println("1 - Add to MaxHeap");
        System.out.println("2 - Add to MinHeap");
        System.out.println("3 - Remove from MaxHeap");
        System.out.println("4 - Remove from MinHeap");
        System.out.println("5 - Print out MaxHeap");
        System.out.println("6 - Print out MinHeap");
        System.out.println("7 - Exit Program");
        System.out.print("Please enter a valid number: ");
    }
}
