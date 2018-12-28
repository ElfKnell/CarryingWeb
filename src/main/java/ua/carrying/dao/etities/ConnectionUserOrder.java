package ua.carrying.dao.entities;

/**
 * Модель за допомогою якої звязується замовлення, замовник та перевізник.
 */
public class ConnectionUserOrder {

    private long id;
    private long id_order;
    private long id_customer;
    private long id_ferryman;
    private boolean confirmation;

    public ConnectionUserOrder() {
    }

    public ConnectionUserOrder(long id, long id_order, long id_customer,
                               long id_ferryman, boolean confirmation) {
        this.id = id;
        this.id_order = id_order;
        this.id_customer = id_customer;
        this.id_ferryman = id_ferryman;
        this.confirmation = confirmation;
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

    public boolean isConfirmation() {
        return confirmation;
    }

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }

    @Override
    public String toString() {
        return "ConnectionUserOrder{" +
                "id=" + id +
                ", id_order=" + id_order +
                ", id_customer=" + id_customer +
                ", id_ferryman=" + id_ferryman +
                ", confirmation=" + confirmation +
                '}';
    }
}
