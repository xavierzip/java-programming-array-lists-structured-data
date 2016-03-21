
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class WordLengths {
    public int[] countWordLengths(FileResource resource, int[] counts){
        for(String word : resource.words()){
            int count = word.length();
            if(!Character.isLetter(word.charAt(0))){
                count--;
            }
            if(!Character.isLetter(word.charAt(word.length()-1))){
                count--;
            }
            if(count>counts.length){
                counts[counts.length-1]++;
            }else{
                counts[count]++;
            }
            System.out.println(word+":"+count);
        }
        return counts;
    }
    public void testCountWordLengths(){
        FileResource resource = new FileResource("data/smallHamlet.txt");
        int[] counts = new int[31];
        countWordLengths(resource, counts);
        for(int i=0;i<counts.length;i++){
            System.out.println(i+": "+counts[i]);
        }
    }
}
