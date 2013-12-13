/**
 * 
 * @author Pim Beuwer en Ralp de Groot
 * Deze class voert opdracht 2 uit
 */
public class Apl {

	/**
	 * @param args
	 * instantieert 4 testen met verschillende input om de N & H te testen en aan te tonen 
	 */
	public static void main(String[] args) 
	{
		//junit tests
		
		//file
		FilegenTest testFile = new FilegenTest();
		testFile.fileGoed();
		//testFile.fileFouteInput();
		//testFile.fileOngeldig();
		
		//heap
		HeapTest testHeap = new HeapTest();
		testHeap.HeapGoed();
		//testHeap.fileFouteInput();
		
		
		Test test = new Test();
		//test1
		System.out.println("test1");
		test.runTest(10, 1000,1);
		
		//test2
		System.out.println("test2");
		test.runTest(10, 500, 1);
		//test3
		System.out.println("test3");
		test.runTest(5, 1000,1);
		//test4
		System.out.println("test4");
		test.runTest(5, 500, 1);
		
		
	}

}
