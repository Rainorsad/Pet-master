package com.platform.bookshare.model.home;

import com.platform.bookshare.R;

/**
 * 作者：${丁丁} on 2017/7/24 10:35
 * 邮箱：75681284@qq.com
 * 功能：首页推荐标签第一个
 */

public class BookTitleModel
{
    private String bookImg;         //图书缩略图
    private String bookName;        //书名
    private String publishName;     //出版社
    private float bookPrice;        //图书定价
    private String authorName;      //作者名称
    private String bookType;        //图书类别
    private float presentPrice;     //现价
    private String bookDescript;    //图书简介
    private String publishTime;     //出版时间


    public BookTitleModel()
    {
        this.bookImg = "";
        this.bookName = "豌豆麻麻";
        this.publishName = "四川 资阳";
        this.bookPrice = R.drawable.jx_user_pet;
        this.authorName = "豌豆";
        this.bookType = "历史";
        this.presentPrice = 1.0f;
    }

    public String getBookImg()
    {
        return bookImg;
    }

    public void setBookImg(String bookImg)
    {
        this.bookImg = bookImg;
    }

    public String getBookName()
    {
        return bookName;
    }

    public void setBookName(String bookName)
    {
        this.bookName = bookName;
    }

    public String getPublishName()
    {
        return publishName;
    }

    public void setPublishName(String publishName)
    {
        this.publishName = publishName;
    }

    public float getBookPrice()
    {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice)
    {
        this.bookPrice = bookPrice;
    }

    public String getAuthorName()
    {
        return authorName;
    }

    public void setAuthorName(String authorName)
    {
        this.authorName = authorName;
    }

    public String getBookType()
    {
        return bookType;
    }

    public void setBookType(String bookType)
    {
        this.bookType = bookType;
    }

    public float getPresentPrice()
    {
        return presentPrice;
    }

    public void setPresentPrice(float presentPrice)
    {
        this.presentPrice = presentPrice;
    }

    public String getBookDescript()
    {
        return bookDescript;
    }

    public void setBookDescript(String bookDescript)
    {
        this.bookDescript = bookDescript;
    }

}
