package graphExercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class TestClassOne {
		
	private boolean[][] adjacencyMatress;
	private int numbersOfVertex;
	private int numbersOfEdges;
		    
	public TestClassOne(int a, int b){
		        numbersOfVertex = a;
		        numbersOfEdges = b;
		        adjacencyMatress = new boolean[numbersOfVertex][numbersOfVertex];
		    }
		    
		    public  void putEdge(int vertexOne, int vertexTwo){
		        adjacencyMatress[vertexOne][vertexTwo] = true;
		    }

		    public boolean existeEdge(int vertexOne, int vertexTwo){
		        return adjacencyMatress[vertexOne][vertexTwo];
		    }
		    
		    
		    public static void main(String args[] ) throws Exception {
		    
		        BufferedReader br = new BufferedReader(new FileReader("hola/revisar.txt"));
		        String line = "";
		        while((line = br.readLine()) != null){
		            String[] vertexAndEdges = line.split(" ");
		            int numbersOfVertex = Integer.parseInt(vertexAndEdges[0]);
		            int numbersOfEdges = Integer.parseInt(vertexAndEdges[1]);
		            TestClassOne classToProbe = new TestClassOne(numbersOfVertex, numbersOfEdges);
		            int  i = 0;
		            while(i < numbersOfEdges){
		                line = br.readLine();
		                String[] edgeAandB = line.split(" ");
		                int x = Integer.parseInt(edgeAandB[0]);
		                int x1 = Integer.parseInt(edgeAandB[1]);
		                classToProbe.putEdge(x - 1 , x1 - 1);
		                i ++;
		            }
		            line = br.readLine();
		            int numbersOfQueries = Integer.parseInt(line);
		            int j = 0;
		            while(j < numbersOfQueries){
		                line = br.readLine();
		                String[] queriesBetweenAandB = line.split(" ");
		                int a = Integer.parseInt(queriesBetweenAandB[0]);
		                int b = Integer.parseInt(queriesBetweenAandB[1]);
		                System.out.println(classToProbe.existeEdge(a - 1,b - 1));
		                j ++;
		            }
		        }
		   
		    }
		    
}
		    
		
