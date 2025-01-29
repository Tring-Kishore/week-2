import java.util.Scanner;

public class Arrays{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a Number to Set Size Of the Array : ");
        int n = s.nextInt();
        // Declaring an Array
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the number : ");
            arr[i] = s.nextInt();
        }

        //Traversing an array
        System.out.println("The Array Elements are : ");
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }

        //Reverse Traversing

        System.out.println("Reverse Traversing");
        for(int i=n-1;i>=0;i--)
        {
            System.out.print(arr[i]+" ");
        }
    }
}