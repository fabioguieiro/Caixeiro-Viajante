/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphtheoryjava.algorithms;

import graphtheoryjava.util.Edge;
import graphtheoryjava.util.Graph;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.lang.Math;

public class CaixeiroViajante {
    
    public CaixeiroViajante(){
    }
    
    public double weight(Edge e1, Edge e2){
        double z;
        z = Math.sqrt(Math.pow((double)e1.sink-e2.sink,2)+Math.pow((double)e1.weight-e2.weight,2));
        return z;
    }
    
    public Graph complete(Graph graph) {

        ArrayList<Integer> vertices = new ArrayList<>();
        ArrayList<ArrayList<Edge>> adjList = new ArrayList<ArrayList<Edge>>();
        double[][] adjMatrix = new double[graph.vertices.size()][graph.vertices.size()];
        ArrayList<Edge> edges = new ArrayList<>();//          Graph v = graph;
        Edge x,y;
        double euc;
        for (int i = 0; i < graph.vertices.size(); i++) {
            vertices.add(i);
            ArrayList<Edge> adjacentesVerticeI = new ArrayList<Edge>();
            adjList.add(adjacentesVerticeI);
                for (int j = 0; j < graph.vertices.size(); j++) {
                    if(graph.edges.get(i).source!=graph.edges.get(j).source){
                        //euc = calcular dist euclidiana entre i e j
                        x=graph.edges.get(i);
                        y=graph.edges.get(j);
                        euc = weight(x,y);
                        adjMatrix[i][j] = euc;
                        Edge e = new Edge(i,j,euc);
                        adjList.get(i).add(e);
                        edges.add(e); 
                    }
                }
        }
        Graph v = new Graph(vertices, edges, adjList, adjMatrix);
        return v;
    }
    
      
      
      
    public ArrayList<Integer> NearestNeighbor(Graph g){
          ArrayList<Integer> naoVisitados = new ArrayList<Integer>();
           ArrayList<Integer> S = new ArrayList<Integer>();
           for(int i=0;i<g.vertices.size();i++){
          naoVisitados.add(g.vertices.get(i));
           }
          int u = 0,v=0;
          naoVisitados.remove(u);
          S.add(u);
          double minimo;
            while(!naoVisitados.isEmpty()){
                    minimo=(double) g.adjList.get(u).get(0).weight;
                    v=naoVisitados.get(0);
                    for(int i=1;i<g.adjList.get(u).size();i++){
                        if(naoVisitados.contains((int)g.adjList.get(u).get(i).sink)){
                            if(minimo>g.adjList.get(u).get(i).weight){     
                                minimo=g.adjList.get(u).get(i).weight;
                                v=(int)g.adjList.get(u).get(i).sink;
                            }
                        }
                    
                    
                    }
                    
                S.add(v);
               naoVisitados.remove(naoVisitados.indexOf(v));
               u=v;
            }
            S.add(S.get(0));
        return S;
    }  
    
   
    
     public ArrayList<Integer> Twoopt( ArrayList<Integer> s,Graph g){
       
         double custo = avalia(s,g);
         int cont=1;
          ArrayList<Integer> s1 = new ArrayList<Integer>();  
          long time= System.currentTimeMillis();
         long time2 = time+100000;
         int i1, i2,aux;
         
double num;
         ArrayList<Integer> list;
         while(time2>time){
         num=Math.random()*(s.size()-2);
         i1=(int)Math.round(num);
         num=Math.random()*(s.size()-2);
         i2=(int)Math.round(num);
         if(i1!=i2){
             s1.clear();
             s1.addAll(s);
                aux=s1.get(i1);
                s1.set(i1, s1.get(i2));
                s1.set(i2, aux);
                cont ++;
                    custo = custo+avalia(s1,g);
                    double av1, av2;
                    av1=avalia(s1,g);
                    av2=avalia(s,g);
                        if(av1<av2){
                         s.clear();
                         s.addAll(s1);
                        }
                }
         time=System.currentTimeMillis();
          }
         System.out.println("melhor custo encontrado: "+avalia(s,g));
         double media=(custo/cont);
         
         System.out.println("media: "+media);
         return s;
    }
    
     public double avalia(ArrayList<Integer> s, Graph g){
   double custo=0, w;
   int u,v;
            for(int i=0; i<s.size()-1;i++){
                   u=s.get(i);
                v=s.get(i+1);
               w=g.adjMatriz[u][v];
                custo=custo+w;
            }
            u=s.get(s.size()-1);
            v=s.get(0);
            w=g.adjMatriz[u][v];
            custo=custo+w;
           
    return custo;
    }
   
   
}
