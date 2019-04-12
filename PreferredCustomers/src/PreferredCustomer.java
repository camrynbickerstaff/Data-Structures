public class PreferredCustomer extends Customer
{
	protected double spent;
	protected String level;
	
	public PreferredCustomer()
	{
		spent = 0;
		level = "";
	}
	
	public PreferredCustomer(String fName,String lName,String addres,String telephon,String customerNumbe,boolean mailingLis,double spen)
	{
		super( fName, lName, addres, telephon , customerNumbe, mailingLis);
		spent = spen;
		level = getLevel();
	}
	public PreferredCustomer(PreferredCustomer other)
	{
		this.firstName = other.firstName;
		this.lastName = other.lastName;
		this.address = other.address;
		this.telephone = other.telephone;
		this.customerNumber = other.customerNumber;
		this.mailingList = other.mailingList;
		this.spent = other.spent;
		this.level = other.level;
	}
	public void setSpent(double spen)
	{
		spent = spen;
	}
	public void setLevel(double spen)
	{
		setSpent(spen);
		level = getLevel();
	}
	public String getLevel()
	{
		if(spent >= 2000)
		{
			level = "10%";
		}
		else if(spent >= 1500)
		{
			level = "7%";
		}
		else if(spent >= 1000)
		{
			level = "6%";
		}
		else if(spent >= 500)
		{
			level = "5%";
		}
		else
		{
			level = "0%";
		}
		return level;
	}
	public double getSpent()
	{
		return spent;
	}
	
	public PreferredCustomer copy()
	{
		PreferredCustomer n = new PreferredCustomer();
		n.address = this.address;
		n.customerNumber = this.customerNumber;
		n.firstName = this.firstName;
		n.lastName = this.lastName;
		n.mailingList = this.mailingList;
		n.telephone = this.telephone;
		n.level = this.level;
		n.spent = this.spent;
		return n;
	}
	
	public String toString()
	{
		return super.toString() + " " + level + " " + spent;
	}
	
	
}