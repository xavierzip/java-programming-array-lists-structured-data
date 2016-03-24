
/**
 * Write a description of CaesarCipher2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class CaesarCipher2 {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    public CaesarCipher2(int key){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        mainKey = key;
    }
    
    public String encrypt(String input){
        StringBuilder inString = new StringBuilder(input);
        for(int i=0;i<input.length();i++){
            char oldCh = input.charAt(i);
            if(Character.isLetter(oldCh)){
                char newCh = shiftedAlphabet.charAt(alphabet.indexOf(Character.toUpperCase(oldCh)));
                if(Character.isLowerCase(oldCh)){
                    inString.setCharAt(i, Character.toLowerCase(newCh));
                }else{
                    inString.setCharAt(i, newCh);
                }
            }
        }
        return inString.toString();
    }

    public String decrypt(String input){
        CaesarCipher2 cc = new CaesarCipher2(26 - mainKey);
        return cc.encrypt(input);
    }

    public String encryptTwoKeyOnce(String input, int key1, int key2){
        CaesarCipher2 cc_key1 = new CaesarCipher2(key1);
        CaesarCipher2 cc_key2 = new CaesarCipher2(key2);
        String encrypted_key1 = cc_key1.encrypt(input);
        String encrypted_key2 = cc_key2.encrypt(input);
        StringBuilder inString = new StringBuilder(input);
        for(int i=0;i<input.length();i++){
            if(i%2==0){
                inString.setCharAt(i, encrypted_key1.charAt(i));
            }else{
                inString.setCharAt(i, encrypted_key2.charAt(i));
            }
        }
        return inString.toString();
    }
}
