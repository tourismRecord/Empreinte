package com.nick.empreinte.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nick.empreinte.R;

/**
 * Created by huanghaojian on 17/5/2.
 */

public class ModifyInfoActivity extends BaseActivity implements View.OnClickListener{
    private Button commitInfo;
    @Override
    public void onCreate(Bundle savedIntanceState){
        super.onCreate(savedIntanceState);
        setContentView(R.layout.user_about);
        initView();
    }
    private void initView(){
        commitInfo=(Button)findViewById(R.id.add);
        commitInfo.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.add:
                MainActivity.actionStart(ModifyInfoActivity.this);
                finish();
                break;
            default:
        }
    }
    public static void actionStart(Context context){
        Intent intent=new Intent(context,ModifyInfoActivity.class);
        context.startActivity(intent);
    }
}
