package Hotel_Management_System;

import java.sql.*;

public class Conn {

    Connection c;
    public Statement s;

    Conn() {
        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            // /Users/kaushalhole/Code/mysql-connector-j-9.6.0/mysql-connector-j-9.6.0.jar
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem", "root", "Mysql2002");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
