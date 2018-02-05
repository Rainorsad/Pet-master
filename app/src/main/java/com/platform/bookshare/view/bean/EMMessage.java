package com.platform.bookshare.view.bean;

/**
 * Created by Zhangchen on 2018/1/29.
 */

public class EMMessage {
    public static final int SEND_RIGHT = 1;
    public static final int SEND_LEFT = 2;
    public static final int RIGHT_TEXT = 3;
    public static final int RIGHT_IMG = 4;
    public static final int LEFT_TEXT = 5;
    public static final int LEFT_IMG = 6;

    public EMMessage(String text_context, String img_contect, String img_head, int type) {
        this.text_context = text_context;
        this.img_contect = img_contect;
        this.img_head = img_head;
        this.type = type;
    }

    private String  text_context;//文字内容
    private String img_contect;//图片内容
    private String img_head;//头像图片
    private int type;//消息类型，图片，文本

    public String getImg_contect() {
        return img_contect;
    }

    public void setImg_contect(String img_contect) {
        this.img_contect = img_contect;
    }

    public String getImg_head() {
        return img_head;
    }

    public void setImg_head(String img_head) {
        this.img_head = img_head;
    }

    public String getText_context() {
        return text_context;
    }

    public void setText_context(String text_context) {
        this.text_context = text_context;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
