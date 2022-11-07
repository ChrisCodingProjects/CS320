// Christopher Majek
// SE 320 Assignment-4 Problem #1
// Nov 6th 2022

import java.util.LinkedHashSet;

// Prints the union, difference and intersection of two pre-defined sets
public class HashSetComparison
{
    public static void main(String[] args) 
    {
        LinkedHashSet<String> setOne = createHashSet(new String[] {"George", "Jim", "John", "Blake", "Kevin", "Michael"});
        LinkedHashSet<String> setTwo = createHashSet(new String[] {"George", "Katie", "Kevin", "Michelle", "Ryan"});
        
        
        LinkedHashSet<String> testSet = new LinkedHashSet<String>();

        // Union of sets
        testSet.addAll(setOne);
        testSet.addAll(setTwo);
        System.out.println("Union of sets:");
        printSet(testSet);

        // Difference of sets
        testSet.clear();
        testSet.addAll(setOne);
        testSet.removeAll(setTwo);
        System.out.println("\nDifference of setOne - setTwo:");
        printSet(testSet);

        testSet.clear();
        testSet.addAll(setTwo);
        testSet.removeAll(setOne);
        System.out.println("\nDifference of setTwo - setOne:");
        printSet(testSet);

        // Intersection of sets
        testSet.clear();
        for (String name : setOne)
        {
            if (setTwo.contains(name))
            {
                testSet.add(name);
            }
        }
        System.out.println("\nIntersection of sets:");
        printSet(testSet);

    }

    // Creates hashtag from input array
    private static LinkedHashSet<String> createHashSet(String[] input)
    {
        LinkedHashSet<String> newSet = new LinkedHashSet<String>();
        for (String name : input)
        {
            newSet.add(name);
        }
        return newSet;
    }

    // Prints out a LinkedHashSet
    private static void printSet(LinkedHashSet<String> inputSet)
    {
        for (String element : inputSet)
        {
            System.out.print(element + " ");
        }
    }
}
