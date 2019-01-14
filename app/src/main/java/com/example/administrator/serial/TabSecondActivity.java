package com.example.administrator.serial;
import android.app.Activity;
import android.os.Bundle;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import com.example.x6.serial.SerialPort;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.administrator.serial.Common;
import android.view.View.OnKeyListener;
import android.view.KeyEvent;
import android.os.Handler;
import android.os.Message;
import android.widget.Chronometer;
import android.os.SystemClock;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.view.View.OnClickListener;
import android.widget.ImageView;

/**
 * Created by Administrator on 2018-10-09.
 */

/**
 * Created by ouyangshen on 2016/10/21.
 */


public class TabSecondActivity extends Activity
        implements CompoundButton.OnCheckedChangeListener,OnClickListener{
    //定时器
    private Chronometer timer;
    //串口
    private boolean ttySispool = true;
    private final String recvbyte = "recvbyte";
    private final String recvsize = "recvsize";
    private final int IttyS2recv = 1;
    private int ttyS2recvSize = 0;
    private final String ttyS = "/dev/ttyS2";
    private final int baudrate = 9600;
    private InputStream ttySInputStream;
    private OutputStream ttySOutputStream;
    private SerialPort serialttyS = null;

    //ui控件
    private CheckBox ck_temp;
    private CheckBox ck_mix;
    private CheckBox ck_pump;
    private CheckBox ck_time;
    private Button btn_temp_sub;
    private TextView tv_temp;
    private Button btn_temp_add;
    private Button btn_mix_sub;
    private TextView tv_mix;
    private Button btn_mix_add;
    private Button btn_pump_sub;
    private TextView tv_pump;
    private Button btn_pump_add;
    private Button btn_rise;
    private Button btn_pause;
    private Button btn_drop;
    private TextView tv_temp_value;
    private TextView tv_mix_value;
    private TextView tv_sys_time;
    private TextView tv_platform_value;

    private ImageView img_mix;
    private ImageView img_temp;
    private ImageView img_platform;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tab_second);

        ck_temp = (CheckBox) findViewById(R.id.ck_temp);
        ck_temp.setOnCheckedChangeListener(this);
        ck_mix = (CheckBox) findViewById(R.id.ck_mix);
        ck_mix.setOnCheckedChangeListener(this);
        ck_pump = (CheckBox) findViewById(R.id.ck_pump);
        ck_pump.setOnCheckedChangeListener(this);
        ck_time = (CheckBox) findViewById(R.id.ck_time);
        ck_time.setOnCheckedChangeListener(this);

        findViewById(R.id.btn_temp_sub).setOnClickListener(this);
        tv_temp = (TextView)  findViewById(R.id.tv_temp);
        findViewById(R.id.btn_temp_add).setOnClickListener(this);

        findViewById(R.id.btn_mix_sub).setOnClickListener(this);
        tv_mix = (TextView)  findViewById(R.id.tv_mix);
        findViewById(R.id.btn_mix_add).setOnClickListener(this);

