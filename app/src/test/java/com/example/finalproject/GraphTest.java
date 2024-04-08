package com.example.finalproject;
/** @file GraphTest.java
 *
 *  @course CS2511
 *  @term Fall 2023
 *
 *  Testing file for graph related tests
 *
 *  @author Peter Willemson
 *  @author Will Class
 *
 *  @date 04 Nov 2023
 *
 *  @version 1.0 */
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {

    private Graph testGraph;

    /**
     * Test of an instantiation of a graph object
     */
    public GraphTest() {
        testGraph = new Graph();
    }

    /**
     * Test of an instantiation of vertex objects
     */
    @org.junit.Test
    public void testVertexCreation() {
        Graph g = new Graph();
        int numVertices = g.getNumVertices();
        assertEquals(0, numVertices);

        Vertex v0 = new Vertex("v0");
        g.addVertex(v0);
        numVertices = g.getNumVertices();
        assertEquals(1, numVertices);

        Vertex v1 = new Vertex("v1");
        g.addVertex(v1);
        numVertices = g.getNumVertices();
        assertEquals(2, numVertices);
    }

    /**
     * Test of an instantiation of edge objects
     */
    @org.junit.Test
    public void testEdgeCreation() {
        Graph g = new Graph();
        int numEdges = g.getNumEdges();
        assertEquals(0, numEdges);

        Vertex v0 = new Vertex();
        g.addVertex(v0);

        Vertex v1 = new Vertex();
        g.addVertex(v1);

        g.addEdge(v0, v1);
        numEdges = g.getNumEdges();
        assertEquals(1, numEdges);

        // make the graph undirected for this edge and add the
        // the opposite direction
        g.addEdge(v1, v0);
        numEdges = g.getNumEdges();
        assertEquals(2, numEdges);

        // Now, add a self loop for v0
        g.addEdge(v0, v0);
        numEdges = g.getNumEdges();
        assertEquals(3, numEdges);
    }

    /**
     * Accessor test to see if vertex labels and edge weights are stored in hashmap
     */
    @org.junit.Test
    public void testLabelsAndWeights() {
        Graph g = new Graph();
        Vertex v0 = new Vertex("v0");
        g.addVertex(v0);
        Vertex v1 = new Vertex("v1");
        g.addVertex(v1);
        g.addEdge(v0, v1, 14.22f);
        assertEquals(true, g.containsLabel("v0"));
        assertEquals(true, g.containsWeight(14.22f));
    }

    /**
     * Structure test to see if printGraph method works and outputs correctly
     */
    @org.junit.Test
    public void testAdjStructure() {
        Graph g = new Graph();
        Vertex v0 = new Vertex("v0");
        g.addVertex(v0);
        Vertex v1 = new Vertex("v1");
        g.addVertex(v1);
        Vertex v2 = new Vertex("v2");
        g.addVertex(v2);
        Vertex v3 = new Vertex("v3");
        g.addVertex(v3);
        Vertex v4 = new Vertex("v4");
        g.addVertex(v4);
        Vertex v5 = new Vertex("v5");
        g.addVertex(v5);
        g.addEdge(v0, v1);
        g.addEdge(v0, v2);
        g.addEdge(v1, v2);
        g.addEdge(v1, v1);
        g.addEdge(v2, v3);
        g.addEdge(v2, v4);
        g.addEdge(v2, v1);
        g.addEdge(v2, v5);
        g.addEdge(v2, v0);
        g.addEdge(v4, v0);
        g.addEdge(v5, v1);
        g.addEdge(v5, v3);
        g.addEdge(v3, v5);
        g.printChart();
    }

    @org.junit.Test
    public void DFTestS1() {
        LinkedList<Vertex> ansList = new LinkedList<>();

        Graph g = new Graph();
        Vertex v0 = new Vertex("v0");
        g.addVertex(v0);
        Vertex v1 = new Vertex("v1");
        g.addVertex(v1);
        Vertex v2 = new Vertex("v2");
        g.addVertex(v2);
        Vertex v3 = new Vertex("v3");
        g.addVertex(v3);
        Vertex v4 = new Vertex("v4");
        g.addVertex(v4);

        ansList.add(v0);
        ansList.add(v1);
        ansList.add(v2);
        ansList.add(v3);
        ansList.add(v1);

        g.addBiEdge(v0, v1);
        g.addBiEdge(v0, v3);
        g.addBiEdge(v1, v2);
        g.addBiEdge(v3, v4);
        g.printChart();
        DFTrans deep = new DFTrans(g);
        deep.transverse(v0);
        deep.getTransOrder();
        assertEquals(true, deep.linkedListComp(ansList));
    }

    @org.junit.Test
    public void BFTestS1() {
        LinkedList<Vertex> ansList = new LinkedList<>();
        Graph g = new Graph();
        Vertex v0 = new Vertex("v0");
        g.addVertex(v0);
        Vertex v1 = new Vertex("v1");
        g.addVertex(v1);
        Vertex v2 = new Vertex("v2");
        g.addVertex(v2);
        Vertex v3 = new Vertex("v3");
        g.addVertex(v3);
        Vertex v4 = new Vertex("v4");
        g.addVertex(v4);

        ansList.add(v0);
        ansList.add(v1);
        ansList.add(v3);
        ansList.add(v2);
        ansList.add(v4);

        g.addBiEdge(v0, v1);
        g.addBiEdge(v0, v3);
        g.addBiEdge(v1, v2);
        g.addBiEdge(v3, v4);
        g.printChart();
        BFTrans bread = new BFTrans(g);
        bread.transverse(v0);
        bread.getTransOrder();
        assertEquals(true, bread.linkedListComp(ansList));
    }


    @org.junit.Test
    public void DFTestS2() {
        LinkedList<Vertex> ansList = new LinkedList<>();
        Graph g = new Graph();
        Vertex v0 = new Vertex("v0");
        g.addVertex(v0);
        Vertex v1 = new Vertex("v1");
        g.addVertex(v1);
        Vertex v2 = new Vertex("v2");
        g.addVertex(v2);
        Vertex v3 = new Vertex("v3");
        g.addVertex(v3);
        Vertex v4 = new Vertex("v4");
        g.addVertex(v4);
        Vertex v5 = new Vertex("v5");
        g.addVertex(v5);
        Vertex v6 = new Vertex("v6");
        g.addVertex(v6);

        ansList.add(v0);
        ansList.add(v1);
        ansList.add(v3);
        ansList.add(v4);
        ansList.add(v2);
        ansList.add(v5);
        ansList.add(v6);


        g.addEdge(v0, v1);
        g.addEdge(v0, v2);
        g.addEdge(v1, v3);
        g.addEdge(v1, v4);
        g.addEdge(v2, v5);
        g.addEdge(v2, v6);
        g.printChart();

        DFTrans deep = new DFTrans(g);
        deep.transverse(v0);
        deep.getTransOrder();
        assertEquals(true, deep.linkedListComp(ansList));
    }

    @org.junit.Test
    public void BFTestS2() {
        LinkedList<Vertex> ansList = new LinkedList<>();
        Graph g = new Graph();
        Vertex v0 = new Vertex("v0");
        g.addVertex(v0);
        Vertex v1 = new Vertex("v1");
        g.addVertex(v1);
        Vertex v2 = new Vertex("v2");
        g.addVertex(v2);
        Vertex v3 = new Vertex("v3");
        g.addVertex(v3);
        Vertex v4 = new Vertex("v4");
        g.addVertex(v4);
        Vertex v5 = new Vertex("v5");
        g.addVertex(v5);
        Vertex v6 = new Vertex("v6");
        g.addVertex(v6);

        ansList.add(v0);
        ansList.add(v1);
        ansList.add(v2);
        ansList.add(v3);
        ansList.add(v4);
        ansList.add(v5);
        ansList.add(v6);

        g.addEdge(v0, v1);
        g.addEdge(v0, v2);
        g.addEdge(v1, v3);
        g.addEdge(v1, v4);
        g.addEdge(v2, v5);
        g.addEdge(v2, v6);
        g.printChart();

        BFTrans bread = new BFTrans(g);
        bread.transverse(v0);
        bread.getTransOrder();
        assertEquals(true, bread.linkedListComp(ansList));
    }

    @org.junit.Test
    public void DFTestC1() {
        LinkedList<Vertex> ansList = new LinkedList<>();
        Graph g = new Graph();
        Vertex v0 = new Vertex("v0");
        g.addVertex(v0);
        Vertex v1 = new Vertex("v1");
        g.addVertex(v1);
        Vertex v2 = new Vertex("v2");
        g.addVertex(v2);
        Vertex v3 = new Vertex("v3");
        g.addVertex(v3);
        Vertex v4 = new Vertex("v4");
        g.addVertex(v4);
        Vertex v5 = new Vertex("v5");
        g.addVertex(v5);
        Vertex v6 = new Vertex("v6");
        g.addVertex(v6);
        Vertex v7 = new Vertex("v7");
        g.addVertex(v7);

        ansList.add(v0);
        ansList.add(v3);
        ansList.add(v1);
        ansList.add(v2);
        ansList.add(v6);
        ansList.add(v7);
        ansList.add(v4);
        ansList.add(v5);

        g.addEdge(v0, v3);
        g.addEdge(v3, v1);
        g.addEdge(v1, v3);
        g.addEdge(v3, v2);
        g.addEdge(v3, v4);
        g.addEdge(v2, v0);
        g.addEdge(v4, v5);
        g.addEdge(v5, v4);
        g.addEdge(v2, v6);
        g.addEdge(v2, v7);
        g.printChart();

        DFTrans deep = new DFTrans(g);
        deep.transverse(v0);
        deep.getTransOrder();
        assertEquals(true, deep.linkedListComp(ansList));
    }

    @org.junit.Test
    public void BFTestC1() {
        LinkedList<Vertex> ansList = new LinkedList<>();
        Graph g = new Graph();
        Vertex v0 = new Vertex("v0");
        g.addVertex(v0);
        Vertex v1 = new Vertex("v1");
        g.addVertex(v1);
        Vertex v2 = new Vertex("v2");
        g.addVertex(v2);
        Vertex v3 = new Vertex("v3");
        g.addVertex(v3);
        Vertex v4 = new Vertex("v4");
        g.addVertex(v4);
        Vertex v5 = new Vertex("v5");
        g.addVertex(v5);
        Vertex v6 = new Vertex("v6");
        g.addVertex(v6);
        Vertex v7 = new Vertex("v7");
        g.addVertex(v7);

        ansList.add(v0);
        ansList.add(v3);
        ansList.add(v1);
        ansList.add(v2);
        ansList.add(v4);
        ansList.add(v6);
        ansList.add(v7);
        ansList.add(v5);

        g.addEdge(v0, v3);
        g.addEdge(v3, v1);
        g.addEdge(v1, v3);
        g.addEdge(v3, v2);
        g.addEdge(v3, v4);
        g.addEdge(v2, v0);
        g.addEdge(v4, v5);
        g.addEdge(v5, v4);
        g.addEdge(v2, v6);
        g.addEdge(v2, v7);
        g.printChart();

        BFTrans bread = new BFTrans(g);
        bread.transverse(v0);
        bread.getTransOrder();
        assertEquals(true, bread.linkedListComp(ansList));
    }

    @org.junit.Test
    public void DFTestC2() {
        LinkedList<Vertex> ansList = new LinkedList<>();
        Graph g = new Graph();
        Vertex v0 = new Vertex("v0");
        g.addVertex(v0);
        Vertex v1 = new Vertex("v1");
        g.addVertex(v1);
        Vertex v2 = new Vertex("v2");
        g.addVertex(v2);
        Vertex v3 = new Vertex("v3");
        g.addVertex(v3);
        Vertex v4 = new Vertex("v4");
        g.addVertex(v4);
        Vertex v5 = new Vertex("v5");
        g.addVertex(v5);
        Vertex v6 = new Vertex("v6");
        g.addVertex(v6);

        ansList.add(v2);
        ansList.add(v0);
        ansList.add(v1);
        ansList.add(v3);
        ansList.add(v5);
        ansList.add(v6);
        ansList.add(v4);

        g.addBiEdge(v0, v1);
        g.addBiEdge(v2, v0);
        g.addBiEdge(v2, v3);
        g.addBiEdge(v2, v4);
        g.addBiEdge(v3, v5);
        g.addBiEdge(v3, v6);
        g.addBiEdge(v4, v6);

        g.printChart();

        DFTrans deep = new DFTrans(g);
        deep.transverse(v2);
        deep.getTransOrder();
        assertEquals(true, deep.linkedListComp(ansList));
    }

    @org.junit.Test
    public void BFTestC2() {
        LinkedList<Vertex> ansList = new LinkedList<>();
        Graph g = new Graph();
        Vertex v0 = new Vertex("v0");
        g.addVertex(v0);
        Vertex v1 = new Vertex("v1");
        g.addVertex(v1);
        Vertex v2 = new Vertex("v2");
        g.addVertex(v2);
        Vertex v3 = new Vertex("v3");
        g.addVertex(v3);
        Vertex v4 = new Vertex("v4");
        g.addVertex(v4);
        Vertex v5 = new Vertex("v5");
        g.addVertex(v5);
        Vertex v6 = new Vertex("v6");
        g.addVertex(v6);

        ansList.add(v2);
        ansList.add(v0);
        ansList.add(v3);
        ansList.add(v4);
        ansList.add(v1);
        ansList.add(v5);
        ansList.add(v6);

        g.addBiEdge(v0, v1);
        g.addBiEdge(v2, v0);
        g.addBiEdge(v2, v3);
        g.addBiEdge(v2, v4);
        g.addBiEdge(v3, v5);
        g.addBiEdge(v3, v6);
        g.addBiEdge(v4, v6);

        g.printChart();

        BFTrans bread = new BFTrans(g);
        bread.transverse(v2);
        bread.getTransOrder();
        assertEquals(true, bread.linkedListComp(ansList));
    }

    @org.junit.Test
    public void DFTestC3() {
        LinkedList<Vertex> ansList = new LinkedList<>();
        Graph g = new Graph();
        Vertex v0 = new Vertex("v0");
        g.addVertex(v0);
        Vertex v1 = new Vertex("v1");
        g.addVertex(v1);
        Vertex v2 = new Vertex("v2");
        g.addVertex(v2);
        Vertex v3 = new Vertex("v3");
        g.addVertex(v3);
        Vertex v4 = new Vertex("v4");
        g.addVertex(v4);
        Vertex v5 = new Vertex("v5");
        g.addVertex(v5);
        Vertex v6 = new Vertex("v6");
        g.addVertex(v6);
        Vertex v7 = new Vertex("v7");
        g.addVertex(v7);
        Vertex v8 = new Vertex("v8");
        g.addVertex(v8);
        Vertex v9 = new Vertex("v9");
        g.addVertex(v9);
        Vertex v10 = new Vertex("v10");
        g.addVertex(v10);

        ansList.add(v10);
        ansList.add(v3);
        ansList.add(v0);
        ansList.add(v1);
        ansList.add(v4);
        ansList.add(v2);
        ansList.add(v7);
        ansList.add(v5);
        ansList.add(v8);
        ansList.add(v6);
        ansList.add(v9);

        g.addBiEdge(v0, v1);
        g.addBiEdge(v0, v2);
        g.addBiEdge(v0, v3);
        g.addBiEdge(v1, v4);
        g.addBiEdge(v1, v7);
        g.addBiEdge(v1, v4);
        g.addBiEdge(v2, v4);
        g.addBiEdge(v3, v5);
        g.addBiEdge(v3, v6);
        g.addBiEdge(v3, v10);
        g.addBiEdge(v5, v7);
        g.addBiEdge(v5, v8);
        g.addBiEdge(v5, v9);
        g.addBiEdge(v5, v10);
        g.addBiEdge(v6, v8);
        g.addBiEdge(v6, v9);
        g.addBiEdge(v6, v10);
        g.addBiEdge(v8, v10);
        g.printChart();

        DFTrans deep = new DFTrans(g);
        deep.transverse(v10);
        deep.getTransOrder();
        assertEquals(true, deep.linkedListComp(ansList));
    }


    @org.junit.Test
    public void BFTestC3() {
        LinkedList<Vertex> ansList = new LinkedList<>();
        Graph g = new Graph();
        Vertex v0 = new Vertex("v0");
        g.addVertex(v0);
        Vertex v1 = new Vertex("v1");
        g.addVertex(v1);
        Vertex v2 = new Vertex("v2");
        g.addVertex(v2);
        Vertex v3 = new Vertex("v3");
        g.addVertex(v3);
        Vertex v4 = new Vertex("v4");
        g.addVertex(v4);
        Vertex v5 = new Vertex("v5");
        g.addVertex(v5);
        Vertex v6 = new Vertex("v6");
        g.addVertex(v6);
        Vertex v7 = new Vertex("v7");
        g.addVertex(v7);
        Vertex v8 = new Vertex("v8");
        g.addVertex(v8);
        Vertex v9 = new Vertex("v9");
        g.addVertex(v9);
        Vertex v10 = new Vertex("v10");
        g.addVertex(v10);

        ansList.add(v10);
        ansList.add(v3);
        ansList.add(v5);
        ansList.add(v6);
        ansList.add(v8);
        ansList.add(v0);
        ansList.add(v1);
        ansList.add(v2);
        ansList.add(v4);
        ansList.add(v7);
        ansList.add(v9);

        g.addBiEdge(v0, v1);
        g.addBiEdge(v0, v2);
        g.addBiEdge(v0, v3);
        g.addBiEdge(v1, v4);
        g.addBiEdge(v1, v7);
        g.addBiEdge(v1, v4);
        g.addBiEdge(v2, v4);
        g.addBiEdge(v3, v5);
        g.addBiEdge(v3, v6);
        g.addBiEdge(v3, v10);
        g.addBiEdge(v5, v7);
        g.addBiEdge(v5, v8);
        g.addBiEdge(v5, v9);
        g.addBiEdge(v5, v10);
        g.addBiEdge(v6, v8);
        g.addBiEdge(v6, v9);
        g.addBiEdge(v6, v10);
        g.addBiEdge(v8, v10);
        g.printChart();

        BFTrans bread = new BFTrans(g);
        bread.transverse(v10);
        bread.getTransOrder();
        assertEquals(true, bread.linkedListComp(ansList));
    }
}