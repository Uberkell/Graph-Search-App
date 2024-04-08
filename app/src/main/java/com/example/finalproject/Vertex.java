package com.example.finalproject;

/** @file Vertex.java
 *
 *  @course CS2511
 *  @term Fall 2023
 *
 *  The source file for the vertex object
 *
 *  @author Peter Willemson
 *  @author Will Class
 *
 *  @date 04 Nov 2023
 *
 *  @version 1.0 */
public class Vertex {
    private boolean visitStatus;
    private String vLabel;
    /** Public constructor without given label */

    protected Vertex() {
        vLabel = "Unassigned";
    }

    /** Public constructor with label
     * @param label the label you would like to name
     */
    public Vertex(String label) {
        vLabel = label;
        visitStatus = false;
    }

    /** Getter method for label value
     *
     * @return string vLabel
     */
    public String getLabel() {
        return vLabel;
    }

    /** Setter method for label value
     *
     * @param label The string label you want
     */
    public void setVLabel(String label) {
        vLabel = label;
    }

    /** Setter method for visitation status
     *
     * @param status true or false value of visitation status
     */
    public void setVisitStatus(Boolean status) {
        visitStatus = status;
    }

    /** Getter method for visitation status
     *
     * @return the true or false status of this vertex.
     */
    public Boolean getVisitStatus() {
        return visitStatus;
    }
}
