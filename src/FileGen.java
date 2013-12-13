import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class that writes random input to a file or generates one if the given file doesn't exist
 * @author 
 *
 */
public class FileGen {
	private int[] input;

	/**
	 * 
	 * @param N the size of the array to write to the file
	 * @param filename the name of the file to write to
	 * @return the array that is generated
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

	private void print(){
		System.out.println("Input {");
		for (int i=0; i< input.length; i++){
			System.out.print(" " + input[i]);
		}
		System.out.println("\n}");
	}

}
