package beginners;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Problem Statement: https://www.dropbox.com/s/jyhux0n10plcyaw/DoubleEndedQueue.pdf
 * @author ameya
 *
 */
public class DoubleEndedQueue {

	LinkedList<Integer> dequeue;  
	int maxLength;
	
	public DoubleEndedQueue( int maxLength ) {
		this.maxLength = maxLength;
		this.dequeue = new LinkedList<Integer>();
	}
	
	String pushLeft( int x ){
		if( dequeue.size() == maxLength )
			return "The queue is full";
		this.dequeue.addFirst(x);
		return "Pushed in left: " + x;
	}
	
	String pushRight( int x ){
		if( dequeue.size() == maxLength )
			return "The queue is full";
		this.dequeue.addLast(x);
		return "Pushed in right: " + x;
	}
	
	String popLeft(){
		if( dequeue.size() == 0 )
			return "The queue is empty";
		return "Popped from left: " + this.dequeue.removeFirst();
	}
	
	String popRight(){
		if( dequeue.size() == 0 )
			return "The queue is empty";
		return "Popped from right: " + this.dequeue.removeLast();
	}
	
	
	String getString( String line ){
		
		String lineSplit[] = line.split(" ");
		
		if( lineSplit[0].equals("pushLeft") )
			return this.pushLeft( Integer.parseInt(lineSplit[1]) );
		if( lineSplit[0].equals("pushRight") )
			return this.pushRight( Integer.parseInt(lineSplit[1]) );
		if( lineSplit[0].equals("popLeft") )
			return this.popLeft();
		if( lineSplit[0].equals("popRight") )
			return this.popRight();
		return "LOL";
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int cases = Integer.parseInt( in.nextLine().trim() );
		int noOfCommands;
		String sizeLine[];
		for( int i = 1; i <= cases; i++ ){
			sizeLine = in.nextLine().trim().split(" ");
			DoubleEndedQueue doubleEndedQueue = new DoubleEndedQueue( Integer.parseInt( sizeLine[0] ) );
			noOfCommands = Integer.parseInt( sizeLine[1] );
			System.out.println("Case " + i + ":");
			while( noOfCommands-- > 0)
				System.out.println( doubleEndedQueue.getString(in.nextLine()));
		}
		in.close();
	}

}
