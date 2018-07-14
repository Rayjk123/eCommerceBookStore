package domain_layer;

public class Customer extends RegisteredUser {

	private String address;
	private int ccNumber;
	private String ccExpiration;
	private boolean subscripion;
	
	//constructor for only address as it will be required
	public Customer(int accountID, String firstName, 
			String lastName, String email, String dateOfBirth,
			String password, String address) {
		super(accountID, firstName, lastName, email, 
				dateOfBirth, password);
		setAddress(address);
	}
	
	//constructor for included optional cc information
	public Customer(int accountID, String firstName, 
			String lastName, String email, String dateOfBirth,
			String password, String address, int ccNumber, 
			String ccExpiration, boolean subscription){
		super(accountID, firstName, lastName, email, 
				dateOfBirth, password);
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

	public int getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(int ccNumber) {
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
}
