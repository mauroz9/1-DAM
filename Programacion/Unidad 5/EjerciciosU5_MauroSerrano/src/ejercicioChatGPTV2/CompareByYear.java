package ejercicioChatGPTV2;

import java.util.Comparator;

public class CompareByYear implements Comparator <Book>{

	@Override
	public int compare(Book b1, Book b2) {
		int yearCompare = Integer.compare(b1.getPubYear(), b2.getPubYear());
		if(yearCompare != 0) {
			return yearCompare;
		}
		
		return Double.compare(b1.getPrice(), b2.getPrice());
	}
	
}
