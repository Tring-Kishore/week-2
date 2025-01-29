import java.util.*;

public class ArraysExample {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter a Number to Set Size Of the Array: ");
        int n = s.nextInt();

        // Declaring an Array
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the number: ");
            arr[i] = s.nextInt();
        }

        // Traversing an array
        System.out.println("The Array Elements are: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        // Reverse Traversing
        System.out.println("\nReverse Traversing:");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }

        // Sorting and searching built-in function
        Arrays.sort(arr);

        // After Sorting
        System.out.println("\nAfter Sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        // built in binary search

        int Elements = Arrays.binarySearch(arr, 3);
        System.out.print("The index of the element is :"+Elements);

        // Manual Sorting

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(arr[j] < arr[i])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("After Sorting :");
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }


    }
}
