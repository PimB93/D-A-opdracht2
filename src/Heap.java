import java.util.Arrays;


public class Heap {
	private int []theHeap;
	private int maxsize;
	private int size;
	

	public Heap(int max)
	{
		maxsize = max;
		theHeap = new int[maxsize];
		size = 0;
	}
	
	
	
	private int parent(int pos)
	{
		//Want parent staat altijd op de locatie van: child / 2
		return pos / 2;
	}
	
	private int leftchild(int pos)
	{
		//Want leftchild staat altijd op locatie van: pos*2
		return 2*pos;
	}
	
	
	
	private boolean isleaf(int pos) 
	{
		//Als onderstaande waar is, dan moet de pos wel een leaf zijn
		return ((pos > size/2) && (pos <= size));
	}
	
	private void swap(int i,int y)
	{
		int temp = theHeap[i];
		theHeap[i] = theHeap[y];
		theHeap[y] = temp;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public int getMin()
	{
		return theHeap[0];
	}
	
	public void setMin(int minimal)
	{
		theHeap[0] = minimal;
	}
	
	public void setElement(int index, int element)
	{
		theHeap[index] = element;
	}
	
	public int getElement(int index)
	{
		return theHeap[index];
	}
	
	public void moveToDeadSpace()
	{
		size--;
	}
	
	
	
	public int[] getArray()
	{
		return theHeap;
	}
	
	public void bubbledown(int pos)
	{
		int smallestchild;
		//Zolang hij nog niet bij de laatste leaf is
		while(!isleaf(pos))
		{
			smallestchild = leftchild(pos);
			if((smallestchild < size) && (theHeap[smallestchild] > theHeap[smallestchild +1]))
			{
				smallestchild = smallestchild + 1;
			}
			if(theHeap[pos] <= theHeap[smallestchild])
			{
				return;
			}
				swap(pos, smallestchild);
					pos = smallestchild;
			
		}
	}
	public void insert( int element)
	{
		size++;
		theHeap[size] = element;
		int position = size;
		//printArray(heapToBuild);

		//Zolang de invoer kleiner is moet er geswapped tot de invoer op de juiste plek staat. De parent moet immers kleiner zijn dan haar kinderen
		while(theHeap[position] < theHeap[parent(position)])
		{
			//Er wordt geswapped in de heap
			swap(position, parent(position));
			//De position wordt de parent
			position = parent(position);
			//printArray(theHeap);
		}
		//printArray(theHeap);

		
	}
}