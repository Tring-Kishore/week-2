import java.util.Scanner;
// Class Node
class Node
{
    int data;
    Node next;
    Node()
    {
        this.data = 0;
        this.next = null;
    }
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
    Node(int data,Node next)
    {
        this.data = data;
        this.next = next;
    }
}
public class Linkedlist {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the Size Of Array : ");
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            System.out.print("Enter the Number : ");
            arr[i] = s.nextInt();
        }
        Node head = constructLL(arr);
        PrintLinkedList(head);
    }
    // Linked List Creation
    public static Node constructLL(int[] arr)
    {
        if(arr == null || arr.length == 0)
        {
            return null;
        }
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i=1;i<arr.length;i++)
        {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    // Printing Linked List
    public static void PrintLinkedList(Node head)
    {
        if(head==null || head.next == null)
        {
            System.out.print(head.data);
            System.exit(0);
        }
        Node mover = head;
        while(mover != null)
        {
            System.out.print(mover.data+" ");
            mover = mover.next;
        }
    }
}
