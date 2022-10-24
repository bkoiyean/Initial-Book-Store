package Main;

import Service.Service;

public class Main {
	public static void main(String[] args) {
		int bookId = 3;

		Service.printBorrowList();
		System.out.println("==============================");
		System.out.println(" - BookId to check: " + bookId);
		Service.printStatusOfABook(bookId);
	}

}
