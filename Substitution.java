/**
 * An abstract that implements Cipher.
 * @author Fida Khadim
 */
public abstract class Substitution implements Cipher {
    
/**
 * Encodes the given charcter into a secret cipher character.
 * @param c the character to encode
 * @return the cipher text
 */
    public abstract char encrypt(char c);
    
/**
 * Decodes the given character into a plain text character.
 * @param c the character to decode
 * @return the plain text 
 */
    public abstract char decrypt(char c);
/**
 * Encrypt given plain text into cipher text.
 * Here encrypt is called for length of plaintext times,
 * each time the charcter at i is encrypted.
 * @param plaintext the given string to encode
 * @return s the cipher text
 */ 
    public String encrypt(String plaintext) {
        String s = "";
        for (int i = 0; i < plaintext.length(); i++) {
            s = s + encrypt(plaintext.charAt(i));
        } 
        return s;
    }
/**
 * Decrypt the given cipher text into plain text.
 * Here decrypt is called for length of cryptotext times,
 * each time the charcter at i is decrypted.
 * @param cryptotext the given string to decode
 * @return s the plain text
 */     
    public String decrypt(String cryptotext) {
        String s = "";
        for (int i = 0; i < cryptotext.length(); i++) {
            s = s + decrypt(cryptotext.charAt(i));
        } 
        return s;
    }
}