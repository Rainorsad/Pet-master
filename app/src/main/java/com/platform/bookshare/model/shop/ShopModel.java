package com.platform.bookshare.model.shop;

/**
 * 作者：${丁丁} on 2017/7/24 10:59
 * 邮箱：75681284@qq.com
 * 功能：图书商品数据模型
 */


public class ShopModel
{
    private String titles;
    private int image;
    private int[] images;

    public ShopModel(String titles, int image, int[] images)
    {
        this.titles = titles;
        this.image = image;
        this.images = images;
    }


    public String getTitles()
    {
        return titles;
    }

    public void setTitles(String titles)
    {
        this.titles = titles;
    }

    public int getImage()
    {
        return image;
    }

    public void setImage(int image)
    {
        this.image = image;
    }

    public int[] getImages()
    {
        return images;
    }

    public void setImages(int[] images)
    {
        this.images = images;
    }
}
