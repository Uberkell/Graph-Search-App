package com.example.finalproject;
/** @file BFTrans.java
 *
 *  @course CS2511
 *  @term Fall 2023
 *
 *  Breath First transversal class
 *
 *  @author Will Class
 *
 *  @date 11 Nov 2023
 *
 *  @version 1.0 */
import java.util.LinkedList;
import java.util.Queue;

public class BFTrans implements ITrans {
    private Graph theGraph;
    private LinkedList<Vertex> transOrder = new LinkedList<Vertex>();

    private Queue<Vertex> theQue = new LinkedList<Vertex>();
    /** Constructor for BFTrans class. **/
    BFTrans(Graph g) {
        theGraph= g;
    }
    /** Method preforming a breath first transversal of a graph
     *
     * @pre should only be called once
     * @param v source vertex
     */
    @Override
    public void transverse(Vertex v) {
        //v.setVisitStatus(true);
        theQue.add(v);
        while (!theQue.isEmpty()) {
            Vertex nextV = theQue.remove();
            if (nextV.getVisitStatus() == false) {
                transOrder.add(nextV);
            }
            nextV.setVisitStatus(true);
            LinkedList<Edge> edgeList = theGraph.getEdgeList(nextV);
            if (edgeList != null) {
                for (Edge e : edgeList) {
                    if (e.getDst().getVisitStatus() == false) {
                        theQue.add(e.getDst());
                    }
                }
            }
        }
    }
    /** Getter method for the recorded transversal path
     *
     * @return A linked list of the transversal path taken
     */
    public LinkedList<Vertex> getTransOrder() {
        for (Vertex v : transOrder) {
            System.out.println(v.getLabel());
        }
        return transOrder;
    }
    /** Comparison method
     * @pre Transversal must be ran at least once
     *
     * @param compList a linked list of vertices that you want to compair with
     *
     * @return A linked list of the transversal path taken
     */
    public Boolean linkedListComp(LinkedList<Vertex> compList) {
        Boolean isSame = true;
        if (compList.size() == transOrder.size()) {
            for (int i =0; i <transOrder.size() ; i++) {
                if (compList.getFirst() != transOrder.getFirst() ){
                    isSame = false;
                }
                compList.pop();
                transOrder.pop();
            }
            return isSame;
        }
        else {
            isSame = false;
            return isSame;
        }
    }

    /** Getter meathod for returning curent graph structure
     *
     * @return The current graph object
     */
    public Graph getTheGraph() {
        return theGraph;
    }

}