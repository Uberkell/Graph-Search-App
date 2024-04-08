package com.example.finalproject;

import java.util.LinkedList;

/** @file Model.java
 *
 *  @course CS2511
 *  @term Fall 2023
 *
 *  The model that contains the graph object and list of visual vertices and edges
 *
 *  @author Will Class
 *
 *  @date 01 Dec 2023
 *
 *  @version 1.0 */
public class Model {
    private LinkedList<VisVertex> visVertList = new LinkedList<VisVertex>();
    private LinkedList<VisEdge> visEdgeList = new LinkedList<VisEdge>();
    // This is the one reference to the graph model
    private static Model theOneInstance;

    //The graph object
    private Graph theGraph;
    //private constructor to ensure only one can be made

    private Model() {
        theGraph = new Graph();
    }
    /** Method for checking and returning for a hashmap */
    public static Model getInstance() {
        if (theOneInstance == null) {
            theOneInstance = new Model();
        }
        return theOneInstance;
    }
    /** Method for adding a new vertex to the graph
     *
     * @param label the string label for the new vertex
     */
    public void addVertex( String label ) {
        Vertex v = new Vertex(label);
        theGraph.addVertex(v);
    }

    /** Method for getting the vertex total
     * @return the current number of vertexes store in the graph
     */
    public int getVertexTotal() {

        return theGraph.getNumVertices();
    }

    /** Method for getting the vertex total
     * @return the current number of vertexes store in the graph
     */
    public int getEdgeTotal() {
        return theGraph.getNumEdges();
    }


    /** Creation method for adding a new edge to the graph
     * @param svt The source vertex
     * @param dvt the destination vertex
     */
    public void addEdge(String svt, String dvt) {
        if (theGraph.containsLabel(svt) && theGraph.containsLabel(dvt)) {
            theGraph.addEdge(theGraph.getVertex(svt),theGraph.getVertex(dvt));
        }
    }
    /** Checker methoad to see if a Edge exists by sending in two labels.
     * @param src the source label.
     *
     * @param dst the destrination label.
     *
     * @return True or false depending on if edge exists.
     */
    public boolean containsEdge(String src, String dst) {
        return theGraph.edgeCheck(src,dst);

    }

    /** Method for adding a new VisVertex to the list
     *
     * @param newVisVert the VisVertex you want to add
     */
    public void addVisVertex(VisVertex newVisVert){
        visVertList.add(newVisVert);
    }

    /** Method for adding a new VisEdge to the list
     *
     * @param newVisEdge the VisEdge you want to add
     */
    public void addVisEdge(VisEdge newVisEdge) {
        visEdgeList.add(newVisEdge);
    }
    /** Getter method for returning the VisVertList
     *
     * @return the VisVertList
     */
    public LinkedList<VisVertex> getVisVertList() {
    return visVertList;
    }

    /** Getter method for returning the VisEdgeList
     *
     * @return the VisEdgeList
     */
    public LinkedList<VisEdge> getVisEdgeList() {
        return visEdgeList;
    }

    /** Creation method to create a DFS and return a linked list of the vertices it checked
     *
     * @return LinkedList of transversed vertices.
     */
    public LinkedList<Vertex> depthSearch() {
        DFTrans deep = new DFTrans(theGraph);
        deep.transverse(theGraph.getVertex("v0"));
        theGraph.vertReset();
        return deep.getTransOrder();
    }

    /** Creation method to create a BFS and return a linked list of the vertices it checked
     *
     * @return LinkedList of transversed vertices.
     */
    public LinkedList<Vertex> breathSearch() {
        BFTrans breath = new BFTrans(theGraph);
        breath.transverse(theGraph.getVertex("v0"));
        theGraph.vertReset();
        return breath.getTransOrder();

    }



}
