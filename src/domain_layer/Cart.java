package domain_layer;
import java.util.Arrays;

public class Cart {
	private Book[] contents;
	
	public Cart(Book[] contents){
		setContents(contents);
	}

	public Book[] getContents() {
		return contents;
	}

	public void setContents(Book[] contents) {
		this.contents = contents;
	}
	
	public Book[] addToCart(Book addedBook) {
		//array arithmetic to add book to array
		Book[] tempCart = new Book[getContents().length+1];
		
		System.arraycopy(getContents(),  0, tempCart, 0, getContents().length);
		
		tempCart[getContents().length+1] = addedBook;
		
		setContents(tempCart);
		
		return tempCart; //contents after adding to the array
	}
	
	public void removeFromCart(Book book) {
		Book[] tempCart = new Book[getContents().length-1];
		
		for (int i = 1; i < getContents().length; i++){
			int j = 1;
			if (getContents()[i] != book)
			{
				tempCart[j] = getContents()[i];
				j++;
			}
		}
	}
}
