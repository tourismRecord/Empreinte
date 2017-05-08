package com.nick.empreinte.Activity;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nick.empreinte.Fragment.LeftFragment;
import com.nick.empreinte.Fragment.RightFragment;
import com.nick.empreinte.R;





public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener{
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private TextView listMoudle;
    private TextView mapMoudle;
    private FrameLayout frameLayout;
    private LeftFragment leftFragment;
    private RightFragment rightFragment;
    private FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    void initView(){
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        frameLayout=(FrameLayout)findViewById(R.id.fragment_container);
        listMoudle=(TextView)findViewById(R.id.txt_deal);
        listMoudle.setOnClickListener(this);
        mapMoudle=(TextView)findViewById(R.id.txt_no);
        mapMoudle.setOnClickListener(this);

        fragmentTransaction=getFragmentManager().beginTransaction();
        listMoudle.setSelected(true);
        leftFragment = new LeftFragment();
        fragmentTransaction.add(R.id.fragment_container,leftFragment);
        fragmentTransaction.commit();

        drawerLayout=(DrawerLayout)findViewById(R.id.id_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navigationView=(NavigationView)findViewById(R.id.nv_menu_left);
        navigationView.setCheckedItem(R.id.nav_personal_info);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.edit_share:
                EditContentActivity.actionStart(MainActivity.this);
                break;
            default:

        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()){
            case R.id.nav_personal_info:
                ModifyInfoActivity.actionStart(MainActivity.this);
                break;
            case R.id.nav_home:
                MyShareActivity.actionStart(MainActivity.this);
                break;
            case R.id.nav_messages:
                Toast.makeText(MainActivity.this,"have not content",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_logout:
                LoginActivity.actionStart(MainActivity.this);
                finish();
                break;
            default:
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onClick(View v){
        FragmentTransaction transaction=getFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        switch (v.getId()){
            case R.id.txt_deal:
                selected();
                listMoudle.setSelected(true);
                if(leftFragment==null){
                    leftFragment = new LeftFragment();
                    transaction.add(R.id.fragment_container,leftFragment);
                }else{
                    transaction.show(leftFragment);
                }
                break;
            case R.id.txt_no:
                selected();
                mapMoudle.setSelected(true);
                if(rightFragment==null){
                    rightFragment = new RightFragment();
                    transaction.add(R.id.fragment_container,rightFragment);
                }else{
                    transaction.show(rightFragment);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }
    //重置所有文本的选中状态
    public void selected(){
        listMoudle.setSelected(false);
        mapMoudle.setSelected(false);
    }

    //隐藏所有Fragment
    public void hideAllFragment(FragmentTransaction transaction){
        if(leftFragment!=null){
            transaction.hide(leftFragment);
        }
        if(rightFragment!=null){
            transaction.hide(rightFragment);
        }
    }
    public static void actionStart(Context context){
        Intent intent=new Intent(context,MainActivity.class);
        context.startActivity(intent);
    }
}
