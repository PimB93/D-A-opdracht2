import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class RSHeap
{
	private int[] input;
	private Heap theHeap;		
	private int inputIndex = 0;
	private int heapSize = 5;
	private FileGen filegen;	
	private BufferedWriter bw;	
	private ArrayList<String> runFileNames;
	
	public RSHeap(int N)
	{
		assert N <0 : "ongeldige waarde";
		heapSize = N;
		input = new int[N];
		this.theHeap = new Heap(heapSize);		
		filegen = new FileGen();
		runFileNames = new ArrayList<String>();		
		
		
		
	}
	
	public void createInputFile(int N)
	{
		input = filegen.generate(N, "numbers.txt");
	}
	
	public void printArray(int [] arrayToPrint)
	{
		System.out.println(Arrays.toString(arrayToPrint));
	}
	
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
		//Heap is al vaker gebruikt
		for(int i = nrOfElements; i < heapSize - 1; i++)
		{
			newHeap.insert(getNext());
			nrOfElements++;
			//printArray(newHeap);
		}
		return newHeap;
	}
	
	
		
	
	private int getNext()
	{
		int temp = input[inputIndex];
		inputIndex++;
		return temp;
	}
	

	public ArrayList<String> getRunFileNames()
	{
		return runFileNames;
	}
	
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

	public void writeToFile(BufferedWriter bw, int element)
	{
		assert bw !=null : "writer mag niet null zijn";
		assert element < 0 : "element is ongeldig";
		try {
			bw.write(Integer.toString(element));
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
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
