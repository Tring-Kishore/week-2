import java.util.Scanner;

class InvalidAgeException extends Exception
{
    InvalidAgeException(String str)
    {
        super(str);
    }
}
public class CustomException {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the Age : ");
        try{
            int age = s.nextInt();
            if(age < 18)
            {
                throw new InvalidAgeException("Not Eligible To Vote");
            }
            System.out.print("Eligible to Vote");
        }
        catch(InvalidAgeException e)
        {
            System.err.println("Your age is not eligible to vote");
        }

    }
}
