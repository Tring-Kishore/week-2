import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashmapExample {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashMap<Integer,String> hm = new HashMap<>();
        // Adding values in Hashmap
        hm.put(1,"Morgan");
        hm.put(2,"Kishore");
        hm.put(3, "Buttler");
        hm.put(4, "Stokes");

        // Printing the Hashmap
        System.out.println("The Key and Values are : ");
        System.out.println(hm);

        // Removing the key and value
        hm.remove(2);

        System.err.println("After Removing : "+hm);

        // Trversing the hashmap
        //Getting key alone and value alone
        for(Map.Entry<Integer,String> e : hm.entrySet())
        {
            System.out.println("The key is : "+e.getKey());
            System.out.println("The value for the key is : "+e.getValue());
        }
    }
}
