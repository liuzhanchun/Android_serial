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
/**
 * Created by Administrator on 2019\1\4 0004.
 */

public class SetConfigPara extends Activity {

    Button btn_return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.setconfigpara);
        super.onCreate(savedInstanceState);

        btn_return = (Button) findViewById(R.id.btn_return);

        btn_return.setOnClickListener(onclick);


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
        }
    };
}

