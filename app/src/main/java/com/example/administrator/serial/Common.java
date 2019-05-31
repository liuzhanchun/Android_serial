package com.example.administrator.serial;

import android.content.SharedPreferences;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by Administrator on 2018-10-20.
 */

public class Common {
    static byte[] cmdsend_speed_query          = new byte[]{0x3a,0x30,0x32,0x30,0x32,0x39,0x39,0x39,0x39};    //02
    static byte[] cmdsend_speed_start_stir     = new byte[]{0x3a,0x30,0x32,0x30,0x32,0x38,0x38,0x38,0x38};
    static byte[] cmdsend_speed_set            = new byte[]{0x3a,0x30,0x32,0x30,0x32};
    static byte[] cmdsend_positive_rotation    = new byte[]{0x3a,0x30,0x32,0x30,0x34,0x31};                   //04
    static byte[] cmdsend_reversal_rotation    = new byte[]{0x3a,0x30,0x32,0x30,0x34,0x32};
    static byte[] cmdsend_stir_start           = new byte[]{0x3a,0x30,0x32,0x30,0x36,0x31};                   //06
    static byte[] cmdsend_stir_stop            = new byte[]{0x3a,0x30,0x32,0x30,0x36,0x32};
    static byte[] cmdsend_temp_query           = new byte[]{0x3a,0x30,0x32,0x30,0x38,0x39,0x39,0x39};         //08
    static byte[] cmdsend_temp_set             = new byte[]{0x3a,0x30,0x32,0x30,0x38};
    static byte[] cmdsend_heating_start        = new byte[]{0x3a,0x30,0x32,0x31,0x30,0x31};                   //10
    static byte[] cmdsend_heating_stop         = new byte[]{0x3a,0x30,0x32,0x31,0x30,0x32};
    static byte[] cmdsend_platform_rise        = new byte[]{0x3a,0x30,0x32,0x31,0x32,0x31};                   //12
    static byte[] cmdsend_platform_drop        = new byte[]{0x3a,0x30,0x32,0x31,0x32,0x32};
    static byte[] cmdsend_platform_stop        = new byte[]{0x3a,0x30,0x32,0x31,0x32,0x34};
    static byte[] cmdsend_platform_query       = new byte[]{0x3a,0x30,0x32,0x31,0x32,0x39};
    static byte[] cmdsend_pump_start           = new byte[]{0x3a,0x30,0x32,0x31,0x34,0x31};                   //14
    static byte[] cmdsend_pump_stop            = new byte[]{0x3a,0x30,0x32,0x31,0x34,0x32};
    static byte[] cmdsend_time_interval_set    = new byte[]{0x3a,0x30,0x32,0x31,0x36};                        //16
    static byte[] cmdsend_time_interval_query  = new byte[]{0x3a,0x30,0x32,0x31,0x36,0x39,0x39};
    static byte[] cmdsend_time_forward         = new byte[]{0x3a,0x30,0x32,0x31,0x38,0x31};                   //18
    static byte[] cmdsend_time_backward        = new byte[]{0x3a,0x30,0x32,0x31,0x38,0x32};
    static byte[] cmdsend_time_start           = new byte[]{0x3a,0x30,0x32,0x32,0x30,0x31};                   //20
    static byte[] cmdsend_time_stop            = new byte[]{0x3a,0x30,0x32,0x32,0x30,0x32};
    static byte[] cmdsend_time_calibration     = new byte[]{0x3a,0x30,0x32,0x32,0x32};                        //22
    static byte[] cmdsend_date_calibration     = new byte[]{0x3a,0x30,0x32,0x32,0x34};                        //24
    static byte[] cmdsend_mode_choice          = new byte[]{0x3a,0x30,0x32,0x32,0x36};                        //26
    static byte[] cmdsend_mode_program         = new byte[]{0x3a,0x30,0x32,0x32,0x38};                        //28
    //30
    //32
    static byte[] cmdsend_shut_down            = new byte[]{0x3a,0x30,0x32,0x33,0x34,0x31};                   //34  关机
    static byte[] cmdsend_lock_screen          = new byte[]{0x3a,0x30,0x32,0x33,0x34,0x38};                   //34  锁屏

    //....

    static byte[] cmdsend_enter    =     new byte[]{0x0d,0x0a};
    static byte[] cmdsend_print_end=     new byte[]{0x0d,0x0a,0x0d,0x0a ,0x0d,0x0a,0x0d,0x0a,0x0d,0x0a,0x0d,0x0a};

    static public SharedPreferences sharesys;
    static public SharedPreferences ModeConfig;

    static public String g_idvalue;
    static public String g_passwordvalue;
    /**
     * Convert hex string to byte[]
     * @param hexString the hex string
     * @return byte[]
     */
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }
    static  private byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static final byte[] hex2byte(String hex)
            throws IllegalArgumentException {
        if (hex.length() % 2 != 0) {
            throw new IllegalArgumentException();
        }
        char[] arr = hex.toCharArray();
        byte[] b = new byte[hex.length() / 2];
        for (int i = 0, j = 0, l = hex.length(); i < l; i++, j++) {
            String swap = "" + arr[i++] + arr[i];
            int byteint = Integer.parseInt(swap, 16) & 0xFF;
            b[j] = new Integer(byteint).byteValue();
        }
        return b;
    }

    static  public byte [] LRC_Calculate(byte[] data) {
        int length, count, k;
        byte []result = new  byte[2];
        byte[] lrcdata = new byte[100];
        length = data.length;
        count = 0;
        for (int i = 1; i < length; i++) {
            lrcdata[i-1] = data[i];
            count++;
        }
        if (count % 2 != 0) {
            count++;
        }
        k = 0;
        for (int i = 0; i < count / 2; i++)
        {
            k += (lrcdata[2 * i] * 16 + lrcdata[2 * i + 1]);
        }
        k = k % 256;
        k = 256 - k;
        k = k % 256;
        if(((k >> 4)&0x000f)<10) {
            result[0] = (byte) (((k >> 4) & 0x000f) + 0x30);
        }   else {
            result[0] = (byte) (((k >> 4) & 0x000f) + 55);
        }
        if(((k ) & 0x000F)<10){
            result[1] = (byte)(((k ) & 0x000F)+0x30);
        }else {
            result[1] = (byte)(((k ) & 0x000F)+55);
        }
        return result;
    }
    //拼接发送指令
    static public byte[] byteMerger(byte[] byte_1, byte[] byte_2) {
        byte[] byte_3 = new byte[byte_1.length + byte_2.length];
        System.arraycopy(byte_1, 0, byte_3, 0, byte_1.length);
        System.arraycopy(byte_2, 0, byte_3, byte_1.length, byte_2.length);
        return byte_3;
    }
    static public int shutdown() {
        int r = 0;
        try {
            Process process = Runtime.getRuntime().exec(new String[]{"su" , "-c" ,"reboot -p"});
            r = process.waitFor();
            java.lang.System.out.println("r:" + r );
        } catch (IOException e) {
            e.printStackTrace();
            r = -1;
        } catch (InterruptedException e) {
            e.printStackTrace();
            r = -1;
        }
        return r;
    }
    static public void my_sleep(int count)
    {
        try {
            Thread.currentThread().sleep(count);//阻断2秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static public int range_of_values(int max,int min,int value)
    {
        if (value<min)
        {
            return min;
        }
        if (value>max)
        {
            return max;
        }
        return value;
    }

}
