package ua.carrying.dao.entities;

/**
 * Модель за допомогою якої звязується замовлення, замовник та перевізник.
 */
public class ConnectionUserOrder {

    private long id;
    private long id_order;
    private long id_ferryman;
    private double price;
    private String send_date;
    private String receive_date;

    public ConnectionUserOrder() {
    }

    public ConnectionUserOrder(long id, long id_order, long id_ferryman,
                               double price, String send_date, String receive_date) {
        this.id = id;
        this.id_order = id_order;
        this.id_ferryman = id_ferryman;
        this.price = price;
        this.send_date = send_date;
        this.receive_date = receive_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_order() {
        return id_order;
    }

    public void setId_order(long id_order) {
        this.id_order = id_order;
    }

    public long getId_ferryman() {
        return id_ferryman;
    }

    public void setId_ferryman(long id_ferryman) {
        this.id_ferryman = id_ferryman;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSend_date() {
        return send_date;
    }

    public void setSend_date(String send_date) {
        this.send_date = send_date;
    }

    public String getReceive_date() {
        return receive_date;
    }

    public void setReceive_date(String receive_date) {
        this.receive_date = receive_date;
    }

    @Override
    public String toString() {
        return "ConnectionUserOrder{" +
                "id=" + id +
                ", id_order=" + id_order +
                ", id_ferryman=" + id_ferryman +
                ", price=" + price +
                ", send_date='" + send_date + '\'' +
                ", receive_date='" + receive_date + '\'' +
                '}';
    }
}
