package edu.drury.cs261;


import java.util.Scanner;

/**
 * Fibonacci App Application to explore recursion using the Fibonacci sequence
 *
 * @author Jali Purcell
 * @version 4/17/2021
 */
public class FibonacciApp {

    // declare variables
    private Scanner in;
    private int numberOfAdditions = 0;
    public FibonacciApp()
    {
        in = new Scanner(System.in);
    }

    /**
     * Recursive Fibonacci implementation
     *
     * @param number, number at which fibonacci number is desired
     * @return total, fibonacci number
     */
    public int fibonacci(int number)
    {
        // initial total is 0
        int total = 0;

        // if the number given is 0
        if (number==0){

            // total is 0
            total=0;
        }

        // if number given is 1
        else if (number==1){

            // total is 1
            total=1;
        }

        else{

            // total is set to the fibonacci number,
            // found by adding the previous two fibonacci numbers
            total=fibonacci(number-1)+fibonacci(number-2);

            // since the line above completes an addition, increment the number of additions
            numberOfAdditions++;
        }

        return total;
    }

    /**
     * Iterative Fibonacci implementation
     *
     * @param number, number at which fibonacci number is desired
     * @return total, fibonacci number
     */
    public int fibonacciIterative(int number)
    {
        // initial number of additions=0
        numberOfAdditions = 0;

        // initial values for total, curr, and temp
        int total = 0;
        int curr = 1;
        int temp = 0;

        // for 0-the number given
        for (int i =0; i < number; i++)
        {
            // set temp variable to the current value plus the total
            temp=curr+total;

            // change curr to the old total
            curr=total;

            // update total to temp
            total=temp;

            // increment number of additions
            numberOfAdditions++;
        }

        return total;
    }


    /**
     * run
     *
     * Take input, calculate answer two ways and report results
     */
    public void run()
    {
        // asks for input to find the fibonacci number of
        System.out.print("Enter a non-negative integer: ");
        int number = Integer.parseInt(in.nextLine());
        int answer = fibonacci(number);

        // finds fibonacci number recursively and iteratively
        // displays number of additions for both
        System.out.println("Fibonacci("+number+") by recursion is " + answer);
        System.out.println(numberOfAdditions + " additions were required");
        numberOfAdditions = 0;
        int iterative = fibonacciIterative(number);
        System.out.println("Fibonacci("+number+") iteratively is " + iterative);
        System.out.println(numberOfAdditions + " additions were required");

    }

    /**
     * main
     *
     * creates FibonacciApp object and calls run on the object
     */
    public static void main(String[] args) {
        FibonacciApp fib = new FibonacciApp();
        fib.run();
    }
}
