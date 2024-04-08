package com.example.finalproject;
/** @file Graph.java
 *
 *  @course CS2511
 *  @term Fall 2023
 *
 *  The file that contains all graph related information and methods
 *
 *  @author Peter Willemson
 *  @author Will Class
 *
 *  @date 04 Nov 2023
 *
 *  @version 1.0 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

public class Graph {

    private HashMap<Vertex, LinkedList<Edge>> m_adjacencyList;

    /** Public constructor for a new graph object */
    public Graph() {
        m_adjacencyList = new HashMap<Vertex, LinkedList<Edge>>(1024);
    }

    //Copy constructor
    public Graph(Graph oldGraph) {

        this.m_adjacencyList = new HashMap<>(oldGraph.m_adjacencyList);
    }

    /** Method for returning the total amount of vertices within the hashmap
     *
     * @return the int sum of all the vertices
     */
    public int getNumVertices() {
        return m_adjacencyList.size();
    }

    /** Method for returning the total amount of edges within the hashmap
     *
     * @return the int sum of all the edges
     */
    public int getNumEdges() {
        int edgeSum = 0;

        for (HashMap.Entry<Vertex, LinkedList<Edge>> hEntry : m_adjacencyList.entrySet()) {

            //Vertex vertexKey = hEntry.getKey();  // not needed

            LinkedList<Edge> edgeList = hEntry.getValue();

            edgeSum += edgeList.size();
        }

        return edgeSum;
    }

    /** Method for adding a new vertex to the hashmap
     *
     * @param v the vertex being added
     */
    public void addVertex(Vertex v) {
        if (m_adjacencyList.containsKey(v) == false) {
            m_adjacencyList.put(v, new LinkedList<Edge>());
        }
    }

    /** Method for adding an edge without weight to a vertex in hashmap
     *
     * @param src source vertex
     * @param dst destination vertex
     */
    public void addEdge(Vertex src, Vertex dst) {
        if (m_adjacencyList.containsKey(src)) {
            LinkedList<Edge> edgeList = m_adjacencyList.get(src);
            edgeList.add(new Edge(src, dst));
        }
    }

    /** Method for adding an edge with weight to a vertex in hashmap
     *
     * @param src source vertex
     * @param dst destination vertex
     * @param wt weight float
     */
    public void addEdge(Vertex src, Vertex dst, float wt) {
        if (m_adjacencyList.containsKey(src)) {
            LinkedList<Edge> edgeList = m_adjacencyList.get(src);
            edgeList.add(new Edge(src, dst, wt));
        }
    }

    /** Method for checking if a weight value exists within a hashmap
     *
     * @param s the given string label
     * @return true is value is present, else false if not
     */
    public boolean containsLabel(String s) {
        for (HashMap.Entry<Vertex, LinkedList<Edge>> hEntry : m_adjacencyList.entrySet()) {
            if ((hEntry.getKey()).getLabel() == s) {
                return true;
            }
        }
        return false;

    }

    /** Method for checking if a weight value exists within a hashmap
     *
     * @param f the given weight float
     * @return true is value is present, else false if not
     */
    public boolean containsWeight(float f) {
        for (HashMap.Entry<Vertex, LinkedList<Edge>> hEntry : m_adjacencyList.entrySet()) {

            for (int i = 0; i < (hEntry.getValue().size()); i++) {
                if ((hEntry.getValue().get(i)).getWeight() == f) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method for printing out an adjacency chart
     */
    public void printChart() {
        for (HashMap.Entry<Vertex, LinkedList<Edge>> hEntry : m_adjacencyList.entrySet()) {
            System.out.print((hEntry.getKey().getLabel()+": -> "));
            if ((hEntry.getValue().size()) == 0) {
                System.out.println("nil");
            }
            else {
                for (int i = 0; i < (hEntry.getValue().size()); i++) {
                    //System.out.print(((hEntry.getValue().get(i)).getSrc().getLabel())+" -> ");
                    System.out.print(((hEntry.getValue().get(i)).getDst().getLabel())+" -> ");
                }
                System.out.println("nullptr");
            }
        }
    }

    public Vertex getVertex(String vert) {
        for (HashMap.Entry<Vertex, LinkedList<Edge>> hEntry : m_adjacencyList.entrySet()) {
            //String listLabel = hEntry.getKey().getLabel();
            //System.out.println(hEntry.getKey().getLabel());
            //System.out.println(vert);
            if (Objects.equals((hEntry.getKey()).getLabel(), vert)) {
                return hEntry.getKey();
            }
        }
        return null;
    }

    public boolean edgeCheck (String src, String dst) {
        if (containsLabel(src) && containsLabel(dst)) {
            LinkedList<Edge> edgeList = m_adjacencyList.get(getVertex(src));
            if (edgeList == null) {
                return false;
            }
            for (Edge edge: edgeList ) {
                if (edge.getDst().getLabel() == getVertex(dst).getLabel()) {
                    return true;
                }
            }
            edgeList = m_adjacencyList.get(getVertex(dst));
            if (edgeList == null) {
                return false;
            }
            for (Edge edge: edgeList ) {
                if (edge.getDst().getLabel() == getVertex(src).getLabel()) {
                    return true;
                }
            }
            return false;
        }
        else {
            return true;
        }
    }

    public LinkedList<Edge> getEdgeList(Vertex src){
        if (m_adjacencyList.containsKey(src)) {
            return m_adjacencyList.get(src);
        }
        return null;
    }

    public void addBiEdge(Vertex src, Vertex dst) {
        if (m_adjacencyList.containsKey(src)) {
            LinkedList<Edge> edgeList = m_adjacencyList.get(src);
            edgeList.add(new Edge(src, dst));
        }
        if (m_adjacencyList.containsKey(dst)) {
            LinkedList<Edge> edgeList = m_adjacencyList.get(dst);
            edgeList.add(new Edge(dst, src));
        }
    }

    public void vertReset() {
        for (HashMap.Entry<Vertex, LinkedList<Edge>> hEntry : m_adjacencyList.entrySet()) {
            (hEntry.getKey()).setVisitStatus(false);
        }
    }
}
