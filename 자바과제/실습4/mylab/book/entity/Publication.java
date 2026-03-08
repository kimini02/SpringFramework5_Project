package mylab.book.entity;

/**
 * 모든 출판물의 기본 클래스
 */
public class Publication {
    private String title;        // 제목
    private String publishDate;  // 출간일 (yyyy-MM-dd)
    private int page;            // 페이지 수
    private int price;           // 가격

    // 기본 생성자
    public Publication() {
    }

    // 모든 필드 초기화 생성자
    public Publication(String title, String publishDate, int page, int price) {
        this.title = title;
        this.publishDate = publishDate;
        this.page = page;
        this.price = price;
    }

    // Getter
    public String getTitle() {
        return title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public int getPage() {
        return page;
    }

    public int getPrice() {
        return price;
    }

    // Setter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return title;
    }
}
