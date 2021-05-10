package com.service.impl;


import com.dao.DeptDao;
import com.pojo.Dept;
import com.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public List<Dept> findAll() {
        return deptDao.findAll();
    }

    @Override
    public void add(Dept dept) {
        deptDao.add(dept);
    }

    @Override
    public Dept findOne(String id) {
        Dept dept = deptDao.findOne(id);
        return dept;
    }

    @Override
    public void update(Dept dept) {
        deptDao.update(dept);
    }

    @Override
    public void delete(String id) {
        deptDao.delete(id);
    }
}
