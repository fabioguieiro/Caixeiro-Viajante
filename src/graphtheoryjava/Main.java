package graphtheoryjava;


import graphtheoryjava.algorithms.CaixeiroViajante;
import graphtheoryjava.util.Graph;
import graphtheoryjava.util.Reader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
 
        try {
            System.out.println("Graph File: ");
            Scanner in = new Scanner(System.in);
            String fileName = in.nextLine();

            Reader ler = new Reader();
            Graph graph = ler.readFile(fileName);
            CaixeiroViajante cv = new CaixeiroViajante();
            
            System.out.println("imprime o plano cartesiano:"+graph.adjList.toString());
            Graph completo = cv.complete(graph);
            System.out.println("imprime o grafo completo: "+completo.adjList.toString());
            ArrayList<Integer> caminho= cv.NearestNeighbor(completo);
            System.out.println("imprime o primeiro caminho encontrado: "+caminho.toString());
            caminho.remove(caminho.size()-1);
            ArrayList<Integer> loop = cv.Twoopt(caminho, completo);
            loop.add(loop.size(),loop.get(0));
            System.out.println("Caminho Twoopt: "+loop.toString());
            } catch (IOException e) {
                System.out.println("txt nao encontrado!! ");
        }
        
        
           
            

        
    }

}
