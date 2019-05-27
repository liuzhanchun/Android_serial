package com.example.administrator.serial;

import android.app.Activity;
import android.content.Context;
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
import android.widget.Toast;

/**
 * Created by Administrator on 2019\1\4 0004.
 */

public class Resetpwd extends Activity {

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
        setContentView(R.layout.resetpwd);
        super.onCreate(savedInstanceState);

        btn_return = (Button) findViewById(R.id.btn_return);
        btn_return.setOnClickListener(onclick);

        btn_user = (Button) findViewById(R.id.btn_user);
        btn_user.setOnClickListener(onclick);

        id_login=(EditText) findViewById(R.id.login_id);
        password_login=(EditText) findViewById(R.id.login_password);
        old_password_login =(EditText) findViewById(R.id.login_old_password);

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
                old_password_login.getPaint().setFlags(0);
                oldpasswordvalue=old_password_login.getText().toString();

                String usernum=Common.sharesys.getString("usernum","");
                if (usernum.length() == 0)
                {
                  //  Toast.makeText(Resetpwd.this, "111", Toast.LENGTH_SHORT).show();
                    Intent in1 = getIntent();
                    //设置返回结果失败
                    setResult(RESULT_CANCELED, in1);
                    //关闭当前activity
                    finish();
                }
                else
                {
                    int nUserum = Integer.valueOf(usernum).intValue();
                    for(int num =0;num<nUserum;num++)
                    {
                        String user  = "user"+String.valueOf(num);
                        String password = "password"+String.valueOf(num);


                        if ((idvalue.equals( Common.sharesys.getString(user,"")))&&(oldpasswordvalue.equals( Common.sharesys.getString(password,"")))&&(!passwordvalue.equals("")))
                        {

                            SharedPreferences.Editor editor=Common.sharesys.edit();
                            // editor.putString("PHONEEDIT",idvalue);
                            editor.putString(password,passwordvalue);
                            editor.commit();
                            Intent in = getIntent();
                            //设置返回结果成功
                            setResult(RESULT_OK, in);
                            //关闭当前activity
                            finish();
                        }
                    }
                  //  Toast.makeText(Resetpwd.this, "444", Toast.LENGTH_SHORT).show();
                    Intent in = getIntent();
                    //设置返回结果失败
                    setResult(RESULT_CANCELED, in);
                    //关闭当前activity
                    finish();

                }
//                if ((oldpasswordvalue.equals( Common.sharesys.getString("PASSWORD","")))&&(!passwordvalue.equals(""))&&(!idvalue.equals("")))
//                {
//
//                    SharedPreferences.Editor editor=Common.sharesys.edit();
//                    editor.putString("PHONEEDIT",idvalue);
//                    editor.putString("PASSWORD",passwordvalue);
//                    editor.commit();
//                    Intent in = getIntent();
//                    //设置返回结果成功
//                    setResult(RESULT_OK, in);
//                    //关闭当前activity
//                    finish();
//                }
//                else
//                {
//                    Intent in = getIntent();
//                    //设置返回结果失败
//                    setResult(RESULT_CANCELED, in);
//                    //关闭当前activity
//                    finish();
//                }



            }
        }
    };
}

