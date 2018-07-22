package domain_layer;

public class CreditCard {
	public CreditCard() {
		
	}
	
	private String cardNumber;
	private String cardSecurityCode;
	private String cardExpiration;
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardSecurityCode() {
		return cardSecurityCode;
	}
	public void setCardSecurityCode(String cardSecurityCode) {
		this.cardSecurityCode = cardSecurityCode;
	}
	public String getCardExpiration() {
		return cardExpiration;
	}
	public void setCardExpiration(String cardExpiration) {
		this.cardExpiration = cardExpiration;
	}
	
	
}
