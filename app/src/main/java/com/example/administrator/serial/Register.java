package com.example.administrator.serial;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


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
 * Created by Administrator on 2019\1\4 0004.
 */

public class Register extends Activity {

    Button btn_return;
    Button btn_user;
    private EditText id_login;
    private EditText password_login;
    private String idvalue;
    private String passwordvalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.register);
        super.onCreate(savedInstanceState);

        btn_return = (Button) findViewById(R.id.btn_return);
        btn_return.setOnClickListener(onclick);

        btn_user = (Button) findViewById(R.id.btn_user);
        btn_user.setOnClickListener(onclick);

        id_login=(EditText) findViewById(R.id.login_id);
        password_login=(EditText) findViewById(R.id.login_password);
    }

    View.OnClickListener onclick = new View.OnClickListener() {
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

                if ((!passwordvalue.equals(""))&&(!idvalue.equals("")))
                {
                    String usernum=Common.sharesys.getString("usernum","");
                    if (usernum.length() == 0)
                    {
                        String user  = "user"+String.valueOf(0);
                        String password = "password"+String.valueOf(0);

                        SharedPreferences.Editor editor=Common.sharesys.edit();
                        editor.putString(user,idvalue);
                        editor.putString(password,passwordvalue);
                        editor.putString("usernum","1");
                        editor.commit();
                    }
                    else
                    {
                        int nUserum = Integer.valueOf(usernum).intValue();
                        nUserum = nUserum+1;

                        String user  = "user"+String.valueOf(nUserum);
                        String password = "password"+String.valueOf(nUserum);

                        SharedPreferences.Editor editor=Common.sharesys.edit();
                        editor.putString(user,idvalue);
                        editor.putString(password,passwordvalue);
                        editor.putString("usernum",String.valueOf(nUserum));
                        editor.commit();
                    }

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

