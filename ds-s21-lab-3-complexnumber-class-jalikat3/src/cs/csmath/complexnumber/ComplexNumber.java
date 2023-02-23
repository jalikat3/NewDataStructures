package cs.csmath.complexnumber;
import cs.csmath.exceptions.ComplexZeroDivisionException;
import java.math.*;

/**
 * The Complex Number class provides a data type for using complex numbers 
 * within a Java program.
 *  * 
 * @author S. Sigman and J.Purcell
 * @version 1.0 (Feb 14, 2017) 2.0(February 14, 2021)
 *
 */ 
public class ComplexNumber {

	/** 
	 * The real part of the complex number.
	 */
	private double realPart;
	
	/** 
	 * The imaginary part of the complex number.
	 */
	private double imagPart;
	
	// Constructors
	
	/**
	 * This constructor initializes a complex number with the
	 * specified real and imaginary parts.
	 * 
	 * @param realP The real part of the complex number.
	 * @param imagP The imaginary part of the complex number.
	 */
	public ComplexNumber(double realP, double imagP)
	{
		// Initialize realPart to realP and imagPart
		//        to imageP.
		this.realPart = realP;
		this.imagPart = imagP;
	}
	
	/**
     * Constructs the complex number 0.0 + 0.0i.
     */
	public ComplexNumber() {
	    // Set the complex number to 0 + 0i.
		this.realPart = 0.0;
		this.imagPart = 0.0;
	}

    // Query Methods (getters and setters)
    
	// Generate getter and setter methods for the
	//        instance variables realPart and imagPart.

	// returns real number
	public double getRealPart(){
		return realPart;
	}

	// returns imaginary number
	public double getImagPart(){
		return imagPart;
	}

	// sets real number to given real number
	public void setRealPart(double real){
		this.realPart = real;
	}

	// sets imaginary number to given imaginary number
	public void setImagPart(double imag){
		this.imagPart = imag;
	}



	// Arithmetic Methods
	
	/**
     * This method adds the complex number otherCN to the
     * value of the current instance and replaces the value
     * of the instance with the sum.
     *  
     * @param otherCN The complex number to add.
     */
    public void add(ComplexNumber otherCN) {
    	this.realPart = this.realPart + otherCN.realPart;
        this.imagPart= this.imagPart + otherCN.imagPart;
    }


    /**
     * This method subtracts the complex number otherCN
     * from the current instance and replaces the value of 
     * the current instance with the difference.
     * 
     * @param otherCN The complex number to subtract.
     */
    public void sub(ComplexNumber otherCN) {
    	this.realPart = this.realPart - otherCN.realPart;
        this.imagPart = this.imagPart - otherCN.imagPart;
    }

    /**
     * This method multiplies the current complex number by 
     * the complex number otherCN and replaces the current
     * complex number with the product.
     * 
     * @param otherCN The complex number to multiply by.
     */
    public void mult(ComplexNumber otherCN) {
       double temp = (this.realPart * otherCN.realPart) - (this.imagPart * otherCN.imagPart);
       this.imagPart = (this.imagPart * otherCN.realPart) + (this.realPart * otherCN.imagPart);
       this.realPart = temp;
    }

    /**
     * This method divides the current complex number by 
     * the complex number otherCN and replaces the current
     * complex number with the quotient.
     * 
     * @param otherCN The divisor to use.
     */
    public void div(ComplexNumber otherCN) {
    	// Implement this method next week.
    }

    
    /**
     * This method returns the conjugate of an instance of a
     * complex number.
     * 
     * @return The conjugate of this instance.
     */
    public ComplexNumber conj() {
        return new ComplexNumber(this.realPart,-1 * this.imagPart);
    }
    
    /**
     * This method returns the absolute value of the this 
     * complex number.  The value returned is:
     * square_root(realPart^2 + imagPart^2)
     * 
     * @return The absolute value of this complex number.
     */
    public double abs() {
    	// TO DO: Implement the absolute value operation.
		double realSqr = (this.realPart * this.realPart);
		double imagSqr = (this.imagPart * this.imagPart);
        return Math.sqrt(realSqr + imagSqr);
    }
    
