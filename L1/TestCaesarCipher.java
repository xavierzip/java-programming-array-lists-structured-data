
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class TestCaesarCipher {
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
    private String breakCaesarCipher(String input){
    	int key = maxIndex(countLetters(input))+'a'-'e';
    	CaesarCipher2 cc = new CaesarCipher2(key);
    	return cc.decrypt(input);
    }

	public void simpleTests(){
		FileResource resource = new FileResource("data/mysteryTwoKeysQuiz.txt");
		String message = resource.lines().iterator().next();
		System.out.println("org: "+message);
		CaesarCipher2 cc = new CaesarCipher2(15);
		String encryptedMessage = cc.encrypt(message);
		System.out.println("enc: "+encryptedMessage);
		String decryptedMessage = cc.decrypt(encryptedMessage);
		System.out.println("dec: "+decryptedMessage);
		String brokenMessage = breakCaesarCipher(message);
		System.out.println("brk: "+brokenMessage);
		for(int key1=0;key1<26;key1++){
			for (int key2=0;key2<26;key2++){
				String encryptedMessage2K = cc.encryptTwoKeyOnce(message, key1, key2);
				System.out.println(key1+","+key2+"="+encryptedMessage2K);
			}
		}
	}
}
