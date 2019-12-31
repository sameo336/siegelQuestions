package siegelQuestions;
import java.util.Arrays;

public class MergeSort {
	
	Integer [] example;

	public Integer[] merge(Integer [] merged,Integer [] left, Integer [] right){
		
		int i=0;
		int j=0;
		int k=0;
		while (i<=left.length-1 && j<=right.length-1){
		
			if (left[i] >= right[j]){
				merged[k]=right[j];
				k++;
				j++;
			}
			else{
				merged[k]=left[i];
				k++;
				i++;
			
			}
		}
		
		while (i<=left.length-1){	
			merged[k]=left[i];
			k++;i++;
		}
		while(j <= right.length-1) {
			merged[k]=right[j];
			k++;j++;
		}
		
		return merged;
	
	
	} 
	
	
	public Integer[] sort(Integer[] example,int l,int r){
	
		if (r-l ==0) {
			int value= example[r];
			Integer [] retVal= new Integer[] {value};
			return retVal;
		}
			
		int m= (l+r)/2;
		
		Integer[] L= sort(example, l,m);
		Integer[] R= sort(example, m+1,r);
		return merge(Arrays.copyOfRange(example,l,r+1),L,R);
		
	
	}
	
	public static void main (String args[]){
	
		MergeSort test = new MergeSort();
		test.example = new Integer[] {100,15,10,25,30,10};
		System.out.println(test.example);
		int i=0;
		while (i<=test.example.length-1) {
			System.out.println("Index no: "+i + " "+test.example[i]);
			i++;
		}
		
		test.example= test.sort(test.example,0,test.example.length-1);
		
		i=0;
		while (i<=test.example.length-1) {
			System.out.println("Index no: "+i + " "+test.example[i]);
			i++;
		}
		
	}

}
