package com.service;



import com.pojo.Dept;

import java.util.List;

public interface DeptService {

    public List<Dept> findAll();

    public void add(Dept dept);

    public Dept findOne(String id);

    public void update(Dept dept);

    public void delete(String id);
}
