package ua.carrying.repository;

import ua.carrying.model.Order;


import java.sql.*;

public class OrderRepository {
    public Order getOrderById(Long id) {
        DataSource dataSource = new DataSource();

        String query = "SELECT id, userName, email, password, roleid, id_customer, id_ferryman," +
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
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO order (id," +
                        "id_customer, id_ferryman, startPlace,finalPlace," +
                        "orderDate) VALUES (?,?,?,?,?,?,?,?,?,?)")
        ) {
            stmt.setString(1, order.getId());
            stmt.setString(2, order.getId_customer());
            stmt.setString(3, order.getId_ferryman());
            stmt.setString(4, order.getStartPlace());
            stmt.setString(5, order.getFinalPlace());
            stmt.setString(6, order.getOrderDate());

            stmt.executeUpdate();
        }  catch (SQLException e) {
            e.printStackTrace()
        }
    }
}
