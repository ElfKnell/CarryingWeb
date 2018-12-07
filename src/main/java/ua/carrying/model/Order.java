package ua.carrying.model;

import java.util.Arrays;

public class Order {
    private long id_order;

    private long id;//we need o discuss that point
    private String startPoint;
    private String finalPoint;
    private Double price;
    private Double weight;
    private String volume;
    private String sendDate;
    private String receiveDate;

    public Order() {
    }

    public Order(long id_order, long id, String startPoint, String finalPoint, Double price,
                 Double weight, String volume, String sendDate, String receiveDate) {
        this.id_order = id_order;
        this.id = id;
        this.startPoint = startPoint;
        this.finalPoint = finalPoint;
        this.price = price;
        this.weight = weight;
        this.volume = volume;
        this.sendDate = sendDate;
        this.receiveDate = receiveDate;
    }

    public long getId_order() {
        return id_order;
    }

    public void setId_order(long id_order) {
        this.id_order = id_order;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getFinalPoint() {
        return finalPoint;
    }

    public void setFinalPoint(String finalPoint) {
        this.finalPoint = finalPoint;
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
                "id_order=" + id_order +
                ", id=" + id +
                ", startPoint='" + startPoint + '\'' +
                ", finalPoint='" + finalPoint + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", volume='" + volume + '\'' +
                ", sendDate='" + sendDate + '\'' +
                ", receiveDate='" + receiveDate + '\'' +
                '}';
    }
}
