package com.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Dept;
import com.pojo.Result;
import com.service.DeptService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


//返回jsp页面采用下面配置
/*    Results({}):集合，对应的结果有多个
 *     Result():一个结果
 *  name:Action return返回的值
 *  location:返回结果的页面
 */

/*@Results({
        @Result(name="success",location="/success.jsp"),
        @Result(name="login",location="/login.jsp"),
        @Result(name="register",location="/register.jsp")
})*/
//Action类[观看顺序5]
@Controller(value = "deptAction")//用于标注控制层组件（如struts中的action）
@Scope("prototype")//单列模式
@ParentPackage("struts-default")
@Namespace("/")
public class DeptAction extends ActionSupport {

    // 引入Service
    @Autowired
    private DeptService deptService;

    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    //get方法后面直接加id可以获取参数
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Action(value = "list")
    public void list() {
        List<Dept> deptList = deptService.findAll();
        write(deptList);
    }

    @Action(value = "add")
    public void add() {
        System.out.println("===add");
        try {
            deptService.add(dept);
            Result result = new Result(true, "add ok");
            write(result);
        } catch (Exception e) {
            e.printStackTrace();
            Result result = new Result(false, "add error");
            write(result);
        }
    }

    @Action(value = "findOne")
    public void findOne() {
        System.out.println("===findOne");
        Dept one = deptService.findOne(id);
        write(one);
    }


    @Action(value = "update")
    public void update() {
        System.out.println("===update");
        try {
            deptService.update(dept);
            Result result = new Result(true, "update ok");
            write(result);
        } catch (Exception e) {
            e.printStackTrace();
            Result result = new Result(false, "update error");
            write(result);
        }
    }


    @Action(value = "delete")
    public void delete() {
        System.out.println("===delete");
        try {
            deptService.delete(id);
            Result result = new Result(true, "delete ok");
            write(result);
        } catch (Exception e) {
            e.printStackTrace();
            Result result = new Result(false, "delete error");
            write(result);
        }
    }


    /**
     * 输出字符串
     *
     * @param object 写出对象
     */
    public void write(Object object) {
        String jsonString = JSON.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect);//取消循环引用
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().print(jsonString);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
