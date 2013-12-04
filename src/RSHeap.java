import java.util.Arrays;


public class RSHeap {
	private int[] unsortedArray;
	private int[] theHeap;
	private int size;
	
	public RSHeap(int[] unsortedArray)
	{
		this.unsortedArray = unsortedArray;
		// -1 zodat hij op locatie 0 kan beginnen in de insert methode
		size = -1;
		
		theHeap = new int[unsortedArray.length ];
	
		sortHeap();
		// een uitkomst: [0, 9, 13, 43, 17, 16, 62, 48, 69, 44, 33].. Klopt volgens mij
		
		
		
	}
	
	public void sortHeap()
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
		printHeap();
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
		//Want parent staat altijd op de locatie van: child / 2
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
