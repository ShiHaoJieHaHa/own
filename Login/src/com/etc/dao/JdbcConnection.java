package com.etc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    private static Connection conn;

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/springboot", "shj", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
