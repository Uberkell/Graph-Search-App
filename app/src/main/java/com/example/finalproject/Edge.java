package com.example.finalproject;

/** @file Edge.java
 *
 *  @course CS2511
 *  @term Fall 2023
 *
 *  Source file for the edge object type
 *
 *  @author Peter Willemson
 *  @author Will Class
 *
 *  @date 04 Nov 2023
 *
 *  @version 1.0 */
public class Edge {

    private final Vertex src;
    private final Vertex dst;
    private float weight;
    final float DEFAULT_WEIGHT = 1.0f;


    protected Edge() {
        src = null;
        dst = null;
        weight = 0.0f;
    }

    /** Public constructor without weight
     * @param s source vertex
     * @param d destination vertex
     */
    public Edge(Vertex s, Vertex d) {
        src = s;
        dst = d;
        weight = DEFAULT_WEIGHT;
    }
    /** Public constructor with weight
     * @param s source vertex
     * @param d destination vertex
     * @param wt weight of edge
     */
    public Edge(Vertex s, Vertex d, float wt) {
        src = s;
        dst = d;
        weight = wt;
    }

    /** getter for private weight varribe
     *
     * @return the float weight varrible
     */
    public float getWeight() {
        return weight;
    }
    /** getter for private source varribe
     *
     * @return the src vertex
     */
    public Vertex getSrc() {
        return src;
    }
    /** getter for private destination varribe
     *
     * @return the dst vertex
     */
    public Vertex getDst() {
        return dst;
    }

}

