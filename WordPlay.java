
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
    public boolean isVowel(char ch){
        String vowels = "aeiou";
        int idx = vowels.indexOf(Character.toLowerCase(ch));
        if(idx !=  -1){
            return true;
        }
        return false;
    }
    public String replaceVowels(String phrase, char ch){
        StringBuilder inString = new StringBuilder(phrase);
        for(int i=0;i<phrase.length();i++){
            if(isVowel(inString.charAt(i))){
                inString.setCharAt(i, ch);
            }
        }
        return inString.toString();
    }
    public String emphasize(String phrase, char ch){
        StringBuilder inString = new StringBuilder(phrase);
        for(int i=0;i<phrase.length();i++){
            if(Character.toLowerCase(inString.charAt(i)) == Character.toLowerCase(ch)){
                if(i%2 == 0){
                    inString.setCharAt(i, '*');
                }else{
                    inString.setCharAt(i, '+');
                }
            }
        }
        return inString.toString();
    }
    public void testVowel(){
        for(char in='a';in<'z';in++){
            if(isVowel(in)){
                System.out.println(in+" is a vowel!");
            }
        }
        for(char in='A';in<'Z';in++){
            if(isVowel(in)){
                System.out.println(in+" is a vowel!");
            }
        }
    }
    public void testReplaceVowels(){
        String testCase = "Hello World!";
        System.out.println("Original String: "+ testCase);
        System.out.println("New String: "+replaceVowels(testCase, '*'));
    }
    public void testEmphasize(){
       System.out.println(emphasize("dna ctgaaactga", 'a'));
       System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
    }
}
