package com.example.administrator.serial;
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
 * Created by Administrator on 2019\1\4 0004.
 */

public class user extends Activity {

    Button btn_return;
    Button btn_user;
    private EditText id_login;
    private EditText password_login;
    private EditText old_password_login;
    private String idvalue;
    private String passwordvalue;
    private String oldpasswordvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.user);
        super.onCreate(savedInstanceState);

        btn_return = (Button) findViewById(R.id.btn_return);
        btn_return.setOnClickListener(onclick);

        btn_user = (Button) findViewById(R.id.btn_user);
        btn_user.setOnClickListener(onclick);

        id_login=(EditText) findViewById(R.id.login_id);
        password_login=(EditText) findViewById(R.id.login_password);
        old_password_login =(EditText) findViewById(R.id.login_old_password);
    }

    OnClickListener onclick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_return)
            {
                Intent in = getIntent();
                //设置返回结果成功
                setResult(RESULT_OK, in);
                //关闭当前activity
                finish();
            }

            if (v.getId() == R.id.btn_user)
            {
                id_login.getPaint().setFlags(0);
                idvalue=id_login.getText().toString();
                password_login.getPaint().setFlags(0);
                passwordvalue=password_login.getText().toString();
                old_password_login.getPaint().setFlags(0);
                oldpasswordvalue=old_password_login.getText().toString();
                if ((oldpasswordvalue.equals( Common.sharesys.getString("PASSWORD","")))&&(!passwordvalue.equals(""))&&(!idvalue.equals("")))
                {

                    SharedPreferences.Editor editor=Common.sharesys.edit();
                    editor.putString("PHONEEDIT",idvalue);
                    editor.putString("PASSWORD",passwordvalue);
                    editor.commit();
                    Intent in = getIntent();
                    //设置返回结果成功
                    setResult(RESULT_OK, in);
                    //关闭当前activity
                    finish();
                }
                else
                {
                    Intent in = getIntent();
                    //设置返回结果失败
                    setResult(RESULT_CANCELED, in);
                    //关闭当前activity
                    finish();
                }
            }
        }
    };
}

