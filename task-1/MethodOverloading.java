// Compile time Polymorphism
import java.util.Scanner;

public class MethodOverloading {
    public static int add(int num1,int num2)
    {
        return num1+num2;
    }
    public static int add(int num1,int num2,int num3)
    {
        return num1+num2+num3;
    }
    public static double add(double num1,double num2)
    {
        return num1+num2;
    }
    public static double add(double num1,double num2,double num3)
    {
        return num1+num2+num3;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(add(5.0, 6.9, 4.0));
        System.out.println(add(2, 3, 2));
    }
}
