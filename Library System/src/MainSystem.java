import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class MainSystem implements Serializable{

	static String filename = null;
	static Library lib = new Library();
	static Scanner in = new Scanner(System.in);
	static Boolean running = true;

	public static void main(String[] args) {
		while (running) {
			System.out.println("\nEnter 0 for load a library." 
					+ "\nEnter 1 for save and quit"
					+ "\nEnter 2 for list all books" 
					+ "\nEnter 3 for add book to library");
			int answer = in.nextInt();
			switch(answer) {
			case 0:
				System.out.println("Enter the file name to load");
				loadScript(in.next());	
				break;
				
			case 1:
				saveAndQuit();
				
				break;
			case 2:
				System.out.println(lib.toString());
				
				break;
				
			case 3:
				addBook();
				break;
			}
		}
		System.exit(0);
	}

	private static void addBook() {
		// TODO Auto-generated method stub
		 String title, author;
		 int serialNum;
		int qty;
		 
		 System.out.println("\nEnter Title: ");
		 title = in.next();
		 
		 System.out.println("\nEnter Author: ");
		 author = in.next();
		 
		 System.out.println("\nEnter SerialNumber: ");
		 serialNum = in.nextInt();
		 
		 System.out.println("\nEnter Quantity: ");
		 qty = in.nextInt();
		 
		 
		 Book b = new Book(author, title, serialNum);
		 lib.addBook(b);
	}

	private static void saveAndQuit() {
		// TODO Auto-generated method stub
		System.out.println("Enter File name: ");
		filename = in.next()+ ".ser";
		running = false;
		FileOutputStream fos= null;
		ObjectOutputStream out = null;
		
		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(lib);
			fos.close();
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException ex) {
			ex.printStackTrace();

		}
	}

	private static void loadScript(String name) {
		FileInputStream fis = null;
		ObjectInputStream in = null;
		
		File file = new File(name+ ".ser");
		
		if(file.exists()) {
		try {
		fis = new FileInputStream(file);
		in = new ObjectInputStream(fis);
		lib = (Library)in.readObject();
		fis.close();
		in.close();
		
		}
		catch (IOException e){
			System.out.println("File not found");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		}
		else {
			System.out.println("\nFile Doesnot Exist");
		}
		
	}
}
