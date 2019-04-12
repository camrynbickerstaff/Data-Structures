public class RationalNumber 
{
private int numerator, denominator;
	
	public RationalNumber()
	{
		numerator = 0;
		denominator = 1;
	}
	
	public RationalNumber(int n, int d)
	{
		numerator = n;
		denominator = d;
	}
	
	public int getNumerator()
	{
		return numerator;
	}
	
	public int getDenominator()
	{
		return denominator;
	}
	
	public void setNumerator(int num)
	{
		numerator = num;
	}
	
	public void setDenominator(int num)
	{
		denominator = num;
	}
	
	private int getGCD()
	{
		int gcd = 1;
		int n = numerator;
		int d = denominator;
		if(n < 0)
		{
			n = Math.abs(n);
		}
		if(d < 0)
		{
			d = Math.abs(d);
		}
		if(n > d)
		{
			for(int i = 2; i <= n/2; i++ )
			{
				if(n%i == 0 && d%i == 0)
				{
					gcd = i;
				}
			}
		}
		else
		{
			for(int i = 2; i <= d/2; i++ )
			{
				if(n%i == 0 && d%i == 0)
				{
					gcd = i;
				}
			}
		}
		return gcd;
	}
	
	private void reduceFraction()
	{
		int gcd = getGCD();
		if(gcd > 1)
		{
			numerator = numerator/gcd;
			denominator = denominator/gcd;
		}
		if(numerator < 0 && denominator < 0)
		{
			numerator = Math.abs(numerator);
			denominator = Math.abs(denominator);
		}
		if(numerator > 0 && denominator < 0)
		{
			numerator = numerator*(-1);
			denominator = Math.abs(denominator);
		}
		
	}
	
	public RationalNumber addRationalNumbers(RationalNumber a)
	{
		int newnume = numerator*a.getDenominator();
		int newdeno = denominator*a.getDenominator();
		int newnumeb = a.getNumerator()*denominator;
		int answernume = newnume + newnumeb;
		RationalNumber addanswer = new RationalNumber(answernume,newdeno);
		return addanswer;
	}
	
	public RationalNumber subtractRationalNumbers(RationalNumber a)
	{
		int newnume = numerator*a.getDenominator();
		int newdeno = denominator*a.getDenominator();
		int newnumeb = a.getNumerator()*denominator;
		int answernume = newnume - newnumeb;
		RationalNumber subtractanswer = new RationalNumber(answernume,newdeno);
		return subtractanswer;
	}
	
	public RationalNumber multiplyRationalNumbers(RationalNumber a)
	{
		int answernume = numerator*a.getNumerator();
		int answerdeno = denominator*a.getDenominator();
		RationalNumber multiplyanswer = new RationalNumber(answernume,answerdeno);
		return multiplyanswer;
	}
	
	public RationalNumber divideRationalNumbers(RationalNumber a) 
	{
		int newnume = numerator*a.getDenominator();
		int newdeno = denominator*a.getNumerator();
		RationalNumber answer = new RationalNumber(newnume,newdeno);
		return answer;
	
	}

	
	public int compareRationalNumbers(RationalNumber b)
	{
		float a = (float)numerator/(float)denominator;
		float b2 = (float)b.getNumerator()/(float)b.getDenominator();
		if(a > b2)
		{
			return 0;
		}
		else if(a < b2)
		{
			return 1;
		}
		else
		{
			return 2;
		}
	}
	public String toString()
	{
		reduceFraction();
		return numerator + "/" + denominator + ""; 		
	}
	public String toStringDecimal()
	{
		float a = ((float)numerator)/((float)denominator);
		return a + "";
	}
}