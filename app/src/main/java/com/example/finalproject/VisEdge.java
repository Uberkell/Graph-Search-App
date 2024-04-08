package com.example.finalproject;
/** @file VisEdge.java
 *
 *  @course CS2511
 *  @term Fall 2023
 *
 *  An extended edge class that can store x and y coordinates
 *
 *  @author Will Class
 *
 *  @date 08 Dec 2023
 *
 *  @version 1.0 */
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;

import androidx.core.content.ContextCompat;

public class VisEdge extends Edge{

    private VisVertex src;
    private VisVertex dst;
    private float srcX;
    private float srcY;
    private float dstX;
    private float dstY;

    private String color;

    private VisEdge(){
    }
    /** constructor for VisEdge object, defualt is private **/
    public VisEdge (VisVertex v1, VisVertex v2) {
        src = v1;
        dst = v2;
        srcX = src.getX();
        srcY = src.getY();
        dstX = dst.getX();
        dstY = dst.getY();
        color = "#800000";
    }

    /** Getter function for returning stored source x cord
     *
     * @return the x coordinate
     */
    public float getSrcX(){
        return srcX;
    }

    /** Getter function for returning stored source y cord
     *
     * @return the y coordinate
     */
    public float getSrcY(){
        return srcY;
    }

    /** Getter function for returning stored destination x cord
     *
     * @return the x coordinate
     */
    public float getDstX(){
        return dstX;
    }

    /** Getter function for returning stored destination y cord
     *
     * @return the y coordinate
     */
    public float getDstY(){
        return dstY;
    }

    /** Getter function for returning stored color string
     *
     * @return the hex color value
     */
    public String getColor() {
        return color;
    }

    /** Setter function for changing stored color string
     *
     * @param newColor the hex string of the new color
     */
    public void setColor (String newColor) {color = newColor;}


}
