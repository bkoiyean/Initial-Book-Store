package Entity;

public class Book {
	private int id;
	private String name;
	private String ISBN;

	public Book(int id, String name, String iSBN) {
		super();
		this.id = id;
		this.name = name;
		ISBN = iSBN;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

}
