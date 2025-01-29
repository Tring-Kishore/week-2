import java.util.*;
public class StackExample {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter how many Numbers Want to Push : ");
        int n = s.nextInt();
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++)
        {
            // pushing  numbers in the stack
            System.out.println("Enter the number : ");
            int num = s.nextInt();
            st.push(num);
        }
        // Printing the Elements
        printElements(st);
        // Poping the last element
        st.pop();
        printElements(st);
        // Peeking a Element
        int t = st.peek();
        printElements(st);
        // checking the stack isEmppty
        if(st.isEmpty())
        {
            System.out.println("The Stack is Empty");
        }
        else
        {
            System.out.println("The Stack has Some numbers");
        }

    }
    public static void printElements(Stack st)
    {
        for(int i=0;i<st.size();i++)
        {
            System.out.print(st.get(i)+" ");
        }
        System.out.println();
    }
}
