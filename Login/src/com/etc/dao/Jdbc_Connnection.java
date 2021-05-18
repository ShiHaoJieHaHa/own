package com.etc.dao;




import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class Jdbc_Connnection {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    private static Connection conn;

    static {
        //通过ResourceBundle获得文件中的信息
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc.properties");
        //通过key值获得文件中的配置信息
        driver = bundle.getString(driver);
        url = bundle.getString(url);
        username = bundle.getString(username);
        password = bundle.getString(password);
    }

    public static Connection getConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                Class.forName(driver);
                conn =DriverManager.getConnection(url, username, password);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return conn;
    }
}