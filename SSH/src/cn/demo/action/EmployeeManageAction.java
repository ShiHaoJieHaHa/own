package cn.demo.action;

import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.demo.bean.Employee;
import cn.demo.service.EmployeeService;

@Controller @Scope("prototype")
public class EmployeeManageAction {
	@Resource EmployeeService employeeService;
	private Employee employee;	
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String addUI(){
		return "add";
	}
	
	public String add(){
		employeeService.save(employee);
		ActionContext.getContext().put("message", "±£´æ³É¹¦");
		return "message";
	}
}
