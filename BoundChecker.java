// Christopher Majek
// Assignment 1

import java.util.Random;
import java.util.Scanner;

// Creates an array of 100 randomly chosen integer and promts the user for a specific index.
public class BoundChecker 
{
    public static void main(String[] args) 
    {

        Random rand = new Random();
        int[] numbers = new int[100];
        for(int index = 0; index < numbers.length; index++)
        {
            numbers[index] = rand.nextInt(Integer.MAX_VALUE);
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("Please select an index from the array to display");
        try
        {
            int input = scan.nextInt();
            System.out.println(numbers[input]);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Out of Bounds");
        }

        scan.close();
    }
}
