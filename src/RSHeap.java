import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Pim Beuwer en Ralph de Groot
 * Deze class bevat methodes die een Replacement Selection kunnen uitvoeren op een minheap. 
 * De minheap wordt opgeslagen in een Heap object. In de Heap class staan de methodes die gebruikt kunnen worden met de minheap.
 * Het doel van de class is om willekeurige getallen in een minheap te krijgen waarna Replacement Selection wordt uitgevoerd. 
 * De geordene getallen worden vervolgens weggeschreven in output file.
 *
 */
public class RSHeap
{
	private int[] input;
	private Heap theHeap;		
	private int inputIndex = 0;
	private int heapSize = 5;
	private FileGen filegen;	
	private BufferedWriter bw;	
	private ArrayList<String> runFileNames;
	
	/**
	 * 
	 * @param N De size van de heap
	 * Variabelen worden hier geïnitialiseerd
	 */
	public RSHeap(int N)
	{
		assert N >0 : "ongeldige waarde";
		heapSize = N;
		input = new int[N];
		this.theHeap = new Heap(heapSize);		
		filegen = new FileGen();
		runFileNames = new ArrayList<String>();		
		
		
		
	}
	/**
	 * 
	 * @param N de size van de heap
	 * Deze methode maakt een inputfile met random getallen
	 */
	public void createInputFile(int N)
	{
		input = filegen.generate(N, "numbers.txt");
	}
	
	
	/**
	 * Deze methode doet de runs als het ware. Ook wordt hier RS uitgevoerd.
	 * De pseudocode voor RS is hier te vinden: http://scis.athabascau.ca/html/lo/repos/comp272/applets/replacement/index.html
	 */
	public void createRuns()
	{
		int runNr = 0;
		
	
		//while IN is not empty
		while(!inputEmpty())
		{
			
			theHeap = buildHeap();			
			runNr++;
			String fileName = "run " + runNr +".txt";
			bw = initWriter(fileName);
			
			//Zolang er nog elementen gelezen kunnen worden en er bestaan nog elementen 
			while(theHeap.getSize() > -1 && !inputEmpty())
			{
				int next = getNext();
				
				//Root gaat naar de output
				writeToFile(bw, theHeap.getMin());

				
				//Als next groter is dan de root, sla het dan op als root
				if(next >= theHeap.getMin())
				{
					theHeap.setMin(next);
				}
				else
				{
					//Element is dus kleiner dan de root, daarom wordt laatste element als root gezet
					theHeap.setElement(0, theHeap.getElement(theHeap.getSize()));
					//Op de oude locatie wordt het volgende element geplaatst
					theHeap.setElement(theHeap.getSize(), next);
					//Laatste is deadspace
					theHeap.moveToDeadSpace();
				}
				//Heap wordt weer als minheap ingesteld
				theHeap.bubbledown(0);
				
			}
			
		}
		
		
	}
	
			

	/**
	 * 
	 * @return De nieuwe heap die gemaakt is met de oude heap en de insert methode
	 */
	public Heap buildHeap()
	{
		Heap oldHeap = theHeap;
		Heap newHeap = new Heap(heapSize);		
		
		int nrOfElements = 0;
		//Bekijk of het eerste aangemaakte heap is
		if(oldHeap != null)
		{
			//als het een deadspace heeft doe dan dit
			if(oldHeap.getSize() != oldHeap.getArray().length)
			{
				for(int i = oldHeap.getSize() + 1; i < oldHeap.getArray().length - 1; i++)
				{
					newHeap.insert(oldHeap.getArray()[i]);
					nrOfElements++;
				}
			}
		}
		
		for(int i = nrOfElements; i < heapSize - 1; i++)
		{
			newHeap.insert(getNext());
			nrOfElements++;
			
		}
		return newHeap;
	}
	
	
		
	/**
	 * 
	 * @return Het volgende getal uit de inputfile
	 */
	private int getNext()
	{
		int temp = input[inputIndex];
		inputIndex++;
		return temp;
	}
	
	/**
	 * 
	 * @return Een lijst met alle filenamen 
	 */
	public ArrayList<String> getRunFileNames()
	{
		return runFileNames;
	}
	
	/**]
	 * 
	 * @param fileName De naam van de file die een writer krijgt
	 * @return
	 */
	public BufferedWriter initWriter(String fileName)
	{
		assert fileName !=null : "filename mag niet leeg zijn";
		try {

			bw = new BufferedWriter(new FileWriter(new File(fileName)));
			runFileNames.add(fileName);
			System.out.println("new run started, now writing to: " + fileName);
			return bw;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param bw De writer van de file
	 * @param element Het getal die weggeschreven moet worden
	 */
	public void writeToFile(BufferedWriter bw, int element)
	{
		assert bw !=null : "writer mag niet null zijn";
		//assert element > 0 : "element is ongeldig";
		try {
			bw.write(Integer.toString(element));
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return True als de input leeg is en false dat niet zo is
	 */
	private boolean inputEmpty()
	{
		if(input.length  == inputIndex + 1)
		{
			return true;
		}
		else
		{
		return false;
		}
	}
	
}
