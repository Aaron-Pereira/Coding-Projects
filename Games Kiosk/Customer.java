import java.util.ArrayList;
import java.util.List;
import java.util.*;


public class Customer {
	private int ID; 
	private String name; 
	private int balance;
	private LinkedList<Game> currentlyRented = new LinkedList<Game>(); 
	private LinkedList<Game> rentingHistory = new LinkedList<Game>();

		// write your solution here

	public Customer(int ID, String name, int balance) {
		this.ID = ID;
		this.name = name;
		this.balance = balance;
	}

	public String toString() {
		return ID + "\t" + name + "\t" + "$ " + balance;
	}

	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}

	public int getID() {
		return ID;
	}

	public void deductFunds(int price) {
		balance = balance - price;
	}

	public void setCurrentlyRented(Game game) {
		currentlyRented.add(game);
		rentingHistory.add(game);
	}

	public void getCurrentlyRented() {
		for(Game game : currentlyRented) 
			System.out.println(game);
	}

	public void getRentingHistory() {
		for(Game game : rentingHistory) 
			System.out.println(game);
	}

	public void removeCurrentlyRented(Game game) {
		LinkedList<Game> matches = new LinkedList<Game>();
		matches.add(game);
		//currentlyRented.remove(game);
		currentlyRented.removeAll(matches);
		//System.out.println("hello");
	}

	public boolean gameRented(String title, int ID) {
		for(Game game : currentlyRented)
			if(game.getTitle().equals(title)) {
				
				return true;
			}
			return false;
	}

	public void topUp(int amt) {
		balance = balance + amt;
	}

	public boolean enoughFunds(int n) {
		if(n > balance) {
			return false;
		} else {
			return true;
		}
	}



	
}
