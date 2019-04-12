import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AddressBook 
{
	static Scanner userInput = new Scanner(System.in);
	public static void main(String[] args) throws Exception
	{
		String run = "yes";
		LinkedList<Address> list = inputFrom();
		//System.out.println(list.removeFromBack());
		//Scanner userInput = new Scanner(System.in);
		businessMan(1);
		System.out.println("I have all of your addresses stored here! If there is anything you would like to do with them, just...\n");
		while(run.equals("yes"))
		{
			int nextOp = 0;
			System.out.println("______________________________________________\n" + "1. Add a new address record\r" + 
					"\n2. View an existing address record\r" + 
					"\n3. Delete an existing address record\r" + 
					"\n4. Modify an existing address record\r" + 
					"\n5. Save the entire address book in a file\r" + 
					"\n6. Retrieve all address entries using zip code\r" + 
					"\n7. Print the entire address book on the screen\r" + "\n_______________________________________________");
			System.out.println("\nType the number of the operation you would like to perform!");
			while(nextOp < 1 || nextOp > 7)
			{
				String in = "";
				//System.out.println("hed");
				in = userInput.next();
				//System.out.println("he");
				switch(in)
				{
				case "1":
					nextOp = 1;
					userInput.nextLine();
					first(list);
					break;
				case "2":
					nextOp = 2;
					userInput.nextLine();
					second(list);
					break;
				case "3":
					nextOp = 3;
					userInput.nextLine();
					third(list);
					break;
				case "4":
					nextOp = 4;
					userInput.nextLine();
					fourth(list);
					break;
				case "5":
					nextOp = 5;
					userInput.nextLine();
					fifth(list);
					break;
				case "6":
					nextOp = 6;
					userInput.nextLine();
					sixth(list);
					break;
				case "7":
					nextOp = 7;
					userInput.nextLine();
					seventh(list);
					break;
				case "quit":
					run = "no";
					break;
				default:
					System.out.println("Please enter a number between 1 and 7, or type \"quit\" if you would like to quit");
				
				}
				if(run.equals("no"))
					break;
			}
			nextOp = 0;
			//System.out.println(nextOp);
			Thread.sleep(4000);
			System.out.println("\n\n------------------------------------------------------------------------------------------------------------------------");
			businessMan(3);
			System.out.println("Type \"yes\" to continue or anything else to quit");
			run = userInput.next();
			run = run.toLowerCase();
			
		}
		businessMan(2);
		userInput.close();
	}
	public static void first(LinkedList<Address> list)
	{
		//Scanner userInput2 = new Scanner(System.in);
		String firstName,lastName,streetAddress,city,state,zip,country,phoneNumber;
		System.out.println("Great! You want to add a new address! What is the first name of your new entry?");
		firstName = userInput.nextLine();
		System.out.println("What is the last name of your new entry?");
		lastName = userInput.nextLine();
		System.out.println("What is the street address name of your new entry?");
		streetAddress = userInput.nextLine();
		System.out.println("What is the city of your new entry?");
		city = userInput.nextLine();
		System.out.println("What is the state of your new entry?");
		state = userInput.nextLine();
		System.out.println("What is the zip code of your new entry?");
		zip = userInput.nextLine();
		System.out.println("What is the country of your new entry?");
		country = userInput.nextLine();
		System.out.println("What is the phone number of your new entry?");
		phoneNumber = userInput.nextLine();
		System.out.println("Here is your new entry: \n");
		Address add = new Address(firstName,lastName,streetAddress,city,state,zip,country,phoneNumber);
		list.insertAtBack(add);
		System.out.println(add + "\n");
	}
	public static LinkedList<Address> inputFrom() throws FileNotFoundException
	{
		LinkedList<Address> toReturn = new LinkedList<Address>();
		File file = new File("addresses.txt");
		Scanner input = new Scanner(file);

		String firstName,lastName,streetAddress,city,state,zip,country,phoneNumber = "";
		while(input.hasNext())
		{
			firstName = input.next();
			lastName = input.next();
			input.nextLine();
			streetAddress = input.nextLine();
			city = input.next();
			city = city.substring(0,city.length()-1);
			state = input.next();
			zip = input.next();
			input.nextLine();
			country = input.nextLine();
			phoneNumber = input.nextLine();
			toReturn.insertAtBack(new Address(firstName,lastName,streetAddress,city,state,zip,country,phoneNumber));
		}
		input.close();
		return toReturn;
	}

	public static void second(LinkedList<Address> list)
	{
		LinkedList<Address> use = new LinkedList<Address>(list);
		String lastName = thingFromUser("last name",3);
		lastName = lastName.toLowerCase();
		int p = list.size();
		System.out.println("Here is the entry for the person with the last name \"" + lastName + "\": \n");
		for(int i = 0; i < p; i++)
		{
			Address test = use.removeFromFront();
			if(test.getLastName().toLowerCase().contentEquals(lastName))
			{
				System.out.println(test);
				return;
			}
			
		}
		System.out.println("I could not find an entry with the last name \"" + lastName + "\"");
		
	}
	private static String thingFromUser(String whatUserNeeds, int op)
	{
		String toDo = "";
		String also = "";
		String boo = "";
		if(op == 1)
		{
			toDo = "deleting";
			boo = "entry";
		}
		else if(op == 2)
		{
			toDo = "modifying";
			boo = "entry";
			also = "new ";
		}
		else if(op == 3)
		{
			toDo = "displaying";
			boo = "entry/entries";
		}
		System.out.println("What is the " + also + whatUserNeeds + " of the " + boo + " you are " + toDo + "?");
		String thing = userInput.nextLine();
		return thing;
	}
	public static void third(LinkedList<Address> list)
	{
		LinkedList<Address> use = new LinkedList<Address>(list);
		String lastName = thingFromUser("last name", 1);
		lastName = lastName.toLowerCase();
		int p = list.size();
		for(int i = 0; i < p; i++)
		{
			Address test = use.removeFromFront();
			if(test.getLastName().toLowerCase().contentEquals(lastName))
			{
				list.remove(test);
				System.out.println("\nThis is done!\n");
				return;
			}
			
		}
		System.out.println("I could not find an entry with the last name \"" + lastName + "\"");
	}
	
	public static void fourth(LinkedList<Address> list)
	{
		String run = "yes";
		LinkedList<Address> use = new LinkedList<Address>(list);
		String lastName = thingFromUser("last name",2);
		Address test = null;
		for(int i = 0; i < list.size(); i++)
		{
			test = use.removeFromFront();
			if(test.getLastName().toLowerCase().contentEquals(lastName))
			{
				break;
			}
		}
		if(test == null)
		{
			System.out.println("I could not find an entry with the last name \"" + lastName + "\"");
			return;
		}
		while(run.equals("yes"))
		{
			int nextOp = 0;
			System.out.println("1. Change First Name\r" + 
					"\n2. Change Last Name\r" + 
					"\n3. Change Street Address\r" + 
					"\n4. Change City\r" + 
					"\n5. Change State\r" + 
					"\n6. Change Zip Code\r" + 
					"\n7. Change Country\r" + 
					"\n8. Change Phone Number\r");
			System.out.println("\nType the number of the operation you would like to perform!");
			while(nextOp < 1 || nextOp > 8)
			{
				String in = "";
				//System.out.println("hed");
				in = userInput.next();
				//System.out.println("he");
				String thing = "";
				switch(in)
				{
				case "1":
					nextOp = 1;
					userInput.nextLine();
					thing = thingFromUser("first name",2);
					test.setFirstName(thing);
					break;
				case "2":
					nextOp = 2;
					userInput.nextLine();
					thing = thingFromUser("last name",2);
					test.setLastName(thing);
					break;
				case "3":
					nextOp = 3;
					userInput.nextLine();
					thing = thingFromUser("street address",2);
					test.setAddress(thing);
					break;
				case "4":
					nextOp = 4;
					userInput.nextLine();
					thing = thingFromUser("city",2);
					test.setCity(thing);
					break;
				case "5":
					nextOp = 5;
					userInput.nextLine();
					thing = thingFromUser("state",2);
					test.setState(thing);
					break;
				case "6":
					nextOp = 6;
					userInput.nextLine();
					thing = thingFromUser("zip code",2);
					test.setZip(thing);
					break;
				case "7":
					nextOp = 7;
					userInput.nextLine();
					thing = thingFromUser("country",2);
					test.setCountry(thing);
					break;
				case "8":
					nextOp = 8;
					userInput.nextLine();
					thing = thingFromUser("phone number",2);
					test.setPhoneNumber(thing);
					break;
				case "quit":
					run = "no";
					break;
				default:
					System.out.println("Please enter a number between 1 and 8, or type \"quit\" if you would like to quit");
				
				}
				if(run.equals("no"))
					break;
			}
			nextOp = 0;
			//System.out.println(nextOp);
			System.out.println("Would you like to make more changes to this entry? Type \"yes\" to continue or anything else if you are done.");
			run = userInput.next();
			run = run.toLowerCase();
			
		}
		System.out.println("Here is your entry with the new modifications: \n\n" + test);
	}
	
	public static void fifth(LinkedList<Address> list) throws Exception
	{
		LinkedList<Address> use = new LinkedList<Address>(list);
		PrintWriter out = new PrintWriter("addressBook.txt");
		for(int i = 0; i < list.size(); i++)
		{
			out.println(use.removeFromFront() + "\n");
		}
		System.out.println("This is done!\nYour new file is called \"addressBook.txt\"\n\n");
		out.close();
	}
	public static void sixth(LinkedList<Address> list)
	{
		LinkedList<Address> use = new LinkedList<Address>(list);
		String zipCode = thingFromUser("zip code",3);
		int p = list.size();
		boolean found = false;
		System.out.println("Here are the entry/entries with the zip code \"" + zipCode + "\": \n");
		for(int i = 0; i < p; i++)
		{
			Address test = use.removeFromFront();
			if(test.getZipCode().contentEquals(zipCode))
			{
				found = true;
				System.out.println(test + "\n");
			}
			
		}
		if(!found)
			System.out.println("I could not find any entries with the zip code \"" + zipCode + "\"");
	}
	public static void seventh(LinkedList<Address> list)
	{
		LinkedList<Address> use = new LinkedList<Address>(list);
		System.out.println("Here are all of the addresses stored in your address book!!\n\n");
		for(int i = 0; i < list.size(); i++)
		{
			System.out.println(use.removeFromFront() + "\n");
		}
	}
	public static class Address implements Comparable<AddressBook.Address>
	{
		protected String firstName,lastName,streetAddress,city,state,zip,country,phoneNumber;
		
		public Address()
		{
			firstName = "";
			lastName = "";
			streetAddress = "";
			city = "";
			state = "";
			zip = "";
			country = "";
			phoneNumber = "";
		}
		
		public Address(String firstName, String lastName, String streetAddress, String city, String state, String zip, String country, String phoneNumber)
		{
			this.firstName = firstName;
			this.lastName = lastName;
			this.streetAddress = streetAddress;
			this.city = city;
			this.state = state;
			this.zip = zip;
			this.country = country;
			this.phoneNumber = phoneNumber;
		}
		public String getZipCode()
		{
			return zip;
		}
		public void setFirstName(String firstName)
		{
			this.firstName = firstName;
		}
		public void setLastName(String lastName)
		{
			this.lastName = lastName;
		}
		public void setAddress(String address)
		{
			this.streetAddress = address;
		}
		public void setCity(String city)
		{
			this.city = city;
		}
		public void setState(String state)
		{
			this.state = state;
		}
		public void setZip(String zip)
		{
			this.zip = zip;
		}
		public void setCountry(String country)
		{
			this.country = country;
		}
		public void setPhoneNumber(String phoneNumber)
		{
			this.phoneNumber = phoneNumber;
		}
		public String getLastName()
		{
			return lastName;
		}
		public String toString()
		{
			return (lastName + ", " + firstName + "\n" + streetAddress + "\n" + city + ", " + state + " " + zip + "\n" + country + "\n" + phoneNumber + "\n");
		}
		public int compareTo(Address o) 
		{
			int comp = this.lastName.compareTo(o.lastName);
			if(comp == 0)
			{
				comp = this.firstName.compareTo(o.firstName);
			}
			return 0;
		}

		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void businessMan(int i) throws Exception
	{
		String toPrint = "";
		if(i == 1)
		{
			toPrint = "          ////////\\\\\\  (Hello, I am your address book manager. I will be helping you today.)";
		}
		else if(i == 2)
		{
			toPrint = "          ////////\\\\\\  (I hope you had a good time using this application. See you later!!!)";
		}
		else if(i == 3)
		{
			toPrint = "          ////////\\\\\\  (Would you like to perform more operations on your address book?????)";
		}
		System.out.println("           _________    .-----------------------------------------------------------------. ");
		System.out.println(toPrint);
		System.out.println("         // __   __ \\\\ /'-----------------------------------------------------------------'");
		System.out.println("        // (()) (()) \\\\");
		System.out.println("       (_    (___)    _)");
		System.out.println("         \\  \\_____/  /");
		System.out.println("          `-._   _.-\'");
		System.out.println("          __.-)_(-,__ ");
		System.out.println("       ./'  \\_\\_/_/  `\\.");
		System.out.println("      / >   | //\\ |   < \\");
		System.out.println("     /  \\   | |/| |   /  \\");
		System.out.println("    /   |\\  | |/| |  /|   \\");
		System.out.println("   /   /| \\ | |/| | / |\\   \\");
		System.out.println("  (   ( |  \\| |/| |/  | )   )");
		System.out.println("   \\   \\|   Y |/| Y   |/   /");
		System.out.println("    \\   |  o| |/| |-  |   /");
		System.out.println("     `\\ |   | `^` |   | /'");
		System.out.println("       `|  o|=[Ll=|-  |'");
		System.out.println("        |   /     \\   |");
		System.out.println("        ~~|`  \\    `|~~");
		System.out.println("          |    |    |");
		System.out.println("          |    |    |");
		System.out.println("          |    |    |");
		System.out.println("          |    |    |");
		System.out.println("          |    |    |");
		System.out.println("          |    |    |");
		System.out.println("          |    |    |");
		System.out.println("          |    |    |");
		System.out.println("          |____|____|");
		System.out.println("          /   / \\   \\");
		System.out.println("         /   /   \\   \\");
		System.out.println("        `---'     `---`");
		Thread.sleep(5000);
		if(i == 1)
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
}