    /** 
	 * This method returns the complex number as a
	 * string formatted as:
	 *    realPart +/- imagPart i
	 * where the appropriate sign is placed before the imagPart
	 * of the number.  No space is placed before the i.
	 * 
     * @return A string representation of the complex number is returned.
     */
    public String toString() {
    	String sign = "+";
    	if (this.imagPart<0)
    		sign = "-";
    	return "" + this.realPart + sign + Math.abs(this.imagPart) + "i";
    }

    public static void main (String[] args){
		if (args[0].equals("print")) {

			// test a : addition Expected: 5.0+0i
			ComplexNumber c1 = new ComplexNumber(2.0, 3.1);

			ComplexNumber c2 = new ComplexNumber(3.0, -3.1);
			c1.add(c2);
			System.out.println("(2.0+3.1i) + (3.0-3.1i)= " + c1);

			// test b : addition Expected: 3.14+2.5i
			ComplexNumber c3 = new ComplexNumber(3.14, 2.5);
			ComplexNumber c4 = new ComplexNumber();
			c3.add(c4);
			System.out.println("(3.14+2.5i + (0.0+0.0i)= " + c3);

			// test c : multiplication Expected: 2.6+.05i
			ComplexNumber c5 = new ComplexNumber(2.1, 3.1);
			ComplexNumber c6 = new ComplexNumber(0.5, -0.5);
			c5.mult(c6);
			System.out.println("(2.1+3.1i) * (0.5-0.5i)= " + c5);

			// test d : multiplication Expected: 0.0+0.0i
			ComplexNumber c7 = new ComplexNumber(2.1, 3.1);
			ComplexNumber c8 = new ComplexNumber(0.0, 0.0);
			c7.mult(c8);
			System.out.println("(2.1+3.1i) * (0.0+0.0i)= " + c7);

			// test e : absolute value Expected: 1
			ComplexNumber c9 = new ComplexNumber(1.0, 0.0);
			System.out.println("Absolute value of (1.0+0.0i)= " + c9.abs());

			// test f : absolute value Expected: 1.414
			ComplexNumber c10 = new ComplexNumber(1.0, 1.0);
			System.out.println("Absolute value of (1.0+1.0i)= " + c10.abs());

			// test g : conjugation Expected: 2.1 - 3.2i
			ComplexNumber c11 = new ComplexNumber(2.1, 3.2);
			System.out.println("Conjugation of (2.1+3.2i)= " + c11.conj());

			// test h : conjugation Expected: 2.1 + 3.2i
			ComplexNumber c12 = new ComplexNumber(2.1, -3.2);
			System.out.println("Conjugation of (2.1-3.2i)= " + c12.conj());

			// THE FOLLOWING ARE ADDITIONAL TESTS

			// test i: addition and addition Expected: 12.3+6.2i
			ComplexNumber c13 = new ComplexNumber(3.3, 4.2);
			ComplexNumber c14 = new ComplexNumber(9.0,0.0);
			c14.add(c13);
			ComplexNumber c15 = new ComplexNumber(0.0,2.0);
			c15.add(c14);
			System.out.println("((3.3+4.2i)) + (9.0+0.0i)) + (0.0+2.0i)= "+ c15);

			// test j: addition and conjugation Expected: 10.2+4.0i

			ComplexNumber c16 = new ComplexNumber(2.0, 1.0);
			ComplexNumber c17 = new ComplexNumber(8.2,-5.0);
			c17.add(c16);
			System.out.println("Conjugation of (2.0+1.0) * (8.2-5.0i)= " + c17.conj());

			// test k: subtraction Expected: 7.0+2.16i
			ComplexNumber c18 = new ComplexNumber(11.0,6.16);
			ComplexNumber c19 = new ComplexNumber(4.0,4.0);
			c18.sub(c19);
			System.out.println("(11.0+6.16i)-(4.0+4.0i)= " + c18);

			// test l: subtraction with existing Expected: -1.0+5.16i
			ComplexNumber c20 = new ComplexNumber(8.0,-3.0);
			c18.sub(c20);
			System.out.println("(7.0+2.16i)- (8.0-3.0i)= " + c18);

			// LAB COMPLETE

		}

	}
}