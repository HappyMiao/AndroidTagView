package com.tagview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.view.Tag;
import com.view.TagListView;
import com.view.TagListViewFlowLayout;
import com.view.TagView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //标签视图
    private TagListView mTagListView;
    //标签数据
    private String tag_data []  = null;
    //标签内容列表
    private List<Tag> mTags = new ArrayList<Tag>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取tag_view布局
        mTagListView = (TagListView) findViewById(R.id.tag_view);

        //获取标签数据
        tag_data = getResources().getStringArray(R.array.tag_text);
        TagListViewFlowLayout.SHOW_LINE_NUM = 12;

        //将标签数据放入标签内容列表
        for (int i = 0; i < tag_data.length; i++) {
            Tag tag = new Tag();
            tag.setTitle(tag_data [i]);
            mTags.add(tag);
        }

        mTagListView.setTags(mTags);
        mTagListView.setOnTagClickListener(new TagListView.OnTagClickListener() {
            @Override
            public void onTagClick(TagView tagView, Tag tag) {
                Toast.makeText(MainActivity.this,tag.getTitle().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
