package com.example.administrator.serial;

/**
 * Created by Administrator on 2018-10-09.
 */
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import  java.text.SimpleDateFormat;

public class TabFirstActivity extends AppCompatActivity {

    private LinearLayout mainLinerLayout;
    private RelativeLayout relativeLayout;
    private String[] name = {"1","2","3","4","5","6","7"};
    @Override protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tab_first);
        mainLinerLayout = (LinearLayout)this.findViewById(R.id.MyTable);
        initData();
    }


    private void initData() {

        int number = 1;
        for (int i = 0; i < 100; i++) {
            relativeLayout = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.table, null);
            MyTableTextView txt = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_1);
            SimpleDateFormat sDateFormat = new    SimpleDateFormat("yyyy-MM-dd    hh:mm:ss");
            String  date = sDateFormat.format(new java.util.Date());
            txt.setText(date);

            txt = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_2);
            txt.setText("50");

            txt = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_3);
            txt.setText("37.5");

            txt = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_4);
            txt.setText("0:10:20");

            txt = (MyTableTextView) relativeLayout.findViewById(R.id.list_1_5);
            txt.setText("正常");
            mainLinerLayout.addView(relativeLayout);
            number++;
        }
    }

}

