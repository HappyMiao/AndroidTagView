package com.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @className: TagView
 * @classDescription: 标签视图
 * @author: miao
 * @createTime: 2017年2月14日
 */

public class TagView extends TextView {
    private boolean mCheckEnable = true;

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
        }
    }

    public void setChecked(boolean paramBoolean) {
        if (this.mCheckEnable) {
        }
    }
}
