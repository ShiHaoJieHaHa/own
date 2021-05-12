package com.etc.service;

import java.util.List;

import com.etc.dao.CustomerDAO;
import com.etc.pojo.Customer;

public class CustomerService  {
	private CustomerDAO dao=new CustomerDAO();
	public boolean login(String custname,String pwd){
		Customer cust=dao.selectByNamePwd(custname, pwd);
		if(cust!=null){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean register(Customer cust){
		Customer c=dao.selectByName(cust.getCustname());
		if(c==null){
			dao.insert(cust);
			return true;
		}else{
			return false;
		}
	}
	
	public Customer viewPersonal(String custname){
		return dao.selectByName(custname);
	}
	
	public List<Customer> viewAll(){
		return dao.selectAll();
	}
	
	public static void main(String[] args){
		CustomerService cs=new CustomerService();
//		boolean flag=cs.login("G4ace", "123");
//		System.out.println(flag);
		
//		Customer c=new Customer("John","123",34,"TJ");
//		boolean flag=cs.register(c);
//		System.out.println(flag);
		
//		Customer c=cs.viewPersonal("John");
		
		
		List<Customer> list=cs.viewAll();
		for(Customer c:list){
			System.out.println(c.getCustname()+" "+c.getPwd()+" "+c.getAge()+" "+c.getAddress());
			
		}
	}
}
