import java.util.Random;


public class Opdracht2 
{
	private Opdracht2 opdr2;
	private int[] getallen;
	
	/**
	 * @param args
	 */
	public Opdracht2(String gegevens)
	{
	  String[] aantal = new String[ gegevens.split(", ").length];
      aantal = gegevens.split(", ");
      getallen = new int[aantal.length];
      for(int i =0; i< aantal.length; i++)
      {
    	  try
    	  {
    	  getallen[i] = Integer.parseInt(aantal[i]);
    	  System.out.println(getallen[i]);
    	  }
    	  catch(NumberFormatException e)
    	  {
    		  System.out.println("fout opgetreden op array index: " + i + "waarde is : " + aantal[i]);
    	  }
      }
      RSHeap heap = new RSHeap(getallen);

	}
	/**
	 * 
	 * @param max Het ingevoerde getal die als grenst geldt bij het genereren van een random getal
	 * @return	Een random getal tussen de 0 en max -1 
	 */

	public static int randInt(int max)	
	{
		Random random = new Random();
		//return min + (int)(Math.random() * (max));  // 2 statements??
		return random.nextInt(max);
	}

}
