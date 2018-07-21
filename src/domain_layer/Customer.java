package domain_layer;

public class Customer extends RegisteredUser {

	private String address;
	private String billingAddress;
	private String shippingAddress;
	private String ccNumber;
	private String ccExpiration;
	private String securityCode;
	private boolean subscripion;
	
	public Customer() {
		
	}
	
	//constructor for only address as it will be required
	public Customer(int accountID, String firstName, String lastName, String email, String dateOfBirth,String password, int permLevel, String address) {
		super(accountID, firstName, lastName, email, dateOfBirth, password, permLevel);
		setAddress(address);
	}
	
	//constructor for included optional cc information
	public Customer(int accountID, String firstName, String lastName, String email, String dateOfBirth,String password, int permLevel, String address, String ccNumber, String ccExpiration, boolean subscription){
		super(accountID, firstName, lastName, email, 
				dateOfBirth, password, permLevel);
		setAddress(address);
		setCcNumber(ccNumber);
		setCcExpiration(ccExpiration);
		setSubscripion(subscripion);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getCcExpiration() {
		return ccExpiration;
	}

	public void setCcExpiration(String ccExpiration) {
		this.ccExpiration = ccExpiration;
	}

	public boolean isSubscripion() {
		return subscripion;
	}

	public void setSubscripion(boolean subscripion) {
		this.subscripion = subscripion;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
}
