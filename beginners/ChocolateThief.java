package beginners;

import java.util.Scanner;

/**
 * Problem Statement: https://www.dropbox.com/s/g7cdwvt1cl0ekrr/ChocolateThief.pdf
 * @author ameya
 *
 */
public class ChocolateThief {

	public static void main(String[] args) {
		
		Scanner in = new Scanner( System.in );
		
		int cases = Integer.parseInt( in.nextLine() );
		
		for( int i = 1; i <= cases; i++ ){
			int max = 0, min = Integer.MAX_VALUE;
			int n = Integer.parseInt( in.nextLine() );
			String thief = "";
			String victim = "";
			while( n-- > 0 ){
				String name = in.nextLine();
				String splitLine[] = name.split(" ");
				name = splitLine[0];
				int x = Integer.parseInt( splitLine[1] )* Integer.parseInt( splitLine[2] ) * Integer.parseInt( splitLine[3] );
				if( x > max ){
					max = x;
					thief = name;
				}
				if( x < min ){
					min = x;
					victim = name;
				}
			}
			System.out.print("Case " + i + ": ");
			if( min == max )
				System.out.println("no thief");
			else
				System.out.println( thief + " took chocolate from " + victim );
		}
		in.close();
	}

}
