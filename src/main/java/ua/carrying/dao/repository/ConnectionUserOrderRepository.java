package ua.carrying.dao.repository;

import ua.carrying.dao.entities.ConnectionUserOrder;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionUserOrderRepository {

    public void saveUserAccept(ConnectionUserOrder connectionUserOrder) {
        DataSource dataSource = new DataSource();

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO `connection` (id_order, " +
                        "id_ferryman, price, send_date, receive_date) VALUES (?,?,?,?,?)")
        ) {


            stmt.setLong(1, connectionUserOrder.getId_order());
            stmt.setLong(2, connectionUserOrder.getId_ferryman());
            stmt.setDouble(3, connectionUserOrder.getPrice());
            stmt.setString(4, connectionUserOrder.getSend_date());
            stmt.setString(5, connectionUserOrder.getReceive_date());


            System.out.println(stmt.toString());

            stmt.executeUpdate();
        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ConnectionUserOrder> getOredrsById(long orderId) {
        DataSource dataSource = new DataSource();
        List<ConnectionUserOrder> orders = new ArrayList<>();


        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT id, id_order, id_ferryman, price, send_date, " +
                        "receive_date FROM connection WHERE id_order =" + orderId);
        ) {
            while ( rs.next() ) {
                orders.add(new ConnectionUserOrder(
                        rs.getLong("id"),
                        rs.getLong("id_order"),
                        rs.getLong("id_ferryman"),
                        rs.getDouble("price"),
                        rs.getString("send_date"),
                        rs.getString("receive_date")
                ));
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }
}
