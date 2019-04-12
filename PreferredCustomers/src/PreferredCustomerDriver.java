
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class PreferredCustomerDriver {

	public static void main(String[] args) throws Exception
	{
		// Reading the text file
		File file = new File("customers.txt");
		Scanner input = new Scanner(file);
		ArrayList<PreferredCustomer> list = new ArrayList<PreferredCustomer>();
		ArrayList<String> data = new ArrayList<String>();
		
		
		while(input.hasNextLine())
		{
			data.add(input.nextLine());
		}
		input.close();
		
		String fName = "";
		String lName = "";
		String address ="";
		String telephone = "";
		String idNumber = "";
		boolean mailList = false;
		String mail = "";
		double spent = 0;
		
		//Going through strings to get data
		for(int i = 0; i < data.size(); i++)
		{
			fName = "";
			lName = "";
			address ="";
			telephone = "";
			idNumber = "";
			mail = "";
			spent = 0;
			for(int j = 0; j < data.get(i).length(); j++)
			{
				String b = data.get(i);
				if(fName == "")
				{
					while(b.charAt(j) != ' ')
					{
						fName = fName + b.charAt(j);
						j++;
					}
				}
				if(lName == "")
				{
					j++;
					while(b.charAt(j) != ';')
					{
						lName = lName + b.charAt(j);
						j++;
					}
				}
				if(address == "")
				{
					j = j+2;
					while(b.charAt(j) != ';')
					{
						address = address + b.charAt(j);
						j++;
					}
				}
				if(telephone == "")
				{
					j = j+2;
					while(b.charAt(j) != ';')
					{
						telephone = telephone + b.charAt(j);
						j++;
					}
				}
				if(idNumber == "")
				{
					j = j+2;
					while(b.charAt(j) != ';')
					{
						idNumber = idNumber + b.charAt(j);
						j++;
					}
				}
				if(mail == "")
				{
					j = j+2;
					mail = b.charAt(j) + "";
					if(mail.equals("t"))
					{
						j = j+5;
						mailList = true;
					}
					else if(mail.equals("f"))
					{
						j = j+6;
						mailList = false;
					}
				}
				if(spent == 0)
				{
					String str = "";
					while(j<b.length())
					{
						str = str + b.charAt(j);
						j++;
					}
					spent = Double.parseDouble(str);
				}
			}
			
			list.add(new PreferredCustomer(fName, lName,address,telephone, idNumber,mailList,spent ));
		}

		System.out.println("Customer Name           Customer's Discount Level           Customer's Number");
		System.out.println("=============           =========================           =================");
		String toPrint = "";
		for(int i = 0; i< list.size(); i++)
		{
			toPrint = "";

			while(toPrint.length()<24)
			{
				if(toPrint.length() == 0)
				{
					toPrint = list.get(i).getName();
				}
				else
				{
					toPrint = toPrint + " ";
				}
			}
			System.out.print(toPrint);
			toPrint = "";

			while(toPrint.length()<36)
			{
				if(toPrint.length() == 0)
				{
					toPrint = list.get(i).getLevel();
				}
				else
				{
					toPrint = toPrint + " ";
				}
			}
				
			System.out.print(toPrint);
			toPrint = "";
			
			while(toPrint.length()<17)
			{
				if(toPrint.length() == 0)
				{
					toPrint = list.get(i).getCustomerNumber();
				}
				else
				{
					toPrint = toPrint + " ";
				}
			}
			System.out.print(toPrint + "\n");	
		}
		System.out.println("\nMailing List:");
		for(int m = 0; m<list.size(); m++)
		{
			if(list.get(m).getMailingList())
				System.out.println(list.get(m).getMailingAddress() + "\n");
		}
		
		System.out.println("\nPhone List:");
		for(int m = 0; m<list.size(); m++)
		{
			toPrint = "";
			if(list.get(m).getMailingList())
			{
				while(toPrint.length() < 15)
				{
					if(toPrint.length() == 0)
					{
						toPrint = list.get(m).getName();
					}
					else
					{
						toPrint = toPrint + " ";
					}
				}
				System.out.println("      " + toPrint +list.get(m).getTelephone() + "");
			}
		}
		
		System.out.println("\nProgram is done.");
		System.out.println("Bye!");
		
		
	
	}

}