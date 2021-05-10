package com.test;


import com.pojo.Dept;
import com.service.DeptService;
import com.web.DeptAction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class NBTest {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DeptAction deptAction;

    @Test
    public void testGet(){
        Dept dept = new Dept();
        dept.setDeptName("新增测试");
        Dept dept1 = deptService.findOne("100");
        System.out.println(dept1);
    }

}
