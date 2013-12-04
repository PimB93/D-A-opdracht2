
public class RSHeap {
	private int[] array;
	
	public RSHeap(int[] unsortedArray)
	{
		array = unsortedArray;
		
	}
	
	public int[] sortLijst()
	{
		//todo
		//sorteer array en geef terug
	}
	private void swap(int i,int y)
	{
		int temp = array[i];
		array[i] = array[y];
		array[y] = temp;
	}
	
}
