
import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Test;

public class FilegenTest 
{
	@Test 
	public void fileGoed()
	{
		FileGen file = new FileGen();
	    int[] getallen = new int[1000];
	    getallen = file.generate(1000, "temp.txt");
		
	
	}
	@Test (expected= AssertionError.class)
	public void fileFouteInput()
	{
		FileGen file = new FileGen();
	    int[] getallen = new int[1000];
	    getallen = file.generate(-1, "temp.txt");
	}
	@Test (expected= AssertionError.class)
	public void fileOngeldig()
	{
		FileGen file = new FileGen();
	    int[] getallen = new int[1000];
	    getallen = file.generate(1000, ".");
	}
}







