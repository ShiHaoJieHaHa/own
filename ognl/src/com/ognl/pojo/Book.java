package com.ognl.pojo;
//书得实体类    模拟ognl得投影功能
public class Book {
    private Integer bookid;
    private String name;
    private Integer price;

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Book(Integer bookid, String name, Integer price) {
        this.bookid = bookid;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
