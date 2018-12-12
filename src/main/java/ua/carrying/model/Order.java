package ua.carrying.model;

public class Order {

    private long id;
    private long id_customer;
    private long id_ferryman;
    private String startPlace;
    private String finalPlace;
    private String orderDate;

    public Order() {
    }

    public Order(long id, long id_customer, long id_ferryman,
                 String startPlace, String finalPlace, String orderDate) {
        this.id = id;
        this.id_customer = id_customer;
        this.id_ferryman = id_ferryman;
        this.startPlace = startPlace;
        this.finalPlace = finalPlace;
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

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getFinalPlace() {
        return finalPlace;
    }

    public void setFinalPlace(String finalPlace) {
        this.finalPlace = finalPlace;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", id_customer=" + id_customer +
                ", id_ferryman=" + id_ferryman +
                ", startPlace='" + startPlace + '\'' +
                ", finalPlace='" + finalPlace + '\'' +
                ", orderDate='" + orderDate + '\'' +
                '}';
    }
}