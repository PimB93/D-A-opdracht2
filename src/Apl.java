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
		
		Test test = new Test();
		Test test2 = new Test();
		Test test3 = new Test();
		Test test4 = new Test();
		//test1
		test.runTest(10, 1000, 10);
		//test2
		test2.runTest(10, 500, 10);
		//test3
		test3.runTest(5, 1000, 5);
		//test4
		test4.runTest(5, 500, 5);
	}

}
