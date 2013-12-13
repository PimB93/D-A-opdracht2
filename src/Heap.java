import java.util.Arrays;

/**
 * 
 * @author Pim Beuwer en Ralph de Groot
 * Deze class bevat alle methodes die gebruikt kunnen worden voor de minheap. 
 */
public class Heap {
	private int []theHeap;
	private int maxsize;
	private int size;
	
	/**
	 * 
	 * @param max De maximale grootte van de heap
	 */
	public Heap(int max)
	{
		maxsize = max;
		theHeap = new int[maxsize];
		size = 0;
	}
	
	
	/**
	 * 
	 * @param pos De positie in de heap
	 * @return	De parent van de positie
	 */
	private int parent(int pos)
	{
		//Want parent staat altijd op de locatie van: child / 2
		return pos / 2;
	}
	
	/**
	 * 
	 * @param pos De positie in de heap
	 * @return Het linkerkind van de positie
	 */
	private int leftchild(int pos)
	{
		//Want leftchild staat altijd op locatie van: pos*2
		return 2*pos;
	}
	
	
	/**
	 * 
	 * @param pos De positie in de heap
	 * @return True als de positie een leaf is en false als dat niet zo is
	 */
	private boolean isleaf(int pos) 
	{
		//Als onderstaande waar is, dan moet de pos wel een leaf zijn
		return ((pos > size/2) && (pos <= size));
	}
	
	/**
	 * 
	 * @param i De eerste positie die geswapped moet worden met de tweede
	 * @param y De tweede positie die geswapped moet worden met de eerste
	 */
	private void swap(int i,int y)
	{
		int temp = theHeap[i];
		theHeap[i] = theHeap[y];
		theHeap[y] = temp;
	}
	
	/**
	 * 
	 * @return De grote van de heap
	 */
	public int getSize()
	{
		return size;
	}
	
	/**
	 * 
	 * @return Het getal dat op de eerste positie van de heap staat
	 */
	public int getMin()
	{
		return theHeap[0];
	}
	
	/** 
	 * 
	 * @param minimal Het getal dat de plek moet innemen op de eerste positie van de heap
	 */
	public void setMin(int minimal)
	{
		theHeap[0] = minimal;
	}
	
	/**
	 * 
	 * @param index Het getal die de positie in de heap voorstelt
	 * @param element Het getal dat op die positie opgslagen moet worden
	 */
	public void setElement(int index, int element)
	{
		theHeap[index] = element;
	}
	
	/**
	 * 
	 * @param index Het getal die de positie in de heap voorstelt
	 * @return Het getal dat op die positie opgeslagen is
	 */
	public int getElement(int index)
	{
		return theHeap[index];
	}
	
	/**
	 * Verminderd de grote van de heap met 1
	 */
	public void moveToDeadSpace()
	{
		size--;
	}
	
	/**
	 * 
	 * @return De heap in arrayvorm, oftewel methodes van een array kunnen dan op de heap aangeroepen worden
	 */	
	public int[] getArray()
	{
		return theHeap;
	}
	
	/**
	 * 
	 * @param pos De positie in de heap die een nieuw element moet krijgen
	 * In onze uitwerking is dat altijd 0. Dus deze methode zorgt ervoor dat het kleinste element in de heap op de eerste locatie van de heap komt
	 */
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
	
	/**
	 * 
	 * @param element Het element dat in de heap moet komen op de juiste plek
	 */
	public void insert( int element)
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
			
		}
		
		
	}
}