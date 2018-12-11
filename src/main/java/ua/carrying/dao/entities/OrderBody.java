package ua.carrying.dao.entities;

/**
 * Модель призначена для вказання всіх полів замовлення.
 */
public class OrderBody {

    private long id;
    private long id_order;
    private Double price;
    private Double weight;
    private String volume;
    private String sendDate;
    private String receiveDate;

    public OrderBody() {
    }

    public OrderBody(long id, long id_order, Double price,
                     Double weight, String volume,
                     String sendDate, String receiveDate) {
        this.id = id;
        this.id_order = id_order;
        this.price = price;
        this.weight = weight;
        this.volume = volume;
        this.sendDate = sendDate;
        this.receiveDate = receiveDate;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getWeight() {
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

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", id_order=" + id_order +
                ", price=" + price +
                ", weight=" + weight +
                ", volume='" + volume + '\'' +
                ", sendDate='" + sendDate + '\'' +
                ", receiveDate='" + receiveDate + '\'' +
                '}';
    }
}
