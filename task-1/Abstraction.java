import java.util.Scanner;

abstract class Movie
{
    String name;
    int seat;
    public Movie(String name,int seat)
    {
        this.name = name;
        this.seat = seat;
    }
    abstract void calculateRate();
}
class Tamilmovie extends Movie
{
    public int rate;
    Tamilmovie(String name,int seat,int rate)
    {
        super(name, seat);
        this.rate = rate;
    }
    @Override
    void calculateRate() {
         int total = seat * rate;
        System.out.println("The Total Amount for tamil Movie is "+total);
    }
}
class Englishmovie extends Movie
{
    public int rate;
    Englishmovie(String name,int seat,int rate)
    {
        super(name, seat);
        this.rate = rate;
    }
    @Override
    void calculateRate()
    {
        int total = seat * rate + 10;
        System.out.print("The total Amount For English Movie is "+total);
    }
}
public class Abstraction {
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the name :");
        String name = s.next();
        System.out.println("Enter how many seats want to book :");
        int seat = s.nextInt();
        System.out.print("Enter 1 to select Tamil Movie Or Enter 2 To Select English Movie:");
        int num = s.nextInt();
        if(num == 1)
        {
            Movie user1 = new Tamilmovie(name,seat,120);
            user1.calculateRate();
        }
        else if(num == 2)
        {
            Movie user2 = new Englishmovie(name,seat , 130 );
            user2.calculateRate();
        }
        else
        {
            System.out.print("Enter the Proper number to Select the Movie");
        }
        
    }
}
