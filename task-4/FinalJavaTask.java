import java.util.ArrayList;
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
    private static final ArrayList<Bank> accounts = new ArrayList<>();
    private static final Scanner s = new Scanner(System.in);
    public static void main(String[] args) 
    {
        System.out.println("Welcome to the Bank!");
        createAccount();
    }
    public static void createAccount() 
    {
        while (true) 
        {
            System.out.println("\n1 - Create Account");
            System.out.println("2 - Login to Existing Account");
            System.out.println("3 - Exit");
            System.out.print("Enter your choice:");
            int choice = s.nextInt();
            s.nextLine();
            if (choice == 1) 
            {
                Bank newUser = new Bank();
                System.out.print("Enter a 15 digit Account Number:");
                String accountNum;
                while (true) 
                {
                    accountNum = s.nextLine();
                    if (accountNum.length() == 15)
                    {
                        break;
                    }    
                    System.out.println("Please enter a 15 digit Account Number:");
                }
                newUser.setAccountNum(accountNum);
                System.out.print("Enter the initial balance:");
                int balance = s.nextInt();
                newUser.setBalance(balance);
                accounts.add(newUser);
                System.out.println("Account Created Successfully!");

            } 
            else if (choice == 2) 
            {
                System.out.print("Enter your Account Number:");
                String accNum = s.next();
                Bank user = getAccount(accNum);
                if (user != null) 
                {
                    performActions(user);
                } else 
                {
                    System.out.println("Invalid account number!");
                }
            } 
            else if (choice == 3) 
            {
                System.out.println("Thank you!!");
                System.exit(0);
            } 
            else 
            {
                System.out.println("Invalid choice, please try again.");
            }
        }
    }
    public static void performActions(Bank user) 
    {
        while (true) 
        {
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
                    int depositAmount = s.nextInt();
                    user.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    int withdrawAmount = s.nextInt();
                    user.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Your current balance is: " + user.getBalance());
                    break;
                case 4:
                    System.out.print("Enter recipient's Account Number:");
                    s.nextLine();
                    String recipientAcc = s.nextLine();
                    Bank recipient = getAccount(recipientAcc);
                    if(recipient == null)
                    {
                        System.out.println("Recipient account not found!");
                    } 
                    else 
                    {
                        System.out.print("Enter amount to transfer:");
                        int transferAmount = s.nextInt();
                        user.transferAmount(transferAmount, recipient);
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option! Try again.");
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
