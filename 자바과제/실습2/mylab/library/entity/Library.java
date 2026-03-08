package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 도서 컬렉션을 관리하는 클래스
 */
public class Library {
    private String name;           // 도서관 이름
    private List<Book> books;      // 도서 목록

    // 생성자 - 도서관 이름 초기화 및 빈 도서 목록 생성
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // Getter
    public String getName() {
        return name;
    }

    /**
     * 도서 추가
     */
    public void addBook(Book book) {
        books.add(book);
        System.out.println("도서가 추가되었습니다: " + book.getTitle());
    }

    /**
     * 제목으로 도서 검색
     */
    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    /**
     * 저자로 도서 검색
     */
    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * ISBN으로 도서 검색
     */
    public Book findByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    /**
     * 도서 대출
     */
    public boolean checkOutBook(String isbn) {
        Book book = findByISBN(isbn);
        if (book != null) {
            return book.checkOut();
        }
        return false;
    }

    /**
     * 도서 반납
     */
    public boolean returnBook(String isbn) {
        Book book = findByISBN(isbn);
        if (book != null) {
            book.returnBook();
            return true;
        }
        return false;
    }

    /**
     * 대출 가능한 도서 목록 반환
     */
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    /**
     * 모든 도서 목록 반환
     */
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    /**
     * 전체 도서 수 반환
     */
    public int getTotalBooks() {
        return books.size();
    }

    /**
     * 대출 가능한 도서 수 반환
     */
    public int getAvailableBooksCount() {
        int count = 0;
        for (Book book : books) {
            if (book.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    /**
     * 대출 중인 도서 수 반환
     */
    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }
}
