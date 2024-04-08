package com.example.finalproject;
/** @file VisVertex.java
 *
 *  @course CS2511
 *  @term Fall 2023
 *
 *  An extended vertex class that can store x and y coordinates
 *
 *  @author Will Class
 *
 *  @date 08 Dec 2023
 *
 *  @version 1.0 */
public class VisVertex extends Vertex{
    private float x;
    private float y;
    private String color;
    private VisVertex() {

    }
    /** constructor for VisVertex object, defualt is private **/
 public VisVertex (float newX, float newY, String theLabel) {
     x= newX;
     y= newY;
     setVLabel(theLabel);
     color = "#800000";
 }
    /** Getter function for returning stored x cord
     *
     * @return the x coordinate
     */
 public float getX(){return x;}

    /** Getter function for returning stored y cord
     *
     * @return the y coordinate
     */
 public float getY(){return y;}

    /** Getter function for returning stored color string
     *
     * @return the hex color value
     */
 public String getColor() {return color;}

    /** Setter function for changing stored color string
     *
     * @param newColor the hex string of the new color
     */
public void setColor (String newColor) {color = newColor;}

}
