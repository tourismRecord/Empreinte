package com.nick.empreinte.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Button;

import com.nick.empreinte.R;

/**
 * Created by huanghaojian on 17/5/2.
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener{
    private Button register;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        setContentView(R.layout.register);
        initView();
    }
    void initView(){
        register=(Button)findViewById(R.id.btnRegister);
        register.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnRegister:
                LoginActivity.actionStart(RegisterActivity.this);
                finish();
                break;
            default:
        }
    }
    public static void actionStart(Context context){
        Intent intent=new Intent(context,RegisterActivity.class);
        context.startActivity(intent);
    }
}
