import java.util.Scanner;
import java.io.File;

/**
 * Lab 11 quicksorting
 * Class SortTest test the accuracy of the
 * quirk sort created in the Sorts class.
 *
 * It will print if the file of values is found or not,
 * and all of the numbers in the order that Sorts placed
 * them in. The quirk sort is accurate if the
 * printed values grow from smallest to largest.
 * The amount of comparisons is also displayed in the
 * output.
 *
 * @author: Jali Purcell
 * @version: 4/24/2021
 */

public class SortTest {

    public static void main (String[] args)
    {
        String fileName = "randintegersA.in";
        int numberOfValues = 0;
        Scanner fin = null;

        //int [] values;
        System.out.println("Opening file " + fileName);
        try {
            fin = new Scanner(new File(fileName));
        }
        catch(java.io.FileNotFoundException e){
            System.err.println("File not found");
            System.exit(0);
        }
        numberOfValues = fin.nextInt();
        System.out.println("Reading "  + numberOfValues + " values");
        int[] values = new int[numberOfValues];

        // read the numbers
        for (int i = 0; i < numberOfValues; i++)
        {
            values[i] = fin.nextInt();
        }
        fin.close();
        System.out.println("Reading complete. Sorting...");

        // sort the numbers
        Sorts qs = new Sorts();
        Sorts.quicksort(values, 0, numberOfValues-1);
        System.out.println ("List sorted!");
        for(int i = 0; i < values.length; i += 10)
        {
            for (int j = i; j < i + 10; j++)
            {
                System.out.print(values[j] + " ");
            }
            System.out.println();
        }

        // show the number of comparisons, should be between length^2 and
        // length * log(2)(length)
        System.out.println("Number of Comparisons: " + Sorts.numComparisons);
    }
}
