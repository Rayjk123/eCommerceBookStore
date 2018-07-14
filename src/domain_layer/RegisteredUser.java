package domain_layer;

public class RegisteredUser {
	private int accountID;
	private String firstName;
	private String lastName;
	private String email;
	private String dateOfBirth;
	private String password;
	
	RegisteredUser(int accountID, String firstName, 
			String lastName, String email, String dateOfBirth,
			String password) {
		setAccountID(accountID);
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setDateOfBirth(dateOfBirth);
		setPassword(password);
	}
	
	public void register() {
		
	}
	
	public void verification() {
		
	}
	
	public boolean checkInfo() {
		return true;
	}
	
	public boolean login() {
		return true;
	}
	
	public boolean logout() {
		return false;
	}
	
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	} 

	
}
