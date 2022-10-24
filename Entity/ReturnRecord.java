package Entity;

public class ReturnRecord {
	private int id;
	private BorrowRecord borrowRecord;
	private int quantity;
	private String date;

	public ReturnRecord(int id, BorrowRecord borrowRecord, int quantity, String date) {
		super();
		this.id = id;
		this.borrowRecord = borrowRecord;
		this.quantity = quantity;
		this.date = date;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BorrowRecord getBorrowRecord() {
		return borrowRecord;
	}

	public void setBorrowRecord(BorrowRecord borrowRecord) {
		this.borrowRecord = borrowRecord;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
