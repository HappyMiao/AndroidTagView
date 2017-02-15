package com.tagview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.view.Tag;
import com.view.TagListView;
import com.view.TagListViewFlowLayout;
import com.view.TagView;

import java.util.ArrayList;
import java.util.List;

/**
 * AndroidTagView
 * @classDescription: Android标签View，可根据内容自动换行，普通标签可以设置点击事件，勾选标签可以设置勾选状态
 * @author: miao
 * @createTime: 2017年2月14日
 */
public class MainActivity extends AppCompatActivity {

    //标签视图
    private TagListView mTagListView;
    //标签数据
    private String tag_data []  = null;
    //标签内容列表
    private List<Tag> mTags = new ArrayList<Tag>();
    //已选择标签提示
    private TextView selected_tag;
    //已选择标签拼接
    StringBuilder stringBuilder = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 初始化布局，添加数据，设置监听
     */
    private void initView() {

        //获取tag_view布局
        mTagListView = (TagListView) findViewById(R.id.tag_view);
        //已选择标签提示
        selected_tag = (TextView) findViewById(R.id.selected_tag);

        //获取标签数据
        tag_data = getResources().getStringArray(R.array.tag_text);

        //默认显示行数 正无穷（全部数据）
        TagListViewFlowLayout.SHOW_LINE_NUM = Double.POSITIVE_INFINITY;

        //将标签数据放入标签内容列表
        for (int i = 0; i < tag_data.length; i++) {
            Tag tag = new Tag();
            tag.setTitle(tag_data [i]);
            //模拟某几个条目已经是选中状态
            if(i == 0 || i == 5 || i == 9 || i == 11){
                tag.setChecked(true);
            }else{
                tag.setChecked(false);
            }
            mTags.add(tag);
        }

        //设置已选择标签提示
        for(int i = 0;i < mTags.size();i++){
            if(mTags.get(i).isChecked()){
                stringBuilder.append(mTags.get(i).getTitle()+"，");
            }
        }
        selected_tag.setText("默认已选择的标签："+stringBuilder.substring(0,stringBuilder.length()-1));

        //setTags 可勾选标签
        mTagListView.setTags(mTags,true);

        //设置勾选监听事情
        mTagListView.setOnTagCheckedChangedListener(new TagListView.OnTagCheckedChangedListener() {
            @Override
            public void onTagCheckedChanged(TagView tagView, Tag tag) {
                //勾选加入标签提示
                if(tag.isChecked()){
                    if(stringBuilder == null){
                        stringBuilder = new StringBuilder();
                    }
                    stringBuilder.append(tag.getTitle()+"，");
                    selected_tag.setText("已选择的标签："+stringBuilder.substring(0,stringBuilder.length()-1));
                }else{
                    //取消勾选删除标签提示
                    stringBuilder = null;
                    stringBuilder = new StringBuilder();
                    if(mTags.contains(tag)){
                        //记录此tag下标
                        int pos = mTags.indexOf(tag);
                        mTags.get(pos).setChecked(false);
                        //设置已选择标签提示
                        for(int i = 0;i < mTags.size();i++){
                            if(mTags.get(i).isChecked()){
                                stringBuilder.append(mTags.get(i).getTitle()+"，");
                            }
                        }
                        if(stringBuilder.length() == 0){
                            selected_tag.setText("未选择任何标签！");
                        }else{
                            selected_tag.setText("已选择的标签："+stringBuilder.substring(0,stringBuilder.length()-1));
                        }
                    }
                }
            }
        });

//        //setTags 普通标签
//        mTagListView.setTags(mTags);
//        //设置点击监听事情
//        mTagListView.setOnTagClickListener(new TagListView.OnTagClickListener() {
//            @Override
//            public void onTagClick(TagView tagView, Tag tag) {
//                Toast.makeText(MainActivity.this,tag.getTitle().toString(),Toast.LENGTH_SHORT).show();
//            }
//        });

    }

}
