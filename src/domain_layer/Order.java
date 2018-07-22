package domain_layer;

public class Order {
	public Order() {
		
	}
	
	private int orderNumber;
	private String email;
	private double total;
	private double tax;
	private double subTotal;
	private double shippingCost;
	private String paymentCard;
	private String shippingAddress;
	private String billingAddress;
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public double getShippingCost() {
		return shippingCost;
	}
	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}
	public String getPaymentCard() {
		return paymentCard;
	}
	public void setPaymentCard(String paymentCard) {
		this.paymentCard = paymentCard;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
}
