package ua.carrying.model;

public class Order {

    private long id;
    private long id_customer;
    private long id_ferryman;
    private String startPlace;
    private String finalPlace;
    private Double price;
    private Double weight;
    private String volume;
    private String sendDate;
    private String receiveDate;

    public Order() {
    }

    public Order(long id, long id_customer, long id_ferryman, String startPlace,
                 String finalPlace, Double price, Double weight, String volume,
                 String sendDate, String receiveDate) {
        this.id = id;
        this.id_customer = id_customer;
        this.id_ferryman = id_ferryman;
        this.startPlace = startPlace;
        this.finalPlace = finalPlace;
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
                ", id_customer=" + id_customer +
                ", id_ferryman=" + id_ferryman +
                ", startPlace='" + startPlace + '\'' +
                ", finalPlace='" + finalPlace + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", volume='" + volume + '\'' +
                ", sendDate='" + sendDate + '\'' +
                ", receiveDate='" + receiveDate + '\'' +
                '}';
    }
}
