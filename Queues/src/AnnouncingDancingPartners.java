import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class AnnouncingDancingPartners 
{

	public static void main(String[] args) throws IOException 
	{

		String dancer;
		CQueue<String> maleQueue = new CQueue<String>();
		CQueue<String> femaleQueue = new CQueue<String>();
		Scanner infile = new Scanner( new File( "dancers.txt"));
		
		while( infile.hasNextLine()) 
		{
			dancer = infile.nextLine();
			if(dancer.charAt(0) == 'F')
			{
				femaleQueue.enqueue(dancer.substring(2));
			}
			else if(dancer.charAt(0) == 'M')
			{
				maleQueue.enqueue(dancer.substring(2));
			}
			
			
		}
		
		System.out.println( "Announcing Dancers: " + femaleQueue + " " + maleQueue);
		
		while(!femaleQueue.isEmpty() && !maleQueue.isEmpty())
		{
			System.out.println(femaleQueue.dequeue() + " will be dancing with " + maleQueue.dequeue());
		}
		int i = 0; 
		while(!femaleQueue.isEmpty() || !maleQueue.isEmpty())
		{
			if(i == 0)
				System.out.println("The following need to wait: ");
			if(femaleQueue.isEmpty())
				System.out.println(maleQueue.dequeue());
			else
				System.out.println(femaleQueue.dequeue());
			i++;
		}
		infile.close();
		return;
	}
}