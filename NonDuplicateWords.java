// Christopher Majek
// SE 320 Assignment-4 Problem #2
// Nov 6th 2022

import java.util.Scanner;
import java.util.TreeSet;
import java.io.*;

public class NonDuplicateWords 
{
    // Prints words in ascending order from a given text file
    public static void main(String[] args) 
    {
        // Stores non-duplicate words
        TreeSet<String> wordSet = new TreeSet<String>();

        // input file is currently hardcoded
        File inputFile = new File("words.txt");
        Scanner textScanner;
        try
        {
            textScanner = new Scanner(inputFile);
            
            while (textScanner.hasNext())
            {
                String text = textScanner.next();
                wordSet.add(text);
            }

            textScanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error: File not found");
            return;
        }

        for (String word : wordSet)
        {
            System.out.print(word + " ");
        }
    }

}
