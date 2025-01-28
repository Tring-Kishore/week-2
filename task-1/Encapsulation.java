// Example For Encapsulation
import java.util.*;
class Bank1 {
    private int accountNumber;
    private String name;
    private String IFSC;
    private double balance;
    Bank1(int accountNumber,String name,String IFSC,double balance)
    {
        this.accountNumber = accountNumber;
        this.name = name;
        this.IFSC = IFSC;
        this.balance = balance;
    }
    public void creditAmount(int amount)
    {
        if(amount > 0)
        {
            balance = balance+amount;
            System.out.print("The amount has been credit successfully"+amount);
            System.out.println("The Balance is "+balance);

        }
        else
        {
            System.out.print("Enter the Amount Properly");
        }
    }
    public void withdraw(int amount)
    {
        if(amount < 0 && amount > balance)
        {
            System.out.print("Enter the valid amount Or Insufficient Balance");
        }
        else
        {
            balance -= amount;
            System.out.println("The amount "+amount+" has been debited successfully.");
        }
    } 
    public void getDetails()
    {
        System.out.print("The Account name is : "+name);
        System.out.println("The Account number is : "+accountNumber);
        System.out.println("The IFSC Code of the Branch : "+IFSC);
    }
    public void getBalance()
    {
        System.out.println("The balance is "+balance);
    }

}
class Encapsulation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the account number , name , IFSC Code , Amount :");
        Bank1 user1 = new Bank1(s.nextInt(),s.nextLine(),s.nextLine(),s.nextDouble());
        user1.creditAmount(500);
        user1.withdraw(300);
        user1.getBalance();
        user1.getDetails();

    }
    
}
