package Entity;

public class BorrowRecord {
	private int id;
	private Book book;
	private Customer customer;
	private int quantity;
	private String borrowDate;
	
	public BorrowRecord(int id, Book book, Customer customer, int quantity, String borrowDate) {
		super();
		this.id = id;
		this.book = book;
		this.customer = customer;
		this.quantity = quantity;
		this.borrowDate = borrowDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}
	
}
