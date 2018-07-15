package domain_layer;

public class Cart {
	private Book[] contents;
	
	public Cart(Book[] contents){
		setContents(contents);
	}
	
	public Cart() {
		
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
		
		tempCart[getContents().length] = addedBook;
		
		setContents(tempCart);
		return tempCart; //contents after adding to the array
	}
	
	public Book[] removeFromCart(Book book) {
		Book[] tempCart = new Book[getContents().length-1];
		int j = 0; //for indexing the temporary cart
		
		for (int i = 0; i < getContents().length; i++){
			if (getContents()[i] != book)
			{
				tempCart[j] = getContents()[i]; //copy non-removed book to tempCart
				j++;
			}
		}
		setContents(tempCart);
		return tempCart;
	}
	
	public String viewCart() {
		StringBuilder displayCartInfo = new StringBuilder();
		
		for (int i = 0; i < getContents().length; i++) {
			displayCartInfo = displayCartInfo.append(getContents()[i].displayAdminInfo());
		}
		
		return displayCartInfo.toString();
	}
}
