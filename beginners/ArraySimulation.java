package beginners;

import java.util.Scanner;

/**
 * Problem Statement: https://www.dropbox.com/s/1ico9eti6ydjawj/ArraySimulation.pdf
 * @author ameya
 *
 */
public class ArraySimulation {
	
	int arr[];
	
	public ArraySimulation( int arr[] ){
		this.arr = arr;
	}
	
	
	public void modifyArray( String line ){
		String elements[] = line.split(" ");
		if( line.length() < 1)
			return;
		char operation = elements[0].charAt(0);
		
		switch(operation){
			case 'P': 
				int i = Integer.parseInt(elements[1]);
				int j = Integer.parseInt(elements[2]);
				
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				break;
			case 'S': 
				int b = Integer.parseInt(elements[1]);
				for( int c = 0; c < this.arr.length; c++ )
					this.arr[c] += b;
				break;
			case 'M': 
				b = Integer.parseInt(elements[1]);
				for( int c = 0; c < this.arr.length; c++ )
					this.arr[c] *= b;
				break;				
			case 'D': 
				b = Integer.parseInt(elements[1]);
				for( int c = 0; c < this.arr.length; c++ )
					this.arr[c] /= b;
				break;			
			case 'R': 
				for( int c = 0; c < this.arr.length/2; c++ ){
					temp = this.arr[c];
					this.arr[c] = this.arr[this.arr.length-c-1];
					this.arr[this.arr.length-c-1] = temp;
				}
				break;	
		}
	}
	
	public static void main(String[] args) {
	
		Scanner in = new Scanner( System.in );
		int cases = Integer.parseInt( in.nextLine() );
		int n = 0;
		int o = 0;
		for( int i = 1; i <= cases; i++ ){
			
			n = in.nextInt();
			o = in.nextInt();
			
			int x[] = new int[n];
			int temp = 0;
			while(temp < n ) x[temp++] = in.nextInt();
			
			ArraySimulation arraySimulation = new ArraySimulation(x);
			
			temp = -1;
			while( temp < o ){
				arraySimulation.modifyArray(in.nextLine());
				temp++;
			}
			
			System.out.println("Case " + i + ":" );
			int p = 0;
			for( p = 0; p < arraySimulation.arr.length-1; p++ )
				System.out.print( arraySimulation.arr[p] + " " );
			System.out.print( arraySimulation.arr[p] );
			System.out.println();
			
		}
		in.close();
		
	}

}
