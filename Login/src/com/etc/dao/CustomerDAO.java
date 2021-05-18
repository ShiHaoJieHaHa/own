package com.etc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.etc.pojo.*;

public class CustomerDAO  {
	public List<Customer> selectAll()  {
		List<Customer> list=new ArrayList<Customer>();
		Connection conn=JdbcConnection.getConnection();
		try {
			Statement stmt=conn.createStatement();
			String sql="select custname,age,address from customer";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				list.add(new Customer(rs.getString(1),null,rs.getInt(2),rs.getString(3)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}
	
	public Customer selectByName(String custname){
		Customer cust=null;
		Connection conn=JdbcConnection.getConnection();
		String sql="select * from customer where custname=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, custname);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				cust=new Customer(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return cust;
	}
	
	public Customer selectByNamePwd(String custname,String pwd){
		Customer cust=null;
		Connection conn=JdbcConnection.getConnection();
		String sql="select * from customer where custname= ? and pwd=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, custname);
			pstmt.setString(2, pwd);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				cust=new Customer(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return cust;
	}
	
	public void insert(Customer cust){
		Connection conn=JdbcConnection.getConnection();
		String sql="insert into customer values(?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, cust.getCustname());
			pstmt.setString(2, cust.getPwd());
			pstmt.setInt(3, cust.getAge());
			pstmt.setString(4, cust.getAddress());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
