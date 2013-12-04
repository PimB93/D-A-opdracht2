import java.util.Arrays;


public class RSHeap {
	private int[] unsortedArray;
	private int[] theHeap;
	private int size;
	
	public RSHeap(int[] unsortedArray)
	{
		this.unsortedArray = unsortedArray;
		size = 0;
		//Dit wordt +1 door de arraygrens
		theHeap = new int[unsortedArray.length + 1];
	
		sortArray();
		// een uitkomst: [0, 9, 13, 43, 17, 16, 62, 48, 69, 44, 33].. Klopt volgens mij
		
		
		
	}
	
	public void sortArray()
	{
		for(int i = 0; i < unsortedArray.length; i++)
		{
			insert(unsortedArray[i]);
		}
		printHeap();
	}
	
	public void insert(int element)
	{
		size++;
		theHeap[size] = element;
		int position = size;
		
		//Zolang de invoer kleiner is moet er geswapped tot de invoer op de juiste plek staat. De parent moet immers kleiner zijn dan haar kinderen
		while(theHeap[position] < theHeap[parent(position)])
		{
			//Er wordt geswapped in de heap
			swap(position, parent(position));
			//De position wordt de parent
			position = parent(position);
			printHeap();
		}
		
	}
	
	private int parent(int pos)
	{
		
		return pos / 2;
	}
	
	private void swap(int i,int y)
	{
		int temp = theHeap[i];
		theHeap[i] = theHeap[y];
		theHeap[y] = temp;
	}
	
	private void printHeap()
	{
		System.out.println(Arrays.toString(theHeap));
	}
	
}
