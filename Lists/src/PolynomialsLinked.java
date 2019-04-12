
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PolynomialsLinked 
{
	
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
		
		
		
		LinkedList<PolyItem> poly1 = stringToList(input.nextLine());
		LinkedList<PolyItem> poly2 = stringToList(input.nextLine());
		System.out.println("Program is reading input file to obtain the two polynomials. The two input polynomials are:\n");
		System.out.println("p(x) = " + polyToString(poly1));
		System.out.println("q(x) = " + polyToString(poly2));
		input.close();
		
		System.out.println("\n\nProgram is now performing arithmetic operations on the two polynomials…\n");
		System.out.print(polyToString(poly1) + " + " + polyToString(poly2) + " = ");
		LinkedList<PolyItem> answer = addition(poly1, poly2);
		System.out.println(polyToString(answer));
	//	answer = subtraction(poly1, poly2);
		System.out.println(polyToString(poly1) + " - " + polyToString(poly2) + " = " + polyToString(answer));
	//	answer = multiply(poly1,poly2);
		System.out.println(polyToString(poly1) + " * " + polyToString(poly2) + " = " + polyToString(answer));
		
		
		System.out.println("\n\nProgram is now evaluating each polynomial using x = " + x + "\n");
	//	System.out.println("p(" + x + ") = " + evaluation(poly1,x));
	//	System.out.println("q(" + x + ") = " + evaluation(poly2,x));
		
		
	
		
		
		
	}
	
	public static LinkedList<PolyItem> stringToList(String poly)
	{
		//System.out.println(poly);
		int value, degree;
		PolyItem add;
		LinkedList<PolyItem> toReturn = new LinkedList<PolyItem>();
		for(int i = 0; i < poly.length(); i = i + 2)
		{
			value = poly.charAt(i)-48;
			i = i + 2;
			degree = poly.charAt(i)-48;
			add = new PolyItem(value,degree);
			toReturn.insertAtBack(add);
		}
		//System.out.println(toReturn);
		return toReturn;
		
	}
	public static String polyToString(LinkedList<PolyItem> poly)
	{
		String toReturn = "(";
		for(int i = 0; i < poly.size(); i++)
		{
			PolyItem p = poly.removeFromFront();
			if(p.value > 0)
			{
				if(p.degree != 0 && !toReturn.contentEquals("("))
				{
					toReturn = toReturn + " + ";
				}
				if(p.value != 1 || p.degree == 0)
				{
					toReturn = toReturn + p.value;
				}
				if(p.degree > 0)
				{
					toReturn = toReturn + "x";
				}
				if(p.degree>1)
				{
					toReturn = toReturn + "^" + p.degree;
				}
				
			}
			else if(p.value < 0 && !toReturn.contentEquals("("))
			{
				if(p.degree != 0)
				{
					toReturn = toReturn + " - ";
				}
				if(p.degree == 0)
				{
					toReturn = toReturn + p.value;
				}
				else if(p.value != -1)
				{
					toReturn = toReturn + Math.abs(p.value);
				}
				
				if(p.degree > 0)
				{
					toReturn = toReturn + "x";
				}
				if(p.degree>1)
				{
					toReturn = toReturn + "^" + p.degree;
				}
				
			}
		}
		toReturn = toReturn + ")";
		return toReturn;
	}
	
	public static LinkedList<PolyItem> addition(LinkedList<PolyItem> polya, LinkedList<PolyItem> polyb)
	{
		LinkedList<PolyItem> poly1 = polya;
		LinkedList<PolyItem> poly2 = polyb;
		LinkedList<PolyItem> answer = new LinkedList<PolyItem>();
		while(!poly2.isEmpty() &&!poly1.isEmpty())
		{	
			int toAdd = 0;
			PolyItem add;
			PolyItem polyo = poly1.removeFromFront();
			while(!poly1.isEmpty())
			{
				PolyItem polyt = poly2.removeFromFront();
				if(polyo.compareTo(polyt) == 0)
				{
					toAdd = polyo.value + polyt.value;
					add = new PolyItem(toAdd, polyo.degree);
					answer.insertAtBack(add);
				}
				else if(polyt.compareTo(polyo) > 0)
				{
					break;
				}
			}
			if(!poly1.isEmpty())
			{
				while(!poly1.isEmpty())
				{
					answer.insertAtBack(poly1.removeFromBack());
				}
			}
			if(!poly2.isEmpty())
			{
				while(!poly2.isEmpty())
				{
					answer.insertAtBack(poly2.removeFromBack());
				}
			}
		}
		return answer;	
	}
	
/*	public static LinkedList subtraction(LinkedList poly1, LinkedList poly2)
	{
		LinkedList<PolyItem> answer;
		int size = 0;
		int min = 0;
		boolean poly1big = false;
		if(poly1.size()>poly2.size())
		{
			answer = new LinkedList<PolyItem>();
			size = poly1.size();
			min = poly2.size();	
			poly1big = true;
		}
		else
		{
			answer = new LinkedList<PolyItem>();
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
			answer.insertAtBack(toAdd);
		}
		return answer;	
	}
	
	public static int evaluation(LinkedList poly, int x)
	{
		int answer = 0;
		for(int i = 0; i < poly.size(); i++)
		{
			answer = answer + (int)poly.get(i)*((int)(Math.pow(x,i)));
		}
		return answer;
	}
	
	public static LinkedList multiply(LinkedList poly1, LinkedList poly2)
	{
		LinkedList<PolyItem> answer = new LinkedList<PolyItem>();
		for(int i = 0; i < poly1.size()*poly2.size(); i++)
		{
			answer.insertAtBack(0);
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
	}*/
	private static class PolyItem implements Comparable<PolynomialsLinked.PolyItem>
	{
		protected int value;
		protected int degree;

		public PolyItem(int value, int degree)
		{
			this.value = value;
			this.degree = degree;;
		}

		@Override
		public int compareTo(PolyItem x) {
			if(x.degree < degree)
			{
				return 1;
			}
			if(degree<x.degree)
			{
				return -1;
			}
			return 0;
		}

	}
}