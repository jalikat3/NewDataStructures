/**
 * The Sorts class provides necessary methods to quick
 * sort a list of given values.
 *
 * The following methods are provided:
 *
 * quicksort()- uses an imported array of values
 * and compares the first two give values.
 * Based on which one is larger, it will either.
 *
 * partition()- splits the array up into two different
 * sections to be sorted from quicksort, and attached
 * together later.
 *
 *
 * @author Jali Purcell
 * @version 4/24/2021
 */

public class Sorts {

    static int NUMBER_SIZE;
    static int numComparisons=0;


    /**
     * Quirksort takes an array of values and determines
     * if they needed to be partitioned, then calls partition
     * if needed, and recursively calls to itself.
     *
     * @ param- values, array of values to sort
     * @ param i- for left partition
     * @ param k- for right partition
     */
    public static void quicksort(int[] values, int i, int k) {

        // g is the assumed lower values
        int g=i;

        // h is the assumed higher values
        int h=k;

        // set the number size to the length of values
        NUMBER_SIZE=values.length;

        // Base case: If the partition size is 1 or zero
        // elements, then the partition is already sorted
        if (g>=h){
            return;
        }

        // Partition the data within the array. Value lowEndIndex
        // returned from partitioning is the index of the low
        // partition's last element.
        int lowEndIndex=Sorts.partition(values, g, h);
        Sorts.quicksort(values, g, lowEndIndex);
        Sorts.quicksort(values, lowEndIndex+1, h);
    }


    /**
     * Partition the array. Returns the location of last
     * element in low partition.
     *
     * @ param- numbers, and int array to partition
     * @ param i- for left partition
     * @ param k- for right partition
     */

    private static int partition(int[] numbers, int i, int k) {

        /* Initialize variables */
        int g = i, h = k; //g=left hand, h=right hand
        boolean done = false;
        int temp;

        /* Pick middle value as pivot */
        int midpoint = i + (k - i) / 2;

        /* Get value at the midpoint */
        int pivot = numbers[midpoint];

        /* continue until all elements are in the correct partition */
        while(!done){

            /* Increment/decrement indexes while numbers are correctly partitioned */
            while(numbers[g]<pivot){
                numComparisons++;
                g+=1;
            }
            numComparisons++;
            while (pivot < numbers[h]) {
                numComparisons++;
                h-=1;
            }
            numComparisons++;

            /* check to see if the low index is greater than the high index*/
            if(g>=h){
                done=true;
            }

            /* if not, swap the numbers at these values*/
            else{
                temp=numbers[g];
                numbers[g]=numbers[h];
                numbers[h]=temp;

                /* update g and h*/
                g+=1;
                h-=1;
            }
        }
        return h;

    }
}
