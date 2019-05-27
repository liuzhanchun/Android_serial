package com.example.administrator.serial;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
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
 * Created by 15522 on 2019/4/18.
 */

public class lockscreen extends Activity {

    private  Button login_button;
    private EditText login_id;
    private EditText login_password;
    private String idvalue;
    private String passwordvalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.lockscrreen);
        super.onCreate(savedInstanceState);

        login_button = (Button) findViewById(R.id.login_button);
        login_button.setOnClickListener(onclick);

        login_id=(EditText) findViewById(R.id.login_id);
        login_password=(EditText) findViewById(R.id.login_password);

        login_id.setText(Common.g_idvalue);
    }

    View.OnClickListener onclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (v.getId() == R.id.login_button)
            {
            //    login_id.getPaint().setFlags(0);
              //  idvalue=login_id.getText().toString();

                login_password.getPaint().setFlags(0);
                passwordvalue=login_password.getText().toString();

                if (passwordvalue.equals(Common.g_passwordvalue))
                {
                    onBackPressed();

                }
            }
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();//注销该方法，相当于重写父类这个方法
    }

}
