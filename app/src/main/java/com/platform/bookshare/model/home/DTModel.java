package com.platform.bookshare.model.home;

/**
 * 作者：${丁丁} on 2017/7/24 10:59
 * 邮箱：75681284@qq.com
 * 功能：首页--动态数据模型
 */


public class DTModel
{
    private int userHeader;//用户头像
    private String userName;//用户名
    private String userDescript;//描述
    private int[] userImages;//用户图片

    public DTModel(int userHeader, String userName, String userDescript, int[] userImages)
    {
        this.userHeader = userHeader;
        this.userName = userName;
        this.userDescript = userDescript;
        this.userImages = userImages;
    }

    public int getUserHeader()
    {
        return userHeader;
    }

    public void setUserHeader(int userHeader)
    {
        this.userHeader = userHeader;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserDescript()
    {
        return userDescript;
    }

    public void setUserDescript(String userDescript)
    {
        this.userDescript = userDescript;
    }

    public int[] getUserImages()
    {
        return userImages;
    }

    public void setUserImages(int[] userImages)
    {
        this.userImages = userImages;
    }
}
