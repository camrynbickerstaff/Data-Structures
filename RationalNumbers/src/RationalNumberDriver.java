import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class RationalNumberDriver {

	public static void main(String[] args) throws Exception 
	{
		File file = new File("fractions.txt");
		Scanner input = new Scanner(file);
		ArrayList<RationalNumber> list = new ArrayList<RationalNumber>();
		int num = 0;
		int den = 0;
		int arrlength = 0;
		
		System.out.println("Program is reading input file to validate two rational numbers...");
		
		
		//retrieving from text file
		while(input.hasNext())
		{
			num = 0;
			den = 0;
			if(input.hasNextInt())
			{
				num = input.nextInt();
				if(input.hasNextInt())
				{
					den = input.nextInt();
					if(den == 0)
					{
						System.out.println("Invalid Fraction: denominator cannot be zero.");
					}
					if(den != 0)
					{
						list.add(new RationalNumber(num,den));
						arrlength = arrlength + 1;
						if(arrlength == 1)
						{
							System.out.println("The first valid fraction obtained is:          " + (list.get(arrlength - 1).toString()) + "      " + (list.get(arrlength - 1).toStringDecimal()));
						}
						if(arrlength == 2)
						{
							System.out.println("The second valid fraction obtained is:         " + (list.get(arrlength - 1).toString()) + "      " + (list.get(arrlength - 1).toStringDecimal()));
						}
					}
				}
				else
				{
					System.out.println("Invalid Input: input must be two integers");
					if(input.hasNext())
					{
						input.next();
					}
				}	
			}
			else
			{
				System.out.println("Invalid Input: input must be two integers");
				input.next();
			}
			if(arrlength == 2)
			{
				break;
			}
			if(input.hasNextLine())
				input.nextLine();
		}
		input.close();
		if(arrlength == 1)
		{
			System.out.println("\nProgram was only able to validate one rational number: " + list.get(0).toString() +  ". Please edit the text file and try again.");
		}
		if(arrlength == 0)
		{
			System.out.println("\nProgram was unable to validate any rational numbers. Please edit the text file and try again.");
		}
		
		if(arrlength == 2)
		{
			System.out.println();
			System.out.println("Program is now performing arithmetic operations on the two fractions...");
			
			RationalNumber a = list.get(0);
			RationalNumber b = list.get(1);
			
			//addition
			
			RationalNumber addanswer = a.addRationalNumbers(b);
			System.out.println(a.toString() + " + " + b.toString() + " = " + addanswer.toString() + " = " + addanswer.toStringDecimal());
		 
			//subtraction
			
			RationalNumber subtractanswer = a.subtractRationalNumbers(b);
			System.out.println(a.toString() + " - " + b.toString() + " = " + subtractanswer.toString() + " = " + subtractanswer.toStringDecimal());
			
			//multiply
			
			RationalNumber multiplyanswer = a.multiplyRationalNumbers(b);
			System.out.println(a.toString() + " * " + b.toString() + " = " + multiplyanswer.toString() + " = " + multiplyanswer.toStringDecimal());
			
		    //divide
			
			if(b.getNumerator() != 0)
			{
				RationalNumber divideanswer = a.divideRationalNumbers(b);
				System.out.println(a.toString() + " / " + b.toString() + " = " + divideanswer.toString() + " = " + divideanswer.toStringDecimal());
			}
			else
			{
				System.out.print(a.toString() + " / " + b.toString() + " = D.N.E");

				System.out.println("    The answer is not a rational number. Cannot divide by zero");
			}
			
			//compare
			
			System.out.println("\nProgram is now comparing the two rational numbers...");
			if(a.compareRationalNumbers(b) == 0)
			{
				System.out.println(a.toString() + " is larger than " + b.toString());
			}
			if(a.compareRationalNumbers(b) == 1)
			{
				System.out.println(a.toString() + " is smaller than " + b.toString());
			}
			if(b.compareRationalNumbers(a) == 2)
			{
				System.out.println(a.toString() + " is the same size as " + b.toString());
			}
		}
		System.out.println("\n" + "Program is done." + "\n" + "Bye!");

	}

}