// Christopher Majek
// SE 320 Assignment-4 Problem #2
// Nov 6th 2022

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

// Prints out formatted numbers and currency from a given input string
public class FormattingNumbers 
{
    public static void main(String[] args) 
    {
        double inputNumber = 12345.678;

        // number formmating for UK locale
        Locale brit = new Locale("en", "UK");
        NumberFormat britNumberFormat = NumberFormat.getNumberInstance(brit);
        britNumberFormat.setMaximumFractionDigits(2);
        String formattedBritString = britNumberFormat.format(inputNumber);
        System.out.println(formattedBritString);

        // currency formmating for US locale
        Locale us = new Locale("en", "US");
        NumberFormat usCurrencyFormat = NumberFormat.getCurrencyInstance(us);
        String formattedUSString = usCurrencyFormat.format(inputNumber);
        System.out.println(formattedUSString);

        // Parsing given string into a number
        try 
        {
            Number parsedNumber = britNumberFormat.parse("12,345.678");
            // We print it out just to test it
            System.out.println("" + parsedNumber);
        } catch (ParseException e) {
            System.out.println("Error: Not a number");
        }

    }
}
