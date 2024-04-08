package com.example.finalproject;
import android.os.CountDownTimer;
import android.os.Handler;

import static java.lang.Math.abs;

import static java.lang.Math.PI;

import java.util.LinkedList;
import java.util.Objects;

/** @file MainActivity.java
 *
 *  @course CS2511
 *  @term Fall 2023
 *
 *  The Presenter for the app
 *
 *  @author Will Class
 *
 *  @date 01 Dec 2023
 *
 *  @version 1.0 */
public class Presenter implements GraphInterface.Presenter {
    //The static model object
    private Model theModel;
    private GraphDrawView graphView;


    private GraphInterface.View currentView;

    /** Constructer for the Presenter Object*/
    public Presenter(GraphInterface.View theView) {
        theModel = Model.getInstance();
        currentView = theView;
    }
    /** Creation method for creating a new vertex in the graph and creating a new visualVertex to go with it.
     * @param x the x cord position of this vertex
     * @param y the y cord position of this vertex
     */
    @Override
    public void createVertex(float x, float y) {
        String vertName = "v" + theModel.getVertexTotal();
        theModel.addVertex(vertName);
        VisVertex newVis = new VisVertex(x,y,vertName);
        theModel.addVisVertex(newVis);
    }
    /** Creation method for creating a new edges in the graph and creating a new visualedge to go with it.
     * @param src the source visVertex
     * @param dst the destrination visual vertex
     */
    @Override
    public void createEdge(VisVertex src, VisVertex dst) {
        VisEdge newVisEdge = new VisEdge(src,dst);
        if ((!theModel.containsEdge(src.getLabel(), dst.getLabel()))) {
            theModel.addEdge(src.getLabel(), dst.getLabel());
            theModel.addEdge(dst.getLabel(), src.getLabel());
            theModel.addVisEdge(newVisEdge);
        }
    }

    /** Getter method for VisVert list
     *
     * @return The Linked list of VisVert
     */
    public LinkedList<VisVertex> getVisVertList(){
        return theModel.getVisVertList();
    }

    /** Getter method for VisEdge list
     *
     * @return The Linked list of VisEdge
     */
    public LinkedList<VisEdge> getVisEdgeList(){
        return theModel.getVisEdgeList();
    }

    /** Checker methoad to see if a Edge exists by sending in two labels.
     * @param srcLabel the source label.
     *
     * @param dstLabel the destrination label.
     *
     * @return True or false depending on if edge exists.
     */
    public boolean checkForEdge(String srcLabel, String dstLabel) {
        return theModel.containsEdge(srcLabel, dstLabel);
    }
    /** Getter method to call and return DFS algorithm
     *
     * @return LinkedList of transversed vertices.
     */
    @Override
    public LinkedList<Vertex> depthFirstSearch() {
        LinkedList<Vertex> transList = theModel.depthSearch();
        return transList;
    }
    /** Getter method to call and return BFS algorithm
     *
     * @return LinkedList of transversed vertices.
     */
    @Override
    public LinkedList<Vertex> breathFirstSearch() {
        LinkedList<Vertex> transList = theModel.breathSearch();
        return transList;

    }
}


