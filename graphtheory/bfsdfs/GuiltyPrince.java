package graphtheory.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


/**
 * Problem Statement: https://www.dropbox.com/s/x4b175x9bpd3vcs/GuiltyPrince.pdf
 * @author ameya
 *
 */
public class GuiltyPrince {
	
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		LOJ_1012 solver = new LOJ_1012();
		int testCount = in.nextInt();
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out);
		out.close();
	}
}

class LOJ_1012 {
	static Set<Integer> visited  = new HashSet<Integer>();
	static int source_node;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
    	Graph graph = parseInputToGraph(in, in.nextInt(), in.nextInt());
    	visited.clear();
    	int count = BFS(graph, source_node);
        out.println("Case " + testNumber + ": " + count);
    }
    

	
    private Graph parseInputToGraph( InputReader in, int W, int H ){
    	char grid[][] = new char[H][W];
    	Graph graph = new Graph(W*H);
    	for( int j = 0; j < H; j++ ){
    		String line = in.next();
    		grid[j] = line.toCharArray();
    	}
    	
    	for(int i = 0; i < H; i++ )
    		for( int j = 0; j < W; j++ ){
    			if( grid[i][j] == '@' )
    				source_node = i*W + j;
    			if( grid[i][j] == '#' )
    				continue;
    			setEdges( graph, grid, i, j);
    		}    	
    	 
    	return graph;
    }

	private void setEdges(Graph graph, char[][] grid, int x, int y) {
		
		int vertices_x[] = new int[]{ x+1, x, x-1, x };
		int vertices_y[] = new int[]{ y, y+1, y, y-1 };
		int MAX_X = grid.length;
		int MAX_Y = grid[0].length;
		
		for( int i = 0; i < 4; i++ ){
			if(vertices_x[i] <0 || vertices_x[i] >= MAX_X ||  vertices_y[i] <0 || vertices_y[i]  >= MAX_Y )
				continue;
				if( grid[vertices_x[i]][vertices_y[i]] == '#' )
					continue;
			graph.addEdge( x*grid[0].length + y, vertices_x[i]*grid[0].length + vertices_y[i]);
			graph.addEdge( vertices_x[i]*grid[0].length + vertices_y[i], x*grid[0].length + y );
		}
		
	}
	private static int BFS(Graph graph, Integer source) {
		
		Queue<Integer> vertices = new LinkedList<Integer>();
		vertices.add(source);
		int count = 0;
		while( !vertices.isEmpty()){
			
			int parent = vertices.poll();
			
			for( Integer adjVertex: graph.adj(parent) ){
				if( !visited.contains(adjVertex) && !vertices.contains(adjVertex) ){
					vertices.add(adjVertex);
				}
			}
			count++;
			visited.add(parent);
		}
		return count;
	}
	
}

class Graph {
	
	Hashtable< Integer, Set<Integer> > adjacencyList;
	/**
	 * create the graph of the defined size
	 * @param V
	 */
	
	public Graph(){
		this.adjacencyList = new Hashtable< Integer, Set<Integer> >();
	}
	public Graph( int V ){
		this.adjacencyList = new Hashtable<Integer, Set<Integer>>();
		for( Integer i = 0; i < V; i++ )
			this.adjacencyList.put(i, new HashSet<Integer>());
	}
	
	public Graph( InputStream inputStream ){
		try {
			BufferedReader in = new BufferedReader( new InputStreamReader(inputStream) );
			String vertices[] = in.readLine().split(" ");
			
			this.addEdge( Integer.parseInt(vertices[0]), Integer.parseInt(vertices[1]) );
			this.addEdge( Integer.parseInt(vertices[1]), Integer.parseInt(vertices[0]) );
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void addEdge( int v, int w ){
		if( !adjacencyList.containsKey(v) )
			adjacencyList.put( v, new HashSet<Integer>() );
		Set<Integer> list = adjacencyList.get(v);
		list.add(w);
	}

	public Set<Integer> adj(int v){
		return adjacencyList.get(v);
	}
	
	public int V(){
		return adjacencyList.keySet().size();
	}
	
	public int E(){
		int counter = 0;
		for( Integer v: adjacencyList.keySet() )
				counter+= adj(v).size();
		return counter/2;
	}
	
	@Override
	public String toString(){
		return adjacencyList.toString();
	}
}

