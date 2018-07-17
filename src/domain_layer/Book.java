package domain_layer;

public class Book 
{
	private int isbn;
	private double price;
	private String title;
	private String author;
	private String genre;
	private String publisher;
	private String vendor;
	private int stock;
	private String promoCode;
	private double promoPrice;
	private int hold; //
	
	public Book(int isbn) {
		setISBN(isbn);
	}
	
	public Book(int isbn, double price, String title, String author, String genre, String publisher, String vendor,int stock, String promoCode, double promoPrice, int hold){
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
		setHold(hold);
	}
	
	public String displayCustomerInfo()
	{
		String p = String.format("%.2f", getPrice());
		return String.format(getTitle() + "%n" + getAuthor() + "%n" + p + "%n" + getGenre() + "%n" + getISBN() + "%n" + getPublisher() + "%n" + getVendor() + "%n%n");
	}
	
	public String displayAdminInfo()
	{
		String p = String.format("%.2f", getPrice());
		String pp = String.format("%.2f", getPromoPrice());
		return String.format(getTitle() + "%n" + getAuthor() + "%n" + p + "%n" + getGenre() + "%n" + getISBN() + "%n" + getPublisher() + "%n" + getVendor() + "%n" + getPromoCode() + "%n" + pp + "%n%n");
	}
	
	//compare inputted promoCode with recorded promoCode and
		//return the appropriate price
	public double checkPromoPrice(String promoCode) {
		if (promoCode == getPromoCode()){
			return promoPrice;
		}
		else
			return getPrice();
	}

	public int getISBN() {
		return isbn;
	}

	public void setISBN(int isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
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

	public double getPromoPrice() {
		return promoPrice;
	}

	public void setPromoPrice(double promoPrice) {
		this.promoPrice = promoPrice;
	}
	
	public double getHold() {
		return hold;
	}

	public void setHold(int hold) {
		this.hold = hold;
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
