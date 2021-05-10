package com.dao.impl;


import com.dao.DeptDao;
import com.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class DeptDaoImpl extends HibernateDaoSupport implements DeptDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Dept> findAll() {
        Dept dept = new Dept();
        return hibernateTemplate.findByExample(dept);
    }

    @Override
    public void add(Dept dept) {
        hibernateTemplate.save(dept);
    }

    @Override
    public Dept findOne(String id) {
        return hibernateTemplate.get(Dept.class, id);
    }

    @Override
    public void update(Dept dept) {
        hibernateTemplate.update(dept);
    }

    @Override
    public void delete(String id) {
        Dept dept = hibernateTemplate.get(Dept.class, id);
        hibernateTemplate.delete(dept);
    }
}
