import java.util.Scanner;
public class DecimalToBinary 
{

	public static void main(String[] args)
	{
		/*int x;
		Scanner keyboard = new Scanner(System.in);
		for(int i = 1; i <=5; i++)
		{
			System.out.println("Enter a positive integer: ");
			x = keyboard.nextInt();
			if(x >= 0)
			{
				convert(x);
			}
			else 
			{
				System.out.println(x + " is negative.");
			}
		}
		keyboard.close();
		return;
*/
		ABStack stack = new ABStack();
		stack.push(4);
		stack.push(6);
		stack.push(8);
		ABStack b = stack.copy();
		System.out.println("B: " + b);
		ABStack c = new ABStack(stack);
		b.push(9);
		System.out.println(b);
		c.push(7);
		System.out.println(c + " " + b);
		
		//System.out.println(stack);
		//System.out.println(b);
		b.push(8);
		b.push(9);
		System.out.println(" B: " + b);
		//c.push(7);
		System.out.println("C: " + c);
		c.copy(b);

		System.out.println("C: " + c);
		c.push(8);
		stack.push(9);
		System.out.println("C: " + c);
		System.out.println("Stack: " + stack);
		
		System.out.println(stack == b);
	}
	
	public static void convert(int num)
	{
		int rem;
		ABStack<Integer> stack = new ABStack<Integer>();
		
		while(num > 0)
		{
			rem = num%2;
			stack.push(rem);
			num = num/2;
		}
		while(!stack.isEmpty())
		{
			System.out.print(stack.pop());
		}
		System.out.println();
		return;
	}

}