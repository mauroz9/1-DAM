package ejercicioChatGPTV2;

import java.util.Objects;

public class Book implements Comparable<Book>{
	private String ISBN;
	private String title;
	private String author;
	private int pubYear;
	private double price;
	private boolean available;
	
	public Book(String iSBN, String title, String author, int pubYear, double price, boolean available) {
		super();
		ISBN = iSBN;
		this.title = title;
		this.author = author;
		this.pubYear = pubYear;
		this.price = price;
		this.available = available;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPubYear() {
		return pubYear;
	}

	public void setPubYear(int pubYear) {
		this.pubYear = pubYear;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Libro [ISBN=" + ISBN + ", title=" + title + ", author=" + author + ", pubYear=" + pubYear + ", price="
				+ price + ", available=" + available + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(ISBN, other.ISBN) && Objects.equals(author, other.author) && available == other.available
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && pubYear == other.pubYear
				&& Objects.equals(title, other.title);
	}

	@Override
	public int compareTo(Book b) {
		return this.ISBN.compareToIgnoreCase(b.getISBN());
	}
	
	
}
