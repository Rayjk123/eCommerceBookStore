package domain_layer;

public class ElevatedUser extends RegisteredUser {
	
	private int elevatedID;
	
	public ElevatedUser(int accountID, String firstName, String lastName, String email, String dateOfBirth,String password, int permLevel, int elevatedID) {
		super(accountID, firstName, lastName, email, dateOfBirth, password, permLevel);
		setElevatedID(elevatedID);
	}

	public int getElevatedID() {
		return elevatedID;
	}

	public void setElevatedID(int elevatedID) {
		this.elevatedID = elevatedID;
	}
}
