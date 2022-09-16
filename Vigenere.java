/**
 * Vigenere class extends Substitution.
 * @author Fida Khadim
 */
public class Vigenere extends Substitution {
/**
 * Stores the difference between a char in key and 'A'.
 */
    private static int[] ciphers;
/**
 * Used to get an index in the ciphers array.
 */
    private static int count = 0;
 /** 
  * Stores the length of the key (args[1]).
  */
    private static int length;
/**
 * Encodes the given character into a secret cipher character.
 * In this case it looks if the character is an alphabet letter
 * then shifts the character by the key
 * key is found by subtracting 'A' from character i in the key
 * if the character surpasses 'z' then it loops back to 'a'
 * @param c the character to encode
 * @return c the encrypted character
 */
    public char encrypt(char c) {
        if (c >= 'a' && c <= 'z') {
            c = (char) (c + ciphers[count]);
            if (c > 'z') {
                c = (char) (c - 26);
            }
            count = count + 1;
        } else if (c == ' ') {
            count = count + 1;
        }
        if (count >= length) {
            count = 0;
        }
        return c;
    }
/**
 * Decrypt the given character into plain text character.
 * In this case it looks if the character is an alphabet letter
 * then shifts the character by the key
 * key is found by subtracting 'A' from character i in the key
 * if the character surpasses 'z' then it loops back to 'a'
 * @param c the character to decrypt
 * @return c the decrypted character
 */
    public char decrypt(char c) {
        if (c >= 'a' && c <= 'z') {
            c = (char) (c - ciphers[count]);
            if (c < 'a') {
                c = (char) (c + 26);
            }
            count = count + 1;
        } else if (c == ' ') {
            count = count + 1;
        }
        if (count >= length) {
            count = 0;
        }
        return c;
    }
/**
 * Default Constructor.
 */
    public Vigenere() {
    }
/**
 * Constructor that takes a String as parameter.
 * ciphers array is given the length of key
 * ciphers stores the difference between character i in the key and 'A'
 * @param key string the user inputs (args[1])
 */
    public Vigenere(String key) {
        int num = 0;
        length = key.length();
        ciphers = new int[length];
        for (int i = 0; i < key.length(); i++) {
            num = key.charAt(i) - 'A';
            ciphers[i] = num;
        }
    }
/**
 * Main method.
 * Checks if the correct number of parameters have been given.
 * If not then the correct error is displayed to the user
 * If correct parameters then args[2] is either encrypted or decrypterd depending on args[0]
 * @param args command line arguments
 */
    public static void main(String[] args) {
        if (args.length > 3) {
            System.out.println("Too many parameters!");
            System.out.println("Usage: java Vigenere encrypt key \"cipher text\"");
        } else if (args.length < 3) {
            System.out.println("Too few parameters!");
            System.out.println("Usage: java Vigenere encrypt key \"cipher text\"");
        } else {
            String type = args[0];
            String key = args[1];
            String s = args[2];
            if (type.equals("encrypt")) {
                Vigenere y = new Vigenere(args[1]);
                String out = y.encrypt(args[2]);
                System.out.println(out);
            } else if (type.equals("decrypt")) {
                Vigenere j = new Vigenere(args[1]);
                String out = j.decrypt(args[2]);
                System.out.println(out);
            } else {
               System.out.println("First parameter must be \"encrypt\" or \"decrypt\"!");
               System.out.println("Usage: java Vigenere encrypt key \"cipher text\"");
            }
        }
    }
}