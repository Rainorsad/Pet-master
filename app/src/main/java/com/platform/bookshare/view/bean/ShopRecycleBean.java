package com.platform.bookshare.view.bean;

/**
 * Created by Zhangchen on 2018/1/30.
 * 展示图书类bean
 */

public class ShopRecycleBean {
    @Override
    public String toString() {
        return "ShopRecycleBean{" +
                "booid='" + booid + '\'' +
                ", bookname='" + bookname + '\'' +
                ", bookauthor='" + bookauthor + '\'' +
                ", bookpress='" + bookpress + '\'' +
                ", booknowprice=" + booknowprice +
                ", bookoldprice=" + bookoldprice +
                ", bookimg='" + bookimg + '\'' +
                ", bookevaluation=" + bookevaluation +
                '}';
    }

    public ShopRecycleBean(String booid, String bookname, String bookauthor, String bookpress, double booknowprice, double bookoldprice, int bookevaluation, String bookimg) {
        this.booid = booid;
        this.bookname = bookname;
        this.bookauthor = bookauthor;
        this.bookpress = bookpress;
        this.booknowprice = booknowprice;
        this.bookoldprice = bookoldprice;
        this.bookevaluation = bookevaluation;
        this.bookimg = bookimg;
    }

    private String booid;//图书id
    private String bookname;//书名
    private String bookauthor;//作者
    private String bookpress;//出版社
    private double booknowprice;//现价
    private double bookoldprice;//旧价
    private String bookimg; //图书图片
    private int bookevaluation;//评价

    public double getBooknowprice() {
        return booknowprice;
    }

    public void setBooknowprice(double booknowprice) {
        this.booknowprice = booknowprice;
    }

    public double getBookoldprice() {
        return bookoldprice;
    }

    public void setBookoldprice(double bookoldprice) {
        this.bookoldprice = bookoldprice;
    }

    public String getBookimg() {
        return bookimg;
    }

    public void setBookimg(String bookimg) {
        this.bookimg = bookimg;
    }

    public String getBooid() {
        return booid;
    }

    public void setBooid(String booid) {
        this.booid = booid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public String getBookpress() {
        return bookpress;
    }

    public void setBookpress(String bookpress) {
        this.bookpress = bookpress;
    }

    public int getBookevaluation() {
        return bookevaluation;
    }

    public void setBookevaluation(int bookevaluation) {
        this.bookevaluation = bookevaluation;
    }
}
