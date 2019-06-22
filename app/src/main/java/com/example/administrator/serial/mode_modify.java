package com.example.administrator.serial;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.SharedPreferences;
/**
 * Created by 15522 on 2019/6/22.
 */

public class mode_modify extends Activity {
    private Button btn_return;
    private TextView temp1;
    private TextView temp2;
    private TextView temp3;
    private TextView temp4;
    private TextView temp5;
    private TextView temp6;
    private TextView temp7;
    private TextView temp8;
    private TextView temp9;
    private TextView temp10;
    private TextView temp11;
    private TextView temp12;

    private TextView rpm1;
    private TextView rpm2;
    private TextView rpm3;
    private TextView rpm4;
    private TextView rpm5;
    private TextView rpm6;
    private TextView rpm7;
    private TextView rpm8;
    private TextView rpm9;
    private TextView rpm10;
    private TextView rpm11;
    private TextView rpm12;

    private CheckBox pump1;
    private CheckBox pump2;
    private CheckBox pump3;
    private CheckBox pump4;
    private CheckBox pump5;
    private CheckBox pump6;
    private CheckBox pump7;
    private CheckBox pump8;
    private CheckBox pump9;
    private CheckBox pump10;
    private CheckBox pump11;
    private CheckBox pump12;

    private CheckBox trun1;
    private CheckBox trun2;
    private CheckBox trun3;
    private CheckBox trun4;
    private CheckBox trun5;
    private CheckBox trun6;
    private CheckBox trun7;
    private CheckBox trun8;
    private CheckBox trun9;
    private CheckBox trun10;
    private CheckBox trun11;
    private CheckBox trun12;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.mode_modify);
        super.onCreate(savedInstanceState);


        Window _window;
        _window = getWindow();
        WindowManager.LayoutParams params = _window.getAttributes();
        params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_IMMERSIVE;
        _window.setAttributes(params);

        temp1 = (TextView)findViewById(R.id.temp1);
        final String st_temp1=Common.ModeConfig.getString("temp1","");
        temp1.setText(st_temp1);
        temp2 = (TextView)findViewById(R.id.temp2);
        final String st_temp2=Common.ModeConfig.getString("temp2","");
        temp2.setText(st_temp2);
        temp3 = (TextView)findViewById(R.id.temp3);
        final String st_temp3=Common.ModeConfig.getString("temp3","");
        temp3.setText(st_temp3);
        temp4 = (TextView)findViewById(R.id.temp4);
        final String st_temp4=Common.ModeConfig.getString("temp4","");
        temp4.setText(st_temp4);
        temp5 = (TextView)findViewById(R.id.temp5);
        final String st_temp5=Common.ModeConfig.getString("temp5","");
        temp5.setText(st_temp5);
        temp6 = (TextView)findViewById(R.id.temp6);
        final String st_temp6=Common.ModeConfig.getString("temp6","");
        temp6.setText(st_temp6);
        temp7 = (TextView)findViewById(R.id.temp7);
        final String st_temp7=Common.ModeConfig.getString("temp7","");
        temp7.setText(st_temp7);
        temp8 = (TextView)findViewById(R.id.temp8);
        final String st_temp8=Common.ModeConfig.getString("temp8","");
        temp8.setText(st_temp8);
        temp9 = (TextView)findViewById(R.id.temp9);
        final String st_temp9=Common.ModeConfig.getString("temp9","");
        temp9.setText(st_temp9);
        temp10 = (TextView)findViewById(R.id.temp10);
        final String st_temp10=Common.ModeConfig.getString("temp10","");
        temp10.setText(st_temp10);
        temp11 = (TextView)findViewById(R.id.temp11);
        final String st_temp11=Common.ModeConfig.getString("temp11","");
        temp11.setText(st_temp11);
        temp12 = (TextView)findViewById(R.id.temp12);
        final String st_temp12=Common.ModeConfig.getString("temp12","");
        temp12.setText(st_temp12);

        rpm1 = (TextView)findViewById(R.id.rpm1);
        final String st_rpm1=Common.ModeConfig.getString("rpm1","");
        rpm1.setText(st_rpm1);
        rpm2 = (TextView)findViewById(R.id.rpm2);
        final String st_rpm2=Common.ModeConfig.getString("rpm2","");
        rpm2.setText(st_rpm2);
        rpm3 = (TextView)findViewById(R.id.rpm3);
        final String st_rpm3=Common.ModeConfig.getString("rpm3","");
        rpm3.setText(st_rpm3);
        rpm4 = (TextView)findViewById(R.id.rpm4);
        final String st_rpm4=Common.ModeConfig.getString("rpm4","");
        rpm4.setText(st_rpm4);
        rpm5 = (TextView)findViewById(R.id.rpm5);
        final String st_rpm5=Common.ModeConfig.getString("rpm5","");
        rpm5.setText(st_rpm5);
        rpm6 = (TextView)findViewById(R.id.rpm6);
        final String st_rpm6=Common.ModeConfig.getString("rpm6","");
        rpm6.setText(st_rpm6);
        rpm7 = (TextView)findViewById(R.id.rpm7);
        final String st_rpm7=Common.ModeConfig.getString("rpm7","");
        rpm7.setText(st_rpm7);
        rpm8 = (TextView)findViewById(R.id.rpm8);
        final String st_rpm8=Common.ModeConfig.getString("rpm8","");
        rpm8.setText(st_rpm8);
        rpm9 = (TextView)findViewById(R.id.rpm9);
        final String st_rpm9=Common.ModeConfig.getString("rpm9","");
        rpm9.setText(st_rpm9);
        rpm10 = (TextView)findViewById(R.id.rpm10);
        final String st_rpm10=Common.ModeConfig.getString("rpm10","");
        rpm10.setText(st_rpm10);
        rpm11 = (TextView)findViewById(R.id.rpm11);
        final String st_rpm11=Common.ModeConfig.getString("rpm11","");
        rpm11.setText(st_rpm11);
        rpm12 = (TextView)findViewById(R.id.rpm12);
        final String st_rpm12=Common.ModeConfig.getString("rpm12","");
        rpm12.setText(st_rpm12);

        pump1 = (CheckBox)findViewById(R.id.pump1);
        final String st_pump1=Common.ModeConfig.getString("pump1","");
       if(st_pump1.equals("开启"))
       {
           pump1.setChecked(true);
           pump1.setPadding(10, 0, 0, 0);
           pump1.setText("关闭");
       }
        else{
           pump1.setChecked(false);
           pump1.setPadding(70, 0, 0, 0);
           pump1.setText("启动");
        }

        pump2 = (CheckBox) findViewById(R.id.pump2);
        final String st_pump2=Common.ModeConfig.getString("pump2","");
        if(st_pump2.equals("开启"))
        {
            pump2.setChecked(true);
            pump2.setPadding(10, 0, 0, 0);
            pump2.setText("关闭");
        }
        else{
            pump2.setChecked(false);
            pump2.setPadding(70, 0, 0, 0);
            pump2.setText("启动");
        }

        pump3 = (CheckBox) findViewById(R.id.pump3);
        final String st_pump3=Common.ModeConfig.getString("pump3","");
        if(st_pump3.equals("开启"))
        {
            pump3.setChecked(true);
            pump3.setPadding(10, 0, 0, 0);
            pump3.setText("关闭");
        }
        else{
            pump3.setChecked(false);
            pump3.setPadding(70, 0, 0, 0);
            pump3.setText("启动");
        }

        pump4 = (CheckBox) findViewById(R.id.pump4);
        final String st_pump4=Common.ModeConfig.getString("pump4","");
        if(st_pump4.equals("开启"))
        {
            pump4.setChecked(true);
            pump4.setPadding(10, 0, 0, 0);
            pump4.setText("关闭");
        }
        else{
            pump4.setChecked(false);
            pump4.setPadding(70, 0, 0, 0);
            pump4.setText("启动");
        }

        pump5 = (CheckBox) findViewById(R.id.pump5);
        final String st_pump5=Common.ModeConfig.getString("pump5","");
        if(st_pump5.equals("开启"))
        {
            pump5.setChecked(true);
            pump5.setPadding(10, 0, 0, 0);
            pump5.setText("关闭");
        }
        else{
            pump5.setChecked(false);
            pump5.setPadding(70, 0, 0, 0);
            pump5.setText("启动");
        }

        pump6 = (CheckBox) findViewById(R.id.pump6);
        final String st_pump6=Common.ModeConfig.getString("pump6","");
        if(st_pump6.equals("开启"))
        {
            pump6.setChecked(true);
            pump6.setPadding(10, 0, 0, 0);
            pump6.setText("关闭");
        }
        else{
            pump6.setChecked(false);
            pump6.setPadding(70, 0, 0, 0);
            pump6.setText("启动");
        }

        pump7 = (CheckBox) findViewById(R.id.pump7);
        final String st_pump7=Common.ModeConfig.getString("pump7","");
        if(st_pump7.equals("开启"))
        {
            pump7.setChecked(true);
            pump7.setPadding(10, 0, 0, 0);
            pump7.setText("关闭");
        }
        else{
            pump7.setChecked(false);
            pump7.setPadding(70, 0, 0, 0);
            pump7.setText("启动");
        }

        pump8 = (CheckBox) findViewById(R.id.pump8);
        final String st_pump8=Common.ModeConfig.getString("pump8","");
        if(st_pump8.equals("开启"))
        {
            pump8.setChecked(true);
            pump8.setPadding(10, 0, 0, 0);
            pump8.setText("关闭");
        }
        else{
            pump8.setChecked(false);
            pump8.setPadding(70, 0, 0, 0);
            pump8.setText("启动");
        }

        pump9 = (CheckBox) findViewById(R.id.pump9);
        final String st_pump9=Common.ModeConfig.getString("pump9","");
        if(st_pump9.equals("开启"))
        {
            pump9.setChecked(true);
            pump9.setPadding(10, 0, 0, 0);
            pump9.setText("关闭");
        }
        else{
            pump9.setChecked(false);
            pump9.setPadding(70, 0, 0, 0);
            pump9.setText("启动");
        }

        pump10 = (CheckBox) findViewById(R.id.pump10);
        final String st_pump10=Common.ModeConfig.getString("pump10","");
        if(st_pump10.equals("开启"))
        {
            pump10.setChecked(true);
            pump10.setPadding(10, 0, 0, 0);
            pump10.setText("关闭");
        }
        else{
            pump10.setChecked(false);
            pump10.setPadding(70, 0, 0, 0);
            pump10.setText("启动");
        }

        pump11 = (CheckBox) findViewById(R.id.pump11);
        final String st_pump11=Common.ModeConfig.getString("pump11","");
        if(st_pump11.equals("开启"))
        {
            pump11.setChecked(true);
            pump11.setPadding(10, 0, 0, 0);
            pump11.setText("关闭");
        }
        else{
            pump11.setChecked(false);
            pump11.setPadding(70, 0, 0, 0);
            pump11.setText("启动");
        }
        pump12 = (CheckBox) findViewById(R.id.pump12);
        final String st_pump12=Common.ModeConfig.getString("pump12","");
        if(st_pump12.equals("开启"))
        {
            pump12.setChecked(true);
            pump12.setPadding(10, 0, 0, 0);
            pump12.setText("关闭");
        }
        else{
            pump12.setChecked(false);
            pump12.setPadding(70, 0, 0, 0);
            pump12.setText("启动");
        }

        trun1 = (CheckBox) findViewById(R.id.trun1);
        final String st_trun1=Common.ModeConfig.getString("trun1","");
        if(st_trun1.equals("正转"))
        {
            trun1.setChecked(true);
            trun1.setPadding(10, 0, 0, 0);
            trun1.setText("反转");
        }
        else{
            trun1.setChecked(false);
            trun1.setPadding(70, 0, 0, 0);
            trun1.setText("正转");
        }
        trun2 = (CheckBox) findViewById(R.id.trun2);
        final String st_trun2=Common.ModeConfig.getString("trun2","");
        if(st_trun2.equals("正转"))
        {
            trun2.setChecked(true);
            trun2.setPadding(10, 0, 0, 0);
            trun2.setText("反转");
        }
        else{
            trun2.setChecked(false);
            trun2.setPadding(70, 0, 0, 0);
            trun2.setText("正转");
        }
        trun3 = (CheckBox) findViewById(R.id.trun3);
        final String st_trun3=Common.ModeConfig.getString("trun3","");
        if(st_trun3.equals("正转"))
        {
            trun3.setChecked(true);
            trun3.setPadding(10, 0, 0, 0);
            trun3.setText("反转");
        }
        else{
            trun3.setChecked(false);
            trun3.setPadding(70, 0, 0, 0);
            trun3.setText("正转");
        }
        trun4 = (CheckBox) findViewById(R.id.trun4);
        final String st_trun4=Common.ModeConfig.getString("trun4","");
        if(st_trun4.equals("正转"))
        {
            trun4.setChecked(true);
            trun4.setPadding(10, 0, 0, 0);
            trun4.setText("反转");
        }
        else{
            trun4.setChecked(false);
            trun4.setPadding(70, 0, 0, 0);
            trun4.setText("正转");
        }
        trun5 = (CheckBox) findViewById(R.id.trun5);
        final String st_trun5=Common.ModeConfig.getString("trun5","");
        if(st_trun5.equals("正转"))
        {
            trun5.setChecked(true);
            trun5.setPadding(10, 0, 0, 0);
            trun5.setText("反转");
        }
        else{
            trun5.setChecked(false);
            trun5.setPadding(70, 0, 0, 0);
            trun5.setText("正转");
        }
        trun6 = (CheckBox) findViewById(R.id.trun6);
        final String st_trun6=Common.ModeConfig.getString("trun6","");
        if(st_trun6.equals("正转"))
        {
            trun6.setChecked(true);
            trun6.setPadding(10, 0, 0, 0);
            trun6.setText("反转");
        }
        else{
            trun6.setChecked(false);
            trun6.setPadding(70, 0, 0, 0);
            trun6.setText("正转");
        }
        trun7 = (CheckBox) findViewById(R.id.trun7);
        final String st_trun7=Common.ModeConfig.getString("trun7","");
        if(st_trun7.equals("正转"))
        {
            trun7.setChecked(true);
            trun7.setPadding(10, 0, 0, 0);
            trun7.setText("反转");
        }
        else{
            trun7.setChecked(false);
            trun7.setPadding(70, 0, 0, 0);
            trun7.setText("正转");
        }
        trun8 = (CheckBox) findViewById(R.id.trun8);
        final String st_trun8=Common.ModeConfig.getString("trun8","");
        if(st_trun8.equals("正转"))
        {
            trun8.setChecked(true);
            trun8.setPadding(10, 0, 0, 0);
            trun8.setText("反转");
        }
        else{
            trun8.setChecked(false);
            trun8.setPadding(70, 0, 0, 0);
            trun8.setText("正转");
        }
        trun9 = (CheckBox) findViewById(R.id.trun9);
        final String st_trun9=Common.ModeConfig.getString("trun9","");
        if(st_trun9.equals("正转"))
        {
            trun9.setChecked(true);
            trun9.setPadding(10, 0, 0, 0);
            trun9.setText("反转");
        }
        else{
            trun9.setChecked(false);
            trun9.setPadding(70, 0, 0, 0);
            trun9.setText("正转");
        }
        trun10 = (CheckBox) findViewById(R.id.trun10);
        final String st_trun10=Common.ModeConfig.getString("trun10","");
        if(st_trun10.equals("正转"))
        {
            trun10.setChecked(true);
            trun10.setPadding(10, 0, 0, 0);
            trun10.setText("反转");
        }
        else{
            trun10.setChecked(false);
            trun10.setPadding(70, 0, 0, 0);
            trun10.setText("正转");
        }
        trun11 = (CheckBox) findViewById(R.id.trun11);
        final String st_trun11=Common.ModeConfig.getString("trun11","");
        if(st_trun11.equals("正转"))
        {
            trun11.setChecked(true);
            trun11.setPadding(10, 0, 0, 0);
            trun11.setText("反转");
        }
        else{
            trun11.setChecked(false);
            trun11.setPadding(70, 0, 0, 0);
            trun11.setText("正转");
        }
        trun12 = (CheckBox) findViewById(R.id.trun12);
        final String st_trun12=Common.ModeConfig.getString("trun12","");
        if(st_trun12.equals("正转"))
        {
            trun12.setChecked(true);
            trun12.setPadding(10, 0, 0, 0);
            trun12.setText("反转");
        }
        else{
            trun12.setChecked(false);
            trun12.setPadding(70, 0, 0, 0);
            trun12.setText("正转");
        }


        Button btn_return = (Button) findViewById(R.id.btn_return);
        btn_return.setOnClickListener(onclick);

        pump1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pump1.isChecked()) {
                    pump1.setText("关闭");
                    pump1.setPadding(10, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("pump1","开启");
                    editor.commit();

                } else {
                    pump1.setText("开启");
                    pump1.setPadding(60, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("pump1","关闭");
                    editor.commit();

                }
            }
        });
        pump2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pump2.isChecked()) {
                    pump2.setText("关闭");
                    pump2.setPadding(10, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("pump2","开启");
                    editor.commit();

                } else {
                    pump2.setText("开启");
                    pump2.setPadding(60, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("pump2","关闭");
                    editor.commit();

                }
            }
        });
        pump3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pump3.isChecked()) {
                    pump3.setText("关闭");
                    pump3.setPadding(10, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("pump3","开启");
                    editor.commit();

                } else {
                    pump3.setText("开启");
                    pump3.setPadding(60, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("pump3","关闭");
                    editor.commit();

                }
            }
        });
        pump4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pump4.isChecked()) {
                    pump4.setText("关闭");
                    pump4.setPadding(10, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("pump4","开启");
                    editor.commit();

                } else {
                    pump4.setText("开启");
                    pump4.setPadding(60, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("pump4","关闭");
                    editor.commit();

                }
            }
        });
        pump5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pump5.isChecked()) {
                    pump5.setText("关闭");
                    pump5.setPadding(10, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("pump5","开启");
                    editor.commit();

                } else {
                    pump5.setText("开启");
                    pump5.setPadding(60, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("pump5","关闭");
                    editor.commit();

                }
            }
        });
        pump6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pump6.isChecked()) {
                    pump6.setText("关闭");
                    pump6.setPadding(10, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("pump6","开启");
                    editor.commit();

                } else {
                    pump6.setText("开启");
                    pump6.setPadding(60, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("pump6","关闭");
                    editor.commit();

                }
            }
        });
        pump7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pump7.isChecked()) {
                    pump7.setText("关闭");
                    pump7.setPadding(10, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("pump7","开启");
                    editor.commit();

                } else {
                    pump7.setText("开启");
                    pump7.setPadding(60, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("pump7","关闭");
                    editor.commit();

                }
            }
        });
        pump8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pump8.isChecked()) {
                    pump8.setText("关闭");
                    pump8.setPadding(10, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("pump8","开启");
                    editor.commit();

                } else {
                    pump8.setText("开启");
                    pump8.setPadding(60, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("pump8","关闭");
                    editor.commit();

                }
            }
        });
        pump9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pump9.isChecked()) {
                    pump9.setText("关闭");
                    pump9.setPadding(10, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("pump9","开启");
                    editor.commit();

                } else {
                    pump9.setText("开启");
                    pump9.setPadding(60, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("pump9","关闭");
                    editor.commit();

                }
            }
        });
        pump10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pump10.isChecked()) {
                    pump10.setText("关闭");
                    pump10.setPadding(10, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("pump10","开启");
                    editor.commit();

                } else {
                    pump10.setText("开启");
                    pump10.setPadding(60, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("pump10","关闭");
                    editor.commit();

                }
            }
        });

        pump11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pump11.isChecked()) {
                    pump11.setText("关闭");
                    pump11.setPadding(10, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("pump11","开启");
                    editor.commit();

                } else {
                    pump11.setText("开启");
                    pump11.setPadding(60, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("pump11","关闭");
                    editor.commit();

                }
            }
        });

        pump12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (pump12.isChecked()) {
                    pump12.setText("关闭");
                    pump12.setPadding(10, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("pump12","开启");
                    editor.commit();

                } else {
                    pump12.setText("开启");
                    pump12.setPadding(60, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("pump12","关闭");
                    editor.commit();

                }
            }
        });
        trun1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (trun1.isChecked()) {
                    trun1.setText("反转");
                    trun1.setPadding(10, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("trun1","正转");
                    editor.commit();

                } else {
                    trun1.setText("正转");
                    trun1.setPadding(60, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("trun1","反转");
                    editor.commit();

                }
            }
        });

        trun2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (trun2.isChecked()) {
                    trun2.setText("反转");
                    trun2.setPadding(10, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("trun2","正转");
                    editor.commit();

                } else {
                    trun2.setText("正转");
                    trun2.setPadding(60, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("trun2","反转");
                    editor.commit();

                }
            }
        });
        trun3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (trun3.isChecked()) {
                    trun3.setText("反转");
                    trun3.setPadding(10, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("trun3","正转");
                    editor.commit();

                } else {
                    trun3.setText("正转");
                    trun3.setPadding(60, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("trun3","反转");
                    editor.commit();

                }
            }
        });
        trun4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (trun4.isChecked()) {
                    trun4.setText("反转");
                    trun4.setPadding(10, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("trun4","正转");
                    editor.commit();

                } else {
                    trun4.setText("正转");
                    trun4.setPadding(60, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("trun4","反转");
                    editor.commit();

                }
            }
        });

        trun5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (trun5.isChecked()) {
                    trun5.setText("反转");
                    trun5.setPadding(10, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("trun5","正转");
                    editor.commit();

                } else {
                    trun5.setText("正转");
                    trun5.setPadding(60, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("trun5","反转");
                    editor.commit();

                }
            }
        });
        trun6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (trun6.isChecked()) {
                    trun6.setText("反转");
                    trun6.setPadding(10, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("trun6","正转");
                    editor.commit();

                } else {
                    trun6.setText("正转");
                    trun6.setPadding(60, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("trun6","反转");
                    editor.commit();

                }
            }
        });
        trun7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (trun7.isChecked()) {
                    trun7.setText("反转");
                    trun7.setPadding(10, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("trun7","正转");
                    editor.commit();

                } else {
                    trun7.setText("正转");
                    trun7.setPadding(60, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("trun7","反转");
                    editor.commit();

                }
            }
        });
        trun8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (trun8.isChecked()) {
                    trun8.setText("反转");
                    trun8.setPadding(10, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("trun8","正转");
                    editor.commit();

                } else {
                    trun8.setText("正转");
                    trun8.setPadding(60, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("trun8","反转");
                    editor.commit();

                }
            }
        });
        trun9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (trun9.isChecked()) {
                    trun9.setText("反转");
                    trun9.setPadding(10, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("trun9","正转");
                    editor.commit();

                } else {
                    trun9.setText("正转");
                    trun9.setPadding(60, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("trun9","反转");
                    editor.commit();

                }
            }
        });
        trun10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (trun10.isChecked()) {
                    trun10.setText("反转");
                    trun10.setPadding(10, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("trun10","正转");
                    editor.commit();

                } else {
                    trun10.setText("正转");
                    trun10.setPadding(60, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("trun10","反转");
                    editor.commit();

                }
            }
        });

        trun11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (trun11.isChecked()) {
                    trun11.setText("反转");
                    trun11.setPadding(10, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("trun11","正转");
                    editor.commit();

                } else {
                    trun11.setText("正转");
                    trun11.setPadding(60, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("trun11","反转");
                    editor.commit();

                }
            }
        });
        trun12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (trun12.isChecked()) {
                    trun12.setText("反转");
                    trun12.setPadding(10, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("trun12","正转");
                    editor.commit();

                } else {
                    trun12.setText("正转");
                    trun12.setPadding(60, 0, 0, 0);
                    SharedPreferences.Editor editor=Common.ModeConfig.edit();
                    editor.putString("trun12","反转");
                    editor.commit();

                }
            }
        });



        temp1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 监听到回车键，按下与松开
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        //按下事件
                        String szvalue = temp1.getText().toString();
                        SharedPreferences.Editor editor=Common.ModeConfig.edit();
                        editor.putString("temp1",szvalue);
                        editor.commit();
                    }
                }
                return false;
            }

        });

        temp1.setOnTouchListener(new View.OnTouchListener() {

            //  @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    temp1.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });


        temp2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 监听到回车键，按下与松开
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        //按下事件
                        String szvalue = temp2.getText().toString();
                        SharedPreferences.Editor editor=Common.ModeConfig.edit();
                        editor.putString("temp2",szvalue);
                        editor.commit();
                    }
                }
                return false;
            }

        });

        temp2.setOnTouchListener(new View.OnTouchListener() {

            //  @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    temp2.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });
        temp3.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 监听到回车键，按下与松开
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        //按下事件
                        String szvalue = temp3.getText().toString();
                        SharedPreferences.Editor editor=Common.ModeConfig.edit();
                        editor.putString("temp3",szvalue);
                        editor.commit();
                    }
                }
                return false;
            }

        });

        temp3.setOnTouchListener(new View.OnTouchListener() {

            //  @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    temp3.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });
        temp4.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 监听到回车键，按下与松开
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        //按下事件
                        String szvalue = temp4.getText().toString();
                        SharedPreferences.Editor editor=Common.ModeConfig.edit();
                        editor.putString("temp4",szvalue);
                        editor.commit();
                    }
                }
                return false;
            }

        });

        temp4.setOnTouchListener(new View.OnTouchListener() {

            //  @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    temp4.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });
        temp5.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 监听到回车键，按下与松开
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        //按下事件
                        String szvalue = temp5.getText().toString();
                        SharedPreferences.Editor editor=Common.ModeConfig.edit();
                        editor.putString("temp5",szvalue);
                        editor.commit();
                    }
                }
                return false;
            }

        });

        temp5.setOnTouchListener(new View.OnTouchListener() {

            //  @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    temp5.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });
        temp6.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 监听到回车键，按下与松开
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        //按下事件
                        String szvalue = temp6.getText().toString();
                        SharedPreferences.Editor editor=Common.ModeConfig.edit();
                        editor.putString("temp6",szvalue);
                        editor.commit();
                    }
                }
                return false;
            }

        });

        temp6.setOnTouchListener(new View.OnTouchListener() {

            //  @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    temp6.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });
        temp7.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 监听到回车键，按下与松开
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        //按下事件
                        String szvalue = temp7.getText().toString();
                        SharedPreferences.Editor editor=Common.ModeConfig.edit();
                        editor.putString("temp7",szvalue);
                        editor.commit();
                    }
                }
                return false;
            }

        });

        temp7.setOnTouchListener(new View.OnTouchListener() {

            //  @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    temp7.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });
        temp8.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 监听到回车键，按下与松开
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        //按下事件
                        String szvalue = temp8.getText().toString();
                        SharedPreferences.Editor editor=Common.ModeConfig.edit();
                        editor.putString("temp8",szvalue);
                        editor.commit();
                    }
                }
                return false;
            }

        });

        temp8.setOnTouchListener(new View.OnTouchListener() {

            //  @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    temp8.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });
        temp9.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 监听到回车键，按下与松开
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        //按下事件
                        String szvalue = temp9.getText().toString();
                        SharedPreferences.Editor editor=Common.ModeConfig.edit();
                        editor.putString("temp9",szvalue);
                        editor.commit();
                    }
                }
                return false;
            }

        });

        temp9.setOnTouchListener(new View.OnTouchListener() {

            //  @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    temp9.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });
        temp10.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 监听到回车键，按下与松开
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        //按下事件
                        String szvalue = temp10.getText().toString();
                        SharedPreferences.Editor editor=Common.ModeConfig.edit();
                        editor.putString("temp10",szvalue);
                        editor.commit();
                    }
                }
                return false;
            }

        });

        temp10.setOnTouchListener(new View.OnTouchListener() {

            //  @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    temp10.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });
        temp11.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 监听到回车键，按下与松开
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        //按下事件
                        String szvalue = temp11.getText().toString();
                        SharedPreferences.Editor editor=Common.ModeConfig.edit();
                        editor.putString("temp11",szvalue);
                        editor.commit();
                    }
                }
                return false;
            }

        });

        temp11.setOnTouchListener(new View.OnTouchListener() {

            //  @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    temp11.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });
        temp12.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 监听到回车键，按下与松开
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        //按下事件
                        String szvalue = temp12.getText().toString();
                        SharedPreferences.Editor editor=Common.ModeConfig.edit();
                        editor.putString("temp12",szvalue);
                        editor.commit();
                    }
                }
                return false;
            }

        });

        temp12.setOnTouchListener(new View.OnTouchListener() {

            //  @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    temp12.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });

        rpm1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 监听到回车键，按下与松开
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        //按下事件
                        String szvalue = rpm1.getText().toString();
                        SharedPreferences.Editor editor=Common.ModeConfig.edit();
                        editor.putString("rpm1",szvalue);
                        editor.commit();
                    }
                }
                return false;
            }

        });

        rpm1.setOnTouchListener(new View.OnTouchListener() {

            //  @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    rpm1.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });

        rpm2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 监听到回车键，按下与松开
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        //按下事件
                        String szvalue = rpm2.getText().toString();
                        SharedPreferences.Editor editor=Common.ModeConfig.edit();
                        editor.putString("rpm2",szvalue);
                        editor.commit();
                    }
                }
                return false;
            }

        });

        rpm2.setOnTouchListener(new View.OnTouchListener() {

            //  @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    rpm2.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });

        rpm3.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 监听到回车键，按下与松开
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        //按下事件
                        String szvalue = rpm3.getText().toString();
                        SharedPreferences.Editor editor=Common.ModeConfig.edit();
                        editor.putString("rpm3",szvalue);
                        editor.commit();
                    }
                }
                return false;
            }

        });

        rpm3.setOnTouchListener(new View.OnTouchListener() {

            //  @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    rpm3.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });

        rpm4.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 监听到回车键，按下与松开
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        //按下事件
                        String szvalue = rpm4.getText().toString();
                        SharedPreferences.Editor editor=Common.ModeConfig.edit();
                        editor.putString("rpm4",szvalue);
                        editor.commit();
                    }
                }
                return false;
            }

        });

        rpm4.setOnTouchListener(new View.OnTouchListener() {

            //  @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    rpm4.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });

        rpm5.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 监听到回车键，按下与松开
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        //按下事件
                        String szvalue = rpm5.getText().toString();
                        SharedPreferences.Editor editor=Common.ModeConfig.edit();
                        editor.putString("rpm5",szvalue);
                        editor.commit();
                    }
                }
                return false;
            }

        });

        rpm5.setOnTouchListener(new View.OnTouchListener() {

            //  @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    rpm5.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });

        rpm6.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 监听到回车键，按下与松开
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        //按下事件
                        String szvalue = rpm6.getText().toString();
                        SharedPreferences.Editor editor=Common.ModeConfig.edit();
                        editor.putString("rpm6",szvalue);
                        editor.commit();
                    }
                }
                return false;
            }

        });

        rpm6.setOnTouchListener(new View.OnTouchListener() {

            //  @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    rpm6.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });

        rpm7.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 监听到回车键，按下与松开
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        //按下事件
                        String szvalue = rpm7.getText().toString();
                        SharedPreferences.Editor editor=Common.ModeConfig.edit();
                        editor.putString("rpm7",szvalue);
                        editor.commit();
                    }
                }
                return false;
            }

        });

        rpm7.setOnTouchListener(new View.OnTouchListener() {

            //  @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    rpm7.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });

        rpm8.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 监听到回车键，按下与松开
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        //按下事件
                        String szvalue = rpm8.getText().toString();
                        SharedPreferences.Editor editor=Common.ModeConfig.edit();
                        editor.putString("rpm8",szvalue);
                        editor.commit();
                    }
                }
                return false;
            }

        });

        rpm8.setOnTouchListener(new View.OnTouchListener() {

            //  @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    rpm8.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });

        rpm9.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 监听到回车键，按下与松开
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        //按下事件
                        String szvalue = rpm9.getText().toString();
                        SharedPreferences.Editor editor=Common.ModeConfig.edit();
                        editor.putString("rpm9",szvalue);
                        editor.commit();
                    }
                }
                return false;
            }

        });

        rpm9.setOnTouchListener(new View.OnTouchListener() {

            //  @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    rpm9.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });

        rpm10.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 监听到回车键，按下与松开
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        //按下事件
                        String szvalue = rpm10.getText().toString();
                        SharedPreferences.Editor editor=Common.ModeConfig.edit();
                        editor.putString("rpm10",szvalue);
                        editor.commit();
                    }
                }
                return false;
            }

        });

        rpm10.setOnTouchListener(new View.OnTouchListener() {

            //  @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    rpm10.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });

        rpm11.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 监听到回车键，按下与松开
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        //按下事件
                        String szvalue = rpm11.getText().toString();
                        SharedPreferences.Editor editor=Common.ModeConfig.edit();
                        editor.putString("rpm11",szvalue);
                        editor.commit();
                    }
                }
                return false;
            }

        });

        rpm11.setOnTouchListener(new View.OnTouchListener() {

            //  @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    rpm11.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });

        rpm12.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 监听到回车键，按下与松开
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        //按下事件
                        String szvalue = rpm12.getText().toString();
                        SharedPreferences.Editor editor=Common.ModeConfig.edit();
                        editor.putString("rpm12",szvalue);
                        editor.commit();
                    }
                }
                return false;
            }

        });

        rpm12.setOnTouchListener(new View.OnTouchListener() {

            //  @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    rpm12.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });





    }

    View.OnClickListener onclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_return) {
                Intent in = getIntent();
                //设置返回结果成功
                setResult(RESULT_OK, in);
                //关闭当前activity
                finish();
            }
        }
    };




}
