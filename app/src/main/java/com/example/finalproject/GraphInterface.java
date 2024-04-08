package com.example.finalproject;

import android.graphics.Canvas;

import java.util.LinkedList;

/** @file GraphInterface.java
 *
 *  @course CS2511
 *  @term Fall 2023
 *
 *  The interface for the whole MVP contract
 *
 *  @author Will Class
 *
 *  @date 01 Dec 2023
 *
 *  @version 1.0 */
public interface GraphInterface {

    interface Presenter {
    void createVertex(float x, float y);

    void createEdge(VisVertex src, VisVertex dst);


        LinkedList<VisVertex> getVisVertList();
        LinkedList<VisEdge> getVisEdgeList();
        public boolean checkForEdge(String srcLabel, String dstLabel);

        LinkedList<Vertex> depthFirstSearch();
        LinkedList<Vertex> breathFirstSearch();
    }

    interface View {
    void showVertices(Canvas canvas);
    void drawVertex(Canvas canvas, LinkedList<VisVertex> v);
    void drawEdge(Canvas canvas, LinkedList<VisEdge> edgeList);

    void callInvalidate();

    }
    interface View2 {

    }
}
