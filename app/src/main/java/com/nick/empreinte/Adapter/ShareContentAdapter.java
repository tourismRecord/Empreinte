package com.nick.empreinte.Adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nick.empreinte.Activity.ShareContentActivity;
import com.nick.empreinte.Model.ShareContent;
import com.nick.empreinte.R;

import java.util.List;


/**
 * Created by huanghaojian on 17/4/15.
 */

public class ShareContentAdapter extends RecyclerView.Adapter<ShareContentAdapter.ViewHolder>{
    private List<ShareContent> shareContentList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView head;
        TextView title;
        TextView userName;
        TextView publishTime;
        View shareContentView;
        public ViewHolder(View view){
            super(view);
            shareContentView=view;
            head=(ImageView)view.findViewById(R.id.head);
            title=(TextView)view.findViewById(R.id.item_title);
            userName=(TextView)view.findViewById(R.id.user_name);
            publishTime=(TextView)view.findViewById(R.id.publish_time);
        }
    }
    public ShareContentAdapter(List<ShareContent> shareContentList){
        this.shareContentList=shareContentList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.share_item,parent,false);
        final ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.shareContentView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int position=viewHolder.getAdapterPosition();
                ShareContent shareContent=shareContentList.get(position);
                ShareContentActivity.actionStart(v.getContext(),shareContent.getId());
            }
        });
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder,int position){
        ShareContent shareContent=shareContentList.get(position);
        viewHolder.head.setImageResource(shareContent.getImageId());
        viewHolder.title.setText(shareContent.getTitle());
        viewHolder.userName.setText(shareContent.getUserName());
        viewHolder.publishTime.setText(shareContent.getPublishTime());
    }
    @Override
    public int getItemCount(){
        return shareContentList.size();
    }
}
