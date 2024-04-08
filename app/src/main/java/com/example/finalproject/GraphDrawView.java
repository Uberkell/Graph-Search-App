package com.example.finalproject;
/** @file GraphDrawView.java
 *
 *  @course CS2511
 *  @term Fall 2023
 *
 *  The view file for the GraphDraw activity
 *
 *  @author Will Class
 *
 *  @date 08 Dec 2023
 *
 *  @version 1.0 */
import android.animation.ValueAnimator;


import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;

import java.util.LinkedList;
import java.util.Objects;

public class GraphDrawView extends View implements GraphInterface.View {


    private boolean edgeCreation = false;
    private VisVertex startVisVert = new VisVertex(0.0f, 0.0f, "start");

    public GraphDrawView(Context context, @Nullable AttributeSet attrs) {

        super(context, attrs);

    }

    GraphInterface.Presenter p = new Presenter(this);

    @Override
    protected void onDraw(Canvas canvas) {
        LinkedList<VisVertex> visVert = p.getVisVertList();
        LinkedList<VisEdge> visEdge = p.getVisEdgeList();
        drawVertex(canvas, visVert);
        drawEdge(canvas, visEdge);

        //Bellow is for the top header for the top header button background
        Paint p = new Paint();
        float width = getWidth();
        float height = getHeight();
        p.setColor(getResources().getColor(R.color.umdmaroon));
        canvas.drawRect(0.0f, 0.0f, width, 150.0f, p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float touchX = event.getX();
        float touchY = event.getY();

        int action = event.getActionMasked();
        switch (action) {

            case (MotionEvent.ACTION_DOWN):
                Log.d("onTouchEvent", "action down: " + touchX + ", " + touchY);
                return true;

            case (MotionEvent.ACTION_UP):
                Log.d("onTouchEvent", "action up: " + touchX + ", " + touchY);
                resetVert();
                if (isInScreen(touchX, touchY) == false) {
                    edgeCreation = false;
                    return false;
                }
                if (distanceCheck(touchX, touchY, 15.0f) == false) {
                    p.createVertex(touchX, touchY);
                    edgeCreation = false;
                    invalidate();
                    return true;
                }
                if (distanceCheck(touchX, touchY, 7.0f) == true) {
                    if (edgeCreation == true && (startVisVert.getLabel() != getClosestVis(touchX, touchY, 7.0f).getLabel())) {
                        p.createEdge(startVisVert, getClosestVis(touchX, touchY, 7.0f));
                        edgeCreation = false;
                    } else {
                        edgeCreation = true;
                        startVisVert = getClosestVis(touchX, touchY, 7.0f);
                        invalidate();
                        return true;
                    }
                }

                invalidate();
                edgeCreation = false;
                return true;

            case (MotionEvent.ACTION_MOVE):
                Log.d("onTouchEvent", "action move: " + touchX + ", " + touchY);
                return true;

            default:
                return super.onTouchEvent(event);
        }
    }//need to create touch events to call functions to create edges and vertexs

    @Override
    public void showVertices(Canvas canvis) {

    }
    /** draw method for VisVertices
     *
     * @param canvas the current canvis
     *
     * @param vis The linked list of visVertexs
     *
     **/
    @Override
    public void drawVertex(Canvas canvas, LinkedList<VisVertex> vis) {
        Paint p = new Paint();
        //p.setColor(getResources().getColor(R.color.umdmaroon));
        //p.setColor(Color.parseColor("#800000"));
        float tempx;
        float tempy;
        for (VisVertex v : vis) {
            System.out.println(v.getColor());
            p.setColor(Color.parseColor(v.getColor()));
            tempx = v.getX();
            tempy = v.getY();
            canvas.drawCircle(tempx, tempy, 20.0f, p);
        }
        if (edgeCreation) {
            p.setColor(Color.parseColor("#ffcc33"));
            tempx = startVisVert.getX();
            tempy = startVisVert.getY();
            canvas.drawCircle(tempx, tempy, 20.0f, p);

        }
        //canvas.drawCircle(touchX, touchY, 50.0f, p);
        //for all vertexs, in vertex canvas.drawCircle(vert.getX(), vert.getY(), 50.0f, p);
    }

    /** draw method for VisEdges
     *
     * @param canvas the current canvis
     *
     * @param edgeList The linked list of visVertexs
     *
     **/
    @Override
    public void drawEdge(Canvas canvas, LinkedList<VisEdge> edgeList) {
        Paint p = new Paint();
        p.setStrokeWidth(5f);
        p.setStyle(Paint.Style.STROKE);
        //p.setColor(getResources().getColor(R.color.umdmaroon));
        float tempSrcX;
        float tempSrcY;
        float tempDstX;
        float tempDstY;
        for (VisEdge edge : edgeList) {
            p.setColor(Color.parseColor(edge.getColor()));
            //System.out.println(edge);
            tempSrcX = edge.getSrcX();
            tempSrcY = edge.getSrcY();
            tempDstX = edge.getDstX();
            tempDstY = edge.getDstY();
            canvas.drawLine(tempSrcX, tempSrcY, tempDstX, tempDstY, p);
        }
    }

    /** Checker method to see nearby Vertices
     *
     * @param newX the x coordinate you want to check
     *
     * @param newY the y coordinate you want to check
     *
     * @param bound the float boundry number
     **/
    public boolean distanceCheck(float newX, float newY, float bound) {
        LinkedList<VisVertex> visList = p.getVisVertList();
        for (VisVertex v : visList) {
            float pointDistance = (float) sqrt(((2 * abs(newX - v.getX())) + (2 * abs(newY - v.getY()))));
            if (pointDistance <= bound) {
                return true;
            }
        }
        return false;
    }

    /** Getter method for returning nearest VisVertex
     *
     * @param curX the x coordinate you want to check
     *
     * @param curY the y coordinate you want to check
     *
     * @param boundary the float boundary number
     *
     * @return the nearest VisVertex
     **/
    public VisVertex getClosestVis(float curX, float curY, float boundary) {
        LinkedList<VisVertex> visList = p.getVisVertList();
        for (VisVertex v : visList) {
            //System.out.println(v.getLabel());
            float pointDistance = (float) sqrt(((2 * abs(curX - v.getX())) + (2 * abs(curY - v.getY()))));
            if (pointDistance <= boundary) {
                return v;
            }
        }
        return visList.getLast();
    }

    /** Getter method for returning nearest VisVertex
     *
     * @param curX the x coordinate you want to check
     *
     * @param curY the y coordinate you want to check
     *
     * @return true or false cords are within screen boundarys
     **/
    public boolean isInScreen(float curX, float curY) {
        if ((curY <= 181.0f) || (curY >= 2065.0f) || (curX <= 35.0f) || (curX >= 1048.0f)) { // would normally need to get screen boundary's
            return false;
        }
        return true;
    }

    /**  Calling method for starting a breath first search and pushing the results to the screen
     *
     **/
    public void startBreathFirstSearch() {
        LinkedList<Vertex> theList = p.breathFirstSearch();
        int i = 0;
        final Handler handler = new Handler();
        for (Vertex vert : theList) {
            for (VisVertex v : p.getVisVertList()) {
                if (Objects.equals(vert.getLabel(), v.getLabel())) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startColorAnimation(v);
                        }
                    }, i * 2000);
                }
            }
            i++;
        }

    }


    /**  Calling method for starting a depth first search and pushing the results to the screen
     *
     **/
    public void startDepthFirstSearch() {
        LinkedList<Vertex> theList = p.depthFirstSearch();
        int i = 0;
        final Handler handler = new Handler();
        for (Vertex vert : theList) {
            for (VisVertex v : p.getVisVertList()) {
                if (Objects.equals(vert.getLabel(), v.getLabel())) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startColorAnimation(v);
                        }
                    }, i * 2000);
                }
            }
            i++;
        }

    }

    /** Method that plays a color change animation for a given visVertex
     *
     * @param ve the VisVertex that will change
     **/
public void startColorAnimation(VisVertex ve) {
    // Use the current color of the VisVertex as the starting color
    int startColor = Color.parseColor(ve.getColor());

    ValueAnimator colorAnimator = ValueAnimator.ofArgb(startColor, Color.parseColor("#ffcc33"));
    colorAnimator.setDuration(1000);
    colorAnimator.setInterpolator(new LinearInterpolator());

    colorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator animator) {
            ve.setColor(String.format("#%06X", (0xFFFFFF & ((int) animator.getAnimatedValue()))));
            invalidate();
        }
    });

    colorAnimator.start();
}

    /** Accessor method for refreshing the screen
     *
     **/
    public void callInvalidate() {
        invalidate();
    }

    /** Setter method for resetting vertices colors after an animation
     *
     **/
    public void resetVert() {
        for (VisVertex vis: p.getVisVertList()) {
            vis.setColor("#800000");
            System.out.println(vis.getColor());
        }
        invalidate();
    }

}
