package ua.carrying.dao.repository;


import ua.carrying.dao.entities.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    public void saveOrder(Order order) {
        DataSource dataSource = new DataSource();
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO `order` (id_customer, " +
                        "start_place, final_place, price, weight, volume, send_date, " +
                        "receive_date, order_date) VALUES (?,?,?,?,?,?,?,?,?)")
        ) {

            stmt.setLong(1, order.getId_customer());
            stmt.setString(2, order.getStartPlace());
            stmt.setString(3, order.getFinalPlace());
            stmt.setDouble(4, order.getPrice());
            stmt.setDouble(5, order.getWeight());
            stmt.setString(6, order.getVolume());
            stmt.setString(7, order.getSendDate());
            stmt.setString(8, order.getReceiveDate());
            stmt.setString(9, order.getOrderDate());

            System.out.println(stmt.toString());

            stmt.executeUpdate();
        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Order> getOrderByCustomerId(long idCustomer ) {
        DataSource dataSource = new DataSource();
        List<Order> notes = new ArrayList<>();

        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT id, id_customer, id_ferryman, start_place," +
                        " final_place, price, weight, volume, send_date, " +
                        "receive_date, order_date FROM order WHERE id_customer = " + idCustomer);
        ) {
            while ( rs.next() ) {
                notes.add(new Order(
                        rs.getLong("id"),
                        rs.getLong("id_customer"),
                        rs.getLong("id_ferryman"),
                        rs.getString("startPlace"),
                        rs.getString("finalPlace"),
                        rs.getDouble("price"),
                        rs.getDouble("weight"),
                        rs.getString("volume"),
                        rs.getString("sendDate"),
                        rs.getString("receiveDate"),
                        rs.getString("orderDate")
                ));
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }

        return notes;
    }

    public List<Order> getNotesByFerrymanId(long idFerryman ) {
        DataSource dataSource = new DataSource();
        List<Order> notes = new ArrayList<>();

        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT id, id_customer, id_ferryman, start_place," +
                        " final_place, price, weight, volume, send_date, " +
                        "receive_date, order_date FROM order WHERE id_ferryman = " + idFerryman);
        ) {
            while ( rs.next() ) {
                notes.add(new Order(
                        rs.getLong("id"),
                        rs.getLong("id_customer"),
                        rs.getLong("id_ferryman"),
                        rs.getString("startPlace"),
                        rs.getString("finalPlace"),
                        rs.getDouble("price"),
                        rs.getDouble("weight"),
                        rs.getString("volume"),
                        rs.getString("sendDate"),
                        rs.getString("receiveDate"),
                        rs.getString("orderDate")
                ));
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }

        return notes;
    }
}
