import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
//import java.util.HashMap;
import java.util.List;

public class Library implements Serializable{
	
		private List<Book> collection;
		
		public Library() {
			collection = new ArrayList<Book>();
		}
		
		public void addBook(Book book) {
			collection.add(book);
		}
		
		public String toString() {
			String total = "\n";
			
			Iterator<Book> i = collection.iterator();
			while(i.hasNext()) {
				Book b = i.next();
				total = total + b.toString();
			}
			return total;
		}

		/*
		Student student1 = new Student("Amit", 100, "1111111111");
		Student student2 = new Student("Yogesh", 100, "222222222");
		Student student3 = new Student("Dwarka", 100, "3333333333");
		*/
}
