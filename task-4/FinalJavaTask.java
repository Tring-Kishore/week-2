import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
class Bank {
    private String accountNum;
    private int balance;
    public void setAccountNum(String accountNum) 
    {
        this.accountNum = accountNum;
    }
    public String getAccountNum() 
    {
        return accountNum;
    }
    public void setBalance(int balance) 
    {
        this.balance = balance;
    }
    public int getBalance() 
    {
        return balance;
    }
    public void withdraw(int amount) 
    {
        if (amount > balance) 
        {
            System.out.println("Insufficient Balance!!");
        } else 
        {
            balance -= amount;
            //System.out.println("The new balance is : " + balance);
        }
    }
    public void deposit(int amount) 
    {
        if (amount <= 0) 
        {
            System.out.println("Enter a valid amount.");
        } 
        else 
        {
            balance += amount;
            //System.out.println("The new balance is : " + balance);
        }
    }
    public void transferAmount(int amount, Bank recipient) 
    {
        if (amount > balance) 
        {
            System.out.println("Insufficient Balance.");
        } 
        else 
        {
            balance -= amount;
            recipient.deposit(amount);
            System.out.println("Successfully transferred " + amount + " to account " + recipient.getAccountNum());
        }
    }
}

public class FinalJavaTask {
    static ArrayList<Bank> accounts = new ArrayList<>();
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) 
    {
        System.out.println("Welcome to the Bank!");
        initialProcess();
    }
    public static void initialProcess() 
    {
        while (true) 
        {
            try{
                System.out.println("\n1 - Create Account");
                System.out.println("2 - Login to Existing Account");
                System.out.println("3 - Exit");
                System.out.print("Enter your choice:");
                int choice = s.nextInt();
                s.nextLine();
                switch (choice) {
                    case 1:
                        createAccount();
                        break;
                    case 2:
                        loginToAccount();
                        break;
                    case 3:
                        System.out.println("Thank you!!");
                        System.exit(0);    
                    default:
                        System.out.println("Invalid input , Enter the valid Input.");
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid Input , Enter the Correct Option.");
                s.nextLine();
            }    
        }
    }
    public static void createAccount()
    {
        Bank newUser = new Bank();
        System.out.print("Enter a 15 digit Account Number:");
        String accountNum = validateAccountInput();
        newUser.setAccountNum(accountNum);
        System.out.print("Enter the initial balance:");
        int balance = validateAmount();
        newUser.setBalance(balance);
        accounts.add(newUser);
        System.out.println("Account Created Successfully!");
    }
    public static void loginToAccount()
    {
        System.out.print("Enter your Account Number:");
        String accNum = validateAccountInput();
        Bank user = getAccount(accNum);
        if (user != null) 
        {
            performActions(user);
        } else 
        {
            System.out.println("Invalid account number!");
        }
    }
    public static boolean validateAccNum(String acc)
    {
        char[] ch = acc.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            if((ch[i] >= 'a' && ch[i] <= 'z' )|| (ch[i] >= 'A' && ch[i] <= 'Z'))
            {
                return false;
            }
        }
        return true;
    }
    public static int validateAmount()
    {
        int amount;
        while(true)
        {
            try{
                amount = s.nextInt();
                return amount;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid Input , Please enter a Amount correctly.");
                s.nextLine();
            }
        }
    }
    public static String validateAccountInput()
    {
        String accNum;
        while (true) 
        {
            accNum = s.nextLine();
            boolean b = validateAccNum(accNum);
            if(b && accNum.length() == 15)
            {
                return accNum;
            }
            else if(!b)
            {
                System.out.println("The Account number should not have Alphabets.");
            }
            if(accNum.length() == 15 && b)
            {
                return accNum;
            }
            else
                System.out.println("Please enter a 15 digit Account Number:");
        }
    }
    public static void performActions(Bank user) 
    {
        while (true) 
        {
            try{
                System.out.println("\nChoose an action:");
                System.out.println("1 - Deposit");
                System.out.println("2 - Withdraw");
                System.out.println("3 - Check Balance");
                System.out.println("4 - Transfer Money");
                System.out.println("5 - Logout");
                System.out.print("Enter your choice: ");
                int choice = s.nextInt();
                switch (choice) 
                {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        int depositAmount = validateAmount();
                        user.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        int withdrawAmount = validateAmount();
                        user.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.println("Your current balance is: " + user.getBalance());
                        break;
                    case 4:
                        System.out.print("Enter recipient's Account Number ");
                        //s.nextLine();
                        String recipientAcc = validateAccountInput();
                        Bank recipient = getAccount(recipientAcc);
                        if(recipient == null)
                        {
                            System.out.println("Recipient account not found!");
                        } 
                        else 
                        {
                            System.out.print("Enter amount to transfer:");
                            int transferAmount = validateAmount();
                            user.transferAmount(transferAmount, recipient);
                        }
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid option! Try again.");
                }        
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid Input , Please Enter the correct the choice.");
                s.nextLine();
            }
        }
    }
    public static Bank getAccount(String accountNum) {
        for (Bank acc : accounts) 
        {
            if (acc.getAccountNum().equals(accountNum)) 
            {
                return acc;
            }
        }
        return null;
    }
}
