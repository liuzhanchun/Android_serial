package com.example.administrator.serial;

/**
 * Created by Administrator on 2019\1\4 0004.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;
import android.view.View;
import android.os.Bundle;
/**
 * Created by Administrator on 2019-01-03.
 */

public class MyTableTextView extends TextView {

    Paint paint = new Paint();
    public MyTableTextView(Context context,AttributeSet attrs)
    {
        super(context,attrs);
        int color = Color.parseColor("#80b9f2");
        paint.setColor(color);
    }
    @Override
    protected  void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawLine(0,0,this.getWidth()-1,0,paint);
        canvas.drawLine(0,0,0,this.getHeight()-1,paint);
        canvas.drawLine(this.getWidth()-1,0,this.getWidth()-1,this.getHeight()-1,paint);
        canvas.drawLine(0,this.getHeight()-1,this.getWidth()-1,this.getHeight()-1,paint);
    }
}
