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
        //ͨ��ResourceBundle����ļ��е���Ϣ
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc.properties");
        //ͨ��keyֵ����ļ��е�������Ϣ
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