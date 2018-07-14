package domain_layer;

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
	
	public void addToCart(Book book) {
		//array arithmetic to add book to array
		
		//use temp array method
	}
	
	public void removeFromCart(Book book) {
		
	}
}
