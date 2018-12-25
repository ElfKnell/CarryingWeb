package ua.carrying.dao.entities;

/**
 * Основна модель замовлення.
 */
public class Order {

    private long id;
    private long id_customer;
    private long id_ferryman;
    private String start_place;
    private String final_place;
    private double price;
    private double weight;
    private String volume;
    private String send_date;
    private String receive_date;
    private String order_date;

    public Order() {
    }

    public Order(long id, long id_customer, long id_ferryman,
                 String start_place, String final_place, double price, double weight,
                 String volume, String send_date, String receive_date, String order_date) {
        this.id = id;
        this.id_customer = id_customer;
        this.id_ferryman = id_ferryman;
        this.start_place = start_place;
        this.final_place = final_place;
        this.price = price;
        this.weight = weight;
        this.volume = volume;
        this.send_date = send_date;
        this.receive_date = receive_date;
        this.order_date = order_date;
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

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getStart_place() {
        return start_place;
    }

    public void setStart_place(String start_place) {
        this.start_place = start_place;
    }

    public String getFinal_place() {
        return final_place;
    }

    public void setFinal_place(String final_place) {
        this.final_place = final_place;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
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

    @java.lang.Override
    public java.lang.String toString() {
        return "Order{" +
                "id=" + id +
                ", id_customer=" + id_customer +
                ", id_ferryman=" + id_ferryman +
                ", start_place='" + start_place + '\'' +
                ", final_place='" + final_place + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", volume='" + volume + '\'' +
                ", send_date='" + send_date + '\'' +
                ", receive_date='" + receive_date + '\'' +
                ", order_date='" + order_date + '\'' +
                '}';
    }
}
