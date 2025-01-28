import java.util.Scanner;
public class Trycatch {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the Name : ");
        String name = s.nextLine();
        System.out.print("Enter the Age : ");
        try{
            int age = s.nextInt();
            if(age < 18)
            {
                throw new Exception("Not Eligible to Vote.");
            }
            System.out.println("You are ready to Vote.");
        }
        catch(Exception e)
        {
            System.out.println("You are Not Eligible to Vote.");
        }
    }   
}
