
/**
 * Write a description of RandomCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Random;

public class RandomCount {
    public void roll(int turns){
        int[] counts = new int[13];
        Random random = new Random();
        for(int i=0;i<turns;i++){
            int dice1 = random.nextInt(6)+1;
            int dice2 = random.nextInt(6)+1;
            counts[dice1+dice2]++;
        }
        for(int i=2;i<counts.length;i++){
            System.out.println("counts "+i+": "+counts[i]);
        }
    }
}
