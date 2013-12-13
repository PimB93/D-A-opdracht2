
import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Test;

public class HeapTest 
{
	@Test 
	public void HeapGoed()
	{
		FileGen file = new FileGen();
	    int[] getallen = new int[1000];
	    getallen = file.generate(1000, "temp.txt");
		for(int i=0; i< getallen.length; i++)
		{
			System.out.println(getallen[i]);
		}
	    RSHeap heap;
	    heap = new RSHeap(1000);
	    heap.createInputFile(1000);
	    heap.createRuns();
	
	  

		

		
	}
	@Test (expected= AssertionError.class)
	public void fileFouteInput()
	{
		FileGen file = new FileGen();
	    int[] getallen = new int[1000];
	    getallen = file.generate(1000, "temp.txt");
		for(int i=0; i< getallen.length; i++)
		{
			System.out.println(getallen[i]);
		}
	    RSHeap heap;
	    heap = new RSHeap(-1);
	    heap.createInputFile(1000);
	    heap.createRuns();
	}

}
