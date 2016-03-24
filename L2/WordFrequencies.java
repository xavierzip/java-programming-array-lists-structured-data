
/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.ArrayList;

public class WordFrequencies {
	private ArrayList<String> myWords;
	private ArrayList<Integer> myFreqs;
	private int totalCount;

	public WordFrequencies(){
		myWords = new ArrayList<String>();
		myFreqs = new ArrayList<Integer>();
		totalCount = 0;
	}

	public void findUnique(){
		FileResource sourceFile = new FileResource();
		for(String word : sourceFile.words()){
			totalCount++;
			if(Character.isLetter(word.charAt(0))){
				word = word.toLowerCase();
				if(!Character.isLetter(word.charAt(word.length()-1))){
					word = word.substring(0, word.length()-1);
				}
				int idx = myWords.indexOf(word);
				if(idx == -1){
					myWords.add(word);
					myFreqs.add(1);
				}else{
					int count = myFreqs.get(idx);
					myFreqs.set(idx, count+1);
				}
			}
		}
	}

	public int getUniqueWordCount(){
		return myWords.size();
	}

	public int getTotalWordCount(){
		return totalCount;
	}

	public void listUniqueWord(){
		for(String s:myWords){
			System.out.println(s);
		}
	}

	public void listUniqueWordCount(){
		for(int i=0;i<myWords.size();i++){
			System.out.println(myWords.get(i)+"\t"+myFreqs.get(i));
		}
	}

	public void findIndexOfMax(){
		int max = 0;
		int indexOfMax = 0;
		for(int i=0;i<myFreqs.size();i++){
			if(myFreqs.get(i)>max){
				max = myFreqs.get(i);
				indexOfMax = i;
			}
		}
		System.out.println("Max: \""+myWords.get(indexOfMax)+"\" appears "+myFreqs.get(indexOfMax)+" times!");
	}

	public void tester(){
		WordFrequencies wf = new WordFrequencies();
		wf.findUnique();
		System.out.println("# unique/total: "+wf.getUniqueWordCount()+"/"+wf.getTotalWordCount());
		wf.listUniqueWordCount();
	}
}
