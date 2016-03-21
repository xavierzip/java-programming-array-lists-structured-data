
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarBreaker {
    private int[] countLetters(String message){
        int[] counts = new int[26];
        for(int i=0;i<message.length();i++){
            if(Character.isLetter(message.charAt(i))){
                counts[Character.toLowerCase(message.charAt(i))-'a']++;
            }
        }
        return counts;
    }
    private int maxIndex(int[] counts){
        int max=0, idx=0;
        for(int i=0;i<counts.length;i++){
            if(counts[i]>max){
                idx = i;
                max = counts[i];
            }
        } 
        return idx;
    }
    public String decrypt(String message){
        int key = maxIndex(countLetters(message))+'a'-'e';
        CaesarCipher cc = new CaesarCipher();
        return cc.encrypt(message, 26-key);
    }
    private String halfOfString(String message, int start){
        StringBuilder newString = new StringBuilder();
        for(int i=0;i<message.length();i++){
            if(i%2 == start){
                newString.append(message.charAt(i));
            }
        }
        return newString.toString();
    }
    public String decryptTwoKeys(String encrypted){
        int key1 = maxIndex(countLetters(halfOfString(encrypted, 0)))+'a'-'e';
        int key2 = maxIndex(countLetters(halfOfString(encrypted, 1)))+'a'-'e';
        key1 = (key1+26)%26;
        key2 = (key2+26)%26;
        CaesarCipher cc = new CaesarCipher();
        System.out.println("key1:"+key1+"|key2:"+key2);
        return cc.encryptTwoKeys(encrypted, 26-key1, 26-key2);
    }
    public void testDecrypt(){
        String testMessage = "Just a test string with lots of eeeeeeeeeeeeeeeees";
        CaesarCipher cc = new CaesarCipher();
        String encrypted = cc.encryptTwoKeys(testMessage, 23, 2);
        System.out.println("Encrypted: "+ encrypted);
        System.out.println(decryptTwoKeys(encrypted));
        
    }
}
