package com.etc.pojo;

import java.sql.*;


public class Connection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //注册成功
        Class.forName("com.mysql.jdbc.Driver");
        //获取数据库的连接
        java.sql.Connection coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/springboot?user=root&&password=root");
        //创建代表sql语句的对象
        Statement stmt = coon.createStatement();
        //执行sql语句
        String sql = "select custname,pwd from Customer";
        //如果是查询语句返回查询结果
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next())//如果有新行就返回true，否则返回false
        {
            //数据库表中的字段是什么类型就用get***来代替
            //对应数据库的字段名，不区分大小写但必须一致
            String ename = rs.getString("custname");
            int i = rs.getInt("pwd");
            System.out.println(ename + ":::" + i);
        }
        //释放资源
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (coon != null) {
            coon.close();
        }
    }
}