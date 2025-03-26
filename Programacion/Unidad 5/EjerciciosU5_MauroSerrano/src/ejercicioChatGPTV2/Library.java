package ejercicioChatGPTV2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Library {
	private Set <Book> bookList;

	public Library(Set<Book> bookList) {
		super();
		this.bookList = bookList;
	}

	public Set<Book> getBookList() {
		return bookList;
	}

	public void setBookList(Set<Book> bookList) {
		this.bookList = bookList;
	}

	@Override
	public String toString() {
		return "Library [bookList=" + bookList + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Library other = (Library) obj;
		return Objects.equals(bookList, other.bookList);
	}
	
	public void addBook(Book b) {
		bookList.add(b);
	}
	
	public Set <Book> searchByAuthor(String author) {
		Set <Book> searchedBooks = new HashSet <Book>();
		
		for(Book b : bookList) {
			if(b.getAuthor().equalsIgnoreCase(author)) {
				searchedBooks.add(b);
			}
		}
		
		return searchedBooks;
	}
	
	public Book searchByISBN(String ISBN) {
		
		for(Book b : bookList) {
			if(b.getISBN().equalsIgnoreCase(ISBN)) {
				return b;
			}
		}
		
		return null;
	}
	
	public int oldestPubYear() {
		Boolean ready = false;
		int oldest = 0;
		
		for(Book b : bookList) {
			if(!ready) {
				oldest = b.getPubYear();
				ready = true;
			}
			if(oldest > b.getPubYear()) {
				oldest = b.getPubYear();
			}
		}
		
		return oldest;
	}
	
	public Set <Book> searchByYear(int year) {
		Set <Book> searchedBooks = new HashSet <Book>();
		
		for(Book b : bookList) {
			if(b.getPubYear() == year) {
				searchedBooks.add(b);
			}
		}
		
		return searchedBooks;
	}
	
	public boolean removeBook(Book b) {
		boolean achived = false;
		
		if(b != null) {
			bookList.remove(b);
			achived = true;
		}
		
		return achived;
	}
	
	public boolean modifyPrice(Book b, double price) {
		boolean achived = false;
		
		if(b != null) {
			b.setPrice(price);;
			achived = true;
		}
		
		return achived;
	}
	
	public Set <Book> orderByISBN(){
		Set <Book> sortedList = new TreeSet <Book> (bookList);
		
		return sortedList;
	}
	
	public List <Book> orderByPubYear(){
		List <Book> sortedList = new ArrayList <Book> (bookList);
		
		Collections.sort(sortedList, new CompareByYear());
		
		return sortedList;
	}
	
	public Set <Book> searchAvailableBooks(){
		Set <Book> availableBooks = new HashSet <Book> ();
		Iterator <Book> it = bookList.iterator(); 
		
		while(it.hasNext()) {
			Book b = it.next();
			if(b.isAvailable()) {
				availableBooks.add(b);
			}
		}
		
		return availableBooks;
		
	}
	
}
