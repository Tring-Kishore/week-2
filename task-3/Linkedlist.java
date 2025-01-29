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
        Node head1 = constructLL(arr);
        PrintLinkedList(head1);
        System.out.println("\nAfter Insert at First");
        Node head2 = insertNodeFirst(9, head1);
        PrintLinkedList(head2);
        System.out.println("\nAfter Insert at Last");
        Node head3 = insertNodeLast(0, head2);
        PrintLinkedList(head3);
        System.out.println("\nAfter Insert at Any Position");
        Node head4 = insertKPosition(6, 3, head3);
        PrintLinkedList(head4);
        System.out.println();
        searchingLL(5, head4);
        System.out.print("\nDeleting Node At First\n");
        Node head5 = deleteFirst(head4);
        PrintLinkedList(head5);
        System.out.println("\nDeleting At Last :");
        Node head6 = deleteLast(head5);
        PrintLinkedList(head6);
        System.out.println("\nDeleting Element\n");
        Node head7 = deleteElement(6, head6);
        PrintLinkedList(head7);
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
    public static Node insertNodeFirst(int element,Node head)
    {
        if(head==null)
        {
            return new Node(element);
        }
        Node newnode = new Node(element);
        newnode.next = head;
        return newnode;
    }
    public static Node insertNodeLast(int element,Node head)
    {
        if(head == null)
        {
            return new Node(element);
        }
        Node newnode = new Node(element);
        Node mover = head;
        while(mover.next != null)
        {
            mover = mover.next;
        }
        mover.next = newnode;
        return head;
    }
    public static Node insertKPosition(int element,int index,Node head)
    {
        int flag = 0;
        if(head == null)
        {
            return new Node(element);
        }
        Node newnode = new Node(element);
        if(index == 0)
        {
            Node newnNode = insertNodeFirst(element, head);
            return newnNode;
        }
        int i = 0;
        Node mover = head;
        Node prev = null;
        while(mover != null)
        {
            if(i == index)
            {
                prev.next = newnode;
                newnode.next = mover;
                flag = 1;
                return head;
            }
            prev = mover;
            mover = mover.next;
            i++;
        }
        if(flag == 0)
        {
            Node newnNode = insertNodeLast(element, head);
        }
        return head;
    }
    public static void searchingLL(int element,Node head)
    {
        if(head == null)
        {
            System.out.println("Element Not Found");
            System.exit(0);
        }
        Node mover = head;
        int i = 0;
        while(mover != null)
        {
            if(mover.data == element)
            {
                System.out.println("The element "+element+" it was in index of "+i);
                System.exit(0);
            }
            i++;
            mover = mover.next;
        }
        System.out.println("Element Not Found");
    }
    public static Node deleteFirst(Node head)
    {
        if(head == null)
        {
            return null;
        }
        head = head.next;
        return head;
    }
    public static Node deleteLast(Node head)
    {
        if(head == null)
        {
            return null;
        }
        Node mover = head;
        while(mover.next.next != null)
        {
            mover = mover.next;
        }
        mover.next = null;
        return head;
    }
    public static Node deleteElement(int element,Node head)
    {
        if(head == null)
        {
            return null;
        }
        Node prev = null;
        Node mover = head;
        if(mover.data == element)
        {
            Node newnode = deleteFirst(head);
            return newnode;
        }
        while(mover != null)
        {
            if(mover.data == element)
            {
                prev.next = mover.next;
            }
            prev = mover;
            mover = mover.next;
        }
        return head;
    }

}
