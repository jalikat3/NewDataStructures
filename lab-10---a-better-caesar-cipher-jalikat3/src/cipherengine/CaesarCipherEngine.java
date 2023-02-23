package cipherengine;
import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * The CeasearCipherEngine implements a shifted key version of the
 * Caesar Cipher.   Use of the class requires the user to supply a 
 * set of key values.  Messages are then encoded and decoded against
 * the set using the methods encode and decode.
 * 
 * Note: Only the <em>printable</em> characters in the ASCII character
 * code are encoded/decoded. (i.e. Characters with ASCII value from 32 
 * to 126).  If a <em>control</em> character is encountered in a string,
 * a space (character 32) is encoded in its place.  The net effect of
 * this policy is that <em>control</em> characters will be lost in an
 * encode - decode cycle.
 * 
 * @author J. Purcell
 * @version 3/30/2021
 */
public class CaesarCipherEngine {
    // 1. Create storage for instance variables
    // 1.5 create an empty keyQ
    // 2
    /**
     * An array of the keys used in the cipher.
     */
    private int[] keys;
    /**
     * The queue of keys to use for encoding and decoding.  keyQ is
     * initialized from the array keys, which defines the order of the
     * keys for the cipher are used.
     */
    private ArrayDeque<Integer> keyQ;

    // see add and remove

    /**
     * CaesarCipherEngine - This constructor is responsible for initilazing
     * the array of keys the cipher will use.
     *
     * @param keys An array of keys the ciper will use for both encoding
     *             and decoding.
     */
    public CaesarCipherEngine(int[] keys) {

        // initialize array of keys
        this.keys = new int[keys.length];

        // fill the array with the keys from parameter
        for (int i = 0; i < this.keys.length; i++) {
            this.keys[i] = (keys[i]);
        }

        // initialize keyQ ArrayDeque
        keyQ = new ArrayDeque<>();
    }


    /**
     * encode - This method returns the CipherText message that
     * results from a shifter Ceaser Cipher encoding of the provided
     * string.
     * <p>
     * //@param clearText The message to encode.
     *
     * @return The ciphertext version of the specified cleartext.
     */
    public String encode(String clearText) {

        // call to make keyQ
        initializeKeyQ();

        // will be added onto and printed
        String eMsg = new String();

        // for each character in the length of clearText
        for (int i = 0; i < clearText.length(); i++) {

            // take off the key to use
            int key = keyQ.remove();

            // add the key to the back of keyQ
            keyQ.add(key);

            // add one to the int value of clearText
            int asci = (int) clearText.charAt(i) + key;

            // used to wrap around 32-127
            if (asci < 32) {
                asci = 128 - key;
            }
            if (asci > 127) {
                asci = 31 + key;
            }

            // add values onto string
            eMsg = eMsg + (char) asci;
        }

        // return string to be printed
        return eMsg;
    }

    /**
     * decode - This method returns the ClearText decoding of the
     * specified CipherText.
     *
     * @param cipherText The message to decode.
     * @return The cleartext version of the specified ciphertext.
     */
    public String decode(String cipherText) {

        // same set up as encode
        initializeKeyQ();
        String eMsg = new String();

        for (int i = 0; i < cipherText.length(); i++) {
            int key = keyQ.remove();
            keyQ.add(key);

            // the difference between encode and decode:
            // in decode, subtract one less from the cipher text
            // when cipherText was encoded, the key was added
            int asci = (int) cipherText.charAt(i) - key;

            // wrap
            if (asci < 32) {
                asci = 128 - key;
            }
            if (asci > 127) {
                asci = 31 + key;
            }
            eMsg = eMsg + (char) asci;
        }
        return eMsg;
    }

        /**
         * initializeKeyQ - This method is a private utility method whose
         * purpose is to insert the set of values in the keyQ in the correct
         * initial order.  It is called by both the encode and decode methods
         * before encoding or decoding a message.
         */

        private void initializeKeyQ() {

            // clear keyQ
            this.keyQ.clear();

            // add values from keys to keyQ
            for (int i = 0; i < this.keys.length; i++) {
                keyQ.add(this.keys[i]);
            }
    }
}
