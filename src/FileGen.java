import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * @author Pim Beuwer en Ralph de Groot
 *	Deze class genereert een file met daarin random getallen
 */
public class FileGen {
	private int[] input;

	/**
	 * 
	 * @param N De grootte van de array om naar de file toe te schrijven
	 * @param de naam van de file waar naar geschreven zal worden
	 * @return de inputarray
	 */
	public int[] generate(int N,String filename){
		input = new int[N];
		try {
			PrintWriter fw = new PrintWriter(filename,"UTF-8");
			for (int i = 0; i < N; i++) {
				int r = (int)(Math.random() * N);
				input[i] = r;
				fw.println(Integer.toString(r));
			}
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();	
		}
		print();
		return input;
	}

	/**
	 * Print alle getallen van de input
	 */
	private void print(){
		System.out.println("Input {");
		for (int i=0; i< input.length; i++){
			System.out.print(" " + input[i]);
		}
		System.out.println("\n}");
	}

}
