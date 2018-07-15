package domain_layer;

public class Order {
	
	private int orderID;
	private Cart orderContents;

	public Order(int orderID, Cart orderContents) {
		setOrderID(orderID);
		setOrderContents(orderContents);
	}
	
	public void checkout() {
		
	}
	
	public boolean cardDeclined() {
		return false;
	}
	
	public boolean holdOrder() {
		return false;
	}
	
	public void usePromotion() {
		
	}
	
	public boolean missingInfo() {
		return false;
	}
	
	public void createOrder() {
		
	}
	
	public void displayOrder() {
		
	}
	
	public void editOrder() {

	}
	
	public void cancelOrder() {
		
	}
	
	public void searchOrder() {
		
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Cart getOrderContents() {
		return orderContents;
	}

	public void setOrderContents(Cart orderContents) {
		this.orderContents = orderContents;
	}
}
