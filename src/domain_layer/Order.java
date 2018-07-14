package domain_layer;

public class Order {
	
	private int orderID;
	private Cart orderContents;

	public Order(int orderID, Cart orderContents) {
		setOrderID(orderID);
		setOrderContents(orderContents);
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
