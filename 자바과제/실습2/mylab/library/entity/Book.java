package mylab.library.entity;

/**
 * 도서 정보를 담는 클래스
 */
public class Book {
    private String title;        // 제목
    private String author;       // 저자
    private String isbn;         // ISBN
    private int publishYear;     // 출판년도
    private boolean isAvailable; // 대출상태

    // 기본 생성자 - 초기 생성 시 대출 가능 상태
    public Book() {
        this.isAvailable = true;
    }

    // 모든 필드를 초기화하는 생성자
    public Book(String title, String author, String isbn, int publishYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.isAvailable = true;
    }

    // Getter 메서드들
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setter 메서드들
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    /**
     * 도서 대출 처리
     * @return 대출 성공 여부
     */
    public boolean checkOut() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    /**
     * 도서 반납 처리
     */
    public void returnBook() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        String availabilityStatus = isAvailable ? "가능" : "대출 중";
        return "책 제목: " + title + " 저자: " + author + " ISBN: " + isbn + 
               " 출판년도: " + publishYear + " 대출 가능 여부: " + availabilityStatus;
    }
}
