import java.util.Scanner;

public class PalindromicDates 
{
	public static void main(String[] args)
	{
		String run = "yes";
		Scanner input = new Scanner(System.in);
		
		LQueue<String> palindromeDates = new LQueue<String>();
		while(run.contentEquals("yes"))
		{	
			while(palindromeDates.size()!=0)
			{
				palindromeDates.dequeue();
			}
			int n = 0; 
			System.out.print("I will find the palindromic dates in any year you give me.\n\nWhat year do you want me to perform this action on?");
			while(n<1000 || n > 9999)
			{
				n = input.nextInt();
				if(n < 1000 || n > 9999)
				{
					System.out.println("\n\nPlease enter a 4 digit number representing a year\n\n");
				}
			}
			LQueue<String> dates = getDates(n);
			String date1;
			while(!dates.isEmpty())
			{
				date1 = dates.dequeue();
				if(isPalindrome(date1))
				{
					palindromeDates.enqueue(date1);
				}
			}
			if(palindromeDates.isEmpty())
			{
				System.out.println("\nThere are not palindromic dates for the year " + n);
			}
			else
			{
				System.out.println("\nThese are the palindromic dates for the year " + n + ":");
				while(!palindromeDates.isEmpty())
				{
					String datep = palindromeDates.dequeue();
					System.out.println("\n\t" + datep.substring(0,2) + "-" + datep.substring(2,4) + "-" + datep.substring(4));
				}
			}
			System.out.println("\n\n\nWould you like to run this program again? Type \"yes\" if you want to or anything else for no: ");
			run = input.next();	
			run = run.toLowerCase();
			System.out.println("\n\n");
		}
		String first = "";
		String last = "";
		String next = "";
		String date4;
		int pal = 0;
		int nextpal = 0;
		int i = 2000;
		while(i<2100)
		{
			LQueue<String> dates21 = getDates(i);
			while(!dates21.isEmpty())
			{
				date4 = dates21.dequeue();
				if(isPalindrome(date4))
				{
					last = date4;
					if(pal == 0)
					{
						first = last;
						pal++;
					}
					//System.out.println(Integer.parseInt(date4.substring(2,4)) + "");
					if(nextpal == 0 && i > 2018)
					{
						if(i == 2019 && Integer.parseInt(date4.substring(0,2)) == 2)
						{
							if(Integer.parseInt(date4.substring(2,4)) > 17)
							{
								next = date4;
							}
						}
						next = date4;
						nextpal++;
					}
				}
				
			}
			i++;
			
		}
		System.out.println("As an extra little treat, I found the earliest palindrome in the 21st century: " + first.substring(0,2) + "-" + first.substring(2,4) + "-" + first.substring(4));
		System.out.println("And I also found the latest palindrome in the 21st century: " + last.substring(0,2) + "-" + last.substring(2,4) + "-" + last.substring(4));
		System.out.println("And I also found the next palindrome in the 21st century: " + next.substring(0,2) + "-" + next.substring(2,4) + "-" + next.substring(4));
	}
	
	public static boolean isLeapYear(int year)
	{
		boolean leap = false;
		
		if(year%4 == 0)
		{
			if(year % 100 != 0)
			{
				leap = true;
			}
			else if(year%400 == 0)
			{
				leap = true;		
			}
		}
		return leap;
		
	}
	
	public static boolean isPalindrome(String date)
	{
		LQueue<String> check = new LQueue<String>();
		String backwardsDate = "";
		for(int i = date.length()-1; i >= 0; i--)
		{
			check.enqueue(date.charAt(i) +"");
		}
		while(!check.isEmpty())
		{
			backwardsDate = backwardsDate + check.dequeue();
		}
		if(backwardsDate.contentEquals(date))
		{
			return true;
		}
		return false;
	}
	
	public static LQueue<String> getDates(int year)
	{
		LQueue<String> dates = new LQueue<String>();
		String date = "";
		int month = 0;
		for(int i = 1; i <= 12; i++)
		{
			date = "";
			month = i;
			int days = 0;
			if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			{
				days = 31;	
			}
			else if(month == 4 || month == 6 || month == 9 || month == 11)
			{
				days = 30;	
			}
			else if(month == 2)
			{
				if(isLeapYear(year)) 
				{
					days = 29;
				}
				else
				{
					days = 28;
				}
			}
			if(month < 10)
			{
				date = date + "0" + month;
			}
			else
			{
				date = date + month;
			}
			for(int j = 1; j <= days; j++)
			{
				date = date.substring(0, 2);
				if(j < 10)
				{
					date = date + "0" + j + year;
					dates.enqueue(date);
				}
				else
				{
					date = date + j+year;
					dates.enqueue(date);
				}
			}
		}
		return dates;
	}

}