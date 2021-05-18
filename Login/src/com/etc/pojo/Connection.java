package com.etc.pojo;

import java.sql.*;


public class Connection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //ע��ɹ�
        Class.forName("com.mysql.jdbc.Driver");
        //��ȡ���ݿ������
        java.sql.Connection coon = DriverManager.getConnection("jdbc:mysql://localhost:3306/springboot?user=root&&password=root");
        //��������sql���Ķ���
        Statement stmt = coon.createStatement();
        //ִ��sql���
        String sql = "select custname,pwd from Customer";
        //����ǲ�ѯ��䷵�ز�ѯ���
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next())//��������оͷ���true�����򷵻�false
        {
            //���ݿ���е��ֶ���ʲô���;���get***������
            //��Ӧ���ݿ���ֶ����������ִ�Сд������һ��
            String ename = rs.getString("custname");
            int i = rs.getInt("pwd");
            System.out.println(ename + ":::" + i);
        }
        //�ͷ���Դ
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