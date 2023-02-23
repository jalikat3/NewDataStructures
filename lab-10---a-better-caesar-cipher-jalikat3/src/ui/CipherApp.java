package ui;

import cipherengine.CaesarCipherEngine;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Write a description of class CipherApp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CipherApp {
    /**
     * in - A scanner opject associated with the keyboard used to 
     * capture user input.
     */
    private Scanner in;
    
    /**
     * Constructor to create an instance of a Ciper Application.
     */
    public CipherApp(){
        in = new Scanner(System.in);
    }
    
    /**
     * run - This method is the heart of the CaesarCiper app. 
     * It is responsible for the organizing and executing the
     * application logic of the application, which includes 
     * creating the user interface.
     */
    public void run(){
        int [] keys = null; // Array of keys to use in the cipher
        
        // Print user directions
        printDirections();
        System.out.println();
        
        // Read in the keys
        keys = readKeys();
        
        // Make a CipherEngine to encode of decode the message
        CaesarCipherEngine cipher = new CaesarCipherEngine(keys);
        
        char cont = 'y';
        while (cont == 'y' || cont=='Y') {

            System.out.print ("Encode or decode a message? (e or d) => ");
            String cmd = in.nextLine();

            // encode a message
            if (cmd.charAt(0) == 'e') {
                System.out.print ("Enter a message to encode and press Enter => ");
                String msg = in.nextLine();
                String encoded = cipher.encode(msg);
                System.out.println("Your encoded message is " + encoded);
            }
            // decode a message
            else if (cmd.charAt(0) == 'd') {
                System.out.print ("Enter a ciphertext message to decode and press Enter => ");
                String msg = in.nextLine();
                String decoded = cipher.decode(msg);
                System.out.println("Your decoded message is " + decoded);
            }
            // an illegal command was entered
            else
            {
                System.out.println ("Unrecognized command. I only know 'd' or 'e'.");
            }


            System.out.print("Endcode or decode another message? (y or n) => ");
            
            String contQuery = in.nextLine();
            if (contQuery.length() > 0)
              cont = contQuery.charAt(0);
            else
              cont = 'n';
        }
        
        // Print an exit message
        System.out.println();
        System.out.println("Encoding and decoding of Messages is finished. Thank");
        System.out.println("you for using our application.");
    }
    
    public static void main(String [] args) {
        CipherApp app = new CipherApp();
        app.run();
    }
    
    /**
     * printDirections - Method to print the directions on the screen
     */
    private void printDirections(){
        System.out.println("===================================================");
        System.out.println("= The Caesar Ciper application allows the user to =");
        System.out.println("= encode or decode a message using a Caesar       =");
        System.out.println("= Cipher, which rotates encoding through a set of =");
        System.out.println("= specified keys.                                 =");
        System.out.println("===================================================");
    }
    
    /**
     * readKeys - This utility method reads the keys from the user and 
     * populates the keys array.
     * 
     * @return The array of keys read from the user.
     */
    public int [] readKeys(){
        //Prompt the user to enter the keys.
        System.out.println("Please enter a sequence of integer keys to use for encoding ");
        System.out.println("and decoding. Enter the keys  on a single line.     "); 
        System.out.println("Values should be separated by a single space. Use   ");
        System.out.println("a value of 0 to end input.");
        System.out.println();
        System.out.print("Keys => ");
        
        // read the keys into a temporary holding storate
        ArrayList<Integer> temp = new ArrayList(); // used to simplify the input
        int curKey = in.nextInt();
        int numKeys = 0;
        while (curKey != 0) {
            temp.add(curKey);
            curKey = in.nextInt();
            numKeys++;
        }
        
        // The newline after the 0 is left in the input buffer.  In order to prepare
        // for other input, this newline must be read from the buffer.
        in.nextLine();
        
        // make a new int array and fill it
        int[] tempKeyArry = new int [numKeys];
        Iterator<Integer> it = temp.iterator();
        int i = 0;
        while(it.hasNext()) {
            tempKeyArry[i] = it.next();
            i++;
        }
        
        // send the array back
        return tempKeyArry;
        
    }
}
