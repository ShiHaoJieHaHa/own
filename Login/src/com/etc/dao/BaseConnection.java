package com.etc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BaseConnection {

    public static void main(String[] args) {
        try {
            System.out.println(BaseConnection.getCon());
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private static String driver;//数据库驱动
    private static String url;//数据库路径，找到对应的数据库
    private static String username;//数据库账号
    private static String password;//数据库密码
    private static  Connection  con;

             static{
                 driver= ResourceBundle.getBundle("db").getString("driver");
                 url=ResourceBundle.getBundle("db").getString("url");
                username=ResourceBundle.getBundle("db").getString("username");
                 password=ResourceBundle.getBundle("db").getString("password");
           }
      /*private static String driver="com.mysql.jdbc.Driver";
 30     private static String url="jdbc:mysql:///test";
 31     private static String user="root";
 32     private static String password="123456";*/



              public static Connection getCon()  {
                  try {
                      Class.forName(driver);//加载数据库驱动
                  } catch (ClassNotFoundException e) {
                      e.printStackTrace();
                  }
                  System.out.println("测试加载数据库成功");
                  try {
                      con = DriverManager.getConnection(url, username, password);
                  } catch (SQLException throwables) {
                      throwables.printStackTrace();
                  }
                  System.out.println("测试数据库链接成功");
                 return con;
            }


              public static void close(Connection con, PreparedStatement ps, ResultSet rs){
                 if(rs!=null){//关闭资源，避免出现异常
                         try {
                                 rs.close();
                            } catch (SQLException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                  }
                 if(ps!=null){
                         try {
                                ps.close();
                             } catch (SQLException e) {
                                 // TODO Auto-generated catch block
                                e.printStackTrace();
                             }
                    }
                if(con!=null){
                         try {
                                 con.close();
                             } catch (SQLException e) {
                                // TODO Auto-generated catch block
                                 e.printStackTrace();
                            }
                   }
        }

}
