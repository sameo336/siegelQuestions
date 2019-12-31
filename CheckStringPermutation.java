package siegelQuestions;
/*
 * time = O(N)
 * space = O(1)
 * 
 * */


public class CheckStringPermutation {
	
	public boolean checkStringPer(String text, String pattern) {
		
		if (text.length() != pattern.length())
		{
			return false;
		}
		
		int [] check = new int [256];
		
		for (int i=0; i<text.length();i++){
		
			check[text.charAt(i)]++;
		}
		
		for (int i=0; i<check.length;i++){
			if(check[i]>0) 
				System.out.println(i + " " +check[i]);
		}
		
		for (int i=0; i<pattern.length();i++){
		
			check[pattern.charAt(i)]--;
			
			if (check[pattern.charAt(i)]==-1){
				return false;
			}
		}
		
		return true;
	
	}
	
	
	public static void main (String args []) {
		
		CheckStringPermutation test = new CheckStringPermutation();
		
		String text = "aabbaacc";
		String pattern = "aaaccbba";
		
		if(test.checkStringPer( text,  pattern)){
			System.out.println("They are a permutations");
		}
		else
			System.out.println("Not a permutation");
	}

}


