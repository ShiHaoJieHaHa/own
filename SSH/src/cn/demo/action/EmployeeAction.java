package cn.demo.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.demo.service.EmployeeService;

@Controller // employeeAction
public class EmployeeAction {
    @Resource EmployeeService employeeService;
    
	public String execute(){
		ActionContext.getContext().put("employees", employeeService.list());
		return "list";
	}
}
