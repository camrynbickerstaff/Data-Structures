
import java.util.Scanner;
public class Palindromes {

	public static void main(String[] args) 
	{
		String str;
		Scanner keyboard = new Scanner(System.in);
		for(int count = 1; count <= 5; count++)
		{
			System.out.print("Enter your string: ");
			str = keyboard.nextLine();
			if(isPalindrome(str))
			{
				System.out.println(str + " is a palindrome");
			}
			else
				System.out.println(str + " is not a palindrome");
		}
		keyboard.close();

	}
	
	public static boolean isPalindrome(String str)
	{
		LinkedStack<Character> stack = new LinkedStack<Character>();
		str = removeBlanks(str);
		str = str.toUpperCase();
		for(int i = 0; i < str.length(); i++)
		{
			stack.push(str.charAt(i));
		}
		
		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) != stack.pop())
				return false;
		}
		return true;
	}
	
	public static String removeBlanks(String str)
	{
		String noBlank = "";
		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) != ' ')
			{
				noBlank = noBlank + str.charAt(i);
			}
		}
		return noBlank;
	}

}