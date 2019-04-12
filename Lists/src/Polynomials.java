import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Polynomials {
	public static void main(String[] args) throws IOException
	{
		Scanner input = new Scanner( new File( "polynomials.txt"));
		String xs = input.nextLine();
		int x = 0;
		boolean neg = false;
		
		for(int i = 0; i < xs.length(); i++)
		{
			if(xs.charAt(i) == '-')
			{
				neg = true;
				//System.out.println("gethere");
			}
			else
			{
				int power = xs.length() - i-1;
				x = x + (int)((int)(xs.charAt(i)-48)*(Math.pow((10), (double)power)));
			}
		}
		if(neg)
		{
			x = x * (-1);
		}
		//System.out.println(x);
		
		
		
		ABList<Integer> poly1 = stringToList(input.nextLine());
		ABList<Integer> poly2 = stringToList(input.nextLine());
		System.out.println("Program is reading input file to obtain the two polynomials. The two input polynomials are:\n");
		System.out.println("p(x) = " + polyToString(poly1));
		System.out.println("q(x) = " + polyToString(poly2));
		input.close();
		
		System.out.println("\n\nProgram is now performing arithmetic operations on the two polynomials…\n");
		System.out.print(polyToString(poly1) + " + " + polyToString(poly2) + " = ");
		ABList<Integer> answer = addition(poly1, poly2);
		System.out.println(polyToString(answer));
		answer = subtraction(poly1, poly2);
		System.out.println(polyToString(poly1) + " - " + polyToString(poly2) + " = " + polyToString(answer));
		answer = multiply(poly1,poly2);
		System.out.println(polyToString(poly1) + " * " + polyToString(poly2) + " = " + polyToString(answer));
		
		
		System.out.println("\n\nProgram is now evaluating each polynomial using x = " + x + "\n");
		System.out.println("p(" + x + ") = " + evaluation(poly1,x));
		System.out.println("q(" + x + ") = " + evaluation(poly2,x));
		
		
	
		
		
		
	}
	
	public static ABList stringToList(String poly)
	{
		int length = poly.length()/2;
		//System.out.println(poly);
		
		ABList<Integer> toReturn = new ABList<Integer>(length);
		for(int i = 0; i < poly.length(); i = i + 4)
		{
			toReturn.insert((poly.charAt(i))-48);
		}
		//System.out.println(toReturn);
		return toReturn;
		
	}
	public static String polyToString(ABList poly)
	{
		String toReturn = "(";
		for(int i = 0; i < poly.size(); i++)
		{
			if((int)poly.get(i) > 0)
			{
				if(i != 0 && !toReturn.contentEquals("("))
				{
					toReturn = toReturn + " + ";
				}
				if((int)poly.get(i) != 1 || i == 0)
				{
					toReturn = toReturn + poly.get(i);
				}
				if(i > 0)
				{
					toReturn = toReturn + "x";
				}
				if(i>1)
				{
					toReturn = toReturn + "^" + i;
				}
				
			}
			else if(((int) poly.get(i) < 0) && !toReturn.contentEquals("("))
			{
				if(i != 0)
				{
					toReturn = toReturn + " - ";
				}
				if(i == 0)
				{
					toReturn = toReturn + (int)poly.get(i);
				}
				else if((int)poly.get(i) != -1)
				{
					toReturn = toReturn + Math.abs((int)poly.get(i));
				}
				
				if(i > 0)
				{
					toReturn = toReturn + "x";
				}
				if(i>1)
				{
					toReturn = toReturn + "^" + i;
				}
				
			}
		}
		toReturn = toReturn + ")";
		return toReturn;
	}
	
	public static ABList addition(ABList poly1, ABList poly2)
	{
		ABList<Integer> answer;
		int size = 0;
		int min = 0;
		boolean poly1big = false;
		if(poly1.size()>poly2.size())
		{
			answer = new ABList<Integer>(poly1.size()-1);
			size = poly1.size();
			min = poly2.size();	
			poly1big = true;
		}
		else
		{
			answer = new ABList<Integer>(poly2.size()-1);
			size = poly2.size();
			min = poly1.size();
		}

		for(int i = 0; i < size; i++)
		{
			int toAdd = 0;
			if(i < min)
			{
				toAdd = (int)poly1.get(i) + (int)poly2.get(i);
			}
			else if(poly1big)
			{
				toAdd = (int)poly1.get(i);
			}
			else
			{
				toAdd = (int) poly2.get(i);
			}
			answer.insert(toAdd);
		}
		return answer;	
	}
	
	public static ABList subtraction(ABList poly1, ABList poly2)
	{
		ABList<Integer> answer;
		int size = 0;
		int min = 0;
		boolean poly1big = false;
		if(poly1.size()>poly2.size())
		{
			answer = new ABList<Integer>(poly1.size()-1);
			size = poly1.size();
			min = poly2.size();	
			poly1big = true;
		}
		else
		{
			answer = new ABList<Integer>(poly2.size()-1);
			size = poly2.size();
			min = poly1.size();
		}

		for(int i = 0; i < size; i++)
		{
			int toAdd = 0;
			if(i < min)
			{
				toAdd = (int)poly1.get(i) - (int)poly2.get(i);
			}
			else if(poly1big)
			{
				toAdd = (int)poly1.get(i);
			}
			else
			{
				toAdd = (int) poly2.get(i);
			}
			answer.insert(toAdd);
		}
		return answer;	
	}
	
	public static int evaluation(ABList poly, int x)
	{
		int answer = 0;
		for(int i = 0; i < poly.size(); i++)
		{
			answer = answer + (int)poly.get(i)*((int)(Math.pow(x,i)));
		}
		return answer;
	}
	
	public static ABList multiply(ABList poly1, ABList poly2)
	{
		ABList<Integer> answer = new ABList<Integer>(poly1.size()*poly2.size());
		for(int i = 0; i < poly1.size()*poly2.size(); i++)
		{
			answer.insert(0);
		}
		//System.out.println(answer);
		for(int i = 0; i < poly1.size(); i++)
		{
			for(int j = 0; j < poly2.size(); j++)
			{
				int toInsert = (int)poly1.get(i) * (int)poly2.get(j);
				int index = i+j;
				toInsert = toInsert + answer.get(index);
				answer.set(toInsert,index);
			}
		}
		return answer;
	}
}
