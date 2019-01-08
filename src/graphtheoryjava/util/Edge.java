/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphtheoryjava.util;

/**
 *
 * @author Cida
 */
public class Edge {
    public int source;
    public double sink;
    public double weight;

    public Edge(int source, double sink, double weight) {
        this.source = source;
        this.sink = sink;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" + source + ", " + sink + ", " + weight + ')';
    }
    
    
}
