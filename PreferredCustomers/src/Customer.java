public class Customer extends Person
{
	protected String customerNumber;
	protected boolean mailingList;
	
	public Customer()
	{
		customerNumber = "";
		mailingList = false;
	}
	public Customer(String fName,String lName,String addres,String telephon,String customerNumbe,boolean mailingLis) 
	{
		super(fName,lName,addres,telephon);
		customerNumber = customerNumbe;
		mailingList = mailingLis;
	}
	
	public Customer(Customer other)
	{
		this.firstName = other.firstName;
		this.lastName = other.lastName;
		this.address = other.address;
		this.telephone = other.telephone;
		this.customerNumber = other.customerNumber;
		this.mailingList = other.mailingList;
	}
	
	public void setCustomerNumber(String custNum)
	{
		customerNumber = custNum;
	}
	
	public void setMailingList(boolean mailLis)
	{
		mailingList = mailLis;
	}
	
	public String getCustomerNumber()
	{
		return customerNumber;
	}
	
	public boolean getMailingList()
	{
		return mailingList;
	}
	
	public Customer copy()
	{
		Customer n = new Customer();
		n.address = this.address;
		n.customerNumber = this.customerNumber;
		n.firstName = this.firstName;
		n.lastName = this.lastName;
		n.mailingList = this.mailingList;
		n.telephone = this.telephone;
		return n;
	}

	public String toString()
	{
		return super.toString() + " " + customerNumber + " " + mailingList;
	}
}