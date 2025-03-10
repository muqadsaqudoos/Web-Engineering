import java.util.*;

public class Calculator{
    public static void main(String[] args){
        int a,b;
        Scanner obj = new Scanner(System.in);
        System.out.println("Please Enter Value 1:");
        a = obj.nextInt();
        System.out.println("Please Enter Value 2:");
        b = obj.nextInt();
        char operator = args[0].charAt(0);
        int res;
        
        if ( operator =='+'){
            System.out.println(a+b);
        }
        else if ( operator =='-'){
            System.out.println(a-b);
        }
        else if ( operator =='x'){
            System.out.println(a*b);
        }
        else{
            System.out.println(a/b);
        }
       

    }
}
