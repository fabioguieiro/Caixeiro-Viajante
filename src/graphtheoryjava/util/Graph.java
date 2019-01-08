/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphtheoryjava.util;

import java.util.ArrayList;

/**
 *
 * @author Cida
 */
public class Graph {
    public ArrayList<Integer> vertices;
    public ArrayList<Edge> edges;
    public ArrayList<ArrayList<Edge>> adjList;
    public double [][] adjMatriz;

    public Graph(ArrayList<Integer> vertices, ArrayList<Edge> edges, ArrayList<ArrayList<Edge>> adjList, double[][] adjMatriz) {
        this.vertices = vertices;
        this.edges = edges;
        this.adjList = adjList;
        this.adjMatriz = adjMatriz;
    }
    
    
    
            }