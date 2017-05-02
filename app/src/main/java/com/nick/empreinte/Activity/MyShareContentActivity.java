package com.nick.empreinte.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.nick.empreinte.Adapter.MyShareContentReviewAdapter;
import com.nick.empreinte.Model.Review;
import com.nick.empreinte.R;
import com.nick.empreinte.tool.DividerItemDecoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by huanghaojian on 17/4/16.
 */

public class MyShareContentActivity extends BaseActivity implements View.OnClickListener {
    private Button back;
    private ImageView head;
    private TextView author;
    private TextView content;
    private TextView publishTime;
    private TextView publishPlace;
    private TextView deleteButton;
    private TextView loadReview;
    private GridView gridView;
    private RecyclerView reviewView;
    private List<Map<String,Object>> imageList;
    private List<Review>reviewList;
    private SimpleAdapter adapter;
    private MyShareContentReviewAdapter myShareContentReviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myshare_content);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        imageList=new ArrayList<Map<String,Object>>();
        reviewList=new ArrayList<>();
        initList();
        initReviewList();
        initView();
        head.setImageResource(R.mipmap.ic_launcher);
        author.setText("xingyingyue");
        content.setText("今天天气很好啊");
        publishTime.setText("2017年4月20日");
        publishPlace.setText("华南理工大学");
    }
    void initView(){
        back=(Button)findViewById(R.id.title_back);
        back.setOnClickListener(this);

        head=(ImageView)findViewById(R.id.myshare_content_head);
        author=(TextView)findViewById(R.id.myshare_content_name);
        content=(TextView)findViewById(R.id.myshare_content_text);
        publishTime=(TextView)findViewById(R.id.myshare_content_publish_time);
        publishPlace=(TextView)findViewById(R.id.myshare_content_place);
        deleteButton=(TextView)findViewById(R.id.myshare_content_delete);
        deleteButton.setOnClickListener(this);

        gridView=(GridView)findViewById(R.id.myshare_content_image_layout);
        String[]from={"image"};
        int[]to={R.id.image_item};
        adapter=new SimpleAdapter(this,imageList,R.layout.image_item,from,to);
        gridView.setAdapter(adapter);

        reviewView=(RecyclerView)findViewById(R.id.myshare_content_review_list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        reviewView.setLayoutManager(layoutManager);
        reviewView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        myShareContentReviewAdapter=new MyShareContentReviewAdapter(reviewList);
        reviewView.setAdapter(myShareContentReviewAdapter);

        loadReview=(TextView)findViewById(R.id.myshare_content_review_load);
        loadReview.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.title_back:
                finish();
                break;
            case R.id.myshare_content_delete:
                Toast.makeText(MyShareContentActivity.this,"click delete button",Toast.LENGTH_SHORT).show();
                break;
            case R.id.myshare_content_review_load:
                Toast.makeText(this,"load more review",Toast.LENGTH_SHORT).show();
            default:
                break;
        }
    }
    private void initList(){
        int []icon={R.mipmap.ic_launcher,R.drawable.nav_image,R.drawable.nav_image,R.drawable.nav_image,R.drawable.nav_image,
                R.drawable.nav_image,R.drawable.nav_image,R.drawable.nav_image,R.drawable.nav_image};
        for(int i=0;i<icon.length;i++){
            Map<String,Object>map=new HashMap<String,Object>();
            map.put("image",icon[i]);
            imageList.add(map);
        }
    }
    private void initReviewList(){
        Review review=new Review(0,"xingyingyue",R.mipmap.ic_launcher,"2017-4-29","对啊");
        reviewList.add(review);
    }

    public static void actionStart(Context context, int id){
        Intent intent=new Intent(context,MyShareContentActivity.class);
        intent.putExtra("item_id",id);
        context.startActivity(intent);
    }
}
