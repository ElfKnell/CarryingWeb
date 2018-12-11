package ua.carrying.repository;

import ua.carrying.model.Order;


import java.sql.*;

public class OrderRepository {
    public Order getOrderById(Long id) {
        DataSource dataSource = new DataSource();

        String query = "SELECT id, userName, email, password, roleid, id_customer, id_ferryman," +
                "startPlace, finalPlace, price, weight, volume,sendDate, receiveDate FROM order " +
                "WHERE user.id=" + id;

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
        ) {
            if ( rs.next() ) {
                Order order = new Order(
                        rs.getLong( "id"),
                        rs.getLong("id_customer"),
                        rs.getLong("id_ferryman"),
                        rs.getString( "startPlace"),
                        rs.getString("finalPlace"),
                        rs.getDouble("price"),
                        rs.getDouble("weight"),
                        rs.getString("volume"),
                        rs.getString("sendDate"),
                        rs.getString("receiveDate")
                );

                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void saveOrder(Order order) {
        DataSource dataSource = new DataSource();
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO order (id," +
                        "id_customer, id_ferryman, startPlace,finalPlace,price, " +
                        "weight,volume,sendDate,receiveDate) VALUES (?,?,?,?,?,?,?,?,?,?)")
        ) {
            stmt.setString(1, order.setId());
            stmt.setString(2, order.setId_customer());
            stmt.setString(3, order.setId_ferryman());
            stmt.setString(4, order.setStartPlace());
            stmt.setString(5, order.setFinalPlace());
            stmt.setString(6, order.setPrice());
            stmt.setString(7, order.setWeight());
            stmt.setString(8, order.setVolume());
            stmt.setString(9, order.setSendDate());
            stmt.setString(9, order.setReceiveDate());

            stmt.executeUpdate();
        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
