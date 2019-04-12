import java.io.File;

import java.util.Scanner;

public class TrackingOnlineAuction {

	public static void main(String[] args) throws Exception 
	{
		// Reading the text file
		File file = new File("bids.txt");
		Scanner input = new Scanner(file);
		
		ABStack<String> names = new ABStack<String>();
		ABStack<Integer> bids = new ABStack<Integer>();
		ABStack<Integer> maxBid = new ABStack<Integer>();
		int highBid = 0;
		int curBid;
		String bidder;
		System.out.println("New Bid		Result			High Bidder	High Bid	Maximum Bid");
		System.out.println("--------------------------------------------------------------------------------------");
		while(input.hasNextInt())
		{	
			curBid = input.nextInt();
			bidder = input.next();
			System.out.print(curBid + " " + bidder);

			if(bids.isEmpty())
			{
				if(curBid != 0)
				{
					bids.push(1);
				}
				maxBid.push(curBid);
				names.push(bidder);
				System.out.println("\t\tNew High Bidder\t\t" + names.peek() + "\t\t" + bids.peek() + "\t\t" + maxBid.peek());
			}
			else if(curBid > maxBid.peek())
			{
				//System.out.println("hi" + bidder);
				highBid = maxBid.peek() + 1;
				bids.push(highBid);
				maxBid.push(curBid);
				names.push(bidder);
				System.out.println("\t\tNew High Bidder\t\t" + names.peek() + "\t\t" + highBid + "\t\t" + maxBid.peek());
			}
			else if(curBid > highBid && curBid < maxBid.peek())
			{
				highBid = curBid;
				bids.push(highBid);
				maxBid.push(maxBid.peek());
				names.push(names.peek());
				System.out.println("\t\tHigh Bid Increased\t" + names.peek() + "\t\t" + highBid + "\t\t" + maxBid.peek());
			}
			else
			{
				System.out.println("\t\tNo Change\t\t" + names.peek() + "\t\t" + highBid + "\t\t" + maxBid.peek());
			}

			
	
		}
		System.out.println("\nThe bid history for this auction is:");
		while(!bids.isEmpty())
		{
			System.out.println(names.pop() + "\t" + bids.pop());
		}

	}

}