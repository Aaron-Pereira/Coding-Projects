import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Catalogue {
	private Kiosk kiosk;
	private LinkedList<Game> gamesAvailable = new LinkedList<Game>();
	private LinkedList<Game> gamesRented = new LinkedList<Game>(); 
	private LinkedList<Genre> genres = new LinkedList<Genre>();
	private LinkedList<Game> games = new LinkedList<Game>();

    		// write your solution here
	public Catalogue(Kiosk kiosk) {
		this.kiosk = kiosk;
		genres.add(new Genre("Action Queue"));
		genres.add(new Genre("Role Playing"));
		genres.add(new Genre("Hand Management"));
		genres.add(new Genre("Modular Board"));
		games.add(new Game("Robinson Crusoe", 2012, 3, genres.get(0)));
		games.add(new Game("Talisman", 2007, 4, genres.get(1)));
		games.add(new Game("Three Kingdoms Redux", 2014, 3, genres.get(2)));
		games.add(new Game("Dungeons & Dragons", 2010, 4, genres.get(3)));
		games.add(new Game("Elder Sign", 2011, 3, genres.get(3)));

		for (Game game : games)
			gamesAvailable.add(game);
		
		//gamesAvailable = games
		//Kiosk kiosk = new Kiosk();
		//kiosk.readChoice();

		/*
		games.add(new Game("Robinson Crusoe", 2012, 3, new Genre("Action Queue")));
		games.add(new Game("Talisman", 2007, 4, new Genre("Role Playing")));
		games.add(new Game("Three Kingdoms Redux", 2014, 3, new Genre("Hand Management")));
		games.add(new Game("Dungeons & Dragons", 2010, 4, new Genre("Modular Board")));
		games.add(new Game("Elder Sign", 2011, 3, new Genre("Modular Board")));
		*/
		
	}

	public void displayCatalogue() {

		System.out.println("Welcome to the Catalogue! Please make a selection from the menu:");
		System.out.println("1." + " " +  "Display all games.");
		System.out.println("2." + " " +  "Display all available games.");
		System.out.println("3." + " " +  "Display all genres.");
		System.out.println("4." + " " +  "Display games in a genre.");
		System.out.println("5." + " " +  "Display all games by year.");
		System.out.println("6." + " " +  "Rent a game.");
		System.out.println("7." + " " +  "Return a game.");
		System.out.println("R." + " " +  "Return to previous menu.");

		char userSelection;
		userSelection = readChoice();
		//while((userSelection = readChoice()) != 'X'){
            switch(userSelection){
                case '1': displayGames(); break;
                case '2': displayAvailableGames(); break;
                case '3': displayGenres(); break;
                case '4': displayGamesByGenre(); break;
                case '5': displayGamesByYear(); break;
				case '6': rentGame(); break;
				case '7': returnGame(); break;
				case 'R': kiosk.use(); break;
				
                default: displayCatalogueHelp(); break;
            
		}
		
		
	}

	private void displayCatalogueHelp() {
		System.out.println("Please enter a number between 1 and 7 or press R to return to the previous menu.");
		displayCatalogue();
	}

	private char readChoice() {
		System.out.print("Enter a choice: ");
		return In.nextChar();
	}

	
	private void displayGames() {
		System.out.println("");
		System.out.println("The Kiosk has the following games:");
		for(Game game : games)
			System.out.println(game);
		System.out.println("");
		displayCatalogue();
	}

	private void displayAvailableGames() {
		System.out.println("");
		System.out.println("The following games are available:");
		for(Game game : gamesAvailable)
			System.out.println(game);
		System.out.println("");
		displayCatalogue();
	}

	private void displayGenres() {
		System.out.println("");
		System.out.println("The Kiosk has games in the following genres:");
		for (Genre genre : genres) {
			System.out.println(genre);
		}
		System.out.println("");
		displayCatalogue();
	}

	private void displayGamesByGenre() {
		boolean temp = false;
		System.out.println("");
		System.out.print("Enter a genre: ");
		String genre = readName();
		System.out.println("The kiosk has the following games in that genre:");
		for(Game game : games)
			if(game.getGenre().equals(genre)) {
				System.out.println(game);
				//System.out.println("");
				//displayCatalogue();
				temp = true;
			}
		if (temp == false) {
		//	System.out.println("");
			//displayCatalogue();
		}
		System.out.println("");
		displayCatalogue();
	}

	private void displayGamesByYear() {
		boolean temp = false;
		System.out.println("");
		System.out.print("Enter the year: ");
		int year = readNumber();
		System.out.println("The kiosk has the following games by that year:");
		for(Game game : games)
			if(game.getYear() == year) {
				System.out.println(game);
				//System.out.println("");
				//displayCatalogue();
				temp = true;
			}
		if (temp == false) {
			//System.out.println("");
			//displayCatalogue();
		}
		System.out.println("");
		displayCatalogue();
			
	
}

	private void rentGame() {
		//verify customer does exist
		//find game customer wants
		//remove games from available
		System.out.println("");
		String name;
		System.out.print("Enter a valid customer ID: ");
		int n = readNumber();
		//System.out.println(kiosk.checkCustomer(n));
		if(kiosk.checkCustomer(n)) {
			System.out.print("Enter the title of the game you wish to rent: ");
			name = readName();
			if(gameAvailableCheck(name, n)) {
				
				if(enoughFunds(name, n)) {
					//System.out.println("Check 1" +enoughFunds(name, n));
					deductFunds(name, n);
					removeAvailableGame(name, n);
					
					System.out.println("Game rented.");
				//matches.add(game);
					System.out.println("");
					displayCatalogue();
				} else {
					//System.out.println("Check 2" + enoughFunds(name, n));
					System.out.println("You don't have sufficient funds to rent this game.");
					System.out.println("");
					displayCatalogue();
				}
				
			}
			else {
				
				System.out.println("That game is not available or doesn't exist.");
				System.out.println("");
				displayCatalogue();
			}


		} else {
			System.out.println("not correct ID");
		}
		
	}

	private boolean enoughFunds(String name, int ID) {
		int price;
		boolean temp = false;
		for(Game game : games) 
			if(game.getTitle().equals(name)){
				price = game.getPrice();
				if(kiosk.enoughFunds(ID, price)) {
					//System.out.println("Check 1" +kiosk.enoughFunds(ID, price));
					temp = true;
					break;
				} else {
					//System.out.println("Check 2" + kiosk.enoughFunds(ID, price));
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

	private void removeAvailableGame(String title, int ID) {
		LinkedList<Game> matches = new LinkedList<Game>();
		for(Game game : gamesAvailable)
			if(game.getTitle().equals(title)) {
				matches.add(game);
				gamesAvailable.removeAll(matches);
				addToCustomerRent(game, ID);
				break;
			}
	}


	private void deductFunds(String name, int ID) {
		int price;
		for(Game game : games) 
			if(game.getTitle().equals(name)){
				price = game.getPrice();
				kiosk.deductFunds(ID, price);
		}
		
	}

	private boolean gameAvailableCheck(String title, int ID) {
		//LinkedList<Game> matches = new LinkedList<Game>();
		boolean temp = false;
		for(Game game : gamesAvailable)
			if(game.getTitle().equals(title)) {
				temp = true;
				//matches.add(game);
				//add game to customers own list
				//addToCustomerRent(game, ID);
				break;
				//return true;
			} else  {
				temp = false;
			}
	
		if(temp) {
			//gamesAvailable.removeAll(matches);
			return true;
	
		} else {
			return false;
		}
	}

	public void addToCustomerRent(Game game, int ID) {
		//System.out.println(title + ID);
		kiosk.addToCustomerRent(game, ID);
	}

	private void removeCustomerRent(String title, int ID) {
		for(Game game : games)
			if(game.getTitle().equals(title))
				kiosk.removeCustomerRent(game, ID);
				
	}

	private void returnGame() {
		System.out.println("");
		String name;
		System.out.print("Enter a valid customer ID: ");
		int n = readNumber();
		//System.out.println(kiosk.checkCustomer(n));
		if(kiosk.checkCustomer(n)) {
			kiosk.showGamesRented(n);
			System.out.print("Enter the title of the game you wish to return: ");
			name = readName();
			if(kiosk.gameRented(name, n)) {
				//check if game is held by customer
				removeCustomerRent(name, n);
				returnToAvailableList(name);
				System.out.println(name + " has been returned.");
				//matches.add(game);
				System.out.println("");
				displayCatalogue();
			}
			else {
				System.out.println("That game is not available or doesn't exist.");
				System.out.println("");
				displayCatalogue();
			}
			//return games rented by customer
			//need to use kiosk class to do this
			
		} else {
			System.out.println("not correct ID");
		}
		

	}

	private void returnToAvailableList(String title) {
		//System.out.println("called");
		for(Game game : games)
			if(game.getTitle().equals(title)) {
				gamesAvailable.add(game);
	}
	}
	
	public void listGames() {
		System.out.println("");
		System.out.println("The Kiosk has the following games:");
		for(Game game : games)
			System.out.println(game);
		System.out.println("");
		kiosk.Admin();
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


	public void addGame() {
		System.out.println("");
		System.out.println("Adding a new game.");
		System.out.print("Enter the title of the game: ");
		String title = readName();
		System.out.print("Enter the year: ");
		int year = readNumber();
		System.out.print("Enter the genre: ");
		String genre = readName();
		System.out.print("Enter price: ");
		int price = readNumber();

		checkGame(title, year, genre, price);

	}

	private void checkGame(String title, int year, String genre, int price) {
		boolean temp = false;
		for(Game game : games)
			if(game.getTitle().equals(title) && game.getYear() == year &&  game.getGenre().equals(genre)) {
				temp = true;
				break;
				//return true;
			} else  {
				temp = false;
			}

		//System.out.println(temp);
			
		if(temp) {
			//System.out.println("");
			System.out.println("The game is already in the catalogue.");
			kiosk.Admin();
			
			
		} else {
			System.out.println("Added " + title + " to catalogue.");
			games.add(new Game(title, year, price, new Genre(genre)));
			System.out.println("");
			kiosk.Admin();
		}

	}


	public void removeGame() {
		LinkedList<Game> matches = new LinkedList<Game>();
		System.out.println("");
		System.out.println("Removing a game.");
		System.out.print("Enter the title of the game: ");
		String gameName = readName();
		System.out.print("Enter the year: ");
		int gameYear = readNumber();
		boolean temp = false;
		
		for (Game game : games)
			if(game.getTitle().equals(gameName) && game.getYear() == gameYear) {
				//System.out.println("called");
				
				//System.out.println(game.toString() + " removed from catalogue.");
				matches.add(game);
				temp = false;
				break;
			}
			else {
				temp = true;
			}
		if(temp) {
			System.out.println("No such game found.");
		} else {
			System.out.println(matches.get(0) + " removed from catalogue.");
		}
				
		//System.out.println(matches.get(0) + " removed from catalogue.");
		games.removeAll(matches);
		System.out.println("");
		kiosk.Admin();

		
	}




}
