public class ArithmeticExample {

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;
        try{
            int answer = num1/num2;
            System.out.print("The answer is "+answer);
        }
        catch(ArithmeticException e)
        {
            System.out.println("Error : Divide by zero");
        }
    }
}