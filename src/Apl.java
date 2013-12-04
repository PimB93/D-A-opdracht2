import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Apl
{


	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
        Opdracht2 opdr2;
        File invoer = new File("input.txt");
        PrintWriter writer =null;
        Scanner scanner = null;

        try 
        {
             writer = new PrintWriter(invoer);
            
        	 for(int i=0; i< 10; i++)
			 {
				
				 writer.print(Opdracht2.randInt(70));
				 writer.print(", ");
			 }	
        	 
        } 
        catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        finally
        
        {
        	writer.close();
        }
        
      try
      {
    	 scanner = new Scanner(invoer);
     	 scanner.useDelimiter(", ");
     	 String gegevens = "";
     	 boolean eerste=false;
     	 while(scanner.hasNext())
     	 {
     		 if(!eerste)
     		 {
     		 eerste = true;
     		 
     		 gegevens +=  scanner.next();
     		 }
     		 else
     		 {
     			 gegevens += ", " + scanner.next();
     		 }
     	 }
     	 opdr2 = new Opdracht2(gegevens);
      }
      catch(FileNotFoundException e)
      {
    	  e.printStackTrace();
      }
      finally
      {
    	  scanner.close();
      }
	}

}
