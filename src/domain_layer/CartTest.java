package domain_layer;

public class CartTest {

	//just testing for now
	public static void main(String[] args) {
		
		Book book1 = new Book(1111111, 9.50, "Hotel Silence", "Auður Ava Ólafsdóttir", "Suspense", "Some Publisher", "Some Vendor", 25, "HOLIDAYINN", 8.50); 
		Book book2 = new Book(222222, 11.50, "The Hobbit", "J.R.R. Tolkien", "Fantasy", "Some Publisher", "Some Vendor", 50, "LOTR", 9.50); 	
		
		Book[] bookArray = { book1, book2};
		Cart cart = new Cart(bookArray); 
		
		Book book3 = new Book(333333, 14.00, "Cloud Atlas", "David Mitchel", "Science Fiction", "Some Publisher", "Some Vendor", 18, "MULTITUDEOFDROPS", 11.50); 	

		System.out.println(cart.viewCart());
		
		cart.addToCart(book3);
		
		System.out.println(cart.viewCart());
		
		cart.removeFromCart(book1);
		
		System.out.println(cart.viewCart());
	}
}
