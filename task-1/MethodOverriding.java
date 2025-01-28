// Example of run time Polymorphism
import java.util.Scanner;

class Movie
{
    public void audio()
    {
        System.out.print("According to The language");
    }
}
class Englishmovie extends Movie
{
    public void audio()
    {
        System.out.println("It will be in English audio");
    }
}
class Tamilmovie extends Movie
{
    public void audio()
    {
        System.out.println("It Will be in Tamil Audio");
    }
}
public class MethodOverriding {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Movie person1 = new Tamilmovie();
        person1.audio();
        Movie person2 = new Englishmovie();
        person2.audio();
    }
}
