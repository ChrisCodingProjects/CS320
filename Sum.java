// Christopher Majek
// Assignment 1


import java.util.Scanner;

// Promps the user for two integers and sums them together. Uses exception handling to continually reprompt user if input was incorrect.
public class Sum 
{
    public static void main(String[] args) 
    {
        boolean validInput = false;
        int result = 0;
        while(!validInput)
        {
            try
            {
                result = calculate();
                validInput = true;
            }
            catch(Exception e)
            {
                System.out.println("Invalid input");
            }
        }

        System.out.println("Sum: " + result);
    }

    private static int calculate()
    {
        System.out.println("Please input two whole numbers:"); 
        Scanner input = new Scanner(System.in);
        int firstNumber = input.nextInt();
        int secondNumber = input.nextInt();

        input.close();
        return firstNumber + secondNumber;
    }
}