//        findViewById(R.id.btn_pump_sub).setOnClickListener(this);
//        tv_pump = (TextView)  findViewById(R.id.tv_pump);
//        findViewById(R.id.btn_pump_add).setOnClickListener(this);

        findViewById(R.id.btn_rise).setOnClickListener(this);
        findViewById(R.id.btn_puase).setOnClickListener(this);
        findViewById(R.id.btn_drop).setOnClickListener(this);

        tv_platform_value=(TextView)  findViewById(R.id.tv_platform_value);;
        tv_temp_value=(TextView)  findViewById(R.id.tv_temp_value);
        tv_mix_value=(TextView)  findViewById(R.id.tv_mix_value);
        tv_sys_time=(TextView)  findViewById(R.id.tv_sys_time);
        tv_pump =(TextView)  findViewById(R.id.tv_pump);
        img_temp=(ImageView)  findViewById(R.id.img_temp);
        img_mix=(ImageView)  findViewById(R.id.img_mix);
        img_platform=(ImageView)  findViewById(R.id.img_platform);

        SimpleDateFormat sDateFormat = new    SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String  date = sDateFormat.format(new java.util.Date());
        tv_sys_time.setText(date);


        try {
            serialttyS = new SerialPort(new File(ttyS), baudrate, 0);
            ttySInputStream = serialttyS.getInputStream();
            ttySOutputStream = serialttyS.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InitView();
   //     refreshResult();
        run();
    }

    public  void InitView()
    {
        byte []lrc= Common.LRC_Calculate( Common.cmdinquiry_temp);
        ttyS3send(Common.cmdinquiry_temp);
        ttyS3send(lrc);
        ttyS3send(Common.cmdsend_enter);

        my_sleep(50);
        lrc= Common.LRC_Calculate( Common.cmdinit_temp);
        ttyS3send(Common.cmdinit_temp);
        ttyS3send(lrc);
        ttyS3send(Common.cmdsend_enter);

        my_sleep(50);
        lrc= Common.LRC_Calculate( Common.cmdinit_mix);
        ttyS3send(Common.cmdinit_mix);
        ttyS3send(lrc);
        ttyS3send(Common.cmdsend_enter);
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        refreshResult( buttonView);
    }
    private void refreshResult(CompoundButton buttonView) {
        if(buttonView == ck_temp)
        {
            if (ck_temp.isChecked()) {
                if (ck_pump.isChecked()) {
                    ck_temp.setText("关闭");
                    ck_temp.setPadding(10, 0, 0, 0);
                    byte[] lrc = Common.LRC_Calculate(Common.cmdsend_tempon);
                    ttyS3send(Common.cmdsend_tempon);
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);
                }
                else
                {
                    ck_temp.setChecked(false);
                    Toast.makeText(TabSecondActivity.this, "请先开水泵，一分钟后再加热！", Toast.LENGTH_SHORT).show();
                }


            }
            else {
                ck_temp.setText("加热");
                ck_temp.setPadding(60,0,0,0);
                byte []lrc= Common.LRC_Calculate( Common.cmdsend_tempoff);
                ttyS3send(Common.cmdsend_tempoff);
                ttyS3send(lrc);
                ttyS3send(Common.cmdsend_enter);
            }
        }
        if(buttonView == ck_mix) {
            if (ck_mix.isChecked()) {
                ck_mix.setText("关闭");
                ck_mix.setPadding(10, 0, 0, 0);
                byte []lrc= Common.LRC_Calculate( Common.cmdsend_mixon);
                ttyS3send(Common.cmdsend_mixon);
                ttyS3send(lrc);
                ttyS3send(Common.cmdsend_enter);
            } else {
                ck_mix.setText("转动");
                ck_mix.setPadding(60, 0, 0, 0);
                byte []lrc= Common.LRC_Calculate( Common.cmdsend_mixoff);
                ttyS3send(Common.cmdsend_mixoff);
                ttyS3send(lrc);
                ttyS3send(Common.cmdsend_enter);
            }
        }
        if(buttonView == ck_pump) {

            if (ck_pump.isChecked()) {
                ck_pump.setText("关闭");
                ck_pump.setPadding(10, 0, 0, 0);
                tv_pump.setText("20");
                byte[] lrc = Common.LRC_Calculate(Common.cmdsend_pumpon);
                ttyS3send(Common.cmdsend_pumpon);
                ttyS3send(lrc);
                ttyS3send(Common.cmdsend_enter);
            } else {
                ck_pump.setText("启动");
                ck_pump.setPadding(60, 0, 0, 0);
                tv_pump.setText("0");
                byte[] lrc = Common.LRC_Calculate(Common.cmdsend_pumpoff);
                ttyS3send(Common.cmdsend_pumpoff);
                ttyS3send(lrc);
                ttyS3send(Common.cmdsend_enter);
            }
        }
        if(buttonView == ck_time) {
            if (ck_time.isChecked()) {
                ck_time.setText("停止");
                ck_time.setPadding(10, 0, 0, 0);
                timer = (Chronometer) findViewById(R.id.timer);
                timer.setBase(SystemClock.elapsedRealtime());//计时器清零
                int hour = (int) ((SystemClock.elapsedRealtime() - timer.getBase()) / 1000 / 60);
                timer.setFormat("0" + String.valueOf(hour) + ":%s");
                timer.start();
            } else {
                ck_time.setText("计时");
                ck_time.setPadding(60, 0, 0, 0);
                timer = (Chronometer) findViewById(R.id.timer);
                timer.stop();
            }
        }
    //  Toast.makeText(TabSecondActivity.this, result, Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onClick(View v) {
        String szvalue;

        if (v.getId() == R.id.btn_temp_sub) {
            java.text.DecimalFormat myformat=new java.text.DecimalFormat("00.0");
            szvalue = tv_temp.getText().toString();
            float fvalue =((Float.parseFloat(szvalue))-(0.1f));
            tv_temp.setText( myformat.format(fvalue));
            szvalue = myformat.format(fvalue);
            szvalue = szvalue.replace(".","");

            byte []lrc= Common.LRC_Calculate( Common.byteMerger(Common.cmdsend_temp,szvalue.getBytes()));
            ttyS3send(Common.byteMerger(Common.cmdsend_temp,szvalue.getBytes()));
            ttyS3send(lrc);
            ttyS3send(Common.cmdsend_enter);
            // Toast.makeText(TabSecondActivity.this, tv_temp.getText().toString(), Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.btn_temp_add) {
            java.text.DecimalFormat myformat=new java.text.DecimalFormat("00.0");
            szvalue = tv_temp.getText().toString();
            float fvalue =((Float.parseFloat(szvalue))+(0.1f));
            tv_temp.setText( myformat.format(fvalue));
            szvalue = myformat.format(fvalue);
            szvalue = szvalue.replace(".","");
            byte []lrc= Common.LRC_Calculate( Common.byteMerger(Common.cmdsend_temp,szvalue.getBytes()));
            ttyS3send(Common.byteMerger(Common.cmdsend_temp,szvalue.getBytes()));
            ttyS3send(lrc);
            ttyS3send(Common.cmdsend_enter);
            // Toast.makeText(TabSecondActivity.this, tv_temp.getText().toString(), Toast.LENGTH_SHORT).show();
        }

        if (v.getId() == R.id.btn_mix_sub) {
            java.text.DecimalFormat myformat=new java.text.DecimalFormat("000.0");
            szvalue = tv_mix.getText().toString();
            float fvalue =((Float.parseFloat(szvalue))-(1.0f));
            tv_mix.setText( myformat.format(fvalue));
            szvalue = myformat.format(fvalue);
            szvalue = szvalue.replace(".","");
            byte []lrc= Common.LRC_Calculate( Common.byteMerger(Common.cmdsend_speed,szvalue.getBytes()));
            ttyS3send(Common.byteMerger(Common.cmdsend_speed,szvalue.getBytes()));
            ttyS3send(lrc);
            ttyS3send(Common.cmdsend_enter);
            // Toast.makeText(TabSecondActivity.this, tv_temp.getText().toString(), Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.btn_mix_add) {

            java.text.DecimalFormat myformat=new java.text.DecimalFormat("000.0");
            szvalue = tv_mix.getText().toString();
            float fvalue =((Float.parseFloat(szvalue))+(1.0f));
            tv_mix.setText( myformat.format(fvalue));
            szvalue = myformat.format(fvalue);
            szvalue = szvalue.replace(".","");
            byte []lrc= Common.LRC_Calculate( Common.byteMerger(Common.cmdsend_speed,szvalue.getBytes()));
            ttyS3send(Common.byteMerger(Common.cmdsend_speed,szvalue.getBytes()));
            ttyS3send(lrc);
            ttyS3send(Common.cmdsend_enter);

            // Toast.makeText(TabSecondActivity.this, tv_temp.getText().toString(), Toast.LENGTH_SHORT).show();
        }
