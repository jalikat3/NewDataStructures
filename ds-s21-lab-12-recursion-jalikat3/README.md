# Lab 13: Recursion
## You can count on me!!
### Exploring recursion through the Fibonacci numbers.

#### Counting with Fibonacci numbers

0. Fibonacci numbers are defined as: 
  <img src="Readme-images/fib.png" />

1. Clone the Github repository with the sample code. Build and run the code to ensure your project is set up correctly. 
2. Complete the recursive method fibonacci for calculating the nth Fibonacci number.  In your method, update the counter that tracks the number of times an addition takes place. *Note:* Two things to watch out for: 
   1. Fibonacci numbers grow in size quickly. If the value of the ith Fibonacci number gets larger than 2,147,483,647, you will get a negative answer. Why?  
      

    The max amount that the bit can hold is this number. Once it excedes the max, it turns to the negatives. Once that number is exceded on the negative side, it will loop back to zero.


   2. Computing fibonaccii numbers larger than fib(45) or so may take your computer some time to complete.  The fib(64) will take some time, but if you are patient enough, the calculation will complete.  
3. Complete the iterative method fibonacciIterative for calculating the nth Fibonacci number.  Again, track the number of additions using a counter.   
4. Test the application to ensure both methods agree. Compare the number of additions required for each. 
   
    The number of additions for recursive method is more than the iterative method.
#### **Finishing the Lab**

Commit and push your code to the Github repository. 
