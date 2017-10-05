import java.io.Serializable;

public class Book implements Serializable{
	private String title, author;
	public int serialNum, qty;
	
	public Book (String title, String author, int num) {
		this.title = title;
		this.author = author;
		this.serialNum = num;
	}
	
	public String toString() {
		return "\nTitle: " + title + "\nAuthor: " + author + 
				"\nSerial: " + serialNum + "\nQuantity: " + qty + "\n";
	}
}
