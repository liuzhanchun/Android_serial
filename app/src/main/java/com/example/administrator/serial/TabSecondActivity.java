package com.example.administrator.serial;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import android.os.Bundle;
import android.os.Environment;
import android.text.InputType;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.app.ProgressDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.TimePicker;
import java.util.Calendar;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.widget.Toast;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.widget.EditText;
import android.content.Intent;

import com.example.administrator.serial.util.DateUtil;
import com.example.administrator.serial.util.FileUtil;
import com.example.x6.serial.SerialPort;
import java.util.Arrays;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

/**
 * Created by Administrator on 2018-10-09.
 */

/**
 * Created by ouyangshen on 2016/10/21.
 */


public class TabSecondActivity extends Activity
      implements OnDateSetListener,OnTimeSetListener{

    private Anticlockwise mTimer;
    private SystemDateTime mSystemTime;
    boolean mIsSystemSet = false;
    int mTiming = 10;
    final static int REQUEST=10;
    //串口
    private boolean ttySispool = true;
    private final String recvbyte = "recvbyte";
    private final String recvsize = "recvsize";
    private final int IttyS2recv = 1;
    private int ttyS2recvSize = 0;
    private final String ttyS = "/dev/ttyS0";
    private final int baudrate = 19200;
    private InputStream ttySInputStream;
    private OutputStream ttySOutputStream;
    private SerialPort serialttyS = null;

    private final String ttyS_print = "/dev/ttyS1";
    private final int baudrate_print = 9600;
    private InputStream ttySInputStream_print;
    private OutputStream ttySOutputStream_print;
    private SerialPort serialttyS_print = null;



    //ui控件
    private TextView tv_date;
    private TextView tv_time;
    private TextView tv_temp;
   // private TextView tv_pump;
    private TextView tv_mix;
    private TextView tv_temp_value;
    private TextView  tv_mix_value;
    private TextView  tv_paplatform;
    private ImageView img_temp;
    private ImageView img_mix;
    private ImageView img_platform;
    private LinearLayout frameSwitch;
    private TextView tv_sys_time;
    private TextView tv_sys_user;
    private CheckBox ck_pump;
    private CheckBox ck_temp;
    private CheckBox ck_positive_inversion;
    private CheckBox ck_reverse;
    private CheckBox ck_mix;
    private CheckBox ck_time;
    private CheckBox ck_mode1;
    private CheckBox ck_mode2;
    private CheckBox ck_mode3;
    private CheckBox ck_mode4;
    private CheckBox ck_mode5;
    private CheckBox ck_mode6;
    private CheckBox ck_mode7;
    private CheckBox ck_mode8;
    private CheckBox ck_mode9;
    private CheckBox ck_mode10;
    private CheckBox ck_mode11;
    private CheckBox ck_mode12;

    private Button btn_heat_time;
    private LinearLayout mainLinerLayout;
    private RelativeLayout relativeLayout;
    private String[] name = {"1","2","3","4","5","6","7"};
    private Button btn_shutdown;
    private Button btn_lockscreen;
    private Button btn_rise;
    private Button btn_puase;
    private Button btn_drop;

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

    private TextView pump1;
    private TextView pump2;
    private TextView pump3;
    private TextView pump4;
    private TextView pump5;
    private TextView pump6;
    private TextView pump7;
    private TextView pump8;
    private TextView pump9;
    private TextView pump10;
    private TextView pump11;
    private TextView pump12;

    private TextView trun1;
    private TextView trun2;
    private TextView trun3;
    private TextView trun4;
    private TextView trun5;
    private TextView trun6;
    private TextView trun7;
    private TextView trun8;
    private TextView trun9;
    private TextView trun10;
    private TextView trun11;
    private TextView trun12;

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

    private static String udisk_path = "/storage/usbhost1/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tab_second);



        Window _window;

        _window = getWindow();

        WindowManager.LayoutParams params = _window.getAttributes();

        params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_IMMERSIVE;

        _window.setAttributes(params);

     //   hideBottomUIMenu();

        tv_sys_user = (TextView)findViewById(R.id.tv_sys_user);

        tv_sys_user.setText("用户："+Common.g_idvalue);

        tv_temp_value=(TextView)  findViewById(R.id.tv_temp_value);
        img_temp=(ImageView)  findViewById(R.id.img_temp);
        tv_mix_value=(TextView)  findViewById(R.id.tv_mix_value);
        img_mix=(ImageView)  findViewById(R.id.img_mix);
        tv_paplatform=(TextView)  findViewById(R.id.tv_paplatform);
        img_platform=(ImageView)  findViewById(R.id.img_platform);
        tv_sys_time=(TextView)  findViewById(R.id.tv_sys_time);
        SimpleDateFormat sDateFormat = new    SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String  date = sDateFormat.format(new java.util.Date());
        tv_sys_time.setText(date);

        btn_lockscreen= (Button)  findViewById(R.id.btn_lockscreen);
        btn_shutdown = (Button)  findViewById(R.id.btn_shutdown);
        btn_rise = (Button)  findViewById(R.id.btn_rise);
        btn_puase = (Button)  findViewById(R.id.btn_puase);
        btn_drop = (Button)  findViewById(R.id.btn_drop);

        frameSwitch = (LinearLayout) findViewById(R.id.frameSwitch);
        GetMasterView();

        try {
            serialttyS = new SerialPort(new File(ttyS), baudrate, 0);
            ttySInputStream = serialttyS.getInputStream();
            ttySOutputStream = serialttyS.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            serialttyS_print = new SerialPort(new File(ttyS_print), baudrate_print, 0);
            ttySInputStream_print = serialttyS_print.getInputStream();
            ttySOutputStream_print = serialttyS_print.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
       // run_query();
        ui_update();
        run();
        InitView();
        btn_lockscreen.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_lockscreen)
                {
                   // showText("lock screen");
                    Intent intent = new Intent(TabSecondActivity.this,MainActivity.class);
                    startActivity(intent);
                  //  finish();
                }
            }
        });
        btn_shutdown.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_shutdown)
                {
                    showDialog();
                }
            }
        });

        btn_rise.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_rise)
                {
                    byte []lrc= Common.LRC_Calculate( Common.cmdsend_platform_rise);
                    ttyS3send(Common.cmdsend_platform_rise);
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);
                }
            }
        });

        btn_puase.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_puase)
                {
                    byte []lrc= Common.LRC_Calculate( Common.cmdsend_platform_stop);
                    ttyS3send(Common.cmdsend_platform_stop);
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);
                }
            }
        });

        btn_drop.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_drop)
                {
                    byte []lrc= Common.LRC_Calculate( Common.cmdsend_platform_drop);
                    ttyS3send(Common.cmdsend_platform_drop);
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);
                }
            }
        });
    }

    public  void InitView()
    {
        //1、查询温度
        byte []lrc= Common.LRC_Calculate( Common.cmdsend_temp_query);
        ttyS3send(Common.cmdsend_temp_query);
        ttyS3send(lrc);
        ttyS3send(Common.cmdsend_enter);
        Common.my_sleep(50);
        //2、设置预设温度 36.5
        String temp_value= "365";
        lrc= Common.LRC_Calculate( Common.byteMerger(Common.cmdsend_temp_set,temp_value.getBytes()));
        ttyS3send(Common.byteMerger(Common.cmdsend_temp_set,temp_value.getBytes()));
        ttyS3send(lrc);
        ttyS3send(Common.cmdsend_enter);
        Common.my_sleep(50);
        //3、设置为正转
        lrc= Common.LRC_Calculate( Common.cmdsend_positive_rotation);
        ttyS3send(Common.cmdsend_positive_rotation);
        ttyS3send(lrc);
        ttyS3send(Common.cmdsend_enter);
        Common.my_sleep(50);
        //4、设置转速初值  200.0转/分
        String speed_value= "2000";
        lrc= Common.LRC_Calculate( Common.byteMerger(Common.cmdsend_speed_set,speed_value.getBytes()));
        ttyS3send(Common.byteMerger(Common.cmdsend_speed_set,speed_value.getBytes()));
        ttyS3send(lrc);
        ttyS3send(Common.cmdsend_enter);
        Common.my_sleep(50);
        //3、设置为正计时
        lrc= Common.LRC_Calculate( Common.cmdsend_time_forward);
        ttyS3send(Common.cmdsend_time_forward);
        ttyS3send(lrc);
        ttyS3send(Common.cmdsend_enter);
        Common.my_sleep(50);

    }



    public void GetSetSystemView()
    {
        mIsSystemSet = true;
        View viewOne = getLayoutInflater().inflate(R.layout.system_set, null);

        Button btn_printer = (Button) viewOne.findViewById(R.id.btn_printer);
        Button btn_date = (Button) viewOne.findViewById(R.id.btn_date);
        Button btn_user = (Button) viewOne.findViewById(R.id.btn_user);
        Button btn_time = (Button) viewOne.findViewById(R.id.btn_time);
        btn_heat_time  =(Button) viewOne.findViewById(R.id.btn_heat_time);
        Button btn_download= (Button) viewOne.findViewById(R.id.btn_download);
        Button btn_set_mode = (Button)viewOne.findViewById(R.id.btn_set_mode);
        tv_date=(TextView)  viewOne.findViewById(R.id.tv_date);
        tv_time =(TextView)  viewOne.findViewById(R.id.tv_time);

        SimpleDateFormat   formatterData   =   new   SimpleDateFormat   ("yyyy年MM月dd日");
        Date curDate =  new Date(System.currentTimeMillis());
        String   strData   =   formatterData.format(curDate);
        tv_date.setText(strData);
        SimpleDateFormat   formatterTime   =   new   SimpleDateFormat   ("HH时mm分ss秒");
        Date curTime =  new Date(System.currentTimeMillis());
        String   strTime   =   formatterTime.format(curTime);
        tv_time.setText(strTime);

        btn_date.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_date)
                {
                    Calendar calendar = Calendar.getInstance();
                    DatePickerDialog dialog = new DatePickerDialog(TabSecondActivity.this, TabSecondActivity.this,
                            calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH));
                    dialog.show();
                }
            }
        });
        btn_time.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_time)
                {
                    Calendar calendar = Calendar.getInstance();
                    TimePickerDialog dialog = new TimePickerDialog(TabSecondActivity.this, TabSecondActivity.this,
                            calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
                    dialog.show();
                }
            }
        });


        btn_heat_time.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_heat_time)
                {
                    ShowHeatTimeDialog();
                }
            }
        });
        btn_download.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_download)
                {
                    ShowDownloadDialog();
                }
            }
        });
        btn_set_mode.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_set_mode)
                {
                  //  ShowModeDialog();
                    Intent it=new Intent(TabSecondActivity.this, mode_modify.class);
                    startActivityForResult(it,REQUEST);


                }
            }
        });

        btn_printer.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
            if (v.getId() == R.id.btn_printer)
            {
                ShowPrintLogDialog();
            }
            }
        });

        btn_user.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_user)
                {
                    ShowUserDialog();
                }
            }
        });


        Button btn_return = (Button) viewOne.findViewById(R.id.btn_return);
        btn_return.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_return)
                {
                    mIsSystemSet = false;
                    GetMasterView();
                    //Toast.makeText(TabSecondActivity.this, "gghhg", Toast.LENGTH_SHORT).show();
                }
            }
        });

        frameSwitch.removeAllViews();
        frameSwitch.addView(viewOne, LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.FILL_PARENT);
    }
    private void ShowUserDialog(){
        AlertDialog.Builder builder=new Builder(this);
        builder.setIcon(android.R.drawable.ic_dialog_info);
        builder.setTitle("用户管理");
        final String []items=new String[]{"注册用户","修改用户","注销所有用户","取消"};
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            //which指的是用户选择的条目的下标
            //dialog:触发这个方法的对话框
            @Override
            public void onClick(DialogInterface dialog, int which) {

            //    Toast.makeText(TabSecondActivity.this, "您选择的是:"+items[which], Toast.LENGTH_SHORT).show();
                if(which == 0)
                {
                    //注册用户
                    Intent it=new Intent(TabSecondActivity.this, Register.class);
                    startActivityForResult(it,REQUEST);
                }
                else if(which ==1)
                {
                    //修改密码
                    Intent it=new Intent(TabSecondActivity.this, Resetpwd.class);
                    startActivityForResult(it,REQUEST);
                }
                else if(which ==2)
                {
                    //注销用户
                    Common.sharesys.edit().clear().commit();
                    showText("注销所有用户成功！");
                   // Intent it=new Intent(TabSecondActivity.this, Logout.class);
                   // startActivityForResult(it,REQUEST);
                }
                else
                {

                }



                hideBottomUIMenu();
                dialog.dismiss();//当用户选择了一个值后，对话框消失

            }
        });
        builder.show();//这样也是一个show对话框的方式，上面那个也可以

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //requestcode 区别发出请求用意
        if (requestCode == REQUEST)
        {
            //第二个页面返回来的数据
            //resultcode 区分结果是否属于正常返回
            if (resultCode == RESULT_OK)
            {
                //操作成功
                showText("操作成功");
            }
            else if (resultCode == RESULT_CANCELED)
            {
                showText("操作失败");
                //操作失败
            }
            hideBottomUIMenu();
        }
    };
    private void ShowHeatTimeDialog()
    {
        final EditText editText = new EditText(this);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("仅输入数字");
        builder.setMessage("设置定时加热时间，单位:(秒)");
        builder.setView(editText);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String input = editText.getText().toString();

                if(editText.length() == 0)
                 {
                     showText("输入不能为空，请重新输入！");
                 }
                 else
                {
                    mTiming=Integer.valueOf(input).intValue();
                    showText(input);
                }



                hideBottomUIMenu();

            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                hideBottomUIMenu();

            }
        });

        builder.create().show();

    }
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        String desc = String.format("%d年%d月%d日",
                year, monthOfYear+1, dayOfMonth);
            hideBottomUIMenu();
            tv_date.setText(desc);
            try {
                mSystemTime.setDate(year,monthOfYear,dayOfMonth);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String desc = String.format("%d时%d分", hourOfDay, minute);
        hideBottomUIMenu();
        tv_time.setText(desc);
        try {
            mSystemTime.setTime(hourOfDay,minute);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    private void ShowDownloadDialog() {

        boolean bIsU = new USBDiskState().isMounted();

        if (bIsU)
        {
            //U盘已经插入
            final ProgressDialog dialog = new ProgressDialog(this);
            final int MAX_PROGRESS = 1;
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setIcon(R.mipmap.ic_launcher);
            dialog.setTitle("数据下载到U盘！");
            dialog.setMessage("数据下载中...");
            dialog.setProgress(0);
            //监听取消时间
            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    showText("数据下载完成！");
                    hideBottomUIMenu();
                }
            });
            dialog.show();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int progress = 0;
                    while (progress < MAX_PROGRESS) {
                        try {

                            //填写下载内容
                            String file_path = udisk_path + DateUtil.getNowDateTime("") + ".txt";
                            String content = "99999hgnjdmhd";
                            //FileUtil.openText(file_path);
                            FileUtil.saveText(file_path,content);
                            //   tv_path.setText("用户注册信息文件的保存路径为：\n"+file_path);
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        progress++;
                        //非UI线程，可以处理DialogUI
                        dialog.setProgress(progress);
                    }
                    dialog.cancel();
                }
            }).start();
        }
        else
            {
             showText("请插入U盘！");

            }



    }
    private void ShowModeDialog() {

        boolean bIsU = new USBDiskState().isMounted();

        if (bIsU)
        {
            //U盘已经插入
            final ProgressDialog dialog = new ProgressDialog(this);
            final int MAX_PROGRESS = 1;
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setIcon(R.mipmap.ic_launcher);
            dialog.setTitle("数据从U盘更新！");
            dialog.setMessage("数据更新中...");
            dialog.setProgress(0);
            //监听取消时间
            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    showText("数据更新完成！");
                    hideBottomUIMenu();
                }
            });
            dialog.show();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int progress = 0;
                    while (progress < MAX_PROGRESS) {
                        try {

                            // 数据从U盘中开始更新
                            readMonDataCsv();
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        progress++;
                        //非UI线程，可以处理DialogUI
                        dialog.setProgress(progress);
                    }
                    dialog.cancel();
                }
            }).start();
        }
        else
        {
            showText("请插入U盘！");

        }



    }
    private void readMonDataCsv() {
        int i = 0;// 用于标记打印的条数
        try {
            String file_path = udisk_path  + "ModeConfig.csv";
           // File csv = new File(Environment.getExternalStorageDirectory() + "/myshare/csv/000001.csv"); // CSV文件路径
            BufferedReader br = new BufferedReader(new FileReader(file_path));
            br.readLine();
            String line = "";
            /**
             * 这里读取csv文件中的前12条数据
             * 如果要读取第10条到30条数据,只需定义i初始值为9,wile中i<10改为i>=9&&i<30即可,其他范围依次类推
             */
            while ((line = br.readLine()) != null && i<12) { // 这里读取csv文件中的前10条数据
                i++;
            //    System.out.println("第" + i + "行：" + line);// 输出每一行数据
                Log.e("www", line);
                //showText(line);
                /**
                 *  csv格式每一列内容以逗号分隔,因此要取出想要的内容,以逗号为分割符分割字符串即可,
                 *  把分割结果存到到数组中,根据数组来取得相应值
                 */
                //将CSV文件内容写入机器

                String buffer[] = line.split(",");// 以逗号分隔
                SharedPreferences.Editor editor=Common.ModeConfig.edit();
                String temp  = "temp"+String.valueOf(i);
                editor.putString(temp,buffer[1]);
                String rpm  = "rpm"+String.valueOf(i);
                editor.putString(rpm, buffer[2]);
                String pump  = "pump"+String.valueOf(i);
                editor.putString(pump,buffer[3]);
                String trun  = "trun"+String.valueOf(i);
                editor.putString(trun,buffer[4]);
                editor.commit();

            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ShowPrintLogDialog() {

        final ProgressDialog dialog = new ProgressDialog(this);
        final int MAX_PROGRESS = 1;
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("请接入打印机！");
        dialog.setMessage("数据打印中...");
        dialog.setProgress(0);
        //监听取消时间
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                showText("数据打印完成！");
                hideBottomUIMenu();
            }
        });
        dialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int progress = 0;
                while (progress < MAX_PROGRESS) {
                    try {
                        String test= "12345abcd";
                        tty_print_send( test.getBytes());
                        tty_print_send(Common.cmdsend_print_end);
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progress++;
                    //非UI线程，可以处理DialogUI
                    dialog.setProgress(progress);
                }
                dialog.cancel();
            }
        }).start();

    }
    public void GetReportView()
    {
        View viewOne = getLayoutInflater().inflate(R.layout.report, null);

        Button btn_return = (Button) viewOne.findViewById(R.id.btn_return);
        btn_return.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_return)
                {
                    GetMasterView();
                    //Toast.makeText(TabSecondActivity.this, "gghhg", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mainLinerLayout = (LinearLayout)viewOne.findViewById(R.id.MyTable);
        initData();



        frameSwitch.removeAllViews();
        frameSwitch.addView(viewOne, LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.FILL_PARENT);
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
    public void GetAutoControlView()
    {

      //  final byte [] temp_value = new byte[3];
       // byte [] rpm_value = new byte[4];
        final byte [] pump_value = new byte[1];
        final byte [] trun_value = new byte[1];

        View viewOne = getLayoutInflater().inflate(R.layout.auto_control, null);

        Button btn_return = (Button) viewOne.findViewById(R.id.btn_return);
        ck_mode1  =(CheckBox) viewOne.findViewById(R.id.ck_mode1);
        ck_mode2  =(CheckBox) viewOne.findViewById(R.id.ck_mode2);
        ck_mode3  =(CheckBox) viewOne.findViewById(R.id.ck_mode3);
        ck_mode4  =(CheckBox) viewOne.findViewById(R.id.ck_mode4);
        ck_mode5  =(CheckBox) viewOne.findViewById(R.id.ck_mode5);
        ck_mode6  =(CheckBox) viewOne.findViewById(R.id.ck_mode6);
        ck_mode7  =(CheckBox) viewOne.findViewById(R.id.ck_mode7);
        ck_mode8  =(CheckBox) viewOne.findViewById(R.id.ck_mode8);
        ck_mode9  =(CheckBox) viewOne.findViewById(R.id.ck_mode9);
        ck_mode10  =(CheckBox) viewOne.findViewById(R.id.ck_mode10);
        ck_mode11  =(CheckBox) viewOne.findViewById(R.id.ck_mode11);
        ck_mode12  =(CheckBox) viewOne.findViewById(R.id.ck_mode12);

        temp1 = (TextView)viewOne.findViewById(R.id.temp1);
        final String st_temp1=Common.ModeConfig.getString("temp1","");
        temp1.setText(st_temp1);
        temp2 = (TextView)viewOne.findViewById(R.id.temp2);
        final String st_temp2=Common.ModeConfig.getString("temp2","");
        temp2.setText(st_temp2);
        temp3 = (TextView)viewOne.findViewById(R.id.temp3);
        final String st_temp3=Common.ModeConfig.getString("temp3","");
        temp3.setText(st_temp3);
        temp4 = (TextView)viewOne.findViewById(R.id.temp4);
        final String st_temp4=Common.ModeConfig.getString("temp4","");
        temp4.setText(st_temp4);
        temp5 = (TextView)viewOne.findViewById(R.id.temp5);
        final String st_temp5=Common.ModeConfig.getString("temp5","");
        temp5.setText(st_temp5);
        temp6 = (TextView)viewOne.findViewById(R.id.temp6);
        final String st_temp6=Common.ModeConfig.getString("temp6","");
        temp6.setText(st_temp6);
        temp7 = (TextView)viewOne.findViewById(R.id.temp7);
        final String st_temp7=Common.ModeConfig.getString("temp7","");
        temp7.setText(st_temp7);
        temp8 = (TextView)viewOne.findViewById(R.id.temp8);
        final String st_temp8=Common.ModeConfig.getString("temp8","");
        temp8.setText(st_temp8);
        temp9 = (TextView)viewOne.findViewById(R.id.temp9);
        final String st_temp9=Common.ModeConfig.getString("temp9","");
        temp9.setText(st_temp9);
        temp10 = (TextView)viewOne.findViewById(R.id.temp10);
        final String st_temp10=Common.ModeConfig.getString("temp10","");
        temp10.setText(st_temp10);
        temp11 = (TextView)viewOne.findViewById(R.id.temp11);
        final String st_temp11=Common.ModeConfig.getString("temp11","");
        temp11.setText(st_temp11);
        temp12 = (TextView)viewOne.findViewById(R.id.temp12);
        final String st_temp12=Common.ModeConfig.getString("temp12","");
        temp12.setText(st_temp12);

        rpm1 = (TextView)viewOne.findViewById(R.id.rpm1);
        final String st_rpm1=Common.ModeConfig.getString("rpm1","");
        rpm1.setText(st_rpm1);
        rpm2 = (TextView)viewOne.findViewById(R.id.rpm2);
        final String st_rpm2=Common.ModeConfig.getString("rpm2","");
        rpm2.setText(st_rpm2);
        rpm3 = (TextView)viewOne.findViewById(R.id.rpm3);
        final String st_rpm3=Common.ModeConfig.getString("rpm3","");
        rpm3.setText(st_rpm3);
        rpm4 = (TextView)viewOne.findViewById(R.id.rpm4);
        final String st_rpm4=Common.ModeConfig.getString("rpm4","");
        rpm4.setText(st_rpm4);
        rpm5 = (TextView)viewOne.findViewById(R.id.rpm5);
        final String st_rpm5=Common.ModeConfig.getString("rpm5","");
        rpm5.setText(st_rpm5);
        rpm6 = (TextView)viewOne.findViewById(R.id.rpm6);
        final String st_rpm6=Common.ModeConfig.getString("rpm6","");
        rpm6.setText(st_rpm6);
        rpm7 = (TextView)viewOne.findViewById(R.id.rpm7);
        final String st_rpm7=Common.ModeConfig.getString("rpm7","");
        rpm7.setText(st_rpm7);
        rpm8 = (TextView)viewOne.findViewById(R.id.rpm8);
        final String st_rpm8=Common.ModeConfig.getString("rpm8","");
        rpm8.setText(st_rpm8);
        rpm9 = (TextView)viewOne.findViewById(R.id.rpm9);
        final String st_rpm9=Common.ModeConfig.getString("rpm9","");
        rpm9.setText(st_rpm9);
        rpm10 = (TextView)viewOne.findViewById(R.id.rpm10);
        final String st_rpm10=Common.ModeConfig.getString("rpm10","");
        rpm10.setText(st_rpm10);
        rpm11 = (TextView)viewOne.findViewById(R.id.rpm11);
        final String st_rpm11=Common.ModeConfig.getString("rpm11","");
        rpm11.setText(st_rpm11);
        rpm12 = (TextView)viewOne.findViewById(R.id.rpm12);
        final String st_rpm12=Common.ModeConfig.getString("rpm12","");
        rpm12.setText(st_rpm12);

        pump1 = (TextView)viewOne.findViewById(R.id.pump1);
        final String st_pump1=Common.ModeConfig.getString("pump1","");
        pump1.setText(st_pump1);
        pump2 = (TextView)viewOne.findViewById(R.id.pump2);
        final String st_pump2=Common.ModeConfig.getString("pump2","");
        pump2.setText(st_pump2);
        pump3 = (TextView)viewOne.findViewById(R.id.pump3);
        final String st_pump3=Common.ModeConfig.getString("pump3","");
        pump3.setText(st_pump3);
        pump4 = (TextView)viewOne.findViewById(R.id.pump4);
        final String st_pump4=Common.ModeConfig.getString("pump4","");
        pump4.setText(st_pump4);
        pump5 = (TextView)viewOne.findViewById(R.id.pump5);
        final String st_pump5=Common.ModeConfig.getString("pump5","");
        pump5.setText(st_pump5);
        pump6 = (TextView)viewOne.findViewById(R.id.pump6);
        final String st_pump6=Common.ModeConfig.getString("pump6","");
        pump6.setText(st_pump6);
        pump7 = (TextView)viewOne.findViewById(R.id.pump7);
        final String st_pump7=Common.ModeConfig.getString("pump7","");
        pump7.setText(st_pump7);
        pump8 = (TextView)viewOne.findViewById(R.id.pump8);
        final String st_pump8=Common.ModeConfig.getString("pump8","");
        pump8.setText(st_pump8);
        pump9 = (TextView)viewOne.findViewById(R.id.pump9);
        final String st_pump9=Common.ModeConfig.getString("pump9","");
        pump9.setText(st_pump9);
        pump10 = (TextView)viewOne.findViewById(R.id.pump10);
        final String st_pump10=Common.ModeConfig.getString("pump10","");
        pump10.setText(st_pump10);
        pump11 = (TextView)viewOne.findViewById(R.id.pump11);
        final String st_pump11=Common.ModeConfig.getString("pump11","");
        pump11.setText(st_pump11);
        pump12 = (TextView)viewOne.findViewById(R.id.pump12);
        final String st_pump12=Common.ModeConfig.getString("pump12","");
        pump12.setText(st_pump12);

        trun1 = (TextView)viewOne.findViewById(R.id.trun1);
        final String st_trun1=Common.ModeConfig.getString("trun1","");
        trun1.setText(st_trun1);
        trun2 = (TextView)viewOne.findViewById(R.id.trun2);
        final String st_trun2=Common.ModeConfig.getString("trun2","");
        trun2.setText(st_trun2);
        trun3 = (TextView)viewOne.findViewById(R.id.trun3);
        final String st_trun3=Common.ModeConfig.getString("trun3","");
        trun3.setText(st_trun3);
        trun4 = (TextView)viewOne.findViewById(R.id.trun4);
        final String st_trun4=Common.ModeConfig.getString("trun4","");
        trun4.setText(st_trun4);
        trun5 = (TextView)viewOne.findViewById(R.id.trun5);
        final String st_trun5=Common.ModeConfig.getString("trun5","");
        trun5.setText(st_trun5);
        trun6 = (TextView)viewOne.findViewById(R.id.trun6);
        final String st_trun6=Common.ModeConfig.getString("trun6","");
        trun6.setText(st_trun6);
        trun7 = (TextView)viewOne.findViewById(R.id.trun7);
        final String st_trun7=Common.ModeConfig.getString("trun7","");
        trun7.setText(st_trun7);
        trun8 = (TextView)viewOne.findViewById(R.id.trun8);
        final String st_trun8=Common.ModeConfig.getString("trun8","");
        trun8.setText(st_trun8);
        trun9 = (TextView)viewOne.findViewById(R.id.trun9);
        final String st_trun9=Common.ModeConfig.getString("trun9","");
        trun9.setText(st_trun9);
        trun10 = (TextView)viewOne.findViewById(R.id.trun10);
        final String st_trun10=Common.ModeConfig.getString("trun10","");
        trun10.setText(st_trun10);
        trun11 = (TextView)viewOne.findViewById(R.id.trun11);
        final String st_trun11=Common.ModeConfig.getString("trun11","");
        trun11.setText(st_trun11);
        trun12 = (TextView)viewOne.findViewById(R.id.trun12);
        final String st_trun12=Common.ModeConfig.getString("trun12","");
        trun12.setText(st_trun12);


        btn_return.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_return)
                {
                    GetMasterView();
                    //Toast.makeText(TabSecondActivity.this, "gghhg", Toast.LENGTH_SHORT).show();
                }
            }
        });



        ck_mode1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ck_mode1.isChecked()){
                    ck_mode1.setText("关闭");
                    ck_mode1.setPadding(10, 0, 0, 0);
                    ck_mode2.setEnabled(false);
                    ck_mode3.setEnabled(false);
                    ck_mode4.setEnabled(false);
                    ck_mode5.setEnabled(false);
                    ck_mode6.setEnabled(false);
                    ck_mode7.setEnabled(false);
                    ck_mode8.setEnabled(false);
                    ck_mode9.setEnabled(false);
                    ck_mode10.setEnabled(false);
                    ck_mode11.setEnabled(false);
                    ck_mode12.setEnabled(false);
                    //下发数据
                    if (st_pump1=="开启")
                    {
                        pump_value[0] = 0x31;
                    }
                    else{
                        pump_value[0] = 0x32;
                    }
                    if (st_trun1=="正转")
                    {
                       trun_value [0] = 0x31;
                    }
                    else{
                        trun_value [0] = 0x32;
                    }

                    String szvalue;
                    java.text.DecimalFormat myformat;
                    float fvalue;

                    myformat=new java.text.DecimalFormat("00.0");
                    fvalue =Float.parseFloat(st_temp1);
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte[] temp_value = szvalue.getBytes();


                    myformat=new java.text.DecimalFormat("000.0");
                    fvalue =Float.parseFloat(st_rpm1);
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte[]rpm_value = szvalue.getBytes();


                    //Common.byteMerger(Common.cmdsend_mode_program,pump_value);
                    //Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value);
                    //Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value),trun_value);
                    byte []lrc= Common.LRC_Calculate( Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value),trun_value),temp_value));
                    ttyS3send(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value),trun_value),temp_value));
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);


                }else{
                    ck_mode1.setText("启动");
                    ck_mode1.setPadding(60,0,0,0);
                    ck_mode2.setEnabled(true);
                    ck_mode3.setEnabled(true);
                    ck_mode4.setEnabled(true);
                    ck_mode5.setEnabled(true);
                    ck_mode6.setEnabled(true);
                    ck_mode7.setEnabled(true);
                    ck_mode8.setEnabled(true);
                    ck_mode9.setEnabled(true);
                    ck_mode10.setEnabled(true);
                    ck_mode11.setEnabled(true);
                    ck_mode12.setEnabled(true);
                }
            }
        });

        ck_mode2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ck_mode2.isChecked()){
                    ck_mode2.setText("关闭");
                    ck_mode2.setPadding(10, 0, 0, 0);
                    ck_mode1.setEnabled(false);
                    ck_mode3.setEnabled(false);
                    ck_mode4.setEnabled(false);
                    ck_mode5.setEnabled(false);
                    ck_mode6.setEnabled(false);
                    ck_mode7.setEnabled(false);
                    ck_mode8.setEnabled(false);
                    ck_mode9.setEnabled(false);
                    ck_mode10.setEnabled(false);
                    ck_mode11.setEnabled(false);
                    ck_mode12.setEnabled(false);

                    //下发数据
                    if (st_pump2=="开启")
                    {
                        pump_value[0] = 0x31;
                    }
                    else{
                        pump_value[0] = 0x32;
                    }
                    if (st_trun2=="正转")
                    {
                        trun_value [0] = 0x31;
                    }
                    else{
                        trun_value [0] = 0x32;
                    }

                    String szvalue;
                    java.text.DecimalFormat myformat;
                    float fvalue;

                    myformat=new java.text.DecimalFormat("00.0");
                    fvalue =Float.parseFloat(st_temp2);
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte[] temp_value = szvalue.getBytes();


                    myformat=new java.text.DecimalFormat("000.0");
                    fvalue =Float.parseFloat(st_rpm2);
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte[]rpm_value = szvalue.getBytes();


                    //Common.byteMerger(Common.cmdsend_mode_program,pump_value);
                    //Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value);
                    //Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value),trun_value);
                    byte []lrc= Common.LRC_Calculate( Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value),trun_value),temp_value));
                    ttyS3send(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value),trun_value),temp_value));
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);

                }else{
                    ck_mode2.setText("启动");
                    ck_mode2.setPadding(60,0,0,0);
                    ck_mode1.setEnabled(true);
                    ck_mode3.setEnabled(true);
                    ck_mode4.setEnabled(true);
                    ck_mode5.setEnabled(true);
                    ck_mode6.setEnabled(true);
                    ck_mode7.setEnabled(true);
                    ck_mode8.setEnabled(true);
                    ck_mode9.setEnabled(true);
                    ck_mode10.setEnabled(true);
                    ck_mode11.setEnabled(true);
                    ck_mode12.setEnabled(true);
                }
            }
        });


        ck_mode3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ck_mode3.isChecked()){
                    ck_mode3.setText("关闭");
                    ck_mode3.setPadding(10, 0, 0, 0);
                    ck_mode1.setEnabled(false);
                    ck_mode2.setEnabled(false);
                    ck_mode4.setEnabled(false);
                    ck_mode5.setEnabled(false);
                    ck_mode6.setEnabled(false);
                    ck_mode7.setEnabled(false);
                    ck_mode8.setEnabled(false);
                    ck_mode9.setEnabled(false);
                    ck_mode10.setEnabled(false);
                    ck_mode11.setEnabled(false);
                    ck_mode12.setEnabled(false);
                    //下发数据
                    if (st_pump3=="开启")
                    {
                        pump_value[0] = 0x31;
                    }
                    else{
                        pump_value[0] = 0x32;
                    }
                    if (st_trun3=="正转")
                    {
                        trun_value [0] = 0x31;
                    }
                    else{
                        trun_value [0] = 0x32;
                    }

                    String szvalue;
                    java.text.DecimalFormat myformat;
                    float fvalue;

                    myformat=new java.text.DecimalFormat("00.0");
                    fvalue =Float.parseFloat(st_temp3);
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte[] temp_value = szvalue.getBytes();


                    myformat=new java.text.DecimalFormat("000.0");
                    fvalue =Float.parseFloat(st_rpm3);
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte[]rpm_value = szvalue.getBytes();

                    byte []lrc= Common.LRC_Calculate( Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value),trun_value),temp_value));
                    ttyS3send(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value),trun_value),temp_value));
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);
                }else{
                    ck_mode3.setText("启动");
                    ck_mode3.setPadding(60,0,0,0);
                    ck_mode1.setEnabled(true);
                    ck_mode2.setEnabled(true);
                    ck_mode4.setEnabled(true);
                    ck_mode5.setEnabled(true);
                    ck_mode6.setEnabled(true);
                    ck_mode7.setEnabled(true);
                    ck_mode8.setEnabled(true);
                    ck_mode9.setEnabled(true);
                    ck_mode10.setEnabled(true);
                    ck_mode11.setEnabled(true);
                    ck_mode12.setEnabled(true);
                }
            }
        });

        ck_mode4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ck_mode4.isChecked()){
                    ck_mode4.setText("关闭");
                    ck_mode4.setPadding(10, 0, 0, 0);
                    ck_mode1.setEnabled(false);
                    ck_mode2.setEnabled(false);
                    ck_mode3.setEnabled(false);
                    ck_mode5.setEnabled(false);
                    ck_mode6.setEnabled(false);
                    ck_mode7.setEnabled(false);
                    ck_mode8.setEnabled(false);
                    ck_mode9.setEnabled(false);
                    ck_mode10.setEnabled(false);
                    ck_mode11.setEnabled(false);
                    ck_mode12.setEnabled(false);
                    //下发数据
                    if (st_pump4=="开启")
                    {
                        pump_value[0] = 0x31;
                    }
                    else{
                        pump_value[0] = 0x32;
                    }
                    if (st_trun4=="正转")
                    {
                        trun_value [0] = 0x31;
                    }
                    else{
                        trun_value [0] = 0x32;
                    }

                    String szvalue;
                    java.text.DecimalFormat myformat;
                    float fvalue;

                    myformat=new java.text.DecimalFormat("00.0");
                    fvalue =Float.parseFloat(st_temp4);
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte[] temp_value = szvalue.getBytes();


                    myformat=new java.text.DecimalFormat("000.0");
                    fvalue =Float.parseFloat(st_rpm4);
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte[]rpm_value = szvalue.getBytes();

                    byte []lrc= Common.LRC_Calculate( Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value),trun_value),temp_value));
                    ttyS3send(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value),trun_value),temp_value));
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);
                }else{
                    ck_mode4.setText("启动");
                    ck_mode4.setPadding(60,0,0,0);
                    ck_mode1.setEnabled(true);
                    ck_mode2.setEnabled(true);
                    ck_mode3.setEnabled(true);
                    ck_mode5.setEnabled(true);
                    ck_mode6.setEnabled(true);
                    ck_mode7.setEnabled(true);
                    ck_mode8.setEnabled(true);
                    ck_mode9.setEnabled(true);
                    ck_mode10.setEnabled(true);
                    ck_mode11.setEnabled(true);
                    ck_mode12.setEnabled(true);
                }
            }
        });
        ck_mode5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ck_mode5.isChecked()){
                    ck_mode5.setText("关闭");
                    ck_mode5.setPadding(10, 0, 0, 0);
                    ck_mode1.setEnabled(false);
                    ck_mode2.setEnabled(false);
                    ck_mode3.setEnabled(false);
                    ck_mode4.setEnabled(false);
                    ck_mode6.setEnabled(false);
                    ck_mode7.setEnabled(false);
                    ck_mode8.setEnabled(false);
                    ck_mode9.setEnabled(false);
                    ck_mode10.setEnabled(false);
                    ck_mode11.setEnabled(false);
                    ck_mode12.setEnabled(false);
                    //下发数据
                    if (st_pump5=="开启")
                    {
                        pump_value[0] = 0x31;
                    }
                    else{
                        pump_value[0] = 0x32;
                    }
                    if (st_trun5=="正转")
                    {
                        trun_value [0] = 0x31;
                    }
                    else{
                        trun_value [0] = 0x32;
                    }

                    String szvalue;
                    java.text.DecimalFormat myformat;
                    float fvalue;

                    myformat=new java.text.DecimalFormat("00.0");
                    fvalue =Float.parseFloat(st_temp5);
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte[] temp_value = szvalue.getBytes();


                    myformat=new java.text.DecimalFormat("000.0");
                    fvalue =Float.parseFloat(st_rpm5);
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte[]rpm_value = szvalue.getBytes();

                    byte []lrc= Common.LRC_Calculate( Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value),trun_value),temp_value));
                    ttyS3send(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value),trun_value),temp_value));
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);
                }else{
                    ck_mode5.setText("启动");
                    ck_mode5.setPadding(60,0,0,0);
                    ck_mode1.setEnabled(true);
                    ck_mode2.setEnabled(true);
                    ck_mode3.setEnabled(true);
                    ck_mode4.setEnabled(true);
                    ck_mode6.setEnabled(true);
                    ck_mode7.setEnabled(true);
                    ck_mode8.setEnabled(true);
                    ck_mode9.setEnabled(true);
                    ck_mode10.setEnabled(true);
                    ck_mode11.setEnabled(true);
                    ck_mode12.setEnabled(true);
                }
            }
        });
        ck_mode6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ck_mode6.isChecked()){
                    ck_mode6.setText("关闭");
                    ck_mode6.setPadding(10, 0, 0, 0);
                    ck_mode1.setEnabled(false);
                    ck_mode2.setEnabled(false);
                    ck_mode3.setEnabled(false);
                    ck_mode4.setEnabled(false);
                    ck_mode5.setEnabled(false);
                    ck_mode7.setEnabled(false);
                    ck_mode8.setEnabled(false);
                    ck_mode9.setEnabled(false);
                    ck_mode10.setEnabled(false);
                    ck_mode11.setEnabled(false);
                    ck_mode12.setEnabled(false);
                    //下发数据
                    if (st_pump6=="开启")
                    {
                        pump_value[0] = 0x31;
                    }
                    else{
                        pump_value[0] = 0x32;
                    }
                    if (st_trun6=="正转")
                    {
                        trun_value [0] = 0x31;
                    }
                    else{
                        trun_value [0] = 0x32;
                    }

                    String szvalue;
                    java.text.DecimalFormat myformat;
                    float fvalue;

                    myformat=new java.text.DecimalFormat("00.0");
                    fvalue =Float.parseFloat(st_temp6);
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte[] temp_value = szvalue.getBytes();


                    myformat=new java.text.DecimalFormat("000.0");
                    fvalue =Float.parseFloat(st_rpm6);
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte[]rpm_value = szvalue.getBytes();

                    byte []lrc= Common.LRC_Calculate( Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value),trun_value),temp_value));
                    ttyS3send(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value),trun_value),temp_value));
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);
                }else{
                    ck_mode6.setText("启动");
                    ck_mode6.setPadding(60,0,0,0);
                    ck_mode1.setEnabled(true);
                    ck_mode2.setEnabled(true);
                    ck_mode3.setEnabled(true);
                    ck_mode4.setEnabled(true);
                    ck_mode5.setEnabled(true);
                    ck_mode7.setEnabled(true);
                    ck_mode8.setEnabled(true);
                    ck_mode9.setEnabled(true);
                    ck_mode10.setEnabled(true);
                    ck_mode11.setEnabled(true);
                    ck_mode12.setEnabled(true);
                }
            }
        });
        ck_mode7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ck_mode7.isChecked()){
                    ck_mode7.setText("关闭");
                    ck_mode7.setPadding(10, 0, 0, 0);
                    ck_mode1.setEnabled(false);
                    ck_mode2.setEnabled(false);
                    ck_mode3.setEnabled(false);
                    ck_mode4.setEnabled(false);
                    ck_mode5.setEnabled(false);
                    ck_mode6.setEnabled(false);
                    ck_mode8.setEnabled(false);
                    ck_mode9.setEnabled(false);
                    ck_mode10.setEnabled(false);
                    ck_mode11.setEnabled(false);
                    ck_mode12.setEnabled(false);
                    //下发数据
                    if (st_pump7=="开启")
                    {
                        pump_value[0] = 0x31;
                    }
                    else{
                        pump_value[0] = 0x32;
                    }
                    if (st_trun7=="正转")
                    {
                        trun_value [0] = 0x31;
                    }
                    else{
                        trun_value [0] = 0x32;
                    }

                    String szvalue;
                    java.text.DecimalFormat myformat;
                    float fvalue;

                    myformat=new java.text.DecimalFormat("00.0");
                    fvalue =Float.parseFloat(st_temp7);
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte[] temp_value = szvalue.getBytes();


                    myformat=new java.text.DecimalFormat("000.0");
                    fvalue =Float.parseFloat(st_rpm7);
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte[]rpm_value = szvalue.getBytes();

                    byte []lrc= Common.LRC_Calculate( Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value),trun_value),temp_value));
                    ttyS3send(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value),trun_value),temp_value));
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);
                }else{
                    ck_mode7.setText("启动");
                    ck_mode7.setPadding(60,0,0,0);
                    ck_mode1.setEnabled(true);
                    ck_mode2.setEnabled(true);
                    ck_mode3.setEnabled(true);
                    ck_mode4.setEnabled(true);
                    ck_mode5.setEnabled(true);
                    ck_mode6.setEnabled(true);
                    ck_mode8.setEnabled(true);
                    ck_mode9.setEnabled(true);
                    ck_mode10.setEnabled(true);
                    ck_mode11.setEnabled(true);
                    ck_mode12.setEnabled(true);
                }
            }
        });
        ck_mode8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ck_mode8.isChecked()){
                    ck_mode8.setText("关闭");
                    ck_mode8.setPadding(10, 0, 0, 0);
                    ck_mode1.setEnabled(false);
                    ck_mode2.setEnabled(false);
                    ck_mode3.setEnabled(false);
                    ck_mode4.setEnabled(false);
                    ck_mode5.setEnabled(false);
                    ck_mode6.setEnabled(false);
                    ck_mode7.setEnabled(false);
                    ck_mode9.setEnabled(false);
                    ck_mode10.setEnabled(false);
                    ck_mode11.setEnabled(false);
                    ck_mode12.setEnabled(false);
                    //下发数据
                    if (st_pump8=="开启")
                    {
                        pump_value[0] = 0x31;
                    }
                    else{
                        pump_value[0] = 0x32;
                    }
                    if (st_trun8=="正转")
                    {
                        trun_value [0] = 0x31;
                    }
                    else{
                        trun_value [0] = 0x32;
                    }

                    String szvalue;
                    java.text.DecimalFormat myformat;
                    float fvalue;

                    myformat=new java.text.DecimalFormat("00.0");
                    fvalue =Float.parseFloat(st_temp8);
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte[] temp_value = szvalue.getBytes();


                    myformat=new java.text.DecimalFormat("000.0");
                    fvalue =Float.parseFloat(st_rpm8);
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte[]rpm_value = szvalue.getBytes();

                    byte []lrc= Common.LRC_Calculate( Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value),trun_value),temp_value));
                    ttyS3send(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value),trun_value),temp_value));
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);
                }else{
                    ck_mode7.setText("启动");
                    ck_mode7.setPadding(60,0,0,0);
                    ck_mode1.setEnabled(true);
                    ck_mode2.setEnabled(true);
                    ck_mode3.setEnabled(true);
                    ck_mode4.setEnabled(true);
                    ck_mode5.setEnabled(true);
                    ck_mode6.setEnabled(true);
                    ck_mode7.setEnabled(true);
                    ck_mode9.setEnabled(true);
                    ck_mode10.setEnabled(true);
                    ck_mode11.setEnabled(true);
                    ck_mode12.setEnabled(true);
                }
            }
        });
        ck_mode9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ck_mode9.isChecked()){
                    ck_mode9.setText("关闭");
                    ck_mode9.setPadding(10, 0, 0, 0);
                    ck_mode1.setEnabled(false);
                    ck_mode2.setEnabled(false);
                    ck_mode3.setEnabled(false);
                    ck_mode4.setEnabled(false);
                    ck_mode5.setEnabled(false);
                    ck_mode6.setEnabled(false);
                    ck_mode7.setEnabled(false);
                    ck_mode8.setEnabled(false);
                    ck_mode10.setEnabled(false);
                    ck_mode11.setEnabled(false);
                    ck_mode12.setEnabled(false);
                    //下发数据
                    if (st_pump9=="开启")
                    {
                        pump_value[0] = 0x31;
                    }
                    else{
                        pump_value[0] = 0x32;
                    }
                    if (st_trun9=="正转")
                    {
                        trun_value [0] = 0x31;
                    }
                    else{
                        trun_value [0] = 0x32;
                    }

                    String szvalue;
                    java.text.DecimalFormat myformat;
                    float fvalue;

                    myformat=new java.text.DecimalFormat("00.0");
                    fvalue =Float.parseFloat(st_temp9);
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte[] temp_value = szvalue.getBytes();


                    myformat=new java.text.DecimalFormat("000.0");
                    fvalue =Float.parseFloat(st_rpm9);
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte[]rpm_value = szvalue.getBytes();

                    byte []lrc= Common.LRC_Calculate( Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value),trun_value),temp_value));
                    ttyS3send(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value),trun_value),temp_value));
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);
                }else{
                    ck_mode9.setText("启动");
                    ck_mode9.setPadding(60,0,0,0);
                    ck_mode1.setEnabled(true);
                    ck_mode2.setEnabled(true);
                    ck_mode3.setEnabled(true);
                    ck_mode4.setEnabled(true);
                    ck_mode5.setEnabled(true);
                    ck_mode6.setEnabled(true);
                    ck_mode7.setEnabled(true);
                    ck_mode8.setEnabled(true);
                    ck_mode10.setEnabled(true);
                    ck_mode11.setEnabled(true);
                    ck_mode12.setEnabled(true);
                }
            }
        });
        ck_mode10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ck_mode10.isChecked()){
                    ck_mode10.setText("关闭");
                    ck_mode10.setPadding(10, 0, 0, 0);
                    ck_mode1.setEnabled(false);
                    ck_mode2.setEnabled(false);
                    ck_mode3.setEnabled(false);
                    ck_mode4.setEnabled(false);
                    ck_mode5.setEnabled(false);
                    ck_mode6.setEnabled(false);
                    ck_mode7.setEnabled(false);
                    ck_mode8.setEnabled(false);
                    ck_mode9.setEnabled(false);
                    ck_mode11.setEnabled(false);
                    ck_mode12.setEnabled(false);
                    //下发数据
                    if (st_pump10=="开启")
                    {
                        pump_value[0] = 0x31;
                    }
                    else{
                        pump_value[0] = 0x32;
                    }
                    if (st_trun10=="正转")
                    {
                        trun_value [0] = 0x31;
                    }
                    else{
                        trun_value [0] = 0x32;
                    }

                    String szvalue;
                    java.text.DecimalFormat myformat;
                    float fvalue;

                    myformat=new java.text.DecimalFormat("00.0");
                    fvalue =Float.parseFloat(st_temp10);
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte[] temp_value = szvalue.getBytes();


                    myformat=new java.text.DecimalFormat("000.0");
                    fvalue =Float.parseFloat(st_rpm10);
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte[]rpm_value = szvalue.getBytes();

                    byte []lrc= Common.LRC_Calculate( Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value),trun_value),temp_value));
                    ttyS3send(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value),trun_value),temp_value));
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);
                }else{
                    ck_mode10.setText("启动");
                    ck_mode10.setPadding(60,0,0,0);
                    ck_mode1.setEnabled(true);
                    ck_mode2.setEnabled(true);
                    ck_mode3.setEnabled(true);
                    ck_mode4.setEnabled(true);
                    ck_mode5.setEnabled(true);
                    ck_mode6.setEnabled(true);
                    ck_mode7.setEnabled(true);
                    ck_mode8.setEnabled(true);
                    ck_mode9.setEnabled(true);
                    ck_mode11.setEnabled(true);
                    ck_mode12.setEnabled(true);
                }
            }
        });
        ck_mode11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ck_mode11.isChecked()){
                    ck_mode11.setText("关闭");
                    ck_mode11.setPadding(10, 0, 0, 0);
                    ck_mode1.setEnabled(false);
                    ck_mode2.setEnabled(false);
                    ck_mode3.setEnabled(false);
                    ck_mode4.setEnabled(false);
                    ck_mode5.setEnabled(false);
                    ck_mode6.setEnabled(false);
                    ck_mode7.setEnabled(false);
                    ck_mode8.setEnabled(false);
                    ck_mode9.setEnabled(false);
                    ck_mode10.setEnabled(false);
                    ck_mode12.setEnabled(false);
                    //下发数据
                    if (st_pump11=="开启")
                    {
                        pump_value[0] = 0x31;
                    }
                    else{
                        pump_value[0] = 0x32;
                    }
                    if (st_trun11=="正转")
                    {
                        trun_value [0] = 0x31;
                    }
                    else{
                        trun_value [0] = 0x32;
                    }

                    String szvalue;
                    java.text.DecimalFormat myformat;
                    float fvalue;

                    myformat=new java.text.DecimalFormat("00.0");
                    fvalue =Float.parseFloat(st_temp11);
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte[] temp_value = szvalue.getBytes();


                    myformat=new java.text.DecimalFormat("000.0");
                    fvalue =Float.parseFloat(st_rpm11);
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte[]rpm_value = szvalue.getBytes();

                    byte []lrc= Common.LRC_Calculate( Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value),trun_value),temp_value));
                    ttyS3send(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value),trun_value),temp_value));
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);
                }else{
                    ck_mode11.setText("启动");
                    ck_mode11.setPadding(60,0,0,0);
                    ck_mode1.setEnabled(true);
                    ck_mode2.setEnabled(true);
                    ck_mode3.setEnabled(true);
                    ck_mode4.setEnabled(true);
                    ck_mode5.setEnabled(true);
                    ck_mode6.setEnabled(true);
                    ck_mode7.setEnabled(true);
                    ck_mode8.setEnabled(true);
                    ck_mode9.setEnabled(true);
                    ck_mode10.setEnabled(true);
                    ck_mode12.setEnabled(true);
                }
            }
        });
        ck_mode12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ck_mode12.isChecked()){
                    ck_mode12.setText("关闭");
                    ck_mode12.setPadding(10, 0, 0, 0);
                    ck_mode1.setEnabled(false);
                    ck_mode2.setEnabled(false);
                    ck_mode3.setEnabled(false);
                    ck_mode4.setEnabled(false);
                    ck_mode5.setEnabled(false);
                    ck_mode6.setEnabled(false);
                    ck_mode7.setEnabled(false);
                    ck_mode8.setEnabled(false);
                    ck_mode9.setEnabled(false);
                    ck_mode10.setEnabled(false);
                    ck_mode11.setEnabled(false);
                    //下发数据
                    if (st_pump12=="开启")
                    {
                        pump_value[0] = 0x31;
                    }
                    else{
                        pump_value[0] = 0x32;
                    }
                    if (st_trun12=="正转")
                    {
                        trun_value [0] = 0x31;
                    }
                    else{
                        trun_value [0] = 0x32;
                    }

                    String szvalue;
                    java.text.DecimalFormat myformat;
                    float fvalue;

                    myformat=new java.text.DecimalFormat("00.0");
                    fvalue =Float.parseFloat(st_temp12);
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte[] temp_value = szvalue.getBytes();


                    myformat=new java.text.DecimalFormat("000.0");
                    fvalue =Float.parseFloat(st_rpm12);
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte[]rpm_value = szvalue.getBytes();

                    byte []lrc= Common.LRC_Calculate( Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value),trun_value),temp_value));
                    ttyS3send(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.byteMerger(Common.cmdsend_mode_program,pump_value),rpm_value),trun_value),temp_value));
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);
                }else{
                    ck_mode12.setText("启动");
                    ck_mode12.setPadding(60,0,0,0);
                    ck_mode1.setEnabled(true);
                    ck_mode2.setEnabled(true);
                    ck_mode3.setEnabled(true);
                    ck_mode4.setEnabled(true);
                    ck_mode5.setEnabled(true);
                    ck_mode6.setEnabled(true);
                    ck_mode7.setEnabled(true);
                    ck_mode8.setEnabled(true);
                    ck_mode9.setEnabled(true);
                    ck_mode10.setEnabled(true);
                    ck_mode11.setEnabled(true);
                }
            }
        });


        frameSwitch.removeAllViews();
        frameSwitch.addView(viewOne, LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.FILL_PARENT);
    }



    public void GetManualControlView()
    {
        View viewOne = getLayoutInflater().inflate(R.layout.manual_control, null);
        tv_temp = (TextView) viewOne.findViewById(R.id.tv_temp);
        tv_mix  = (TextView) viewOne.findViewById(R.id.tv_mix);
     //   tv_pump = (TextView) viewOne.findViewById(R.id.tv_pump);
        ck_temp = (CheckBox) viewOne.findViewById(R.id.ck_temp);
        ck_pump = (CheckBox) viewOne.findViewById(R.id.ck_pump);
        ck_positive_inversion= (CheckBox) viewOne.findViewById(R.id.ck_positive_inversion);
        ck_mix =(CheckBox) viewOne.findViewById(R.id.ck_mix);
        ck_reverse =(CheckBox) viewOne.findViewById(R.id.ck_reverse);
        ck_time =(CheckBox) viewOne.findViewById(R.id.ck_time);

        Button btn_temp_sub = (Button) viewOne.findViewById(R.id.btn_temp_sub);
        btn_temp_sub.setOnClickListener(new OnClickListener()
        {
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
                    byte []lrc= Common.LRC_Calculate( Common.byteMerger(Common.cmdsend_temp_set,szvalue.getBytes()));
                    ttyS3send(Common.byteMerger(Common.cmdsend_temp_set,szvalue.getBytes()));
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);
                }
            }
        });
        Button btn_temp_add = (Button) viewOne.findViewById(R.id.btn_temp_add);
        btn_temp_add.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String szvalue;
                if (v.getId() == R.id.btn_temp_add) {
                    java.text.DecimalFormat myformat=new java.text.DecimalFormat("00.0");
                    szvalue = tv_temp.getText().toString();
                    float fvalue =((Float.parseFloat(szvalue))+(0.1f));
                    tv_temp.setText( myformat.format(fvalue));
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte []lrc= Common.LRC_Calculate( Common.byteMerger(Common.cmdsend_temp_set,szvalue.getBytes()));
                    ttyS3send(Common.byteMerger(Common.cmdsend_temp_set,szvalue.getBytes()));
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);
                }
            }
        });

        tv_temp.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 监听到回车键，按下与松开
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        //按下事件
                        String szvalue;
                        java.text.DecimalFormat myformat=new java.text.DecimalFormat("00.0");
                        szvalue = tv_temp.getText().toString();
                        float fvalue =((Float.parseFloat(szvalue))+(0.0f));
                        tv_temp.setText( myformat.format(fvalue));
                        szvalue = myformat.format(fvalue);
                        szvalue = szvalue.replace(".","");
                        byte []lrc= Common.LRC_Calculate( Common.byteMerger(Common.cmdsend_temp_set,szvalue.getBytes()));
                        ttyS3send(Common.byteMerger(Common.cmdsend_temp_set,szvalue.getBytes()));
                        ttyS3send(lrc);
                        ttyS3send(Common.cmdsend_enter);
                       // tv_temp.setCursorVisible(false);
                    //    hideBottomUIMenu();

                    }
                }
                return false;
            }

        });

        tv_temp.setOnTouchListener(new View.OnTouchListener() {

       //  @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_DOWN == event.getAction()) {
                    tv_temp.setCursorVisible(true);// 再次点击显示光标
                }
                return false;
            }
        });

        ck_temp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ck_temp.isChecked()){
                    if (ck_pump.isChecked()) {
                        ck_temp.setText("关闭");
                        ck_temp.setPadding(10, 0, 0, 0);
                        byte[] lrc = Common.LRC_Calculate(Common.cmdsend_heating_start);
                        ttyS3send(Common.cmdsend_heating_start);
                        ttyS3send(lrc);
                        ttyS3send(Common.cmdsend_enter);
                    }
                    else
                    {
                        ck_temp.setChecked(false);
                        Toast.makeText(TabSecondActivity.this, "请先开水泵，一分钟后再加热！", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    ck_temp.setText("加热");
                    ck_temp.setPadding(60,0,0,0);
                    byte []lrc= Common.LRC_Calculate( Common.cmdsend_heating_stop);
                    ttyS3send(Common.cmdsend_heating_stop);
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);
                }
            }
        });
        Button btn_mix_sub = (Button) viewOne.findViewById(R.id.btn_mix_sub);
        btn_mix_sub.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String szvalue;
                if (v.getId() == R.id.btn_mix_sub) {
                    java.text.DecimalFormat myformat=new java.text.DecimalFormat("000.0");
                    szvalue = tv_mix.getText().toString();
                    float fvalue =((Float.parseFloat(szvalue))-(0.1f));
                    tv_mix.setText( myformat.format(fvalue));
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte []lrc= Common.LRC_Calculate( Common.byteMerger(Common.cmdsend_speed_set,szvalue.getBytes()));
                    ttyS3send(Common.byteMerger(Common.cmdsend_speed_set,szvalue.getBytes()));
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);
                }
            }
        });
        Button btn_mix_add = (Button) viewOne.findViewById(R.id.btn_mix_add);
        btn_mix_add.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String szvalue;
                if (v.getId() == R.id.btn_mix_add) {
                    java.text.DecimalFormat myformat=new java.text.DecimalFormat("000.0");
                    szvalue = tv_mix.getText().toString();
                    float fvalue =((Float.parseFloat(szvalue))+(0.1f));
                    tv_mix.setText( myformat.format(fvalue));
                    szvalue = myformat.format(fvalue);
                    szvalue = szvalue.replace(".","");
                    byte []lrc= Common.LRC_Calculate( Common.byteMerger(Common.cmdsend_speed_set,szvalue.getBytes()));
                    ttyS3send(Common.byteMerger(Common.cmdsend_speed_set,szvalue.getBytes()));
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);
                }
            }
        });
        tv_mix.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 监听到回车键，会执行2次该方法。按下与松开
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        //按下事件
                        String szvalue;
                        java.text.DecimalFormat myformat=new java.text.DecimalFormat("000.0");
                        szvalue = tv_mix.getText().toString();
                        float fvalue =((Float.parseFloat(szvalue))+(0.0f));
                        tv_mix.setText( myformat.format(fvalue));
                        szvalue = myformat.format(fvalue);
                        szvalue = szvalue.replace(".","");
                        byte []lrc= Common.LRC_Calculate( Common.byteMerger(Common.cmdsend_speed_set,szvalue.getBytes()));
                        ttyS3send(Common.byteMerger(Common.cmdsend_speed_set,szvalue.getBytes()));
                        ttyS3send(lrc);
                        ttyS3send(Common.cmdsend_enter);
                        hideBottomUIMenu();
                    }
                }
                return false;
            }

        });
        ck_positive_inversion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ck_positive_inversion.isChecked()){
                    ck_positive_inversion.setText("反转");
                    ck_positive_inversion.setPadding(70, 0, 0, 0);
                    byte []lrc= Common.LRC_Calculate( Common.cmdsend_positive_rotation);
                    ttyS3send(Common.cmdsend_positive_rotation);
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);

                }else{
                    ck_positive_inversion.setText("正转");
                    ck_positive_inversion.setPadding(10,0,0,0);
                    byte []lrc= Common.LRC_Calculate( Common.cmdsend_reversal_rotation);
                    ttyS3send(Common.cmdsend_reversal_rotation);
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);
                }
            }
        });
        ck_mix.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ck_mix.isChecked()){
                    ck_mix.setText("关闭");
                    ck_mix.setPadding(10, 0, 0, 0);
                    byte []lrc= Common.LRC_Calculate( Common.cmdsend_stir_start);
                    ttyS3send(Common.cmdsend_stir_start);
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);
                }else{
                    ck_mix.setText("转动");
                    ck_mix.setPadding(60,0,0,0);
                    byte []lrc= Common.LRC_Calculate( Common.cmdsend_stir_stop);
                    ttyS3send(Common.cmdsend_stir_stop);
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);
                }
            }
        });
        ck_pump.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ck_pump.isChecked()){
                    ck_pump.setText("关闭");
                    ck_pump.setPadding(10, 0, 0, 0);
                 //   tv_pump.setText( "100");

                    byte []lrc= Common.LRC_Calculate( Common.cmdsend_pump_start);
                    ttyS3send(Common.cmdsend_pump_start);
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);
                    showText("一分钟后开启加热");


                }else{
                    ck_pump.setText("启动");
                    ck_pump.setPadding(60,0,0,0);
                    ck_temp.setText("加热");
                    ck_temp.setPadding(60,0,0,0);
                    ck_temp.setChecked(false);
                   // tv_pump.setText("0");
                    byte []lrc= Common.LRC_Calculate( Common.cmdsend_pump_stop);
                    ttyS3send(Common.cmdsend_pump_stop);
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);

                }
            }
        });
        //   Common.my_sleep(1000);
        mTimer = (Anticlockwise) viewOne.findViewById(R.id.id_timer);
        mTimer.setOnTimeCompleteListener(new Anticlockwise.OnTimeCompleteListener()
        {
            @Override
            public void onTimeComplete()
            {
                showText("计时完成！");
            }
        });
        ck_reverse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(ck_time.isChecked())
                {
                    if(ck_reverse.isChecked()){
                        ck_reverse.setChecked(false);
                    }else{
                        ck_reverse.setChecked(true);
                    }
                }
                else
                {
                    if(ck_reverse.isChecked()){
                        ck_reverse.setText("倒计");
                        ck_reverse.setPadding(70, 0, 0, 0);
                        byte []lrc= Common.LRC_Calculate( Common.cmdsend_time_backward);
                        ttyS3send(Common.cmdsend_time_backward);
                        ttyS3send(lrc);
                        ttyS3send(Common.cmdsend_enter);
                        //初始化时间
                        mTimer.TimerMode(0);
                        mTimer.initTime(mTiming);
                     //   mTimer.reStart();

                    }else{
                        ck_reverse.setText("正计");
                        ck_reverse.setPadding(10,0,0,0);
                        byte []lrc= Common.LRC_Calculate( Common.cmdsend_time_forward);
                        ttyS3send(Common.cmdsend_time_forward);
                        ttyS3send(lrc);
                        ttyS3send(Common.cmdsend_enter);
                        mTimer.TimerMode(1);
                        mTimer.initTime(1);

                    }
                }
            }
        });

        ck_time.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ck_time.isChecked()){
                    ck_time.setText("停止");
                    ck_time.setPadding(10, 0, 0, 0);
                    byte []lrc= Common.LRC_Calculate( Common.cmdsend_time_start);
                    ttyS3send(Common.cmdsend_time_start);
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);
                    mTimer.reStart();
                }else{
                    ck_time.setText("开始");
                    ck_time.setPadding(60,0,0,0);
                    byte []lrc= Common.LRC_Calculate( Common.cmdsend_time_stop);
                    ttyS3send(Common.cmdsend_time_stop);
                    ttyS3send(lrc);
                    ttyS3send(Common.cmdsend_enter);
                    mTimer.stop();
                }
            }
        });
        Button btn_return = (Button) viewOne.findViewById(R.id.btn_return);
        btn_return.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_return)
                {
                    GetMasterView();
                    //Toast.makeText(TabSecondActivity.this, "gghhg", Toast.LENGTH_SHORT).show();
                }
            }
        });
        frameSwitch.removeAllViews();
        frameSwitch.addView(viewOne, LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.FILL_PARENT);
    }
    public void GetMasterView()
    {
        View master = getLayoutInflater().inflate(R.layout.master, null);

        Button btn_manual = (Button) master.findViewById(R.id.btn_manual_control);
        btn_manual.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.btn_manual_control) {
                    GetManualControlView();
                }

            }
        });
        Button btn_auto = (Button) master.findViewById(R.id.btn_auto_control);
        btn_auto.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.btn_auto_control) {
                   GetAutoControlView();
                }

            }
        });
        Button btn_set = (Button) master.findViewById(R.id.btn_system_set);
        btn_set.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.btn_system_set) {
                    GetSetSystemView();
                }

            }
        });
        Button btn_report = (Button) master.findViewById(R.id.btn_report);
        btn_report.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.btn_report) {
                   GetReportView();
                }

            }
        });
        frameSwitch.removeAllViews();
        frameSwitch.addView(master, LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.FILL_PARENT);
    }
    private void ttyS3send(byte[] sendcmd) {
        try {
            ttySOutputStream.write(sendcmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void tty_print_send(byte[] sendcmd) {
        try {
            ttySOutputStream_print.write(sendcmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ui_update() {
        new Thread() {
            @Override
            public void run() {
                while (ttySispool) {
                    Message msg = Message.obtain();
                    msg.what = 1000;
                    msg.arg1 = 10;
                    ui_handler.sendMessage(msg);
                    Common.my_sleep(500);
                }
            }
        }.start();
    }
    Handler ui_handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            SimpleDateFormat sDateFormat = new    SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String  date = sDateFormat.format(new java.util.Date());
            tv_sys_time.setText(date);
            if(mIsSystemSet == true)
            {
                        SimpleDateFormat   formatterData   =   new   SimpleDateFormat   ("yyyy年MM月dd日");
                        Date curDate =  new Date(System.currentTimeMillis());
                        String   strData   =   formatterData.format(curDate);
                        tv_date.setText(strData);
                        SimpleDateFormat   formatterTime   =   new   SimpleDateFormat   ("HH时mm分ss秒");
                        Date curTime =  new Date(System.currentTimeMillis());
                        String   strTime   =   formatterTime.format(curTime);
                        tv_time.setText(strTime);
            }
        }
    };
    /**
     * 定期查询下位机状态
     */
    private void run_query() {
        new Thread() {
            @Override
            public void run() {
                while (ttySispool) {
                //1、查询温度
                byte []lrc= Common.LRC_Calculate( Common.cmdsend_temp_query);
                ttyS3send(Common.cmdsend_temp_query);
                ttyS3send(lrc);
                ttyS3send(Common.cmdsend_enter);
                Common.my_sleep(1000);
                //2、查询转速
               lrc= Common.LRC_Calculate( Common.cmdsend_speed_query);
                ttyS3send(Common.cmdsend_speed_query);
                ttyS3send(lrc);
                ttyS3send(Common.cmdsend_enter);
                Common.my_sleep(1000);
                //3、查询高度
               lrc= Common.LRC_Calculate( Common.cmdsend_platform_query);
                ttyS3send(Common.cmdsend_platform_query);
                ttyS3send(lrc);
                ttyS3send(Common.cmdsend_enter);
                Common.my_sleep(1000);
                }
            }
        }.start();
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
        java.text.DecimalFormat myformat_temp=new java.text.DecimalFormat("00.0");
        java.text.DecimalFormat myformat_speed=new java.text.DecimalFormat("000.0");
        Bundle bundle = null;
        byte[] receivebyte = new byte[100];
        bundle = msg.getData();

        ttyS2recvSize = bundle.getInt(recvsize);
        receivebyte = bundle.getByteArray(recvbyte);

        if ((receivebyte[0] == 0x3a) && (receivebyte[1] == 0x30) && (receivebyte[2] == 0x32) && (receivebyte[3] == 0x30) && (receivebyte[4] == 0x39)) {
            //温度回传
            int temp = (receivebyte[5] - 0x30) * 100 + (receivebyte[6] - 0x30) * 10 + (receivebyte[7] - 0x30);
            float f_temp = ((float) temp)/10.0f;
            tv_temp_value.setText( myformat_temp.format(f_temp));
            img_temp.setImageDrawable(getResources().getDrawable(R.drawable.point_green));
        }
        if ((receivebyte[0] == 0x3a) && (receivebyte[1] == 0x30) && (receivebyte[2] == 0x32) && (receivebyte[3] == 0x30) && (receivebyte[4] == 0x33)) {
            //转速回传  应改成占四位 目前0到9999
            int speed = (receivebyte[5] - 0x30) * 1000 + (receivebyte[6] - 0x30)*100+(receivebyte[7] - 0x30)*10+(receivebyte[8] - 0x30);
            float f_speed = ((float) speed)/10.0f;
            tv_mix_value.setText(myformat_speed.format(f_speed));
            img_mix.setImageDrawable(getResources().getDrawable(R.drawable.point_green));

        }
        if ((receivebyte[0] == 0x3a) && (receivebyte[1] == 0x30) && (receivebyte[2] == 0x32) && (receivebyte[3] == 0x31) && (receivebyte[4] == 0x33)) {
            //工作台高度回传
            int high = (receivebyte[5] - 0x30) * 10 + (receivebyte[6] - 0x30);
            tv_paplatform.setText( (String.valueOf(high)+"%"));
            img_platform.setImageDrawable(getResources().getDrawable(R.drawable.point_green));
        }

    }

    private void showDialog(){
        android.support.v7.app.AlertDialog.Builder builder=new android.support.v7.app.AlertDialog.Builder(this);
        //  builder.setIcon(R.drawable.picture);
        builder.setTitle("提示!");
        // builder.setMessage("关闭系统");
        builder.setPositiveButton("关机",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        hideBottomUIMenu();
                        // 下发关机指令
                        byte []lrc= Common.LRC_Calculate( Common.cmdsend_shut_down);
                        ttyS3send(Common.cmdsend_shut_down);
                        ttyS3send(lrc);
                        ttyS3send(Common.cmdsend_enter);
                        Common.my_sleep(300);
                        Common.shutdown();
                    }
                });
        builder.setNegativeButton("取消",
                new DialogInterface.OnClickListener()  {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        hideBottomUIMenu();
                    }
                });
        android.support.v7.app.AlertDialog dialog=builder.create();
        dialog.show();
    }

    /**
     * 隐藏虚拟按键，并且全屏
     */
    protected void hideBottomUIMenu() {
//        //隐藏虚拟按键，并且全屏
//        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
//            View v = this.getWindow().getDecorView();
//            v.setSystemUiVisibility(View.GONE);
//        } else if (Build.VERSION.SDK_INT >= 19) {
//            //for new api versions.
//            View decorView = getWindow().getDecorView();
//            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
//            decorView.setSystemUiVisibility(uiOptions);
//        }
    }
    @Override
    public void onBackPressed() {
        // super.onBackPressed();//注释掉这行,back键不退出activity
        tv_temp.setCursorVisible(false);
        hideBottomUIMenu();
    }
    public void showText(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
