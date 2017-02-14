package com.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.tagview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: TagListView
 * @classDescription: 标签控件实现类
 * @author: miao
 * @createTime: 2017年2月14日
 */

public class TagListView extends TagListViewFlowLayout implements View.OnClickListener {

    //DeleteMode
    private boolean mIsDeleteMode;
    //标签被勾选与否监听
    private OnTagCheckedChangedListener mOnTagCheckedChangedListener;
    //标签点击监听
    private OnTagClickListener mOnTagClickListener;
    //标签背景资源ID
    private int mTagViewBackgroundResId;
    //标签文字颜色ID
    private int mTagViewTextColorResId;
    //标签实体数组
    private final List<Tag> mTags = new ArrayList<Tag>();

    /**
     * 构造方法
     * @param context
     */
    public TagListView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        init();
    }

    /**
     * 构造方法
     * @param context
     * @param attributeSet
     */
    public TagListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        // TODO Auto-generated constructor stub
        init();
    }

    /**
     * 构造方法
     * @param context
     * @param attributeSet
     * @param defStyle
     */
    public TagListView(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        // TODO Auto-generated constructor stub
        init();
    }

    private void init() {}

    /**
     * 标签点击事件监听
     * @param v
     */
    @Override
    public void onClick(View v) {
        //判断当前View对象是否为TagView
        if ((v instanceof TagView)) {
            //获取tag
            Tag localTag = (Tag) v.getTag();
            //回调点击监听方法
            if (this.mOnTagClickListener != null) {
                this.mOnTagClickListener.onTagClick((TagView) v, localTag);
            //回调勾选监听方法
            }else if(this.mOnTagCheckedChangedListener != null){
                this.mOnTagCheckedChangedListener.onTagCheckedChanged((TagView) v, localTag);
            }
        }
    }


    /**
     * 获取标签View方法
     * @param t 标签实体
     * @param b 是否勾选
     */
    private void inflateTagView(final Tag t, boolean b) {

        TagView localTagView = (TagView) View.inflate(getContext(), R.layout.tag_view, null);
        localTagView.setText(t.getTitle());
        localTagView.setTag(t);

        localTagView.setCheckEnable(b);
        localTagView.setChecked(t.isChecked());
        //设置默认勾选状态
        if(t.isChecked()){
            localTagView.setTextColor(Color.parseColor("#FF1493"));
        }
        if (mIsDeleteMode) {
            int k = (int) TypedValue.applyDimension(1, 5.0F, getContext().getResources().getDisplayMetrics());
            localTagView.setPadding(localTagView.getPaddingLeft(), localTagView.getPaddingTop(), k, localTagView.getPaddingBottom());
            localTagView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        //设置背景
        if (t.getBackgroundResId() > 0) {
            localTagView.setBackgroundResource(t.getBackgroundResId());
        }
        if ((t.getLeftDrawableResId() > 0) || (t.getRightDrawableResId() > 0)) {
            localTagView.setCompoundDrawablesWithIntrinsicBounds(t.getLeftDrawableResId(), 0, t.getRightDrawableResId(), 0);
        }
        localTagView.setOnClickListener(this);
        addView(localTagView);
    }

    /**
     * 添加标签方法
     * @param i
     * @param s
     */
    public void addTag(int i, String s) {
        addTag(i, s, false);
    }

    /**
     * 添加标签方法
     * @param i
     * @param s
     * @param b
     */
    public void addTag(int i, String s, boolean b) {
        addTag(new Tag(i, s), b);
    }

    /**
     * 添加标签方法
     * @param tag
     */
    public void addTag(Tag tag) {
        addTag(tag, false);
    }

    /**
     * 添加标签方法
     * @param tag
     * @param b
     */
    public void addTag(Tag tag, boolean b) {
        mTags.add(tag);
        inflateTagView(tag, b);
    }

    /**
     * 添加标签方法
     * @param lists
     */
    public void addTags(List<Tag> lists) {
        addTags(lists, false);
    }

    /**
     * 添加标签方法
     * @param lists
     * @param b
     */
    public void addTags(List<Tag> lists, boolean b) {
        for (int i = 0; i < lists.size(); i++) {
            addTag((Tag) lists.get(i), b);
        }
    }

    /**
     * 获取标签方法
     * @return
     */
    public List<Tag> getTags() {
        return mTags;
    }

    /**
     * 通过tag找到对应的View方法
     * @param tag
     * @return
     */
    public View getViewByTag(Tag tag) {
        return findViewWithTag(tag);
    }

    /**
     * 通过tag删除某个View
     * @param tag
     */
    public void removeTag(Tag tag) {
        mTags.remove(tag);
        removeView(getViewByTag(tag));
    }

    /**
     * setDeleteMode
     * @param b
     */
    public void setDeleteMode(boolean b) {
        mIsDeleteMode = b;
    }

    /**
     * 设置标签勾选监听
     * @param onTagCheckedChangedListener
     */
    public void setOnTagCheckedChangedListener(
            OnTagCheckedChangedListener onTagCheckedChangedListener) {
        mOnTagCheckedChangedListener = onTagCheckedChangedListener;
    }

    /**
     * 设置标签点击监听
     * @param onTagClickListener
     */
    public void setOnTagClickListener(OnTagClickListener onTagClickListener) {
        mOnTagClickListener = onTagClickListener;
    }

    /**
     * 设置tag对应标签View的背景资源
     * @param res
     */
    public void setTagViewBackgroundRes(int res) {
        mTagViewBackgroundResId = res;
    }

    /**
     * 设置tag对应的标签View的文本颜色
     * @param res
     */
    public void setTagViewTextColorRes(int res) {
        mTagViewTextColorResId = res;
    }

    /**
     * 设置标签方法
     * @param lists
     */
    public void setTags(List<? extends Tag> lists) {
        setTags(lists, false);
    }

    /**
     * 设置标签方法
     * @param lists
     * @param b
     */
    public void setTags(List<? extends Tag> lists, boolean b) {
        removeAllViews();
        mTags.clear();
        for (int i = 0; i < lists.size(); i++) {
            addTag((Tag) lists.get(i), b);
        }
    }

    /**
     * 标签勾选监听接口
     */
    public  interface OnTagCheckedChangedListener {
         void onTagCheckedChanged(TagView tagView, Tag tag);
    }

    /**
     * 标签点击监听接口
     */
    public interface OnTagClickListener {
         void onTagClick(TagView tagView, Tag tag);
    }
}
