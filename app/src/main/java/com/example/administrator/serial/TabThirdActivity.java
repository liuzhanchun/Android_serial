package com.example.administrator.serial;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
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
import android.widget.Toast;

import android.view.Window;
/**
 * Created by Administrator on 2018-10-09.
 */

public class TabThirdActivity extends Activity
        implements OnClickListener, OnDateSetListener , OnTimeSetListener{

    private TextView tv_date;
    private TextView tv_time;
    final static int REQUEST=10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.fragment_tab_third);

        tv_date = (TextView) findViewById(R.id.tv_date);
        findViewById(R.id.btn_date).setOnClickListener(this);

        tv_time = (TextView) findViewById(R.id.tv_time);
        findViewById(R.id.btn_time).setOnClickListener(this);

        findViewById(R.id.btn_mode).setOnClickListener(this);

        findViewById(R.id.btn_printer).setOnClickListener(this);
        findViewById(R.id.btn_download).setOnClickListener(this);
        findViewById(R.id.btn_dataupdate).setOnClickListener(this);
        findViewById(R.id.btn_user).setOnClickListener(this);


        SimpleDateFormat   formatterData   =   new   SimpleDateFormat   ("yyyy年MM月dd日");
        Date curDate =  new Date(System.currentTimeMillis());
        String   strData   =   formatterData.format(curDate);
        tv_date.setText(strData);

        SimpleDateFormat   formatterTime   =   new   SimpleDateFormat   ("HH时mm分");
        Date curTime =  new Date(System.currentTimeMillis());
        String   strTime   =   formatterTime.format(curTime);
        tv_time.setText(strTime);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_date) {
            Calendar calendar = Calendar.getInstance();
            DatePickerDialog dialog = new DatePickerDialog(this, this,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH));
            dialog.show();
        }
        if (v.getId() == R.id.btn_time) {
            Calendar calendar = Calendar.getInstance();
            TimePickerDialog dialog = new TimePickerDialog(this, this,
                    calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
            dialog.show();
        }
        if (v.getId() == R.id.btn_mode) {
            Intent it=new Intent(this, SetConfigPara.class);
            startActivityForResult(it,REQUEST);
        }
        if (v.getId() == R.id.btn_printer) {

            showPrinterDialog();


        }
        if (v.getId() == R.id.btn_download) {
            ShowDownloadDialog();
        }
        if (v.getId() == R.id.btn_dataupdate) {
            ShowDataUpdateDialog();
        }
        if (v.getId() == R.id.btn_user) {
            Intent it=new Intent(this, Resetpwd.class);
            startActivityForResult(it,REQUEST);
        }


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

        }
    };

    private void ShowDataUpdateDialog()
    {
        final EditText editText = new EditText(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("仅输入数字");
        builder.setMessage("设置报表刷新率，单位:(min)");
        builder.setView(editText);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String input = editText.getText().toString();
                showText(input);
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }
    private void ShowDownloadDialog() {

        final ProgressDialog dialog = new ProgressDialog(this);
        final int MAX_PROGRESS = 100;
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("请插入U盘！");
        dialog.setMessage("数据下载中...");
        dialog.setProgress(0);
        //监听取消时间
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
               showText("数据下载完成！");
            }
        });
        dialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int progress = 0;
                while (progress < MAX_PROGRESS) {
                    try {
                        Thread.sleep(50);
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
    private void showPrinterDialog(){
        AlertDialog.Builder builder=new Builder(this);
        builder.setIcon(android.R.drawable.ic_dialog_info);
        builder.setTitle("请选择工作模式");
        final String []items=new String[]{"模式一","模式二","模式 三","模式四","模式五"};
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            //which指的是用户选择的条目的下标
            //dialog:触发这个方法的对话框
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(TabThirdActivity.this, "您选择的是:"+items[which], Toast.LENGTH_SHORT).show();
                dialog.dismiss();//当用户选择了一个值后，对话框消失

            }
        });
        builder.show();//这样也是一个show对话框的方式，上面那个也可以

    }



    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        String desc = String.format("%d年%d月%d日",
                year, monthOfYear+1, dayOfMonth);
        tv_date.setText(desc);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String desc = String.format("%d时%d分", hourOfDay, minute);
        tv_time.setText(desc);
    }
    public void showText(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}


