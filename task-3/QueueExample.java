import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueExample {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the size for queue : ");
        int n = s.nextInt();
        Queue<Integer> q = new LinkedList<>();
        // Adding the values in queue
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the Number : ");
            int num = s.nextInt();
            q.add(num);
        }
        // Printing the Queue Values
        System.out.println("Printing the Elements : ");
        printElements(q);
        // Removing an Element
        System.out.println("\nRemoving the First Element : ");
        q.remove();
        printElements(q);
        System.err.println("The Size Of the Queue : "+ q.size());
        // Checking the queue  isEmpty
        if(q.isEmpty())
        {
            System.out.println("The Queue is Empty.");
        }
        else
        {
            System.out.println("The Queue has Some Values");
        }

    }
    public static void printElements(Queue<Integer> q)
    {
        for(int i:q)
        {
            System.out.print(i+" ");
        }
    }
}
