package com.ognl.action;

import com.ognl.pojo.Book;

import java.util.ArrayList;
import java.util.List;

public class BookAction {
    private String name;
    private List<Book> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }


    public String execute() {
        list=new ArrayList<Book>();
        list.add(new Book(45,"JAVA",45));
        list.add(new Book(46,"JAVA1",75));
        list.add(new Book(47,"JAVA2",85));
        list.add(new Book(48,"JAVA3",95));
        return "success";
    }
}
