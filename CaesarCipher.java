
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class CaesarCipher {
    public String encrypt(String input, int key){
        StringBuilder inString = new StringBuilder(input);
        for(int i=0;i<input.length();i++){
            char newCh = encryptChar(inString.charAt(i), key);
            if(newCh != '.'){
                inString.setCharAt(i, newCh);
            }
        }
        return inString.toString();
    }
    private char encryptChar(char ch, int key){
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String keyAlphabets = alphabets.substring(key) + alphabets.substring(0,key);
        int idx = alphabets.indexOf(ch);
        if(idx != -1){
            return keyAlphabets.charAt(idx);
        }else{
            idx = alphabets.indexOf(Character.toUpperCase(ch));
            if(idx != -1){
                return Character.toLowerCase(keyAlphabets.charAt(idx));
            }
        }
        return '.';
    }
    public String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder inString = new StringBuilder(input);
        for(int i=0;i<input.length();i++){
            char newCh;
            if(i%2 == 0){
                 newCh = encryptChar(inString.charAt(i), key1);
            }else{
                 newCh = encryptChar(inString.charAt(i), key2);
            }           
            if(newCh != '.'){
                inString.setCharAt(i, newCh);
            }
        }
        return inString.toString();        
    }
    public void testCaesar(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        System.out.println(encryptTwoKeys(message, 8, 21));
    }
}
