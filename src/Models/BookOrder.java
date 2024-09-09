
package Models;

import java.util.Iterator;
import java.util.List;

public class BookOrder {
    private List<BookQuantity> bookQuantities;
    private double bookPrice;

    public BookOrder(List<BookQuantity> bookQuantities, double bookPrice) {
        this.bookQuantities = bookQuantities;
        this.bookPrice = bookPrice;
    }

    public List<BookQuantity> getBookQuantities() {
        return this.bookQuantities;
    }

    public void setBookQuantities(List<BookQuantity> bookQuantities) {
        this.bookQuantities = bookQuantities;
    }

    public double getBookPrice() {
        return this.bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public double calculateTotalPrice() {
        double total = 0.0;

        BookQuantity bq;
        for(Iterator var3 = this.bookQuantities.iterator(); var3.hasNext(); total += (double)bq.getQuantity() * this.bookPrice) {
            bq = (BookQuantity)var3.next();
        }

        return total;
    }
}
