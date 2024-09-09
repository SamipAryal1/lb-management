package Models;

public class BookQuantity {
    private String bookName;
    private int quantity;

    public BookQuantity(String bookName, int quantity) {
        this.bookName = bookName;
        this.quantity = quantity;
    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
