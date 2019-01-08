/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphtheoryjava.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Cida
 */
public class Reader {
    public Graph graph;
    private File file;
    
    public Reader(){}
    
    public Graph readFile(String name) throws IOException{
        
        this.file=new File(name);
      
        FileReader reader= new FileReader(file);
        BufferedReader br= new BufferedReader(reader);

        String[] line;
        line=br.readLine().split(" ");
        int numVertices=(Integer.parseInt(line[0]));
       
        ArrayList<Integer> vertices = new ArrayList<>(); //perguntar pq ta vazio
        ArrayList<ArrayList<Edge>> adjList = new ArrayList<ArrayList<Edge>>();
        double [][]adjMatriz = new double[numVertices][numVertices];
        ArrayList<Edge> edges = new ArrayList<>();
        
        for(int i = 0; i <numVertices;i++)
        {
            ArrayList<Edge> adjListOfVertex = new ArrayList<>(); 
            vertices.add(i);
            adjList.add(adjListOfVertex);
            for(int j = 0; j<numVertices;j++){
                adjMatriz[i][j] = 0;
            }
        }
        
        
        for(int i =0 ; i<numVertices;i++){
            String[] infoAresta = br.readLine().split(" ");
            int source = Integer.parseInt(infoAresta[0]);
            double sink = Double.parseDouble(infoAresta[1]);
            double weight = Double.parseDouble(infoAresta[2]);
            Edge e = new Edge(source, sink, weight);
            edges.add(e);
            adjList.get(source).add(e);
        
        }                                                                                                       
        graph = new Graph(vertices, edges, adjList, adjMatriz);
        
        br.close();
        reader.close();
        return graph;
    }
           
}
                                                                                                                                                            