package Entity;

public class BookType {
	private Book book;
	private Type type;

	public BookType(Book book, Type type) {
		super();
		this.book = book;
		this.type = type;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
