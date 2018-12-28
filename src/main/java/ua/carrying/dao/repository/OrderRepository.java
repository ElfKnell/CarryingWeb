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
            stmt.setString(2, order.getStart_place());
            stmt.setString(3, order.getFinal_place());
            stmt.setDouble(4, order.getPrice());
            stmt.setDouble(5, order.getWeight());
            stmt.setString(6, order.getVolume());
            stmt.setString(7, order.getSend_date());
            stmt.setString(8, order.getReceive_date());
            stmt.setString(9, order.getOrder_date());

            System.out.println(stmt.toString());

            stmt.executeUpdate();
        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Order> getOrderByCustomerId(long idCustomer ) {
        DataSource dataSource = new DataSource();
        List<Order> orders = new ArrayList<>();

        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT id, id_customer, id_ferryman, start_place, final_place, price," +
                        " weight, volume, send_date, receive_date, order_date FROM `order` WHERE id_customer = " + idCustomer);
        ) {
            while ( rs.next() ) {
                orders.add(new Order(
                        rs.getLong("id"),
                        rs.getLong("id_customer"),
                        rs.getLong("id_ferryman"),
                        rs.getString("start_place"),
                        rs.getString("final_place"),
                        rs.getDouble("price"),
                        rs.getDouble("weight"),
                        rs.getString("volume"),
                        rs.getString("send_date"),
                        rs.getString("receive_date"),
                        rs.getString("order_date")
                ));
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    public List<Order> getOredrsByFerrymanId() {
        DataSource dataSource = new DataSource();
        List<Order> orders = new ArrayList<>();

        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT id, id_customer, id_ferryman, start_place," +
                        " final_place, price, weight, volume, send_date, " +
                        "receive_date, order_date FROM `order` WHERE id_ferryman = " + 0);
        ) {
            while ( rs.next() ) {
                orders.add(new Order(
                        rs.getLong("id"),
                        rs.getLong("id_customer"),
                        rs.getLong("id_ferryman"),
                        rs.getString("start_place"),
                        rs.getString("final_place"),
                        rs.getDouble("price"),
                        rs.getDouble("weight"),
                        rs.getString("volume"),
                        rs.getString("send_date"),
                        rs.getString("receive_date"),
                        rs.getString("order_date")
                ));
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }
    public Order getOrderById( long id ) {
        DataSource dataSource = new DataSource();
        Order order = null;

        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT id, id_customer,id_ferryman,start_place,final_place," +
                        "price,weight,volume,send_date,receive_date,order_date FROM `order` WHERE id = " + id);
        ) {
            if ( rs.next() ) {
                order = new Order(
                        rs.getLong("id"),
                        rs.getLong("id_customer"),
                        rs.getLong("id_customer"),
                        rs.getString("start_place"),
                        rs.getString("final_place"),
                        rs.getDouble("price"),
                        rs.getDouble("weight"),
                        rs.getString("volume"),
                        rs.getString("send_date"),
                        rs.getString("receive_date"),
                        rs.getString("order_date")
                );
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }
  /*  public List<String> getOrders() {
        DataSource dataSource = new DataSource();
        List<String> lorders = new ArrayList<>();

        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT id, id_customer, start_place,final_place from `order`")

        ) {
            while ( rs.next() ) {

                       String s = String.valueOf(rs.getLong("id"))+
                        rs.getLong("id_customer")+
                        rs.getString("start_place")+
                        rs.getString("final_place")+
                        rs.getString("order_date");
                       lorders.add(s);

            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }

        return lorders;*/
    }