//        if (v.getId() == R.id.btn_pump_sub) {
//
//            szvalue = tv_pump.getText().toString();
//            int nvalue =(Integer.parseInt(szvalue)-1);
//            tv_pump.setText( String.valueOf(nvalue));
//            szvalue = szvalue.replace(".","");
//            ///   szvalue.getBytes();
//
//            // Toast.makeText(TabSecondActivity.this, tv_temp.getText().toString(), Toast.LENGTH_SHORT).show();
//        }
//        if (v.getId() == R.id.btn_pump_add) {
//
//            szvalue = tv_pump.getText().toString();
//            int nvalue =(Integer.parseInt(szvalue)+1);
//            tv_pump.setText( String.valueOf(nvalue));
//            szvalue = szvalue.replace(".","");
//            ///   szvalue.getBytes();
//            ///   szvalue.getBytes();
//
//            // Toast.makeText(TabSecondActivity.this, tv_temp.getText().toString(), Toast.LENGTH_SHORT).show();
//        }
        if (v.getId() == R.id.btn_rise) {
            byte []lrc= Common.LRC_Calculate( Common.cmdsend_rise);
            ttyS3send(Common.cmdsend_rise);
            ttyS3send(lrc);
            ttyS3send(Common.cmdsend_enter);
            my_sleep(50);
            ck_mix.setChecked(false);


          //   Toast.makeText(TabSecondActivity.this, "rise", Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.btn_puase) {

            byte []lrc= Common.LRC_Calculate( Common.cmdsend_stop);
            ttyS3send(Common.cmdsend_stop);
            ttyS3send(lrc);
            ttyS3send(Common.cmdsend_enter);
          //   Toast.makeText(TabSecondActivity.this, "puase", Toast.LENGTH_SHORT).show();
        }
        if (v.getId() == R.id.btn_drop) {
            byte []lrc= Common.LRC_Calculate( Common.cmdsend_drop);
            ttyS3send(Common.cmdsend_drop);
            ttyS3send(lrc);
            ttyS3send(Common.cmdsend_enter);
      //      Toast.makeText(TabSecondActivity.this, "drop".toString(), Toast.LENGTH_SHORT).show();
            my_sleep(50);
            ck_mix.setChecked(false);

        }
    }

    private void ttyS3send(byte[] sendcmd) {
        try {
            ttySOutputStream.write(sendcmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 串口接受
     */
    private void run() {
        new Thread() {
            @Override
            public void run() {
                while (ttySispool) {
                    int size;
                    byte[] recvbyte = new byte[1024];
                    if (ttySInputStream == null)
                        return;
                    try {

                        size = ttySInputStream.read(recvbyte);
                        if (size > 0)
                            syncrecv(size, recvbyte, IttyS2recv);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }.start();
    }
    private void syncrecv(int size, byte[] rbyte, int msgw) {
        int bytesize = size;
        Bundle bundle = new Bundle();
        Message message = new Message();
        bundle.putByteArray(recvbyte, rbyte);
        bundle.putInt(recvsize, bytesize);
        message.setData(bundle);
        message.what = msgw;
        handler.sendMessage(message);
    }
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {

                case IttyS2recv:
                    syncView(msg, IttyS2recv);
                    break;
            }
        }
    };
    private void syncView(Message msg, int keyI) {
        java.text.DecimalFormat myformat=new java.text.DecimalFormat("0.0");
        Bundle bundle = null;
        byte[] receivebyte = new byte[100];
        bundle = msg.getData();

        ttyS2recvSize = bundle.getInt(recvsize);
        receivebyte = bundle.getByteArray(recvbyte);
        if ((receivebyte[0] == 0x3a) && (receivebyte[1] == 0x30) && (receivebyte[2] == 0x32) && (receivebyte[3] == 0x30) && (receivebyte[4] == 0x35)) {
            //温度回传
            int temp = (receivebyte[5] - 0x30) * 100 + (receivebyte[6] - 0x30) * 10 + (receivebyte[7] - 0x30);
            float f_temp = ((float) temp)/10.0f;
            tv_temp_value.setText( myformat.format(f_temp));
            img_temp.setImageDrawable(getResources().getDrawable(R.drawable.point_green));
        }
        if ((receivebyte[0] == 0x3a) && (receivebyte[1] == 0x30) && (receivebyte[2] == 0x32) && (receivebyte[3] == 0x30) && (receivebyte[4] == 0x33)) {
            //转速回传  应改成占四位 目前0到99
            int speed = (receivebyte[5] - 0x30) * 10 + (receivebyte[6] - 0x30);
           // speed = speed / 100;
            tv_mix_value.setText( String.valueOf(speed));
            img_mix.setImageDrawable(getResources().getDrawable(R.drawable.point_green));

        }
        if ((receivebyte[0] == 0x3a) && (receivebyte[1] == 0x30) && (receivebyte[2] == 0x32) && (receivebyte[3] == 0x30) && (receivebyte[4] == 0x37)) {
            //工作台高度回传
            int high = (receivebyte[5] - 0x30) * 10 + (receivebyte[6] - 0x30);
            tv_platform_value.setText( String.valueOf(high));
            img_platform.setImageDrawable(getResources().getDrawable(R.drawable.point_green));
        }

    }
    public  void my_sleep(int count)
    {
        try {
            Thread.currentThread().sleep(count);//阻断2秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
