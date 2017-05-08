package com.nick.empreinte.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.nick.empreinte.Adapter.ShareContentAdapter;
import com.nick.empreinte.Model.ShareContent;
import com.nick.empreinte.R;
import com.nick.empreinte.Tool.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huanghaojian on 17/4/30.
 */

public class LeftFragment extends Fragment  {
    private RecyclerView recyclerView;
    private TextView refreshButton;
    private List<ShareContent>shareContentList=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.left_fragment,container,false);
        initList();
        recyclerView=(RecyclerView)view.findViewById(R.id.share_content_list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(),DividerItemDecoration.VERTICAL_LIST));
        ShareContentAdapter adapter=new ShareContentAdapter(shareContentList);
        recyclerView.setAdapter(adapter);

        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        refreshButton=(TextView)getActivity().findViewById(R.id.refresh);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"refresh",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initList(){
        ShareContent shareContent=new ShareContent(0,"xingyingyue",R.mipmap.ic_launcher,"no_title","2017-04-16");
        shareContentList.add(shareContent);
        ShareContent shareContent1=new ShareContent(1,"xingyingyue",R.drawable.nav_image,"no_title","2017-04-16");
        shareContentList.add(shareContent1);
        shareContentList.add(shareContent1);
        shareContentList.add(shareContent1);
        shareContentList.add(shareContent1);
    }
}
