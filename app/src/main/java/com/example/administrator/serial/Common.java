package com.example.administrator.serial;

import android.content.SharedPreferences;

/**
 * Created by Administrator on 2018-10-20.
 */

public class Common {

    static byte[] cmdsend_rise     = new byte[]{0x3a,0x30,0x32,0x30,0x36,0x31};
    static byte[] cmdsend_drop     = new byte[]{0x3a,0x30,0x32,0x30,0x36,0x32};
    static byte[] cmdsend_stop     = new byte[]{0x3a,0x30,0x32,0x30,0x36,0x00};
    static byte[] cmdsend_temp     = new byte[]{0x3a,0x30,0x32,0x30,0x34};
    static byte[] cmdsend_speed    = new byte[]{0x3a,0x30,0x32,0x30,0x32};
    static byte[] cmdsend_tempoff     = new byte[]{0x3a,0x30,0x32,0x30,0x38,0x30};
    static byte[] cmdsend_tempon     =  new byte[]{0x3a,0x30,0x32,0x30,0x38,0x31};
    static byte[] cmdsend_pumpoff     = new byte[]{0x3a,0x30,0x32,0x31,0x30,0x30};
    static byte[] cmdsend_pumpon     =  new byte[]{0x3a,0x30,0x32,0x31,0x30,0x31};
    static byte[] cmdsend_mixoff     = new byte[]{0x3a,0x30,0x32,0x31,0x38,0x30};
    static byte[] cmdsend_mixon     =  new byte[]{0x3a,0x30,0x32,0x31,0x38,0x31};
    static byte[] cmdinquiry_temp    =  new byte[]{0x3a,0x30,0x32,0x30,0x34,0x30,0x30,0x30};
    static byte[] cmdinit_temp    =  new byte[]{0x3A,0x30,0x32,0x30,0x34,0x33,0x37,0x35};
    static byte[] cmdinit_mix    =  new byte[]{0x3A,0x30,0x32,0x30,0x32,0x32,0x34,0x30,0x30};

    static byte[] cmdsend_enter= new byte[]{0x0d,0x0a};
    static public SharedPreferences sharesys;

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



}
