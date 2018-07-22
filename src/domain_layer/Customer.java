package domain_layer;

public class Customer extends RegisteredUser {

	private String address;
	private String billingAddress;
	private String shippingAddress;
	private String ccNumber;
	private String ccExpiration;
	private String securityCode;
	private String subscription;
	private String permission; 
	private String streetBilling;
	private String cityBilling;
	private String stateBilling;
	private String zipBilling;
	private String streetShipping;
	private String cityShipping;
	private String stateShipping;
	private String zipShipping;

	public Customer() {
		super();
	}
	
	//constructor for only address as it will be required
	public Customer(int accountID, String firstName, String lastName, String email, String dateOfBirth,String password, int permLevel, String address) {
		super(accountID, firstName, lastName, email, dateOfBirth, password, permLevel);
		setAddress(address);
	}
	
	//constructor for included optional cc information
	public Customer(int accountID, String firstName, String lastName, String email, String dateOfBirth,String password, int permLevel, String address, String ccNumber, String ccExpiration, String subscription){
		super(accountID, firstName, lastName, email, 
				dateOfBirth, password, permLevel);
		setAddress(address);
		setCcNumber(ccNumber);
		setCcExpiration(ccExpiration);
		setSubscripion(subscription);
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

	public String getSubscription() {
		return subscription;
	}

	public void setSubscripion(String subscription) {
		this.subscription = subscription;
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
	
	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getStreetBilling() {
		return streetBilling;
	}

	public void setStreetBilling(String streetBilling) {
		this.streetBilling = streetBilling;
	}

	public String getCityBilling() {
		return cityBilling;
	}

	public void setCityBilling(String cityBilling) {
		this.cityBilling = cityBilling;
	}

	public String getStateBilling() {
		return stateBilling;
	}

	public void setStateBilling(String stateBilling) {
		this.stateBilling = stateBilling;
	}

	public String getZipBilling() {
		return zipBilling;
	}

	public void setZipBilling(String zipBilling) {
		this.zipBilling = zipBilling;
	}

	public String getStreetShipping() {
		return streetShipping;
	}

	public void setStreetShipping(String streetShipping) {
		this.streetShipping = streetShipping;
	}

	public String getCityShipping() {
		return cityShipping;
	}

	public void setCityShipping(String cityShipping) {
		this.cityShipping = cityShipping;
	}

	public String getStateShipping() {
		return stateShipping;
	}

	public void setStateShipping(String stateShipping) {
		this.stateShipping = stateShipping;
	}

	public String getZipShipping() {
		return zipShipping;
	}

	public void setZipShipping(String zipShipping) {
		this.zipShipping = zipShipping;
	}
	
	
}
