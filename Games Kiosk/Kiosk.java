import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Kiosk {
	private Catalogue catalogue;
	private LinkedList<Customer> customers = new LinkedList<Customer>();
	
	//add games, remove games from catalogue
	//call the functions from this kiosk class.

	public static void main(String[] args) {
		Kiosk kiosk = new Kiosk();
		kiosk.use();
		//new Kiosk().use();
	}
	
	// write your solution here
	public Kiosk() {
		//add customer here and other required data
		customers.add(new Customer(101, "Jaime", 10));
		customers.add(new Customer(102, "Luke", 10));
		customers.add(new Customer(103, "William", 1));
		//add games
		
		//catalogue = new Catalogue(this.kiosk);
		this.catalogue = new Catalogue(this);
	}

	//main selection loop
	public void use() {
		System.out.println("Welcome to the Game Kiosk! Please make a selection from the menu:");
		System.out.println("1." + " " +  "Explore the catalogue.");
		System.out.println("2." + " " +  "View your customer record.");
		System.out.println("3." + " " +  "Show you favourite games.");
		System.out.println("4." + " " +  "Top up account.");
		System.out.println("5." + " " +  "Enter Admin Mode.");
		System.out.println("X." + " " +  "Exit the system.");

		char userSelection;
		userSelection = readChoice();
		//while((userSelection = readChoice()) != 'X'){
            switch(userSelection){
                case '1': catalogue.displayCatalogue(); break;
                case '2': customerRecord(); break;
                case '3': showFavourite(); break;
                case '4': topUpAccount(); break;
                case '5': Admin(); break;
				case 'X': System.out.println("Thank you for using the Game Kiosk, do visit us again."); break;
                default: useHelp(); break;
            
            
         }
            
    }

	private void useHelp() {
		System.out.println("Please enter a number between 1 and 5, or press X to exit.");
		use();
	}

	private char readChoice() {
		System.out.print("Enter a choice: ");
		return In.nextChar();
	}



private void customerRecord() {
		//lookup specific customer record
		//return doesnt exist if not found
		boolean temp = false;
		System.out.println("");
		System.out.print("Enter a customer ID: ");
		int userInput = readNumber();
		for(Customer customer : customers)
			if(customer.getID() == userInput) {
				//System.out.println(customer);
				System.out.println("ID: " + customer.getID());
				System.out.println("Name: " + customer.getName());
				System.out.println("Balance: $" + customer.getBalance());

				System.out.println("Games currently rented by " + customer.getName() +":");
				customer.getCurrentlyRented();
				System.out.println(customer.getName() +"'s renting history:");
				customer.getRentingHistory();
				//customer.getCurrentlyRented();
				temp = true;
				break;
			} 
			if(!temp) {
				System.out.println("That customer does not exist.");
			}
			System.out.println("");
			use();
	}
	
	
	

	private void showFavourite() {

	}

	private void topUpAccount() {
		boolean temp = false;
		System.out.println("");
		System.out.print("Enter a customer ID: ");
		int userInput = readNumber();
		for(Customer customer : customers)
			if(customer.getID() == userInput) {
				System.out.print("Enter the top-up amount:");
				int amount = readNumber();
				System.out.println("");				
				System.out.println("Transaction complete.");
				System.out.println(customer.getName() + "'s balance was: $" + customer.getBalance());
				customer.topUp(amount);
				System.out.println(customer.getName() + "'s current balance is: $" + customer.getBalance());
				temp = true;
				break;
			} 
			if(!temp) {
				System.out.println("That customer does not exist.");
			}
			System.out.println("");
			use();
	}
	

	public void Admin() {

		System.out.println("Welcome to the administration menu:");
		System.out.println("1." + " " +  "List all customers.");
		System.out.println("2." + " " +  "Add a customer.");
		System.out.println("3." + " " +  "Remove a customer.");
		System.out.println("4." + " " +  "List all games.");
		System.out.println("5." + " " +  "Add a game to the catalogue.");
		System.out.println("6." + " " +  "Remove a game from the catalogue.");
		System.out.println("R." + " " +  "Return to the previous menu.");

		char userSelection;
		userSelection = readChoice();
		//while((userSelection = readChoice()) != 'X'){
            switch(userSelection){
                case '1': listCustomers(); break;
                case '2': addCustomer(); break;
                case '3': removeCustomer(); break;
                case '4': listGames(); break;
                case '5': addGame(); break;
				case '6': removeGame(); break;
				case 'R', 'r': use(); break;
                default: help(); break;
			}
            
         
            //System.out.println("Done");
	}

	private void help() {
		System.out.println("help stuff");
	}

	//view all customer in the linkedlist
	private void listCustomers() {
		System.out.println("");
		System.out.println("The Kiosk has the following customers:");
		for(Customer customer : customers)
			System.out.println(customer);
		System.out.println("");
		Admin();
	}




	private void addCustomer() {
		System.out.println("");
		System.out.println("Adding a new customer.");
		System.out.print("Enter a new ID: ");
		int ID = readNumber();
		customerCheck(ID);

	}

	private void customerCheck(int ID) {
		boolean temp = false;
		for(Customer customer : customers)
			if(customer.getID() == ID) {
				temp = true;
				break;
				//return true;
			} else if (customer.getID() != ID) {
				temp = false;
			}

		//System.out.println(temp);
			
		if(temp) {
			System.out.print("That customer already exists, please enter a new ID: ");
			ID = readNumber();
			customerCheck(ID);
		} else {
			addCustomerTrue(ID);
		}

	}

	private void addCustomerTrue(int ID) {
			System.out.print("Enter the customer's name: ");
			String name = readName();
			System.out.print("Enter the customer's initial balance: ");
			int balance = readNumber();
			customers.add(new Customer(ID, name, balance));
			System.out.println("Customer added.");
			System.out.println("");
			Admin();
	}

	



	private int readNumber() {
        //System.out.print("Number: ");
        return In.nextInt();
    }

	private String readName() {
        //products.getName();
        //System.out.print("Name: ");
        return In.nextLine();
    }


	private void removeCustomer() {
		LinkedList<Customer> matches = new LinkedList<Customer>();
		System.out.println("");
		System.out.println("Removing a customer.");
		System.out.print("Enter a customer ID: ");
		int custID = readNumber();
		boolean temp = false;
		
		for (Customer customer : customers)
			if(customer.getID() == custID) {
				//System.out.println("called");
				
				//System.out.println(game.toString() + " removed from catalogue.");
				matches.add(customer);
				
				System.out.println("Customer removed.");
				temp = false;
				break;
			} else {
				temp = true;
			}
		
		if(temp) {
			System.out.println("That customer does not exist.");
		}
		
		
		//System.out.println(matches.get(0));
		customers.removeAll(matches);
		System.out.println("");
		Admin();
	}

//this needs to reference from catalogue class.
//----------------------------------------------------------------------------
//---------------------------------------------------------------------------

	private void listGames() {
		catalogue.listGames();
	}

	private void addGame() {
		catalogue.addGame();
	}

	private void removeGame() {
		catalogue.removeGame();
	}

	public boolean checkCustomer(int ID) {
		boolean temp = false;
		for(Customer customer : customers)
			if(customer.getID() == ID) {
				temp = true;
				break;
				//return true;
			} else if (customer.getID() != ID) {
				temp = false;
				//break;
			}
			
		if(temp) {
			//System.out.print("Customer exists");
			//ID = readNumber()
			return true;
			//customerCheck(ID);
		} else {
			//System.out.println("doesnt exist");
			return false;
			//addCustomerTrue(ID);

		}
	}

	public void addToCustomerRent(Game game, int ID) {
		for(Customer customer : customers) 
			if(customer.getID() == ID) {
				//System.out.println("hello this was called");
				customer.setCurrentlyRented(game);
				//customer.getCurrentlyRented();

		}
	}

	public void removeCustomerRent(Game game, int ID) {
		for(Customer customer : customers) 
			if(customer.getID() == ID) {
				//System.out.println("hello this was called");
				customer.removeCurrentlyRented(game);
			}
	}

	public void showGamesRented(int ID) {
		for(Customer customer : customers) 
			if(customer.getID() == ID) {
				//System.out.println("hello this was called");
				System.out.println(customer.getName() + " has the following games:");
				System.out.println("Games currently rented by " + customer.getName() +":");
				customer.getCurrentlyRented();
				//customer.getCurrentlyRented();

		}
	}

	public boolean gameRented(String title, int ID) {
		boolean temp = false;
		for(Customer customer : customers) 
			if(customer.getID() == ID) {
				//System.out.println("hello this was called");
				if(customer.gameRented(title, ID)) {
					temp = true;
				}
			
			}


	return temp;
	}

	public void deductFunds(int ID, int price) {
		for(Customer customer : customers)
			if(customer.getID() == ID) {
				customer.deductFunds(price);
			}
	}

	public boolean enoughFunds(int ID, int n) {
		boolean temp = false;
		for(Customer customer : customers)
			if(customer.getID() == ID) {
				if(customer.enoughFunds(n)) {
					temp = true;
					break;
				} else {
					temp = false;
					break;
				}
			}
			if(temp) {
				return true;
			} else {
				return false;
			}
			
	}



	


}
