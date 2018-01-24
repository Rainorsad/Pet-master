package com.platform.bookshare.view.bean;

import java.io.Serializable;

/**
 * Created by Zhangchen on 2018/1/19.
 */

public class ShareUserBean implements Serializable {
    public ShareUserBean(String userId, String jingdu, String weidu, String booktitle) {
        this.userId = userId;
        this.jingdu = jingdu;
        this.weidu = weidu;
        this.booktitle = booktitle;
    }

    private String userId;
    private String jingdu;
    private String weidu;
    private String booktitle;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getJingdu() {
        return jingdu;
    }

    public void setJingdu(String jingdu) {
        this.jingdu = jingdu;
    }

    public String getWeidu() {
        return weidu;
    }

    public void setWeidu(String weidu) {
        this.weidu = weidu;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }
}
