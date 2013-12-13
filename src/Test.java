
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Test
{

/**
 * 
 * @author Pim Beuwer en Ralph de Groot
 * Deze class voert tests uit van het programma met behulp van drie verschillende variabelen.
 * De heapgrootte, de grootte van het bestand en het aantal keer dat het programma moet draaien.
 */


	RSHeap rs;
	BufferedReader br;


	/**
	 * 
	 * @param heapsize De grootte van de heap
	 * @param elements De hoeveelheid getallen die in de input moet komen
	 * @param amountOfTests Het aantal keer dat de rest uitgevoerd moet wordens
	 */
	public void runTest(int heapsize, int elements, int amountOfTests)
	{
		// run the test x amount of times
		// make an arraylist of arraylists
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();

		for (int i=1; i<=amountOfTests; i++){
			rs = new RSHeap(heapsize);
			rs.createInputFile(elements);
			rs.createRuns();

			// get the result of the test
			ArrayList<Integer> tmpResult = readRuns();

			// add it to the results
			results.add(tmpResult);
			int runNumber =1;
			System.out.println("test " + i);
			for (Integer run : tmpResult){
				System.out.println(" \t run " + runNumber + " elements: " +run  );
				runNumber ++;
			}
			
		}

		// get the highest amount of runs
		int maxRuns = highestAmountOfRuns(results);
		// calculate and print average
		// create a format which we can easily work with
		int[][] averageHelpList = new int[amountOfTests][maxRuns];
		int firstIndex =-1;
		for (ArrayList<Integer> list : results){
			firstIndex++;
			int secondIndex =-1;
			for (Integer ints : list){
				secondIndex++;
				averageHelpList[firstIndex][secondIndex] = ints; 
			}
		}

		//take the sum of all the results into one array
		int[] average = new int[maxRuns];
		for (int i=0; i<maxRuns; i++){
			for (int a=0; a<amountOfTests; a++ ){
				average[i] += averageHelpList[a][i];
			}
		}

		// divide the sum by the amount of tests and print the result
		System.out.println("\n Average:");
		for (int i=0; i<average.length;i++){
			int tmpInt = average[i];
			tmpInt = (tmpInt/3);
			average[i]=tmpInt;
			System.out.println("\t run "+(i+1)+":"+ tmpInt + " elements" );
		}


		
		
	}

	/**
	 * 
	 * @param tmpList De arraylist met de resultaten
	 * @return Het hoogste aantal aan runs
	 */
	private int highestAmountOfRuns(ArrayList<ArrayList<Integer>> tmpList){
		int max =0;
		for (ArrayList<Integer> a : tmpList){
			int counter = 0;
			for (Integer b : a){
				counter++;
				if (counter> max){
					max = counter;
				}
			}
		}

		return max;
	}

	
	private ArrayList<Integer> readRuns(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		try {
			String line;
			for (String s : rs.getRunFileNames()){
				int elementCounter = 0;
				br = new BufferedReader(new FileReader(new File(s)));
				while((line = br.readLine()) != null ){
					elementCounter++;
				}
				result.add(elementCounter);
				br.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

}
