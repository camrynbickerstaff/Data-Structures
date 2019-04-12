import java.util.Scanner;
public class MatchingParentheses {

	public static void main(String[] args)
	{
		String expression;
		ABStack<Integer> stack = new ABStack<Integer>(20);
		Scanner input = new Scanner(System.in);
		
		for(int i = 1; i < 6; i++)
		{
			System.out.print("Enter an expression: ");
			expression = input.nextLine();
			for(int k = 0; k < expression.length(); k++)
			{
				if(expression.charAt(k) == '(')
				{
					stack.push(k);
				}
				else if(expression.charAt(k) == ')')
				{
					if(!stack.isEmpty())
					{
						System.out.print("The left parentheses at index " + stack.pop() + " matches the right parentheses at index " + k + "\n");
					}
					else
					{
						System.out.println("The right parentheses at index " + k + " does not have a matching left parentheses.");
					}
				}
				
				
			}
			while(!stack.isEmpty())
			{
				System.out.println("The left parentheses at index " + stack.pop() + " does not have a matching right parentheses.");
			}
		}

	}

}