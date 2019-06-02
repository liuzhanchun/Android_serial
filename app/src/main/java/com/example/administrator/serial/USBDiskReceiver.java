package com.example.administrator.serial;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by 15522 on 2019/5/29.
 */

public class USBDiskReceiver extends BroadcastReceiver {
    private static final String TAG = "USBDiskReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String path = intent.getData().getPath();
        if (!TextUtils.isEmpty(path)) {
            if ("android.intent.action.MEDIA_REMOVED".equals(action)) {
                Log.e(TAG, "onReceive: ---------------u盘拨出-------------");
                //Toast.makeText(USBDiskReceiver.this, "u盘拨出--", Toast.LENGTH_SHORT).show();
            }
            if ("android.intent.action.MEDIA_MOUNTED".equals(action)) {
                Log.e(TAG, "onReceive: --------u盘路径-------"+ path);
                //  Toast.makeText(USBDiskReceiver.this, "onCreate: ------u盘路径-------" + path, Toast.LENGTH_SHORT).show();
            }
        }
    }


}