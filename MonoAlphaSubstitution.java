/**
 * MonoAlphaSubstitution class that extends Substitution.
 * @author Fida Khadim
 */
public class MonoAlphaSubstitution extends Substitution {
/**
 * Stores the key, which is given by the user.
 */
    private static String mapping;
/**
 * Encodes the given character into a secret cipher character.
 * In this case it looks at the odd position characters in mapping
 * then sees if the character c is in mapping
 * if it is then c is encrypted with the character after it (i + 1)
 * @param c the character to encode
 * @return c the encrypted character
 */
    public char encrypt(char c) {
        for (int i = 0; i < mapping.length(); i += 2) {
                if (c == mapping.charAt(i)) {
                    c = mapping.charAt(i+1);
                    break;
                }
        }
        return c;
    }
/**
 * Decrypts the given cipher character into plain text character.
 * In this case it looks at the odd position characters in mapping
 * then sees if the character c is in mapping
 * if it is then c is encrypted with the character before it
 * @param c the character to decrypt
 * @return c the decrypted character
 */
    public char decrypt(char c) {
        for (int i = 0; i < mapping.length(); i += 2) {
            if (c == mapping.charAt(i+1)) {
                c = mapping.charAt(i);
                break;
            }
        }
        return c;
    }
/**
 * Default Constructor.
 */
    public MonoAlphaSubstitution() {
    }
/**
 * Constructor that takes a String as parameter.
 * This constructor sets mapping with a key
 * which is inputted by the user
 * @param text is the key
 */
    public MonoAlphaSubstitution(String text) {
        mapping = text;
    }
/**
 * Main method.
 * Checks if the correct number of parameters have been given.
 * If not then the correct error is displayed to the user
 * If correct parameters then args[2] is either encrypted or decrypterd depending on args[0]
 * @param args command line arguments
 */
    public static void main(String[] args) {
        String type;
        String text;
        if (args.length > 3) {
            System.out.println("Too many parameters!");
            System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
        } else if (args.length < 3) {
            System.out.println("Too few parameters!");
            System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
        } else {
            type = args[0];
            text = args[2];
            if (type.equals("encrypt")) {
                MonoAlphaSubstitution y = new MonoAlphaSubstitution(args[1]);
                String out = y.encrypt(text);
                System.out.println(out);
            } else if (type.equals("decrypt")) {
                MonoAlphaSubstitution y = new MonoAlphaSubstitution(args[1]);
                String out = y.decrypt(text);
                System.out.println(out);
            } else {
               System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!");
               System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
            }
        }
    }
}