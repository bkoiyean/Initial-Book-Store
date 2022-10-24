package Service;

import java.util.ArrayList;

import Entity.Book;
import Entity.Stock;
import Entity.Customer;
import Entity.BorrowRecord;
import Entity.ReturnRecord;
import DataSource.DataSource;

public class Service {
	public static BorrowRecord[] borrowRecordList = updatedBorrowRecord(DataSource.borrowRecordList, DataSource.returnRecordList);
	
	public static BorrowRecord[] updatedBorrowRecord(BorrowRecord borrowRecordList[], ReturnRecord returnRecordList[]) {
		for (BorrowRecord borrowRecord : borrowRecordList) {
			for (ReturnRecord returnRecord : returnRecordList) {
				if (returnRecord.getBorrowRecord().getId() == borrowRecord.getId()) {
					borrowRecord.setQuantity(borrowRecord.getQuantity() - returnRecord.getQuantity());
				}
			}
		}
		return borrowRecordList;
	}

	public static ArrayList<Integer> getBorrowedBookIdListArray(BorrowRecord borrowRecordList[], Book bookList[]) {
		ArrayList<Integer> borrowedBookIds = new ArrayList<Integer>();
		for (BorrowRecord borrowRecord : borrowRecordList) {
			for (Book book : bookList) {
				if (borrowRecord.getQuantity() > 0 && borrowRecord.getBook().getId() == book.getId()
						&& !borrowedBookIds.contains(book.getId())) {
					borrowedBookIds.add(book.getId());
				}
			}

		}
		return borrowedBookIds;

	}

	public static ArrayList<Integer> getBorrowedCustomerIdPerBookListArray(BorrowRecord borrowRecordList[], int bookId,
			Customer customerList[]) {
		ArrayList<Integer> borrowedCustomerIds = new ArrayList<Integer>();
		for (BorrowRecord borrowRecord : borrowRecordList) {
			if (borrowRecord.getBook().getId() == bookId) {
				for (Customer customer : customerList) {
					if (borrowRecord.getQuantity() > 0 && borrowRecord.getCustomer().getId() == customer.getId()
							&& !borrowedCustomerIds.contains(customer.getId())) {
						borrowedCustomerIds.add(customer.getId());
					}
				}
			}

		}
		return borrowedCustomerIds;

	}

	public static void printBorrowList() {
		ArrayList<Integer> borrowedBookIds = getBorrowedBookIdListArray(borrowRecordList, DataSource.bookList);
		if (borrowedBookIds.size() == 0) {
			System.out.println("There is no book borrowed!");
		} else {
			System.out.println("Borrow list:");
			for (int i = 0; i < borrowedBookIds.size(); i++) {
				for (BorrowRecord borrowRecord : borrowRecordList) {
					if (borrowedBookIds.get(i) == borrowRecord.getBook().getId() && borrowRecord.getQuantity() > 0) {
						System.out.println(" - No." + (i + 1) + ":");
						System.out.println("    + Title: " + bookTitle(borrowedBookIds.get(i), DataSource.bookList));
						System.out.println("    + ISBN : " + bookISBN(borrowedBookIds.get(i), DataSource.bookList));
						printBorrowedCustomerPerBook(borrowRecordList, borrowedBookIds.get(i), DataSource.customerList);
					}
				}
			}
		}
	}

	public static void printBorrowedCustomerPerBook(BorrowRecord borrowRecordList[], int bookId,
			Customer customerList[]) {
		ArrayList<Integer> borrowedCustomerIds = getBorrowedCustomerIdPerBookListArray(borrowRecordList, bookId,
				customerList);
		for (BorrowRecord borrowRecord : borrowRecordList) {
			for (int i = 0; i < borrowedCustomerIds.size(); i++) {
				if (borrowRecord.getQuantity() > 0 && borrowRecord.getBook().getId() == bookId
						&& borrowRecord.getCustomer().getId() == borrowedCustomerIds.get(i)) {
					System.out.println("    + Customer no." + (i + 1) + ": ");
					System.out.println("       * Name    : " + customerName(borrowedCustomerIds.get(i), customerList));
					System.out.println("       * Quantity: " + borrowRecord.getQuantity());
				}
			}
		}

	}

	public static void printStatusOfABook(int bookId) {
		int countBorrowedBook = 0;
		int countBorrow = 0;
		ArrayList<Integer> borrowedCustomerIds = getBorrowedCustomerIdPerBookListArray(borrowRecordList, bookId,
				DataSource.customerList);
		for (BorrowRecord borrowRecord : borrowRecordList) {
			if (borrowRecord.getBook().getId() == bookId) {
				countBorrowedBook += borrowRecord.getQuantity();
				countBorrow += 1;
			}
		}
		if (countBorrowedBook == 0 && countBorrow > 0) {
			System.out.println("This book is returned!");
			for (int i = DataSource.returnRecordList.length - 1; i > 0; i--) {
				if (DataSource.returnRecordList[i].getBorrowRecord().getBook().getId() == bookId) {
					System.out.println("The last time when this book is returned on: " + DataSource.returnRecordList[i].getDate()
							+ " by: " + DataSource.returnRecordList[i].getBorrowRecord().getCustomer().getName());
					break;
				}

			}
		} else if (countBorrowedBook == 0 && countBorrow == 0) {
			System.out.println("No one borrows this book yet!");
		} else if (countBorrowedBook > 0) {
			for (BorrowRecord borrowRecord : borrowRecordList) {
				if (borrowRecord.getBook().getId() == bookId && borrowRecord.getQuantity() > 0) {
					System.out.println("This book is borrowed by: ");

					for (int i = 0; i < borrowedCustomerIds.size(); i++) {
						System.out.println("   - " + customerName(borrowedCustomerIds.get(i), DataSource.customerList));
						System.out.println("     + on the date: " + borrowRecord.getBorrowDate());
						System.out.println("     + with the quantity: " + borrowRecord.getQuantity());
					}
				}
			}
			System.out.println("Customers borrowed " + countBorrowedBook + " of this book.");
			System.out.println((quantity(bookId, DataSource.stockList) - countBorrowedBook) + " available in stock.");
		}
	}

	public static String bookTitle(int id, Book bookList[]) {
		String title = "";
		for (Book book : bookList) {
			if (book.getId() == id) {
				title = book.getName();
				break;
			}
		}
		return title;
	}

	public static String bookISBN(int id, Book bookList[]) {
		String ISBN = "";
		for (Book book : bookList) {
			if (book.getId() == id) {
				ISBN = book.getISBN();
				break;
			}
		}
		return ISBN;
	}

	public static String customerName(int id, Customer customerList[]) {
		String name = "";
		for (Customer customer : customerList) {
			if (customer.getId() == id) {
				name = customer.getName();
				break;
			}
		}
		return name;
	}

	public static int quantity(int bookId, Stock stockList[]) {
		int quantity = 0;
		for (Stock stock : stockList) {
			if (stock.getBook().getId() == bookId) {
				quantity += stock.getQuantity();
			}
		}
		return quantity;
	}
}
