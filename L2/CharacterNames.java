
/**
 * Write a description of CharacterNames here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.ArrayList;

public class CharacterNames {
	private ArrayList<String> characters;
	private ArrayList<Integer> freqs;
	private int totalCharacters;

	public CharacterNames(){
		characters = new ArrayList<String>();
		freqs = new ArrayList<Integer>();
		totalCharacters = 0;
	}

	public void findCharacters(){
		FileResource sourceFile = new FileResource();
		for(String line : sourceFile.lines()){
			int idxPeriod = line.indexOf('.');
			if(idxPeriod != -1){
				line = line.substring(0, idxPeriod);
				line = line.trim();
				int idxCharacter = characters.indexOf(line);
				if(idxCharacter == -1){
					characters.add(line);
					freqs.add(1);
				}else{
					int count = freqs.get(idxCharacter);
					freqs.set(idxCharacter, count+1);
				}
			}
		}
	}

	public void listCharacters(){
		for(int i=0;i<characters.size();i++){
			int count = freqs.get(i);
			if(count > 1){
				System.out.println(freqs.get(i)+"\t"+characters.get(i));
			}
		}
	}

	public void tester(){
		CharacterNames cn = new CharacterNames();
		cn.findCharacters();
		cn.listCharacters();
	}
}
