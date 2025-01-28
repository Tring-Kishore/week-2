import java.util.Scanner;
class BankAccount{
    String name;
    String accountNum;
    int age;
    int balance;
    void createAccount(String name,String accountNum,int age,int balance)
    {
        this.name = name;
        this.accountNum = accountNum;
        this.age = age;
        this.balance = balance;
    }
    // Arithmetic Execption
    void withdraw(int amount)
    {
        try{
            if(balance < amount)
            {
                throw new ArithmeticException("Insufficient Balance");
            }
            balance -= amount;
            System.out.println("The amount has been Withdrawed");
            System.out.println("The balance is"+balance);
        }
        catch(ArithmeticException e)
        {
            System.out.println("Insufficient Balance");
        }
    }
    void deposite(int amount)
    {
        try{
            if(amount < 0)
            {
                throw new ArithmeticException("Amount should be greater than 0");
            }
            System.out.println("The amount has been deposited");
            balance += amount;
            System.out.println("The balance is "+balance);
        }
        catch(ArithmeticException e)
        {
            System.out.println("Ampount should be greater than 0");
        }
    }
}
public class ExecptionExample {
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the Name : ");
        String name = s.nextLine();
        try{
            int len = name.length();
            if(len <= 0)
            {
                throw new NullPointerException();
            }
        }
        catch(NullPointerException e){
            System.out.println("Enter the Valid Name.");
            System.exit(0);
        }
        System.out.println("Enter the Account Number : ");
        String accountNum = s.next();
        try{
            int len = accountNum.length();
            if(len < 15 || len > 15)
            {
                throw new validateAccountNumber("Enter 15 Digit Account Number");
            }
        }
        catch(validateAccountNumber e)
        {
            System.out.println("Enter 15 Digit Account Number Properly");
            System.exit(0);
        }
        System.out.println("Enter the Age : ");
        int age = s.nextInt();
        try{
            if(age < 18)
            {
                throw new InvalidAgeException("Enter the valid age");
            }
        }
        catch(InvalidAgeException e)
        {
            System.out.println("You are under age 18");
            System.exit(0);
        }
        System.out.println("Enter the Amount : ");
        int amount = s.nextInt();
        BankAccount user = new BankAccount();
        user.createAccount(name, accountNum, age, amount);
        while(true)
        {
            System.out.println("Enter 2 to Withdraw");
            System.out.println("Enter 3 to Deposit money");
            System.out.println("Enter 4 to Exit");
            int num = s.nextInt();
                
            if(num == 2)
            {
                System.out.println("Enter the Amount to Withdraw");
                int n1 = s.nextInt();
                user.withdraw(n1);
            }
            else if(num == 3)
            {
                System.out.println("Enter the Amount to Deposit");
                int n1 = s.nextInt();
                user.deposite(n1);
            }
            else if(num == 4)
            {
                System.exit(0);
            }
        }

    }
}
// custom Execption
class validateAccountNumber extends Exception{
    validateAccountNumber(String message)
    {
        super(message);
    }
}
class InvalidAgeException extends Exception
{
    InvalidAgeException(String message)
    {
        super(message);
    }
}
