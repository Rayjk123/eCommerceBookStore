package domain_layer;

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
	
	Book(int isbn, float price, String title, String author,String genre, String publisher, String vendor,int stock, String promoCode, float promoPrice){
		setISBN(isbn);
		setPrice(price);
		setTitle(title);
		setAuthor(author);
		setGenre(genre);
		setPublisher(publisher);
		setVendor(vendor);
		setStock(stock);
		setPromoCode(promoCode);
		setPromoPrice(promoPrice);
	}
	
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

	//compare inputted promoCode with recorded promoCode and
	//return the appropriate price
	public float getPromoPrice(String promoCode) {
		if (promoCode == getPromoCode()){
			return promoPrice;
		}
		else
			return getPrice();
	}

	public void setPromoPrice(float promoPrice) {
		this.promoPrice = promoPrice;
	}
	
	public boolean checkInfo()
	{
		return true;
	}
	
	public boolean soldOut()
	{
		return false;
	}
}
