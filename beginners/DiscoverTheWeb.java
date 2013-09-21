package beginners;

import java.util.Scanner;
import java.util.Stack;

/**
 * Problem Statement: https://www.dropbox.com/s/xbrov7cux0lbzj7/DIscoverTheWeb.pdf
 * @author ameya
 *
 */
public class DiscoverTheWeb {
	
	Stack<String> backwardStack;
	Stack<String> forwardStack;
	
	public DiscoverTheWeb(){
		backwardStack = new Stack<String>();
		forwardStack = new Stack<String>();
		
		backwardStack.push("http://www.lightoj.com/");
	}
	
	public String back(){
		if( backwardStack.size() == 1 )
			return "Ignored";
		forwardStack.push( backwardStack.pop() );
		return backwardStack.peek();
	}
	
	public String forward(){
		if( forwardStack.isEmpty() )
			return "Ignored";
		backwardStack.push( forwardStack.pop() );
		return backwardStack.peek();
	}
	
	public String visit( String url ){
		backwardStack.push(url);
		forwardStack.clear();
		return backwardStack.peek();
	}
	
	public String getCurrentPage(){
		return backwardStack.peek();
	}
	
	public String performAction( String line ){
		String split_array[] = line.trim().split(" ");
		
		if( split_array[0].equals("VISIT") )
			return visit(split_array[1]);
		if( split_array[0].equals("BACK") )
			return back();
		if( split_array[0].equals("FORWARD") )
			return forward();
		return backwardStack.peek();
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner( System.in );
		
		int cases = Integer.parseInt( in.nextLine() );
		String line;
		DiscoverTheWeb discovertheWeb = new DiscoverTheWeb();
		for( int i = 1; i <= cases; i++ ){
			System.out.println( "Case " + i + ":" );
			
			while( !( ( line = in.nextLine() ).equals("QUIT") ) )
				System.out.println( discovertheWeb.performAction(line) );
			discovertheWeb = new DiscoverTheWeb();
		}
		in.close();
	}

}
