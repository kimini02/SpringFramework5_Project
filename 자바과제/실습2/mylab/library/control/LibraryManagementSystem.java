package mylab.library.control;

import mylab.library.entity.Book;
import mylab.library.entity.Library;

import java.util.List;

/**
 * 도서관 관리 시스템 테스트 메인 클래스
 */
public class LibraryManagementSystem {

    public static void main(String[] args) {
        // 도서관 객체 생성
        Library library = new Library("중앙 도서관");

        // 샘플 도서 추가
        addSampleBooks(library);

        // 도서관 정보 출력
        printLibraryInfo(library);

        // 도서 검색 테스트
        testFindBook(library);

        // 도서 대출 테스트
        testCheckOut(library);

        // 도서 반납 테스트
        testReturn(library);

        // 대출 가능한 도서 목록 출력
        displayAvailableBooks(library);
    }

    /**
     * 샘플 도서 추가
     */
    private static void addSampleBooks(Library library) {
        library.addBook(new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
        library.addBook(new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));
    }

    /**
     * 도서관 정보 출력
     */
    private static void printLibraryInfo(Library library) {
        System.out.println("\n===== " + library.getName() + " =====");
        System.out.println("전체 도서 수: " + library.getTotalBooks());
        System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount());
        System.out.println("대출 중인 도서 수: " + library.getBorrowedBooksCount());
    }

    /**
     * 도서 검색 테스트
     */
    private static void testFindBook(Library library) {
        System.out.println("\n===== 도서 검색 테스트 =====");

        // 제목으로 검색
        System.out.println("제목으로 검색 결과:");
        Book book = library.findByTitle("자바의 정석");
        if (book != null) {
            System.out.println(book);
        }

        // 저자로 검색
        System.out.println("\n저자로 검색 결과:");
        List<Book> books = library.findByAuthor("Robert C. Martin");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    /**
     * 도서 대출 테스트
     */
    private static void testCheckOut(Library library) {
        System.out.println("\n===== 도서 대출 테스트 =====");

        String isbn = "978-89-01-14077-4"; // 자바의 정석 ISBN
        if (library.checkOutBook(isbn)) {
            System.out.println("도서 대출 성공!");
            System.out.println("대출된 도서 정보:");
            System.out.println(library.findByISBN(isbn));
        } else {
            System.out.println("도서 대출 실패!");
        }

        System.out.println("\n도서관 현재 상태:");
        System.out.println("전체 도서 수: " + library.getTotalBooks());
        System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount());
        System.out.println("대출 중인 도서 수: " + library.getBorrowedBooksCount());
    }

    /**
     * 도서 반납 테스트
     */
    private static void testReturn(Library library) {
        System.out.println("\n===== 도서 반납 테스트 =====");

        String isbn = "978-89-01-14077-4"; // 자바의 정석 ISBN
        if (library.returnBook(isbn)) {
            System.out.println("도서 반납 성공!");
            System.out.println("반납된 도서 정보:");
            System.out.println(library.findByISBN(isbn));
        } else {
            System.out.println("도서 반납 실패!");
        }

        System.out.println("\n도서관 현재 상태:");
        System.out.println("전체 도서 수: " + library.getTotalBooks());
        System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount());
        System.out.println("대출 중인 도서 수: " + library.getBorrowedBooksCount());
    }

    /**
     * 대출 가능한 도서 목록 출력
     */
    private static void displayAvailableBooks(Library library) {
        System.out.println("\n===== 대출 가능한 도서 목록 =====");
        List<Book> availableBooks = library.getAvailableBooks();
        for (Book book : availableBooks) {
            System.out.println(book);
            System.out.println("-----------------------");
        }
    }
}
