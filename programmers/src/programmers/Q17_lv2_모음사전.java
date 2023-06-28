package programmers;

import java.util.ArrayList;
import java.util.List;

public class Q17_lv2_모음사전 {
	private static final char[] CHARS = "AEIOU".toCharArray();
	
	/* public int solution(String word) {
        return generate("").indexOf(word);
    }
	
	private List<String> generate(String word){
		List<String> words = new ArrayList<>();
		words.add(word);
		
		if(word.length() == 5) return words;
		
		for(char c : CHARS)
			words.addAll(generate(word+c));
		
		return words;
	} */
	
	public int solution(String word) {
		List<String> words = new ArrayList<>();
        generate("", words);
        return words.indexOf(word);
    }
	
	private void generate(String word, List<String> words){
		words.add(word);
		
		if(word.length() == 5) return;
		
		for(char c : CHARS)
			generate(word+c, words);
	}
}