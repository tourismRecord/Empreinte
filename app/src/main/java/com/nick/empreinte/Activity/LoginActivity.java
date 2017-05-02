package com.nick.empreinte.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nick.empreinte.R;

/**
 * Created by huanghaojian on 17/5/2.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener{
    private Button login;
    private TextView toRegister;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        setContentView(R.layout.login);
        initView();
    }
    void initView(){
        login=(Button)findViewById(R.id.btnLogin);
        toRegister=(TextView)findViewById(R.id.zhucexinxi);
        login.setOnClickListener(this);
        toRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnLogin:
                MainActivity.actionStart(LoginActivity.this);
                finish();
                break;
            case R.id.zhucexinxi:
                RegisterActivity.actionStart(LoginActivity.this);
                break;
            default:
        }
    }
    public static void actionStart(Context context){
        Intent intent=new Intent(context,LoginActivity.class);
        context.startActivity(intent);
    }
}
