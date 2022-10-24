package Entity;

public class Stock {
	private Warehouse warehouse;
	private Book book;
	private int quantity;

	public Stock(Warehouse warehouse, Book book, int quantity) {
		super();
		this.warehouse = warehouse;
		this.book = book;
		this.quantity = quantity;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
