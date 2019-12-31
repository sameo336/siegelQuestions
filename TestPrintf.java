package siegelQuestions;
/* checking time complexity of printf ...it is  O(N)*/
public class TestPrintf {

	
	public static void main(String args []) {
		long startTime = System.nanoTime();

		/*for(int i = 0;i < 100000;++i)
		    System.out.println("a");*/
		
		for(int i = 0;i < 100000;++i)
		System.out.println("asdhasdyasiluftyiufhiuasydfujshaskljdaklsdhkajsasdjhakjshakjsfgajskgjfgdsajfgasdkjgadviuasgdfmnasdbfjgsdyjakdhggggggggcjhasdfjkgsjkdfgsdfhgdsfdsfgalsdkjfdhkagsdjkasdjd");
		
		
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(totalTime/1_000_000_000);
	}
}
