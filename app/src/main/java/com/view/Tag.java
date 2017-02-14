package com.view;

import java.io.Serializable;

/**
 * @className:Tag
 * @classDescription: 标签实体类
 * @author: miao
 * @createTime: 2017年2月14日
 */
public class Tag implements Serializable {

    private static final long serialVersionUID = 2345436746732425465L;

    private int backgroundResId;
    private int id;
    private boolean isChecked = false;
    private int leftDrawableResId;
    private int rightDrawableResId;
    private String title;
    private Object extra;

    public Tag() {

    }

    public Tag(int paramInt, String paramString) {
        this.id = paramInt;
        this.title = paramString;
    }

    public int getBackgroundResId() {
        return this.backgroundResId;
    }

    public int getId() {
        return this.id;
    }

    public int getLeftDrawableResId() {
        return this.leftDrawableResId;
    }

    public int getRightDrawableResId() {
        return this.rightDrawableResId;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setBackgroundResId(int paramInt) {
        this.backgroundResId = paramInt;
    }

    public void setChecked(boolean paramBoolean) {
        this.isChecked = paramBoolean;
    }

    public void setId(int paramInt) {
        this.id = paramInt;
    }

    public void setLeftDrawableResId(int paramInt) {
        this.leftDrawableResId = paramInt;
    }

    public void setRightDrawableResId(int paramInt) {
        this.rightDrawableResId = paramInt;
    }

    public void setTitle(String paramString) {
        this.title = paramString;
    }

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }
}
