package DataSource;

import Entity.Book;
import Entity.Type;
import Entity.BookType;
import Entity.Author;
import Entity.BookAuthor;
import Entity.Warehouse;
import Entity.Stock;
import Entity.Customer;
import Entity.BorrowRecord;
import Entity.ReturnRecord;

public class DataSource {
	public static Book[] bookList = { new Book(1, "Book A", "ISBN 1"), new Book(2, "Book B", "ISBN 2"),
			new Book(3, "Book C", "ISBN 3") };

	public static Type[] typeList = { new Type(1, "Type 1"), new Type(2, "Type 2"), new Type(3, "Type 3") };

	public static BookType[] bookTypeList = { new BookType(bookList[0], typeList[0]),
			new BookType(bookList[0], typeList[1]), new BookType(bookList[1], typeList[2]),
			new BookType(bookList[2], typeList[0]), new BookType(bookList[2], typeList[2]) };

	public static Author[] authorList = { new Author(1, "Author 1"), new Author(2, "Author 2"),
			new Author(3, "Author 3") };

	public static BookAuthor[] bookAuthorList = { new BookAuthor(bookList[0], authorList[0]),
			new BookAuthor(bookList[0], authorList[1]), new BookAuthor(bookList[1], authorList[2]),
			new BookAuthor(bookList[2], authorList[0]), new BookAuthor(bookList[2], authorList[2]) };

	public static Warehouse[] warehouseList = { new Warehouse(1, "Warehouse A", "Location 1"),
			new Warehouse(2, "Warehouse B", "Location 2"), new Warehouse(3, "Warehouse C", "Location 3") };

	public static Stock[] stockList = { new Stock(warehouseList[0], bookList[0], 2),
			new Stock(warehouseList[0], bookList[1], 5), new Stock(warehouseList[0], bookList[2], 6),
			new Stock(warehouseList[1], bookList[0], 0), new Stock(warehouseList[1], bookList[1], 3),
			new Stock(warehouseList[2], bookList[0], 5), new Stock(warehouseList[2], bookList[2], 8) };

	public static Customer[] customerList = { new Customer(1, "Customer A"), new Customer(2, "Customer B"),
			new Customer(3, "Customer C"), new Customer(4, "Customer D"), new Customer(5, "Customer E") };

	public static BorrowRecord[] borrowRecordList = { 
			new BorrowRecord(1, bookList[0], customerList[0], 1, "20/11/2022"),
			new BorrowRecord(2, bookList[1], customerList[0], 2, "22/11/2022"), 
			new BorrowRecord(3, bookList[0], customerList[1], 3, "24/11/2022"),
			new BorrowRecord(4, bookList[2], customerList[2], 1, "25/11/2022"),
			new BorrowRecord(5, bookList[2], customerList[0], 2, "29/11/2022") };

	public static ReturnRecord[] returnRecordList = { 
			new ReturnRecord(1, borrowRecordList[0], 1, "29/11/2022"),
			new ReturnRecord(2, borrowRecordList[1], 1, "30/11/2022"), 
			new ReturnRecord(3, borrowRecordList[2], 2, "30/11/2022"),
			new ReturnRecord(4, borrowRecordList[1], 1, "01/12/2022"), 
			new ReturnRecord(5, borrowRecordList[3], 1, "05/12/2022") };

}
