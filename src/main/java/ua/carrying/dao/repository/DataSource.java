package ua.carrying.dao.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



    public class DataSource implements AutoCloseable {
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL="jdbc:mysql://localhost/carrying4?user=root&password=0000";

        private Connection connection = null;


        public DataSource() {
            try{
                Class.forName(JDBC_DRIVER).newInstance();
            } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


        public Connection getConnection()
        {
            try {
                if( connection == null ) {
                    connection = DriverManager.getConnection(DB_URL);
                }
            }
            catch( SQLException e ) {
                System.out.println("Error " + e.toString());
            }
            return connection;
        }

        @Override
        public void close() {
            try {
                if( connection != null ) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


