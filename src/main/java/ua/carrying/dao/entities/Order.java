package ua.carrying.dao.entities;

/**
 * Основна модель замовлення.
 */
public class Order {

    private long id;
    private long id_customer;
    private long id_ferryman;
    private long id_body;
    private String orderDate;

    public Order() {
    }

    public Order(long id, long id_customer, long id_ferryman,
                 long id_body, String orderDate) {
        this.id = id;
        this.id_customer = id_customer;
        this.id_ferryman = id_ferryman;
        this.id_body = id_body;
        this.orderDate = orderDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_customer() {
        return id_customer;
    }

    public void setId_customer(long id_customer) {
        this.id_customer = id_customer;
    }

    public long getId_ferryman() {
        return id_ferryman;
    }

    public void setId_ferryman(long id_ferryman) {
        this.id_ferryman = id_ferryman;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", id_customer=" + id_customer +
                ", id_ferryman=" + id_ferryman +
                ", id_body=" + id_body +
                ", orderDate='" + orderDate + '\'' +
                '}';
    }
}
