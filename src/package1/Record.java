package package1;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Record implements Serializable {
    private Product product;
    private int quantity;
    private double amount;
    private LocalDateTime dateTime;

    public Record(Product product , int quantity , double amount) {
        this.product = product;
        this.quantity = quantity;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "Record{" +
                "product=" + product.getName() +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                '}';
    }
}
