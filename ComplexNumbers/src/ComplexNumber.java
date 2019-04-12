public class ComplexNumber 
{
	private int realPart;
	private int imaginaryPart;
	
	public ComplexNumber() {

		this.realPart = 0;
		this.imaginaryPart = 0;
	}
	
	public ComplexNumber(int realPart, int imaginaryPart)
	{
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}
	
	public ComplexNumber(ComplexNumber other)
	{
		this.realPart = other.realPart;
		this.imaginaryPart = other.imaginaryPart;
	}
	
	
	public void SetComplexNumber( int realPart, int imaginaryPart) 
	{

		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
		
		return;
	}
	
	public void setRealPart( int realPart) 
	{

		this.realPart = realPart;
		
		return;
	}
	
	public void setImaginaryPart( int imaginaryPart) {

		this.imaginaryPart = imaginaryPart;
		
		return;
	}
	
	public ComplexNumber copy() {

		int newReal = this.realPart;
		int newImag = this.imaginaryPart;	
		
		return new ComplexNumber( newReal, newImag);
	}
	
	public int getRealPart() {

		return realPart;
	}
	
	public int getImaginaryPart() {

		return imaginaryPart;
	}
	
	public ComplexNumber add( ComplexNumber other) 
	{
		int newReal = this.realPart;
		int imaginaryNew = this.imaginaryPart;
		newReal += other.realPart;
		imaginaryNew += other.imaginaryPart;
		
		return new ComplexNumber(newReal, imaginaryNew);
	}
	
	public ComplexNumber subtract( ComplexNumber other) 
	{
		int newReal = this.realPart;
		int imaginaryNew = this.imaginaryPart;
		newReal -= other.realPart;
		imaginaryNew -= other.imaginaryPart;
		
		return new ComplexNumber(newReal, imaginaryNew);
		
	}
	
	public ComplexNumber multiply( ComplexNumber other) 
	{

		int newReal = this.realPart * other.realPart - this.imaginaryPart * other.imaginaryPart;
		int newImag = this.imaginaryPart * other.realPart + this.realPart * other.imaginaryPart;
		
		return new ComplexNumber( newReal, newImag);
	}
	
	public ComplexNumber dividedBy( ComplexNumber other) {

		ComplexNumber temp1 = other.conjugate();
		ComplexNumber temp2 = this.multiply( temp1);
		ComplexNumber temp3 = other.multiply( temp1);
		int newReal = temp2.realPart / temp3.realPart;
		int newImag = temp2.imaginaryPart / temp3.realPart;
		
		return new ComplexNumber( newReal, newImag);
	}
	
	public ComplexNumber conjugate() {

		int newReal = this.realPart;
		int newImag = -this.imaginaryPart;
		
		return new ComplexNumber( newReal, newImag);
	}

	public String toString() {

		String str = "";
		int r = this.realPart;
		int i = this.imaginaryPart;
		
		if(r == 0 && i == 0)
		{
			str += "0";
			return str;
		}
		if(r == 0)
		{
			return str + i + "i";
		}
		if(i < 0)
		{
			i = -i;
			str += r + " - " + i + "i";
			return str;
		}
		if(i == 0)
		{
			return r + str;
		}
		return r + " + " + i + "i"; 

	}
}