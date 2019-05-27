package com.example.administrator.serial;

/**
 * Created by 15522 on 2019/4/10.
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Chronometer;

@SuppressLint(
        { "ViewConstructor", "SimpleDateFormat" })
public class Anticlockwise extends Chronometer
{
    public Anticlockwise(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        // TODO 自动生成的构造函数存根
        mTimeFormat = new SimpleDateFormat("HH:mm:ss");
        mTimeFormat.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        updateTimeText();
        this.setOnChronometerTickListener(listener);


    }
    private long mTime;
    private long mNextTime;
    private OnTimeCompleteListener mListener;
    private SimpleDateFormat mTimeFormat;
    private int mMode;

    public Anticlockwise(Context context)
    {
        super(context);

    }
    /**
     * 重新启动计时
     */
    public void reStart(long _time_s)
    {
        if (_time_s == -1)
        {
            mNextTime = mTime;
        } else
        {
            mTime = mNextTime = _time_s;
        }
        this.start();
    }

    public void reStart()
    {
        reStart(-1);
    }

    public void TimerMode (int mode)
    {
        mNextTime = 0;
        mMode = mode;
    }
    /**
     * 继续计时
     */
    public void onResume()
    {
        this.start();
    }

    /**
     * 暂停计时
     */
    public void onPause()
    {
        this.stop();
    }

    /**
     * 设置时间格式
     *
     * @param pattern
     *            计时格式
     */
    public void setTimeFormat(String pattern)
    {
        mTimeFormat = new SimpleDateFormat(pattern);
    }

    public void setOnTimeCompleteListener(OnTimeCompleteListener l)
    {
        mListener = l;
    }

    OnChronometerTickListener listener = new OnChronometerTickListener()
    {
        @Override
        public void onChronometerTick(Chronometer chronometer)
        {
            if (mNextTime <= 0)
            {
                if (mNextTime == 0)
                {
                    Anticlockwise.this.stop();
                    if (null != mListener)
                        mListener.onTimeComplete();
                }
                mNextTime = 0;
                updateTimeText();
                return;
            }
            if(mMode==1)
            {
                mNextTime++;
            }
            else {
                mNextTime--;
            }


            updateTimeText();
        }
    };

    /**
     * 初始化时间
     * @param _time_s
     */
    public void initTime(long _time_s)
    {
        mTime = mNextTime = _time_s;
        updateTimeText();
    }

    private void updateTimeText()
    {
        if(mMode==1)
        {
            this.setText(mTimeFormat.format(new Date((mNextTime-1) * 1000)));
        }
        else {
            this.setText(mTimeFormat.format(new Date(mNextTime * 1000)));
        }

    }

    interface OnTimeCompleteListener
    {
        void onTimeComplete();
    }

}
