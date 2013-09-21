package graphtheory.bfsdfs;


import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Statement: https://www.dropbox.com/s/nhpjgcp3ue1tijf/AToyCompany.pdf
 * @author ameya
 *
 */
public class ToyCompany {
	
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		AToyCompany solver = new AToyCompany();
		int testCount = in.nextInt();
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out);
		out.close();
	}
}

class AToyCompany{
	
	static char[][][] visited = new char[26][26][26];
	static char[][][] forbidden = new char[26][26][26];
	
	
	public void solve(int i, InputReader in, PrintWriter out) {
		clear(forbidden);
		clear(visited);
		
		in.readBlankLine();
		String start = in.nextLine();
		String finish = in.nextLine();
		
		int noOfForbiddenStrings = in.nextInt();
		
		while( noOfForbiddenStrings-- > 0 )
			getString(in.nextLine());
		out.println( "Case " + i + ": " + BFS(start, finish) );
	}

	private static int BFS( String source, String finish){

		Queue<State> queue = new LinkedList<State>();
		
		if( isValidState(source) )
			addToQueue( queue, new State(source, 0) );
			
		State parent = null;

		while( !queue.isEmpty() ){
			parent = queue.poll();

			if( parent.state.equals(finish) )
				return parent.cost;
			
			for( State adj: getAdjList(parent, finish ) )
				if( isValidState(adj.state) )
					addToQueue(queue, adj);
		}
		return -1;
	}

	private static void addToQueue( Queue<State> queue, State state ){
		queue.add(state);
		visited[state.state.charAt(0)-'a'][state.state.charAt(1)-'a'][state.state.charAt(2)-'a'] = '1';
	}
	
	private static void getString( String line ){
		String split[] = line.split(" ");
		for( Character character: split[0].toCharArray() )
			for( Character character2: split[1].toCharArray() )
				for( Character character3: split[2].toCharArray() )
					forbidden[character-'a'][character2-'a'][character3-'a'] = '1';
	}
	
	
	private static HashSet<State> getAdjList( State parent, String finish ) {

		HashSet<State> adjacentVertices = new HashSet<State>();
		String tempString;
		for( int i = 0; i < parent.state.length(); i++ ){
			
			StringBuilder temp = new StringBuilder(parent.state);
			
			temp.setCharAt( i, (char) ( 'a' + (getValue(temp.toString(), i) + 1 )%26 ) );
			tempString = temp.toString();
			adjacentVertices.add( new State(tempString, parent.cost+1 ) );

			temp.setCharAt( i, (char) ( 'a' + (getValue(temp.toString(), i) - 2 + 26)%26 ) );
			tempString = temp.toString();
			adjacentVertices.add( new State(tempString, parent.cost+1 ) );
		}

		return adjacentVertices;
	}
	
	private static boolean isValidState( String tempString ){
		return ( forbidden[getValue(tempString, 0)][getValue(tempString, 1)][getValue(tempString, 2)] == '0' 
			   && visited[getValue(tempString, 0)][getValue(tempString, 1)][getValue(tempString, 2)] == '0' );
	}
	
	public static int getValue( String string, int index ){
		return string.charAt(index)-'a';
	}
	private static void clear(char[][][] triChar ){
		for( int i = 0; i < 26; i++ ){
			for( int j = 0; j < 26; j++ ){
				for( int k = 0; k < 26; k++ ){
					triChar[i][j][k] = '0';
				}	
			}	
		}
	}
}

class State{
	String state;
	int diff;
	int cost;
	
	public State( String state, int cost ){
		this.state = state;
		this.cost = cost;
	}
	

	@Override
	public String toString(){
		return ( state + "," + String.valueOf(cost) );
	}
}

