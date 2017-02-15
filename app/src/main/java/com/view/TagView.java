package com.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;

import com.tagview.R;

/**
 * @className: TagView
 * @classDescription: 标签视图
 * @author: miao
 * @createTime: 2017年2月14日
 */

public class TagView extends TextView {

    //是否可勾选
    private boolean mCheckEnable = false;
    //是否勾选
    private boolean mChecked = false;

    public TagView(Context paramContext) {
        super(paramContext);
        init();
    }

    public TagView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init();
    }

    public TagView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, 0);
        init();
    }

    private void init() {
        setText("");
    }

    public void setCheckEnable(boolean paramBoolean) {
        this.mCheckEnable = paramBoolean;
        if (!this.mCheckEnable) {
            //不可勾选
        }
    }

    public void setChecked(boolean paramBoolean) {
        this.mChecked = paramBoolean;
        if (this.mChecked) {
            //已勾选
            this.setTextColor(Color.parseColor("#FFFFFF"));
            this.setBackgroundResource(R.drawable.symptom_bg_selected);
        }
    }
}
