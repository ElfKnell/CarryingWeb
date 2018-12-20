package ua.carrying.dao.repository;

import ua.carrying.dao.etities.Order;


import java.sql.*;

public class OrderRepository {
    public Order getOrderById(Long id) {
        DataSource dataSource = new DataSource();

        String query = "SELECT id," +
                "startPlace, finalPlace,orderDate FROM order " +
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
                        rs.getString("orderDate")
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
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO `order`(startPlace, finalPlace, orderDate) VALUES (?,?,?)")
                )
                {

            stmt.setString(1, order.getStartPlace());
            stmt.setString(2, order.getFinalPlace());
            stmt.setString(3, order.getOrderDate());

            stmt.executeUpdate();
        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
