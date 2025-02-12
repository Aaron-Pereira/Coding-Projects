import java.util.ArrayList;
import java.util.List;

public class Game {
	private String title; 
	private int year; 
	private int price; 
	private Genre genre;
		// write your solution here
	public Game(String title, int year, int price, Genre genre) {
		this.title = title;
		this.year = year;
		this.price = price;
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public int getPrice() {
		return price;
	}

	public String getGenre() {
		return genre.getName();
	}

	public String toString() {
		return year + "\t" + title + "\t"  + genre.toString() + "\t" + "$" + price;
	}
}
