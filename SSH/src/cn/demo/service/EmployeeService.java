package cn.demo.service;

import java.util.List;

import cn.demo.bean.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
	public void save(Employee employee);
	public void update(Employee employee);
	public Employee find(String username);
	public void delete(String... usernames);
	public List<Employee> list();
}
