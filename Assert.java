// Christopher Majek
// Assignment 2
// Problem # 3

import java.util.Scanner;

public class Assert 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input number between 0 and 10:"); 
        int firstNumber = input.nextInt();

        assert firstNumber < 10 : "The entered number is out of range";
        assert firstNumber > 0 : "The entered number is out of range";
        System.out.println(firstNumber);

        input.close();
    }
}
