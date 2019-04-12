import java.util.Scanner;

public class Sieve 
{
	public static void main(String[] args)
	{
		String run = "yes";
		Scanner input = new Scanner(System.in);
		while(run.contentEquals("yes"))
		{	
			int n = 0; 
			System.out.print("I will find the prime numbers between 2 and n. What do you want n to be?");
			while(n <= 2)
			{
				n = input.nextInt();
				if(n <= 2)
				{
					System.out.print("Please enter a number greater than 2");
				}
			}
		
			CQueue<Integer> numbers = new CQueue<Integer>();
			CQueue<Integer> numbers2 = new CQueue<Integer>();
			for(int i = 2; i <= n; i++)
			{
				numbers.enqueue(i);
			}
			//System.out.println(numbers);
			ABQueue<Integer> primes = new ABQueue<Integer>();
			int t = 0;
			int i = 0;
			while(!numbers.isEmpty() || !numbers2.isEmpty())
			{
				//System.out.println(primes);
				if(i%2 == 0 && !numbers.isEmpty())
				{
					//System.out.println(numbers);
					if(numbers.peekAtBack() == null)
					{
						break;
					}
					t = numbers.dequeue();
					primes.enqueue(t);
					while(!numbers.isEmpty())
					{
						int num = numbers.dequeue();
						if(num%t != 0)
						{
							numbers2.enqueue(num);
						}
					}
					//System.out.println(numbers2);
				}
				else
				{
					
					t = numbers2.dequeue();
					primes.enqueue(t);
					while(!numbers2.isEmpty())
					{
						if(numbers2.peekAtBack() == null)
						{
							break;
						}
						int num = numbers2.dequeue();
						if(num%t != 0)
						{
							numbers.enqueue(num);
						}
					}
				}
				i++;
			}
			System.out.println("\n\nThese are the prime numbers from 2 to " + n +":\n\n");
			int sum = 0;
			double product = 1;
			while(!primes.isEmpty())
			{
				for(int k = 0; k < 10; k++)
				{
					if(!primes.isEmpty())
					{
						int a = primes.dequeue();
						sum = sum + a;
						product = product*a;
						System.out.print(a + " ");
					}
				}
				System.out.println();
			}	
			
			System.out.println("\n\nNow I will do some extra calculations with the prime numbers that I found: \n");
			System.out.println("The sum of all of the prime numbers from 2 to " + n + " is " + sum);
			System.out.println("The product of all of the prime numbers from 2 to " + n + " is " + product);
			
			
			System.out.println("\n\nWould you like to run this program again? Type \"yes\" if you want to or anything else for no: ");
			run = input.next();	
			run = run.toLowerCase();
		}
		System.out.println("Thanks for running my program, bye!");
		input.close();
	}
}