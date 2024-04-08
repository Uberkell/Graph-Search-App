package com.example.finalproject;
/** @file DrawingView.java
 *
 *  @course CS2511
 *  @term Fall 2023
 *
 *  Second activity that builds a graph
 *
 *  @author Will Class
 *
 *  @date 08 Dec 2023
 *
 *  @version 1.0 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawingView extends View {

    public DrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint p = new Paint();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float touchX = event.getX();
        float touchY = event.getY();

        int action = event.getActionMasked();
        switch (action) {

            case (MotionEvent.ACTION_DOWN):
                Log.d("onTouchEvent", "action down: " + touchX + ", " + touchY);
                //
                return true;

            case (MotionEvent.ACTION_UP):
                Log.d("onTouchEvent", "action up: " + touchX + ", " + touchY);
                // no vertices...
                // get X and Y, send to DrawPresenter!  Do something with the "up" event

                return true;

            case (MotionEvent.ACTION_MOVE):
                Log.d("onTouchEvent", "action move: " + touchX + ", " + touchY);
                return true;

            default:
                return super.onTouchEvent(event);
        }
    }
}
