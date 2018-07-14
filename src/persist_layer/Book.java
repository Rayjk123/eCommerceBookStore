package persist_layer;

public class Book 
{
	private int isbn;
	private float price;
	private String title;
	private String author;
	private String genre;
	private String publisher;
	private String vendor;
	private int stock;
	private String promoCode;
	private float promoPrice;
	
	public String displayInfo()
	{
		return String.format(getTitle() + ".%n" + 
				getAuthor() + ".%n" + 
				"%.2f", getPrice() + ".%n" + 
				getGenre() + ".%n" + 
				getISBN() + ".%n" +
				getPublisher() + ".%n" + 
				getVendor() + ".%n");
	}

	public int getISBN() {
		return isbn;
	}

	public void setISBN(int isbn) {
		this.isbn = isbn;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public float getPromoPrice() {
		return promoPrice;
	}

	public void setPromoPrice(float promoPrice) {
		this.promoPrice = promoPrice;
	}
	
	
}
