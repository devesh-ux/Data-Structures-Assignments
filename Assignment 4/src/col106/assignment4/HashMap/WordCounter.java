package col106.assignment4.HashMap;

import java.io.IOException;
//import java.util.ArrayList;
import java.util.Vector;

public class WordCounter {
	//char wordarr[];
	
	public WordCounter(){
		
		 
		// write your code here
	}
	
	// ArrayList o1 = new ArrayList();
	
	public int count(String str, String word){
		int count = 0;
		// write your code here
		int j = 0;
		while(j<str.length()) {
			if(str.charAt(j)==word.charAt(0)) {
				int t= 0;
				int k = j;
				//System.out.println("devesuj");
				for(int m = 0;m<word.length();m++) {
					if(k<str.length()&& str.charAt(k) == word.charAt(m) ) {
						t++;
						k++;
						
					}
					else {
						break;
					}
				}
				if(t == word.length()) {
					count++;
					 j++;
				}
				else {
					j = j+1;
				}
				
			}
			else {
				j++;
			}
		}
		
		return count;

	}
//	public static void main(String[] args) throws IOException {
//		WordCounter obj1 = new WordCounter();
//		WordCounterDriverCode.ma();
//	}
}