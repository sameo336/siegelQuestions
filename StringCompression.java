package siegelQuestions;

import java.util.HashMap;

public class StringCompression {

	
	public String stringCompress(String text) {
		
		int size = text.length();
		HashMap <Integer,String > frequency = new HashMap(size);
		
		int index = 0;
		int count = 0;
		int hasmapIndex = 0;
		char current = text.charAt(0);
		while (index < size)
		{
			if (current == text.charAt(index)){
				count++;
			}
			else{
				frequency.put (hasmapIndex, current+Integer.toString(count));
				hasmapIndex++;
				current = text.charAt(index);
				count = 1;
			}
			index++;
		}
		StringBuilder compressedString =  new StringBuilder();
		
		frequency.forEach((k,v) -> compressedString.append(v));
		
		
		return compressedString.toString();
	}
	
	public static void main (String args[]) {
		
		StringCompression test = new StringCompression();
		
		System.out.println(test.stringCompress("aabbcccaa"));
		
		
	}
	
	
}
