package domain_layer;

public class Book 
{
	private String isbn;
	private double price;
	private String title;
	private String author;
	private String genre;
	private String publisher;
	private String vendor;
	private int stock;
	private String promoCode;
	private double promoPrice;
	private int hold; 
	private String image; //URL or fully qualified path to image file
	private String description; //long string of book description
	
	public Book() {
		
	}
	
	public Book(String isbn) {
		setIsbn(isbn);
	}
	
	public Book(String isbn, double price, String title, String author, String genre, String publisher, String vendor,int stock, String promoCode, double promoPrice, int hold, String image, String description){
		setIsbn(isbn);
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
		setImage(image);
		setDescription(description);
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
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean checkInfo()
	{
		return true;
	}
	
	public boolean soldOut()
	{
		return false;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}
