public class Person 
{
	protected String firstName, lastName, address, telephone;

	public Person()
	{
		firstName = lastName = address = telephone = "";
	}
	
	public Person(String fName, String lName, String addres, String telephon)
	{
		firstName = fName;
		lastName = lName;
		address = addres;
		telephone = telephon;
	}
	public Person(Person other)
	{
		firstName = other.firstName;
		lastName = other.lastName;
		address = other.address;
		telephone = other.telephone;
	}
	public void setName(String fName, String lName)
	{
		firstName = fName;
		lastName = lName;
	}
	public void setFirstName(String fName)
	{
		firstName = fName;
	}
	public void setLastName(String lName)
	{
		lastName = lName;
	}
	public void setAddress(String addres)
	{
		address = addres;
	}
	public void setTelephone(String telephon)
	{
		telephone = telephon;
	}
	public String getName()
	{
		return firstName + " " + lastName;
	}
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getMailingAddress() 
	{
		int a = address.indexOf(',');
		String street = address.substring(0,a);
		String cityState = address.substring(a+2,address.length());
		return "        " + getName() + "\n        " + street + "\n        " + cityState;
	}
	public String getAddress()
	{
		return address;
	}
	public String getTelephone()
	{
		return telephone;
	}
	public String toString()
	{
		//int a = address.indexOf(',');
		//String street = address.substring(0,a);
		//String cityState = address.substring(a,address.length()-1);
		return getName() + getAddress() + getTelephone(); //+ "\n" + street + "\n" + cityState;
	}
}