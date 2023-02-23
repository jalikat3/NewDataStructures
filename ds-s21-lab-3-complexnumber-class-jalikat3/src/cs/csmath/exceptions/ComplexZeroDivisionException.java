/**
 * File:  ComplexZeroDivisionException        Date: 01/31/2014
 * 
 * Course:  Data Structures
 */
package cs.csmath.exceptions;

/**
 * Exception that indicates an attempt to divide by zero.
 * 
 * @author S. Sigman 
 * @version 1.0 (Feb 14, 2017)
 *
 */
public class ComplexZeroDivisionException extends RuntimeException {
    public ComplexZeroDivisionException(){
    	super("Complex Division By Zero");
    }
}