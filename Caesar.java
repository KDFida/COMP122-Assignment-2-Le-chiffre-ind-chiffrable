/**
 * Caesar class extends MonoAlphaSubstitution.
 * @author Fida Khadim
 */
public class Caesar extends MonoAlphaSubstitution {
    
/**
 * Stores the key, which is given by the user.
 */
    private static int shift;
    
/**
 * Encodes the given character into a secret cipher character.
 * In this case it looks if the character is an alphabet letter (upper and lower case)
 * then shifts the character by the key
 * if the character surpasses 'z' then it loops back to 'a'
 * @param character the character to encode
 * @return character the encrypted character
 */
     public char encrypt(char character) {
        if ((character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z')) { 
            if (Character.isLowerCase(character)) {
                character = (char) (character + shift);
                if (character > 'z') {
                   character = (char) (character - 26);
                }
            } else {
                character = (char) (character + shift);
                if (character > 'Z') {
                    character = (char) (character - 26);
                }
            }
        }
        return character;
    }
    
/**
 * Decrypt the given character into plain text character.
 * In this case it looks if the character is an alphabet letter (upper and lower case)
 * then shifts the character by the key
 * if the character surpasses 'z' then it loops back to 'a'
 * @param character the character to decrypt
 * @return character the decrypted character
 */
    public char decrypt(char character) {
        if (shift < 0) {
            shift = 26 + (shift%26);
        }
        if ((character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z')) { 
            if (Character.isLowerCase(character)) {
                character = (char) (character + shift);
                if (character > 'z') {
                   character = (char) (character - 26);
                }
            } else {
                character = (char) (character + shift);
                if (character > 'Z') {
                    character = (char) (character - 26);
                }
            }
        }
        return character;
    }
  
/**
 * Default Constructor.
 */
    public Caesar() {
        
    }
/**
 * Constructor that takes an int as parameter.
 * This constructor sets shift with key
 * which is inputted by the user
 * @param key is the key (integer)
 */
    public Caesar(int key) {
        shift = key;
    }
/**
 * Main method.
 * Checks if the correct number of parameters have been given.
 * If not then the correct error is displayed to the user
 * If correct parameters then args[2] is either encrypted or decrypterd depending on args[0]
 * @param args command line arguments
 */    
    public static void main(String[] args) {
        String type = args[0];
        if (args.length == 3) {
            if (type.equals("encrypt")) {
                
                Caesar e = new Caesar(Integer.parseInt(args[1])); 
                String out = e.encrypt(args[2]); 
                System.out.println(out);
                
            } else if (type.equals("decrypt")) {
                int x = Integer.parseInt(args[1]); 
                Caesar d = new Caesar(-x); 
                String out = d.decrypt(args[2]); 
                System.out.println(out);
                
            } else {
                System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!");
                System.out.println("Usage: java Caesar encrypt n \"cipher text\"");
            }
            
        } else if (args.length > 3) {
            System.out.println("Too many parameters!");
            System.out.println("Usage: java Caesar encrypt n \"cipher text\"");
        } else {
            System.out.println("Too few parameters!");                                                                  
            System.out.println("Usage: java Caesar encrypt n \"cipher text\"");
        }
    }
}