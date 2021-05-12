package com.etc.dao;



import java.sql.*;
import java.util.ResourceBundle;

public class Jdbc_Connnection {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    static {
        //ͨ��ResourceBundle����ļ��е���Ϣ
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc.properties");
        //ͨ��keyֵ���db�ļ��е�������Ϣ
        driver=bundle.getString(driver);
        url=bundle.getString(url);
        username=bundle.getString(username);
        password=bundle.getString(password);
    }

    public static Connection getConnection(){
        //�������ݿ�
        Connection conn=null;
        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url, username, password);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public static void sqlcolse(Connection con, PreparedStatement pstem, ResultSet rs) {

        try {
            if(con!=null) {
                con.close();
            }
            if(pstem!=null)
            {
                pstem.close();
            }
            if(rs!=null) {
                rs.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


}
