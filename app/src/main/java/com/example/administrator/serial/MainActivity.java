package com.example.administrator.serial;
import android.content.Intent;
import android.os.Bundle;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.io.IOException;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import com.example.x6.serial.SerialPort;

public class MainActivity extends AppCompatActivity {
    private EditText id_login;
    private EditText password_login;
    private ImageView avatar_login;
    private Button button_login;
    private Button btn_shutdown;
   // private SharedPreferences sp;
    private String idvalue;
    private String passwordvalue;
    private static final int PASSWORD_MIWEN = 0x81;
    private String TAG = MainActivity.class.getSimpleName();
    private final String ttyS = "/dev/ttyS0";
    private final int baudrate = 19200;
    private InputStream ttySInputStream;
    private OutputStream ttySOutputStream;
    private SerialPort serialttyS = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Window _window;
        _window = getWindow();
        WindowManager.LayoutParams params = _window.getAttributes();
        params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_IMMERSIVE;
        _window.setAttributes(params);

       // hideBottomUIMenu();

        try {
            serialttyS = new SerialPort(new File(ttyS), baudrate, 0);
            ttySInputStream = serialttyS.getInputStream();
            ttySOutputStream = serialttyS.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
       // sp = this.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        Common.sharesys   = getSharedPreferences("user", Context.MODE_PRIVATE);
        Common.ModeConfig = getSharedPreferences("mode_config",Context.MODE_PRIVATE);

        //判断是否第一次启动该APP
        boolean isFirstRun =  Common.ModeConfig.getBoolean("isFirstRun",true);

        if (isFirstRun)
        {
            //创建自动模式配置列表
            SharedPreferences.Editor editor=Common.ModeConfig.edit();
            editor.putBoolean("isFirstRun", false);

            editor.putString("temp1","38");
            editor.putString("temp2","37");
            editor.putString("temp3","37");
            editor.putString("temp4","37");
            editor.putString("temp5","37");
            editor.putString("temp6","37");
            editor.putString("temp7","37");
            editor.putString("temp8","37");
            editor.putString("temp9","37");
            editor.putString("temp10","37");
            editor.putString("temp11","37");
            editor.putString("temp12","37");

            editor.putString("rpm1","240.0");
            editor.putString("rpm2","240.0");
            editor.putString("rpm3","240.0");
            editor.putString("rpm4","240.0");
            editor.putString("rpm5","240.0");
            editor.putString("rpm6","240.0");
            editor.putString("rpm7","240.0");
            editor.putString("rpm8","240.0");
            editor.putString("rpm9","240.0");
            editor.putString("rpm10","240.0");
            editor.putString("rpm11","240.0");
            editor.putString("rpm12","240.0");

            editor.putString("pump1","开启");
            editor.putString("pump2","开启");
            editor.putString("pump3","开启");
            editor.putString("pump4","开启");
            editor.putString("pump5","开启");
            editor.putString("pump6","开启");
            editor.putString("pump7","开启");
            editor.putString("pump8","开启");
            editor.putString("pump9","开启");
            editor.putString("pump10","开启");
            editor.putString("pump11","开启");
            editor.putString("pump12","开启");

            editor.putString("trun1","正转");
            editor.putString("trun2","正转");
            editor.putString("trun3","正转");
            editor.putString("trun4","正转");
            editor.putString("trun5","正转");
            editor.putString("trun6","正转");
            editor.putString("trun7","正转");
            editor.putString("trun8","正转");
            editor.putString("trun9","正转");
            editor.putString("trun10","正转");
            editor.putString("trun11","正转");
            editor.putString("trun12","正转");

            editor.commit();



        }




        //找到相应的布局及控件
        setContentView(R.layout.activity_main);
        id_login=(EditText) findViewById(R.id.login_id);
        password_login=(EditText) findViewById(R.id.login_password);
        avatar_login=(ImageView) findViewById(R.id.login_avatar);
        button_login=(Button) findViewById(R.id.login_button);
        btn_shutdown = (Button) findViewById(R.id.btn_shutdown);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id_login.getPaint().setFlags(0);
                idvalue=id_login.getText().toString();
                password_login.getPaint().setFlags(0);
                passwordvalue=password_login.getText().toString();

                String usernum =  Common.sharesys.getString("usernum","");

                if (usernum.length() == 0)
                {

                    Common.g_idvalue = idvalue;
                    Intent intent = new Intent(MainActivity.this,TabSecondActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {

                    int nUserum = Integer.valueOf(usernum).intValue();
                    boolean user_error = false;
                    for(int num =0;num<nUserum; num++)
                    {
                        //String user,password;
                        String user  = "user"+String.valueOf(num);
                        String password = "password"+String.valueOf(num);

                        if (idvalue.equals( Common.sharesys.getString(user,""))&&passwordvalue.equals( Common.sharesys.getString(password,"")))
                        {
                            Common.g_idvalue = idvalue;
                            Common.g_passwordvalue = passwordvalue;
                            Intent intent = new Intent(MainActivity.this,TabSecondActivity.class);
                            startActivity(intent);
                            finish();
                            user_error = true;
                        }

                    }
                    if (user_error==false)
                    {
                        Toast.makeText(MainActivity.this, "用户名或密码错误，请重新登录", Toast.LENGTH_SHORT).show();
                    }

                }




//                if (idvalue.equals( Common.sharesys.getString("user1",""))&&passwordvalue.equals( Common.sharesys.getString("password1","")))
//                {
//                    Intent intent = new Intent(MainActivity.this,TabSecondActivity.class);
//                    startActivity(intent);
//                    finish();
//                }else{
//                    Toast.makeText(MainActivity.this, "用户名或密码错误，请重新登录", Toast.LENGTH_SHORT).show();
//                }


            }
        });
        btn_shutdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }
    private void showDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
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
        AlertDialog dialog=builder.create();
        dialog.show();
    }
    private void ttyS3send(byte[] sendcmd) {
        try {
            ttySOutputStream.write(sendcmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
}
